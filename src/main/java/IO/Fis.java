package IO;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description: TODO 输入流
 * @Author guanqing
 * @Date 2021/4/23 9:15
 **/
public class Fis {

    public static final String filePath = "src/main/resources/现金流量代码.txt";

    /**
    * @ Author:guanqing
    * @ Date 2021/4/24 12:47
    * @ Description //一个字节一个字节读
    * @ Param[]
    * @ return void
    **/
    public static void read() throws IOException{
        long start = System.currentTimeMillis();
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
            int n;
            while ((n = in.read()) != -1) {
                System.out.print(n);
            }
            System.out.println();
        } finally {
            if (in != null)
                in.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时1："+ (end - start) +" ms");
    }

    /**
    * @ Author:guanqing
    * @ Date 2021/4/24 12:48
    * @ Description //带缓冲的读
    * @ Param[]
    * @ return void
    **/
    public static void readBuffer() throws IOException{
        long tStart = System.currentTimeMillis();
        InputStream in = null;

        try {
            in = new FileInputStream(filePath);
            byte[] buffer = new byte[1024];
            int tn;
            StringBuilder sb = new StringBuilder();
            while ((tn = in.read(buffer)) != -1){
                System.out.print("read "+ tn + " bytes.");
                sb.append(new String(buffer, "UTF-8"));
            }
            System.out.println();
            System.out.println("sb>>"+sb.toString());
        } finally {
            if (in != null)
                in.close();
        }

        long tEnd = System.currentTimeMillis();
        System.out.println("用时2："+ (tEnd - tStart) + "ms");
    }

    /**
    * @ Author:guanqing
    * @ Date 2021/4/24 12:48
    * @ Description //ByteArrayInputStream
    * @ Param[]
    * @ return void
    **/
    public static void readBAIS() throws IOException {
        byte[] data = {72, 101, 108, 108, 111, 33};

        InputStream in = null;
        try {
             in = new ByteArrayInputStream(data);
            int n;
            while ((n = in.read())!=-1){
                System.out.print((char) n);
            }
        } finally {
            if (in != null)
                in.close();
        }
    }

    /**
    * @ Author:guanqing
    * @ Date 2021/4/24 19:53
    * @ Description //读取文本字符串
    * @ Param[]
    * @ return void
    **/
    public static void readAsString(InputStream in) throws IOException {
        try {
            int n;
            StringBuilder sb = new StringBuilder();
            while ((n = in.read()) != -1){
                sb.append((char)n);
            }
            System.out.println("str>>"+sb.toString());
        } finally {
            if (in != null)
                in.close();
        }
    }

    /**
    * @ Author:guanqing
    * @ Date 2021/4/24 20:00
    * @ Description //读取本地文件
    * @ Param[]
    * @ return void
    **/
    public static void readLocal() throws IOException {
        InputStream in = new FileInputStream(filePath);
        readAsString(in);
    }

    /**
    * @ Author:guanqing
    * @ Date 2021/4/24 20:03
    * @ Description //读取内存字节
    * @ Param[]
    * @ return void
    **/
    public static void readMemory() throws IOException {
        byte[] bytes = { 72, 101, 108, 108, 111, 33 };
        InputStream in = new ByteArrayInputStream(bytes);
        readAsString(in);
    }

    public static void main(String[] args) throws IOException {
        /*read();
        readBuffer();
        readBAIS();
        readLocal();
        readMemory();*/
        readBuffer();
    }
}
