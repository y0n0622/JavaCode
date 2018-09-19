package com.bl;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class Main {


    public static void PrintArg(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("      ODex to Smali小工具");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("      h 帮助信息");
        System.out.println("      d  [dir] 将DexExtractor脱壳dump出的dex文件解密为ODex文件");
        System.out.println("      s  [dir] 将所在目录中的ODex文件转为smali代码");
        System.out.println("      f  [filepath] 将ODex文件转为smali代码");
        System.out.println("      ds [dir] 解密脱壳dump文件并转为smali代码");
        System.out.println("      df [filepath] 解密脱壳dump文件并转为smali代码");
        System.out.println("      本工具修改至DexExtractor的DexReverse工程 ");
        System.out.println("--------------------------------------------------------------------");
    }

    public static void paraseArgs(String[] args){
        if (args.length == 0){
            PrintArg();
            return;
        }

        if(args[0].equals("d")){
            System.out.println("[I] 解密dex文件...  " + args[1]);
            decodeDex(args[1]);
        } else if(args[0].equals("s")){
            System.out.println("[I] 转换dex文件为smali... " + args[1]);
            deodex(args[1]);
        } else if(args[0].equals("f")){
            System.out.println("[I] 转换dex文件为smali... " + args[1]);
            deodexFile(args[1]);
        } else if(args[0].equals("b")){
            System.out.println("[I] 转换smali为dex文件... " + args[1]);
            builddexFile(args[1]);
        }
        else if(args[0].equals("ds")){
            System.out.println("[I] 解密dex文件..." + args[1]);
            decodeDex(args[1]);
            System.out.println("[I] 转换dex文件为smali..." + args[1]);
            deodex(args[1]);
        } else if(args[0].equals("df")){
            System.out.println("[I] 解密dex文件..." + args[1]);
            boolean bret = decodeDexFile(args[1]);
            if (!bret) return;
            System.out.println("[I] 转换dex文件为smali..." + args[1]);
            deodexFile(args[1].replace(".dex", ".read.dex"));
        }
        else if(args[0].equals("h")){
            PrintArg();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        paraseArgs(args);

        //
//        String file = "D:\\lianxi\\hongbao\\_classes_7992.read.dexsmali";
//        builddexFile(file);

        //decodeDex(dir);

        //deodex(dir);
        // tesst();
        System.out.println("Main.main() 结束.....");
    }

    private static void decodeDex(String dir) {
        Collection<File> dexFiles = FileUtils.listFiles(new File(dir),
                new String[] { "dex" }, false);

        for (File file : dexFiles) {
            try {
                if (!DexChecker.isDex(file)) {
                    //System.out.println("Boot.decodeDex()" + file.getAbsolutePath() + " : "+DexChecker.isDex(file));
                    DexProcessor.decodeDex(file);
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private static boolean decodeDexFile(String dir) {
        File file = new File(dir);

        try {
            if (!DexChecker.isDex(file)) {
                //System.out.println("Boot.decodeDexFile()" + file.getAbsolutePath()  + " : "+ DexChecker.isDex(file));
                return DexProcessor.decodeDex(file);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public static void deodex(String dir) {
        Collection<File> dexFiles = FileUtils.listFiles(new File(dir),
                new String[] { "dex" }, false);

        for (File file : dexFiles) {
            try {
                if (DexChecker.isOdexFileFile(file)) {
                    System.err.println("Main.deodex()" + file.getAbsolutePath()  + " : "+ DexChecker.isOdexFileFile(file));
                    ODex.dumpToSmalli("D:\\MoGu\\imgupack\\1\\framework", file);
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
                System.out.println("deodex 解析发生错误");
            }
            System.out.println("循环...");
        }
    }

    public static void deodexFile(String dir) {

        File file = new File(dir);

        try {
            if (DexChecker.isOdexFileFile(file)) {
                System.err.println("Main.deodexFile()" + file.getAbsolutePath() + " : "+ DexChecker.isOdexFileFile(file));
                ODex.dumpToSmalli("D:\\MoGu\\imgupack\\1\\framework", file);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void builddexFile(String dir) {

        File file = new File(dir);

        try {
            ODex.smaliToDex(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
