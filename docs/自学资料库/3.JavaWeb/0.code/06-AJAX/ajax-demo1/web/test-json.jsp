<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/test.js"></script>
  </head>
  <body>
    <h3>测试前端JSON格式转换</h3>
    <input type="button" value="测试" onclick="testJson()"/>
    <script type="text/javascript">
      function testJson(){
        //1.将JS对象转换成JSON格式字符串
        var obj = {stuNum:"10001",stuName:"张三"};
        obj.stuGender = "男";
        var jsonStr = JSON.stringify(obj);

        //发送异步请求，将JSON格式的字符串提交到TestJsonServlet
        var ajaxReq;
        if(window.XMLHttpRequest){
           ajaxReq = new XMLHttpRequest();
        }else{
          ajaxReq = new ActiveXObject("Microsoft.XMLHTTP");
        }
        ajaxReq.open("POST","TestJsonServlet",true);
        ajaxReq.onreadystatechange = function(){
            if(ajaxReq.status==200 && ajaxReq.readyState==4){
                var s = ajaxReq.responseText;
                //将接收的服务器的响应的JSON字符串转换成js对象
              var stu = eval("("+s+")");
              console.log(stu.stuName);
            }
        };
        //ajax采用的是POST请求，将json格式字符串通过请求正文提交
        ajaxReq.send(jsonStr);
      }
    </script>
  </body>
</html>
