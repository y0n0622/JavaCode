package com.y0n.ApkShell.Utils;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by y0n on 2017/7/10.
 */
public class ZipFileUtils {
    /**
     * 解压文件
     *
     * @param filePath 压缩文件路径
     */
    public static void unzip(String filePath) {
        File source = new File(filePath);
        if (source.exists()) {
            ZipInputStream zis = null;
            BufferedOutputStream bos = null;
            try {
                zis = new ZipInputStream(new FileInputStream(source));
                ZipEntry entry = null;
                while ((entry = zis.getNextEntry()) != null
                        && !entry.isDirectory()) {
                    File target = new File(StringsUtils.getFileNameNoEx(filePath), entry.getName());
                    if (!target.getParentFile().exists()) {
                        // 创建文件父目录
                        target.getParentFile().mkdirs();
                    }
                    // 写入文件
                    bos = new BufferedOutputStream(new FileOutputStream(target));
                    int read = 0;
                    byte[] buffer = new byte[1024 * 4];
                    while ((read = zis.read(buffer, 0, buffer.length)) != -1) {
                        bos.write(buffer, 0, read);
                    }

                    target.setExecutable(true, false);
                    target.setWritable(true,false);
                    target.setReadable(true, false);

                    bos.flush();
                }

                bos.close();
                zis.closeEntry();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 压缩整个文件夹中的所有文件，生成指定名称的zip压缩包
     * @param filepath 文件所在目录
     * @param zippath 压缩后zip文件名称
     * @param dirFlag zip文件中第一层是否包含一级目录，true包含；false没有
     *
     */
    public static void zipMultiFile(String filepath ,String zippath, boolean dirFlag) {
        try {
            File file = new File(filepath);// 要被压缩的文件夹
            File zipFile = new File(zippath);
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File fileSec:files){
                    if(dirFlag){
                        handlerFile(filepath, zipOut, fileSec, file.getName() + File.separator);
                    }else{
                        handlerFile(filepath, zipOut, fileSec, "");
                    }
                }
            }
            zipOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private static void recursionZip(ZipOutputStream zipOut, File file, String baseDir) throws Exception{
//        if(file.isDirectory()){
//            File[] files = file.listFiles();
//            for(File fileSec:files){
//                recursionZip(zipOut, fileSec, baseDir + file.getName() + File.separator);
//            }
//        }else{
//            byte[] buf = new byte[1024];
//            InputStream input = new FileInputStream(file);
//            zipOut.putNextEntry(new ZipEntry(baseDir + file.getName()));
//            int len;
//            while((len = input.read(buf)) != -1){
//                zipOut.write(buf, 0, len);
//            }
//            input.close();
//        }
//    }

    /**
     48      *
     49      * @param zip 压缩的目的地址
     50      * @param zipOut
     51      * @param srcFile  被压缩的文件信息
     52      * @param path  在zip中的相对路径
     53      * @throws IOException
     54      */
    private static byte[] _byte = new byte[1024] ;
    private static void handlerFile(String zip , ZipOutputStream zipOut , File srcFile , String path ) throws IOException{
        System.out.println(" begin to compression file[" + srcFile.getName() + "]");
        if( !"".equals(path) && ! path.endsWith(File.separator)){
            path += File.separator ;
        }
        if( ! srcFile.getPath().equals(zip) ){
            if( srcFile.isDirectory() ){
                File[] _files = srcFile.listFiles() ;
                if( _files.length == 0 ){
                    zipOut.putNextEntry(new ZipEntry( path + srcFile.getName() + File.separator));
                    zipOut.closeEntry();
                }else{
                    for( File _f : _files ){
                        handlerFile( zip ,zipOut , _f , path + srcFile.getName() );
                    }
                }
            }else{
                InputStream _in = new FileInputStream(srcFile) ;
                zipOut.putNextEntry(new ZipEntry(path + srcFile.getName()));
                int len = 0 ;
                while( (len = _in.read(_byte)) > 0  ){
                    zipOut.write(_byte, 0, len);
                }

                _in.close();
                zipOut.closeEntry();
            }
        }
    }



//    /**
//     * 压缩文件
//     *
//     * @param filePath
//     *            待压缩的文件路径
//     * @return 压缩后的文件
//     */
//    public static File zipMultiFile2(String filePath) {
//        File target = null;
//        File source = new File(filePath);
//        if (source.exists()) {
//            // 压缩文件名=源文件名.zip
//            String zipName = source.getName() + ".zip";
//            target = new File(source.getParent(), zipName);
//            if (target.exists()) {
//                target.delete(); // 删除旧的文件
//            }
//            FileOutputStream fos = null;
//            ZipOutputStream zos = null;
//            try {
//                fos = new FileOutputStream(target);
//                zos = new ZipOutputStream(new BufferedOutputStream(fos));
//                // 添加对应的文件Entry
//                addEntry("", source, zos);
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            } finally {
//                closeQuietly(zos, fos);
//            }
//        }
//        return target;
//    }
//
//    /**
//     * 扫描添加文件Entry
//     *
//     * @param base
//     *            基路径
//     *
//     * @param source
//     *            源文件
//     * @param zos
//     *            Zip文件输出流
//     * @throws IOException
//     */
//    private static void addEntry(String base, File source, ZipOutputStream zos)
//            throws IOException {
//        // 按目录分级，形如：/aaa/bbb.txt
//        String entry = base + source.getName();
//        if (source.isDirectory()) {
//            for (File file : source.listFiles()) {
//                // 递归列出目录下的所有文件，添加文件Entry
//                addEntry(entry + "/", file, zos);
//            }
//        } else {
//            FileInputStream fis = null;
//            BufferedInputStream bis = null;
//            try {
//                byte[] buffer = new byte[1024 * 10];
//                fis = new FileInputStream(source);
//                bis = new BufferedInputStream(fis, buffer.length);
//                int read = 0;
//                zos.putNextEntry(new ZipEntry(entry));
//                while ((read = bis.read(buffer, 0, buffer.length)) != -1) {
//                    zos.write(buffer, 0, read);
//                }
//                zos.closeEntry();
//            } finally {
//                closeQuietly(bis, fis);
//            }
//        }
//    }
//
//
//    /**
//            * 关闭一个或多个流对象
//     *
//             * @param closeables
//     *            可关闭的流对象列表
//     * @throws IOException
//     */
//    public static void close(Closeable... closeables) throws IOException {
//        if (closeables != null) {
//            for (Closeable closeable : closeables) {
//                if (closeable != null) {
//                    closeable.close();
//                }
//            }
//        }
//    }
//
//    /**
//     * 关闭一个或多个流对象
//     *
//     * @param closeables
//     *            可关闭的流对象列表
//     */
//    public static void closeQuietly(Closeable... closeables) {
//        try {
//            close(closeables);
//        } catch (IOException e) {
//            // do nothing
//        }
//    }
}
