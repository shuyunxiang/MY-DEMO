package IO.Net.Bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        byte[] recvByteBuf = new byte[1024];

        Scanner sco = new Scanner(System.in);
        while (sco.hasNext()) {

            // 写入数据
            outputStream.write(sco.nextLine().getBytes(StandardCharsets.UTF_8));

            // 获取数据
            int len = inputStream.read(recvByteBuf);

            // 获取响应
            System.out.println("收到服务端返回消息: "
                    .concat(new String(recvByteBuf, 0, len, StandardCharsets.UTF_8) + ",time = " + System.currentTimeMillis()));
        }

    }


}
