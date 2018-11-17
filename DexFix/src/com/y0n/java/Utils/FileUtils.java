package com.y0n.java.Utils;

import com.y0n.java.UIOperator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by y0n on 2017/6/29.
 */
public class FileUtils {
    public static void deletFolder(String delPath){
        File dir = new File(delPath);
        deleteFile(dir);
    }

    public static void deleteFile(File file) {
        // 判断是否为文件，是文件直接删除
        if (file.isFile()){
            //System.out.println("[删除文件]" + file.getName());
            UIOperator.MsgShow2TextArea("[删除文件]" + file.getName());
            UIOperator.MsgShow2TextArea("\n");
            file.delete();
        } else if (file.isDirectory()){
            // 是目录，先遍历目录下面的文件，逐一删除，然后再递归目录中的目录
            File[] files = file.listFiles();
            for (int i = 0; i <files.length ; i++) {
                // 递归删除文件
                deleteFile(files[i]);
            }
            //System.out.println("[删除目录]" + file.getName());
            UIOperator.MsgShow2TextArea("[删除目录]" + file.getName());
            UIOperator.MsgShow2TextArea("\n");
            file.delete();
        }
    }

    public static void copyFolder(String oldPath, String newPath){
        // 1. 创建新的文件路径，可能包含有多个文件夹，所以是mkdirs
        File file = new File(newPath);
        if (!file.exists())
            file.mkdirs();
        // 2. 遍历老的文件夹，分别拷贝文件和文件夹
        File file1 = new File(oldPath);
        File[] files = file1.listFiles();
        for (int i = 0; i < files.length; i++) {
            File temp = null;
            // 判断文件路径最后的斜杠，没有斜杠，需要增加
            if (oldPath.endsWith(File.separator)){
                temp = new File(oldPath + files[i].getName());
            } else {
                temp = new File(oldPath + File.separator + files[i].getName());
            }

            try{
                // 判断是不是文件
                if (temp.isFile()){
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                            (temp.getName()).toString());
                    byte[] b = new byte[1024];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();

                } else if (temp.isDirectory()){
                    copyFolder(oldPath + "/" + files[i].getName(),
                            newPath + "/" + files[i].getName());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}