package com.y0n.java.Utils;

import com.y0n.java.UIOperator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

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
                    continue;
                // 5. 判断assets目录有没有，没有创建
                String assets = newPath + File.separator+"assets";
                File dir = new File(assets);
                if (!dir.exists()){
                    dir.mkdir();
                }
                // 6. 写入dex文件
                String path = assets + File.separator+ "src.dex";
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

}
