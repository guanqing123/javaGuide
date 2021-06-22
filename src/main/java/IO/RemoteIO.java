package IO;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @description: TODO java远程文件下载
 * @Author guanqing
 * @Date 2021/6/22 15:33
 **/
public class RemoteIO {

    public static void main(String[] args) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            URL urlfile = new URL("https://oss-cn-hangzhou.aliyuncs.com/honyar/202106/1407198056935387138.mp4");
            HttpURLConnection httpUrl = (HttpURLConnection) urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/test.mp4")));
            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
