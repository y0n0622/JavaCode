package com.y0n.ApkShell;

import java.io.*;
import java.security.MessageDigest;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by y0n on 2017/7/3.
 * 对傀儡dex与源dex进行加密融合
   读取待加固apk中的dex文件 srcdex
   读取puppet.dex文件
   合成新的dex文件
   修该dex文件头信息
   保存为新的dex文件为classes.dex
 */
public class DexFileMix {

    public static void makeDexFiles(String DexPath, String apkPath){
        //读取源apk中的dex文件
        byte[] apkDex = readDexFromApk(apkPath);
        //对源dex进行加密
        //byte[] apkDexEnByte = Encode(apkDex);
        //读取傀儡dex文件
        byte[] puppetDexBytes = readDexFile(DexPath);
        System.out.println("傀儡dex大小：" + puppetDexBytes.length);

        //合成新的dex文件
        //计算新dex长度
        int newDexLen = puppetDexBytes.length + apkDex.length + 4;
        System.out.println("新dex大小：" + newDexLen);
        //申请空间
        byte[] newDexFile = new byte[newDexLen];
        //拷贝傀儡dex到缓冲区
        System.arraycopy(puppetDexBytes, 0, newDexFile, 0, puppetDexBytes.length);
        //拷贝加密后的源dex到缓冲区，在傀儡dex 的后面
        System.arraycopy(apkDex, 0, newDexFile, puppetDexBytes.length, apkDex.length);
        //拷贝源dex文件长度到缓冲区
        byte[] apklen = IntToByte(apkDex.length);
        System.out.println("最后4个字节：" + apklen[0] + " " + apklen[1] + " " + apklen[2] + " " + apklen[3]);
        System.arraycopy(apklen, 0, newDexFile, puppetDexBytes.length + apkDex.length, 4);

        //修该dex头
        pathDexHeader(newDexFile, newDexLen);

        //保存新的文件
        String newDexPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "classes.dex";
        writeNewDexFile(newDexFile, newDexPath);

    }

    private static void writeNewDexFile(byte[] newDexFile, String dexPath) {
        try {
            FileOutputStream outputStream = new FileOutputStream(new File(dexPath));
            outputStream.write(newDexFile);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pathDexHeader(byte[] newDexFile, int newDexLen) {
        //修正文件打下
        byte[] lengths = IntToByte(newDexLen);
        System.arraycopy(lengths, 0, newDexFile, 8+4+20, 4);

        //修正siganature
        byte[] siganature = getDexFileSiganature(newDexFile);
        System.arraycopy(siganature, 0, newDexFile, 8+4, 20);

        //修正checksum
        byte[] checksums = getDexFileCheckSum(newDexFile);
        System.arraycopy(checksums, 0, newDexFile, 8, 4);
    }

    private static byte[] getDexFileCheckSum(byte[] newDexFile) {
        //创建Adler32对象
        Adler32 adler32 = new Adler32();
        //计算缓冲区校验和
        adler32.update(newDexFile, 12, newDexFile.length - 12);
        //获取值
        long value = adler32.getValue();
        int data = (int) value;
        //将整型转化为数组
        byte[] checksums = new byte[4];
        for (int i = 0; i < 4; i++){
            checksums[i] = (byte) (data % 256);
            data >>= 8;
        }
        return checksums;
    }

    private static byte[] getDexFileSiganature(byte[] newDexFile) {
        try {
            //获取sha-1摘要对象
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            int startOffset = 8+4+20;
            //计算缓冲区
            md.update(newDexFile, startOffset, newDexFile.length - startOffset);
            //获取摘要
            byte[] siganature = md.digest();
            //返回摘要
            return siganature;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static byte[] IntToByte(int length) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++){
            bytes[i] = (byte) (length % 256);
            length >>= 8;
        }
        return bytes;
    }

    public static byte[] readDexFile(String dexPath) {
        try {
            int byteread = 0;
            File oldFile = new File(dexPath);
            if (oldFile.exists()){
                InputStream inputStream = new FileInputStream(dexPath);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                //int length = 0;
                while ((byteread = inputStream.read(buffer)) != -1){
                    bos.write(buffer, 0, byteread);
                }
                inputStream.close();
                return bos.toByteArray();
            }
        }catch (Exception e){
            System.out.println("复制出错!");
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] Encode(byte[] apkDex) {
        for (int i = 0; i < apkDex.length; i++){
            apkDex[i] ^= 0xff;
        }
        return apkDex;
    }

    private static byte[] readDexFromApk(String apkPath) {
        try {
            //获取zip对象
            ZipFile zf = new ZipFile(apkPath);
            String name = "classes.dex";
            InputStream in = new BufferedInputStream(new FileInputStream(apkPath));
            //创建zip输入流
            ZipInputStream zin = new ZipInputStream(in);
            ZipEntry ze;
            //通过zip输入流，循环获取zip文件对象
            while ((ze = zin.getNextEntry()) != null){
                if (ze.isDirectory()){

                }else {
                    //不是目录判断是否为classes.dex
                    if (!name.equals(ze.getName())){
                        continue;
                    }
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    InputStream inputStream = zf.getInputStream(ze);
                    int len = 0;
                    int count = 0;
                    byte[] bytes = new byte[1024];
                    while ((len = inputStream.read(bytes)) != -1){
                        bos.write(bytes, 0, len);
                        count += len;
                    }
                    System.out.println(ze.getName() + "文件大小：" + count);
                    return bos.toByteArray();
                }
            }
            zin.closeEntry();
        }catch (Exception e){
            System.out.println("复制出错");
            e.printStackTrace();
        }
        return null;
    }
}
