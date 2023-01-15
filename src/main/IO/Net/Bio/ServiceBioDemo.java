package IO.Net.Bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServiceBioDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9988);

        System.out.println("阻塞开始等待连接");
        Socket accept = serverSocket.accept();
        System.out.println("阻塞结束获得连接");

        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

        byte[] receiveDataBuf = new byte[1024];

        while (true) {
            // 读取数据放入缓存
            int len = inputStream.read(receiveDataBuf);
            if (len == -1) {
                break;
            }

            // 序列化
            System.out.println("收到数据：".concat(new String(receiveDataBuf, 0, len, StandardCharsets.UTF_8)));

            // 回写数据
            outputStream.write(("响应数据：收到请求".getBytes()));
        }

        // 关闭当前连接，如果关闭，无法再次获取数据
        accept.shutdownOutput();
    }
}
