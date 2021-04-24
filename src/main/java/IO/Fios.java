package IO;

import java.io.*;

/**
 * @description: TODO 输入输出流
 * @Author guanqing
 * @Date 2021/4/24 20:58
 **/
public class Fios {

    public static final String source = "src/main/resources/现金流量代码.txt";
    public static final String dest = "src/main/resources/dest.txt";

    public static void io() throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
             in = new FileInputStream(source);
             out = new FileOutputStream(dest);

            byte[] bytes = new byte[1024];
            int n;

            while ((n = in.read(bytes)) != -1) {
                out.write(bytes);
            }
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }

    public static void main(String[] args) throws IOException {
        io();
    }
}
