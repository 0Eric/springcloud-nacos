package com.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class SocketServer {

    private static Log log = LogFactory.getLog(SocketServer.class);
    private static final Integer SERVER_PORT = 9999;


    public static void main(String[] args) {

        System.out.println("服务端启动...........");
        //1:创建服务器端套接字
        ServerSocket server = null;
        try {
            server = new ServerSocket(9000);
            while (true) {
                //2:监听客户端的套接字
                Socket socket = server.accept();
                //3:获取输入流
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //4:获取输出流
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                //4:读取数据
                while (true) {
                    String content = br.readLine();
                    System.out.println("服务端：接收到客户端发送内容：" + content);
                    if (content == null || "".equals(content)) {
                        break;
                    }
                }

                //写会内容，通知客户端
                bw.write("登陆成功");
                bw.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("服务端：读取数据失败：" + e);
        }
    }

}

