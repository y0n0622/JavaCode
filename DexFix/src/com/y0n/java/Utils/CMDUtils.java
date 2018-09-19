package com.y0n.java.Utils;

import com.y0n.java.UIOperator;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by y0n on 2017/6/29.
 */
public class CMDUtils {
    public static void runCMD(String path){
        try {
            String cmd = "cmd.exe /c "+ path;
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String readinfo = null;
            while ((readinfo = br.readLine()) != null){
                //System.out.println(readinfo);
                UIOperator.MsgShow2TextArea(readinfo);
                UIOperator.MsgShow2TextArea("\n");
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runCMD(String path, String dir){
        try {
            String cmd = "cmd.exe /c "+ path;
            Process process = Runtime.getRuntime().exec(cmd, null, new File(dir));
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String readinfo = null;
            while ((readinfo = br.readLine()) != null){
                //System.out.println(readinfo);
                UIOperator.MsgShow2TextArea(readinfo);
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
