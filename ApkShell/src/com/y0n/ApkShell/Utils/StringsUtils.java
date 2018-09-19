package com.y0n.ApkShell.Utils;

import com.y0n.ApkShell.UIOperator;

/**
 * Created by y0n on 2017/6/29.
 */
public class StringsUtils {


    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    public static String getAPKPath() {
        //从界面中的textField中获取路径字符串并返回
        String path = UIOperator.mJTextField.getText();
        return path;
    }

    public static String getName(String filePath) {
        //对路径字符串进行提取文件名
        if (filePath != null && filePath.length() > 0){
            while (true){
                int dot = filePath.lastIndexOf('\\');
                if ((dot > 0) && (dot < (filePath.length()))){
                    filePath = filePath.substring(dot + 1, filePath.length());
                }
                else {
                    break;
                }
            }
        }
        return filePath;
    }
}
