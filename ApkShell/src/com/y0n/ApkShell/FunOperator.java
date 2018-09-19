package com.y0n.ApkShell;

import com.y0n.ApkShell.Utils.ApkUtils;
import com.y0n.ApkShell.Utils.CMDUtils;
import com.y0n.ApkShell.Utils.StringsUtils;
import com.y0n.ApkShell.Utils.XmlUtils;

import java.io.File;

import static com.y0n.ApkShell.DexFileMix.makeDexFiles;
import static com.y0n.ApkShell.UIOperator.MsgShow2TextArea;
import static com.y0n.ApkShell.Utils.FileUtils.deletFolder;
import static com.y0n.ApkShell.Utils.FileUtils.deleteFile;


/**
 * Created by y0n on 2017/7/10.
 * 思路1：合并傀儡文件和待加密文件，反编译apk，修改清单文件，重打包，解压，复制合并的dex和so，压缩，签名
 * 思路2：合并傀儡文件和待加密文件，反编译apk时使用-s参数，不反编译dex文件，修改清单文件，替换dex和so，签名
 * 思路2能避免压缩和解压过程
 *
 */
public class FunOperator {

    private static String apkName;
    private static String apkNoEx;

    public static void makeApk(){
        //1.合并傀儡dex和待加密的dex
        System.out.println("1/> 合并傀儡dex和待加密的dex...");
        MsgShow2TextArea("1/> 合并傀儡dex和待加密的dex...\n");
        makeDexFiles(System.getProperty("user.dir") + System.getProperty("file.separator") +  "puppet.dex",
                System.getProperty("user.dir") + System.getProperty("file.separator") + "crackMe002.apk");

        //2.获取待加固apk的路径并反编译apk
        String apkPath = StringsUtils.getAPKPath();
        //从路径中提取文件名
        apkName = StringsUtils.getName(apkPath);
        //apkName = "crackMe002.apk";
        apkNoEx = StringsUtils.getFileNameNoEx(apkName);
        System.out.println("2/> 反编译apk...");
        MsgShow2TextArea("2/> 反编译apk...\n");
        CMDUtils.runCMD("java -jar apktool.jar d -f -s " + apkName);

        //3.修改AndroidManifest.xml文件，添加com.example.y0n.puppetdexfrommem.MypuppetApplication信息
        System.out.println("3/> 修改AndroidManifest.xml...");
        MsgShow2TextArea("3/> 修改AndroidManifest.xml...\n");
        XmlUtils.ChangeAplication(apkNoEx + File.separator + "AndroidManifest.xml");


        //4.替换classes.dex,将合并的傀儡dex复制到重打包好的apk中，删除原来的dex
        //  复制傀儡启动使用的lib库libpuppet-lib.so...
        System.out.println("4/> 替换classes.dex，添加libpuppet-lib.so...");
        MsgShow2TextArea("4/> 替换classes.dex，添加libpuppet-lib.so...\n");
        ApkUtils.changeFileInZip2();

        //5.重打包
        System.out.println("5/> 重打包apk...");
        MsgShow2TextArea("5/> 重打包apk...\n");
        String outApkName = apkNoEx +"_pack.apk";
        CMDUtils.runCMD("java -jar apktool.jar b " + apkNoEx + " -o " + outApkName);

        //6.签名
        System.out.println("6/> apk签名...");
        MsgShow2TextArea("6/> apk签名...\n");
        String dir = System.getProperty("user.dir");
        String signDir = dir+ File.separator+"sign";
        String outSignedApk = apkNoEx+"_signed.apk";
        CMDUtils.runCMD("java -jar signapk.jar testkey.x509.pem testkey.pk8 " +
                        dir+File.separator+ apkNoEx + ".apk " +
                        dir+File.separator+ outSignedApk,
                signDir
        );
        System.out.println("签名完成...\n");
        MsgShow2TextArea("签名完成...\n");


        //删除文件
        System.out.println("7/> 清理中间文件...\n");
        MsgShow2TextArea("7/> 清理中间文件...\n");
        deletFolder(System.getProperty("user.dir") + File.separator + apkNoEx);
        deleteFile(new File(System.getProperty("user.dir") + File.separator + apkNoEx + "_pack.apk"));
        deleteFile(new File(System.getProperty("user.dir") + File.separator + "classes.dex"));
        System.out.println("8/> 加固完成!...\n");
        MsgShow2TextArea("8/> 加固完成!...\n");


//        //5.复制傀儡启动使用的lib库
//        System.out.println("6/> 添加库libpuppet-lib.so...");
//        //ApkUtils.copyFileToZip(String srcPath, String destPath);

//        System.out.println("请关闭程序手动打包成[apkname]_pack.zip，重启程序再签名！");
//        MsgShow2TextArea("请关闭程序手动打包成[apkname]_pack.zip，重启程序再签名！\n");
    }

    public static void apkNewBuild(){
        //获取待加固apk的路径并反编译apk
        String apkPath = StringsUtils.getAPKPath();
        //从路径中提取文件名
        apkName = StringsUtils.getName(apkPath);
        //apkName = "crackMe002.apk";
        apkNoEx = StringsUtils.getFileNameNoEx(apkName);

        System.out.println("# 重打包apk...");
        MsgShow2TextArea("# 重打包apk...\n");
        String outApkName = apkNoEx +"_pack.apk";
        CMDUtils.runCMD("java -jar apktool.jar b " + apkNoEx + " -o " + outApkName);

        MsgShow2TextArea("重打包完成...\n");
    }


    public static void apkRebuild(){
        //获取待加固apk的路径并反编译apk
        String apkPath = StringsUtils.getAPKPath();
        //从路径中提取文件名
        apkName = StringsUtils.getName(apkPath);
        //apkName = "crackMe002.apk";
        apkNoEx = StringsUtils.getFileNameNoEx(apkName);

        System.out.println("# 反编译apk...");
        MsgShow2TextArea("# 反编译apk...\n");
        CMDUtils.runCMD("java -jar apktool.jar d -f " + apkName);

        MsgShow2TextArea("反编译完成...\n");
    }


    public static void apkSign(){
        //签名
        //获取待加固apk的路径并反编译apk
        String apkPath = StringsUtils.getAPKPath();
        //从路径中提取文件名
        apkName = StringsUtils.getName(apkPath);
        //apkName = "crackMe002.apk";
        apkNoEx = StringsUtils.getFileNameNoEx(apkName);

        System.out.println("# apk签名...");
        MsgShow2TextArea("# apk签名...\n");
        String dir = System.getProperty("user.dir");
        String signDir = dir+ File.separator+"sign";
        String outSignedApk = apkNoEx+"_signed.apk";
        CMDUtils.runCMD("java -jar signapk.jar testkey.x509.pem testkey.pk8 " +
                        dir+File.separator+ apkNoEx + ".apk " +
                        dir+File.separator+ outSignedApk,
                signDir
        );
        MsgShow2TextArea("签名完成...\n");
    }
}
