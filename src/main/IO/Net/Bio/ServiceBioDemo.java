package IO.Net.Bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServiceBioDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9988);

        while(true){
            System.out.println("阻塞开始等待数据");
            Socket accept = serverSocket.accept();
            System.out.println("获取数据成功");

            byte[] receiveDataBuf = new byte[1024];
            StringBuilder req = new StringBuilder();
            while (true) {
                int len = accept.getInputStream().read(receiveDataBuf);
                if (len == -1) {
                    break;
                }
                req.append(new String(receiveDataBuf, 0, len, StandardCharsets.UTF_8));
            }
            System.out.println("收到数据：".concat(req.toString()));
            accept.getOutputStream().write(("响应数据：收到请求".getBytes()));
            accept.shutdownOutput();
        }

    }
}
