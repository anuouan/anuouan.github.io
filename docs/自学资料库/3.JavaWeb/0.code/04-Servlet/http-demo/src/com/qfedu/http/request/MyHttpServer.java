package com.qfedu.http.request;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class MyHttpServer {

    public static void main(String[] args) throws IOException {

        //创建一个网络服务器（可以通过浏览器请求这个服务）
        ServerSocket serverSocket = new ServerSocket(9999);
        //当浏览器请求我这个服务器之后，就建立网络连接（socket对象）
        Socket socket = serverSocket.accept();
        //通过socket对象的输入流，
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        //读取 浏览器发送的 HTTP请求
        String content = null;
//        while( !"" .equals(content = reader.readLine())){
        while( (content = reader.readLine())!=null){
            System.out.println(content);
        }

        // 自定义HTTP服务器响应浏览器
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("HTTP/1.1 200 OK");
        out.println("Connection: keep-alive");
        out.println("Content-Length: 154");
        out.println("Content-Type: text/html;charset=utf-8");
        out.println("Date: Sun, 07 Nov 2021 17:52:42 GMT");
        out.println("Location: https://www.baidu.com/");
        out.println("P3p: CP=\" OTI DSP COR IVA OUR IND COM \"");
        out.println("P3p: CP=\" OTI DSP COR IVA OUR IND COM \"");
        out.println("Server: BWS/1.1");
        out.println("X-Frame-Options: sameorigin");
        out.println("X-Ua-Compatible: IE=Edge,chrome=1");
        out.println("");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>这是自定义服务器响应的页面</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<label style='color:red'>这是自定义服务器响应的内容 </label>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

}
