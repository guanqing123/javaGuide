package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/4/23 9:15
 **/
public class Fis {

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();
        InputStream in = null;
        try {
            in = new FileInputStream("src/main/resources/现金流量代码.txt");
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

        long tStart = System.currentTimeMillis();
        InputStream tin = null;

        try {
            tin = new FileInputStream("src/main/resources/现金流量代码.txt");
            byte[] buffer = new byte[1024];
            int tn;
            while ((tn = tin.read(buffer)) != -1){
                System.out.println("read"+ tn + "bytes.");
            }
            System.out.println();
        } finally {
            if (tin != null)
                tin.close();
        }

        long tEnd = System.currentTimeMillis();
        System.out.println("用时2："+ (tEnd - tStart) + "ms");
    }

}
