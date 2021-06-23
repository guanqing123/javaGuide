package IO;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.http.HttpUtil;

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

/*        String path = RemoteIO.class.getClassLoader().getResource("src/main/resources").getPath();
        System.out.println("path >> " + path);*/

        String fileUrl = "https://oss-cn-hangzhou.aliyuncs.com/honyar/202106/1407198056935387138.mp4";
        //带进度显示的文件下载
        HttpUtil.downloadFile(fileUrl, FileUtil.file("src/main/resources/ht.mp4"), new StreamProgress() {
//        HttpUtil.downloadFile(fileUrl, new File("src/main/resources/t.mp4"), new StreamProgress() {
            @Override
            public void start() {
                System.out.println("开始下载...");
            }

            @Override
            public void progress(long l) {
                System.out.println("已下载: " + FileUtil.readableFileSize(l));
            }

            @Override
            public void finish() {
                System.out.println("下载完成!");
            }
        });
    }

    public static void download(){
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
