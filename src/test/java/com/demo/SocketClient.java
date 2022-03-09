package com.demo;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.Socket;

/**
 * 服务端
 */
public class SocketClient {
    private static Log log = LogFactory.getLog(SocketClient.class);

//    private static String HOST = "192.168.0.174";
    private static String HOST = "8.135.42.12";
    private static int PORT = 7000;

    public static void main(String[] args) {

        System.out.println("服务端启动...........");
        //1:创建服务器端套接字
        Socket socket = null;
        try {
            //建立连接
            log.info(">>>>>>>>>>>>>>>连接信息host: " + HOST + ",端口：" + PORT);
            //建立连接
            socket = new Socket(HOST, PORT);
            log.info(">>>>>>>>>>>>>>>客户端建立连接");
            //2:获取输出流
            OutputStream outputStream = socket.getOutputStream();
            //3 获取输入流
            InputStream inputStream = socket.getInputStream();
            //3:获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            //4:获取输出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

            //3:写数据到服务端
            bw.write("VM00061830617500");
            bw.flush();
            //告诉服务器。客户端这边数据写入完毕
            socket.shutdownOutput();

            //4:读取从服务器响应的数据
            while (true) {
                String content = br.readLine();
                System.out.println("客户端：接收到服务端发送内容：" + content);
                if (content == null || "".equals(content)) {
                    break;
                }
            }
//            List<Integer> resList = new ArrayList<>();
//            int len = 0;
//            while ((len = inputStream.read()) != -1) {
//                resList.add(len);
//                log.info(">>>>>>>>服务端响应数据：" + len);
//            }
//            log.info(">>>>>>>>服务端响应数据resList：" + resList);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("客户端：读取数据失败：" + e);
            IOUtils.closeQuietly(socket);
        }
    }

}

