package IO;

import java.io.*;

/**
 * @description: TODO 输出流
 * @Author guanqing
 * @Date 2021/4/24 20:22
 **/
public class Fos {

    public static final String FilePath = "src/main/resources/readme.txt";

    /**
    * @ Author:guanqing
    * @ Date 2021/4/24 20:38
    * @ Description //删除存在的文件
    * @ Param[filePath]
    * @ return void
    **/
    public static void deleteFileIfExist(String filePath){
        File file = new File(filePath);
        if (file.exists())
            file.delete();
    }

    /**
    * @ Author:guanqing
    * @ Date 2021/4/24 20:26
    * @ Description //一个字节一个字节写
    * @ Param[]
    * @ return void
    **/
    public static void writeByte() throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream(FilePath);
            out.write(72);  // H
            out.write(101); // e
            out.write(108); // l
            out.write(108); // l
            out.write(111); // o
        } finally {
            if (out != null)
                out.close();
        }
    }

    /*
    * @ Author:guanqing
    * @ Date 2021/4/24 20:35
    * @ Description //一次性读取多个字节
    * @ Param[]
    * @ return void
    **/
    public static void writeBytes() throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream(FilePath);
            out.write("Hello 中国".getBytes("UTF-8"));
        } finally {
            if (out != null)
                out.close();
        }
    }

    /*
    * @ Author:guanqing
    * @ Date 2021/4/24 20:56
    * @ Description //ByteArrayOutputStream
    * @ Param[]
    * @ return void
    **/
    public static void writeBAOS() throws IOException {
        ByteArrayOutputStream out = null;
        try {
            byte[] bytes;
            out = new ByteArrayOutputStream();
            out.write("Hello ".getBytes("UTF-8"));
            out.write("World!".getBytes("UTF-8"));
            bytes = out.toByteArray();
            System.out.println(new String(bytes, "UTF-8"));
        } finally {
            if (out != null)
                out.close();
        }
    }

    public static void main(String[] args) throws IOException {
//        writeByte();
//        writeBytes();
//        deleteFileIfExist(FilePath);
//        writeBytes();
//        writeBAOS();
    }

}
