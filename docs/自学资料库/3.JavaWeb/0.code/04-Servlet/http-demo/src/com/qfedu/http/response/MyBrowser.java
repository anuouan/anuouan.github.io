package com.qfedu.http.response;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.Socket;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class MyBrowser {

    public static void main(String[] args) throws IOException {
        //将上一个案例中浏览器发送给 MyHttpServer的 http请求内容，发送给百度

        // 1.向百度服务器发送链接请求
        Socket socket = new Socket("www.baidu.com", 80);
        // 2.通过链接中的输出流，将HTTP请求内容发送给百度
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream);
        out.println("GET /s HTTP/1.1");
        out.println("Host: www.baidu.com:80");
        out.println("Connection: keep-alive");
        out.println("sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"");
        out.println("sec-ch-ua-mobile: ?0");
        out.println("sec-ch-ua-platform: \"Windows\"");
        out.println("Upgrade-Insecure-Requests: 1");
        out.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36");
        out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        out.println("Sec-Fetch-Site: none");
        out.println("Sec-Fetch-Mode: navigate");
        out.println("Sec-Fetch-User: ?1");
        out.println("Sec-Fetch-Dest: document");
        out.println("Accept-Encoding: gzip, deflate, br");
        out.println("Accept-Language: zh-CN,zh;q=0.9");
        out.println("");
        out.flush();
        //3.通过输入流接受百度的响应数据（HTTP响应规则）
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String responseContent = null;
        while( (responseContent = reader.readLine())!=null){
            System.out.println(responseContent);
        }

    }
}
