package com.y0n.ApkShell.Utils;

import com.y0n.ApkShell.UIOperator;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.y0n.ApkShell.UIOperator.MsgShow2TextArea;
import static com.y0n.ApkShell.Utils.FileUtils.*;
import static com.y0n.ApkShell.Utils.ZipFileUtils.unzip;
import static com.y0n.ApkShell.Utils.ZipFileUtils.zipMultiFile;



/**
 * Created by y0n on 2017/6/29.
 */
public class ApkUtils {
    public static void copyFileFromZip(String oldPath, String newPath){

        try {
            // 1. 获取ZipFile对象
            ZipFile zipFile = new ZipFile(oldPath);
            // 2. 创建Zip输入流
            InputStream inputStream = new FileInputStream(oldPath);
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            // 3. 循环读取Zip输入流中的对象
            ZipEntry zipEntry = null;
            while (null != (zipEntry = zipInputStream.getNextEntry()) ){
                // 4. 找到classes.dex
                String name = zipEntry.getName();
                //System.out.println("zip:" + name);
                UIOperator.MsgShow2TextArea("zip:" + name);
                UIOperator.MsgShow2TextArea("\n");
                if (!name.equals("classes.dex"))
                {
                    continue;
                }
                // 5. 有dex则删除
                //deleteDexFile();
                // 6. 写入dex文件
                String path = newPath + File.separator+ "classes.dex";
                FileOutputStream outputStream = new FileOutputStream(path);
                InputStream inputStream1 = zipFile.getInputStream(zipEntry);
                byte[] bytes = new byte[1024];
                int iReadSize = -1;
                while ((iReadSize = inputStream1.read(bytes,0,1024))!=-1){
                    outputStream.write(bytes,0,iReadSize);
                }
                outputStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    不解压直接复制dex文件：存在错误，复制后的文件无法解压
//    public static void copyDexFileToZip(String zipPath, byte[] dexbytes){
//        int BUFFER = 1024;
//        try {
//            ZipOutputStream zipOutputStream = null;
//            FileInputStream fis = new FileInputStream(zipPath);
//            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
//            ZipEntry entry;
//            byte data[] = new byte[1024];
//            FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")
//                    + System.getProperty("file.separator")
//                    + "crackMe002_dex.zip");
//            zipOutputStream = new ZipOutputStream(fos);
//
//            while ((entry = zis.getNextEntry()) != null) {
//                if (entry.isDirectory()) {
//
//                } else {
//                    //不是目录读取字节流
//                    ZipEntry ze = new ZipEntry( entry.getName() );
//                    zipOutputStream.putNextEntry(ze);
//                    int count;
//                    while ((count = zis.read(data, 0, BUFFER)) != -1) {
//                        if (entry.getName().equals("libpuppet-lib.so")) {
//                            int length = 0;
//                            System.out.println("dexsize:"+entry.getSize());
//                            zipOutputStream.write(dexbytes, 0, dexbytes.length);
//                            break;
//                        }
//                        else {
//                            zipOutputStream.write(data, 0, count);
//                        }
//                    }
//                    zipOutputStream.flush();
//                    ze.clone();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public static void changeFileInZip2(){
        //1.删除其中的classes.dex文件
        System.out.println("删除classes.dex...");
        MsgShow2TextArea("删除classes.dex...\n");
        deleteDexFile(System.getProperty("user.dir") + System.getProperty("file.separator")
                + "crackMe002"
                + System.getProperty("file.separator")
                + "classes.dex");
        //2.复制傀儡dex文件
        System.out.println("复制傀儡classes.dex...");
        MsgShow2TextArea("复制傀儡classes.dex...\n");
        copyFile(System.getProperty("user.dir") + System.getProperty("file.separator")
                        +  "classes.dex",
                System.getProperty("user.dir") + System.getProperty("file.separator")
                        +  "crackMe002"
                        + System.getProperty("file.separator")
                        + "classes.dex");
        //3.复制so文件
        System.out.println("复制so...");
        MsgShow2TextArea("复制so...\n");
        copyFile(System.getProperty("user.dir") + System.getProperty("file.separator")
                        +  "libpuppet-lib.so",
                System.getProperty("user.dir") + System.getProperty("file.separator")
                        +  "crackMe002"
                        + System.getProperty("file.separator")
                        + "lib"
                        + System.getProperty("file.separator")
                        + "x86"
                        + System.getProperty("file.separator")
                        + "libpuppet-lib.so");
    }


    public static void changeFileInZip(String zipPath){
        //1.解压重打包的apk文件
        System.out.println("解压...");
        MsgShow2TextArea("解压...\n");
        unzip(zipPath);
        //2.删除其中的classes.dex文件
        System.out.println("删除classes.dex...");
        MsgShow2TextArea("删除classes.dex...\n");
        deleteDexFile(System.getProperty("user.dir") + System.getProperty("file.separator")
                + "crackMe002_pack"
                + System.getProperty("file.separator")
                + "classes.dex");
        //3.复制傀儡dex文件
        System.out.println("复制傀儡classes.dex...");
        MsgShow2TextArea("复制傀儡classes.dex...\n");
        copyFile(System.getProperty("user.dir") + System.getProperty("file.separator")
                        +  "classes.dex",
                System.getProperty("user.dir") + System.getProperty("file.separator")
                        +  "crackMe002_pack"
                        + System.getProperty("file.separator")
                        + "classes.dex");
        //4.复制so文件
        System.out.println("复制so...");
        MsgShow2TextArea("复制so...\n");
        copyFile(System.getProperty("user.dir") + System.getProperty("file.separator")
                +  "libpuppet-lib.so",
                System.getProperty("user.dir") + System.getProperty("file.separator")
                        +  "crackMe002_pack"
                        + System.getProperty("file.separator")
                        + "lib"
                        + System.getProperty("file.separator")
                        + "x86"
                        + System.getProperty("file.separator")
                        + "libpuppet-lib.so");



        //5.压缩
//        System.out.println("压缩...");
//        zipMultiFile(System.getProperty("user.dir") + System.getProperty("file.separator") + "crackMe002_pack",
//                "crackMe002_pack.zip",
//                false);
       // zipMultiFile2(System.getProperty("user.dir") + System.getProperty("file.separator") + "crackMe002_pack");
    }
}
