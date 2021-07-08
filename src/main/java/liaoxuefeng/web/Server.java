package liaoxuefeng.web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/7/8 8:28
 **/
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);   //监听指定端口
        System.out.println("server is running...");
        for (;;){
            Socket socket = ss.accept();
            System.out.println("connected from "+ socket.getRemoteSocketAddress());
            Thread t = new Handler(socket);
            t.start();
        }
    }

    static class Handler extends Thread {
        Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = this.socket.getInputStream()){
                try (OutputStream output = this.socket.getOutputStream()) {
                    handle(input, output);
                }
            } catch (Exception e){
                try {
                    this.socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("client disconnected.");
            }
        }

        private void handle(InputStream input,OutputStream output) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
            // TODO: 处理HTTP请求
            for (;;){
                String header = reader.readLine();
                if (header.isEmpty()){  //读取到空行时, HTTP Header 读取完毕
                    break;
                }
                System.out.println(header);
            }

            // 发送成功响应
            String data = "<html><body><h1>Hello,world!</h1></body></html>";
            int length = data.getBytes(StandardCharsets.UTF_8).length;
            writer.write("HTTP/1.0 200 OK\r\n");
            writer.write("Connection:close\r\n");
            writer.write("Content-Type:text/html\r\n");
            writer.write("Content-Length:"+ length +"\r\n");
            writer.write("\r\n"); // 空行标识Header和Body分隔
            writer.write(data);
            writer.flush();
        }
    }

}
