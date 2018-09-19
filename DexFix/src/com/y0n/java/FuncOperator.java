package com.y0n.java;


import com.y0n.java.Utils.*;

import javax.swing.*;
import java.io.File;

import static com.y0n.java.UIOperator.MsgShow2TextArea;

/**
 * Created by y0n on 2017/7/5.
 */
public class FuncOperator {
    public static void makeFixApk(){
        //进行加固操作
        //1.获取待加固apk的路径
        String apkPath = StringsUtils.getAPKPath();
        //从路径中提取文件名
        String apkName = StringsUtils.getName(apkPath);
        //String apkName = "app.apk";
        String apkNoEx = StringsUtils.getFileNameNoEx(apkName);
        System.out.println("1/> 反编译apk...");
        MsgShow2TextArea("1/> 反编译apk...\n");
        CMDUtils.runCMD("java -jar apktool.jar d -f " + apkPath);

        //2.修改AndroidManifest.xml文件，添加com\example\y0n\puppetdex\puppetApplication信息
        System.out.println("2/> 修改AndroidManifest.xml...");
        MsgShow2TextArea("2/> 修改AndroidManifest.xml...\n");
        XmlUtils.ChangeAplication(apkNoEx + File.separator + "AndroidManifest.xml");

        //3.将加固apk中的dex复制到assets目录下，没有则创建，修改名称为src.dex
        System.out.println("3/> 复制dex...");
        MsgShow2TextArea("3/> 复制dex...\n");
        ApkUtils.copyFileFromZip(apkName, apkNoEx);

        //4.将反编译后的smali代码替换为傀儡dex的smali代码
        System.out.println("4/> 将反编译后的smali代码替换为傀儡dex的smali代码...");
        MsgShow2TextArea("4/> 将反编译后的smali代码替换为傀儡dex的smali代码...\n");
        String smaliDir = apkNoEx+ File.separator+"smali";
        FileUtils.deletFolder(smaliDir);
        MsgShow2TextArea("复制smali代码中...\n");
        FileUtils.copyFolder("smali",smaliDir);
        MsgShow2TextArea("复制smali代码完成...\n");
        //5.重打包apk
        System.out.println("5/> 重打包apk...");
        MsgShow2TextArea("5/> 重打包apk...\n");
        String outApkName = apkNoEx+"_pack.apk";
        CMDUtils.runCMD("java -jar apktool.jar b " + apkNoEx + " -o " + outApkName);

        //6.签名
        System.out.println("6/> apk签名...");
        MsgShow2TextArea("6/> apk签名...\n");
        String dir = System.getProperty("user.dir");
        String signDir = dir+ File.separator+"sign";
        String outSignedApk = apkNoEx+"_pack_signed.apk";
        CMDUtils.runCMD("java -jar signapk.jar testkey.x509.pem testkey.pk8 " +
                        dir+File.separator+ outApkName + " " +
                        dir+File.separator+ outSignedApk,
                signDir
        );

        //7.完成，并测试
        System.out.println("加固完成！");
        MsgShow2TextArea("加固完成！\n");

    }
}
