package IO.Net.Bio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 功能：
 * 详情：
 *
 * @author ChenCaihua
 * @since 2019年11月10日
 */
public class ClientBioDemo {

    public static void main(String[] args) throws Exception {


        Socket socket = new Socket(InetAddress.getLocalHost(), 9988);

        socket.getOutputStream().write(("[我是客户端请求消息" + System.currentTimeMillis() + "]").getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();


        byte[] recvByteBuf = new byte[1024];
        StringBuilder resp = new StringBuilder();
        while (true) {
            int len = socket.getInputStream().read(recvByteBuf);
            if(len==-1){
                break;
            }
            resp.append(new String(recvByteBuf, 0, len, StandardCharsets.UTF_8));
        }
        System.out.println("收到服务端返回消息: " + resp.toString() + ",time = " + System.currentTimeMillis());

    }
}
