<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
  </head>
  <body>
    <h3>用户注册</h3>
    <form action="" method="post">
      <p>
        帐号：<input type="text" id="userName"/><label id="tipsLabel"></label>
        <input type="button" value="检测" id="checkBtn"/>
      </p>
      <p>密码：<input type="password"/></p>
      <p>确认密码：<input type="password"/></p>
      <p>姓名：<input type="text"/></p>
      <p>电话：<input type="text"/></p>
      <p><input type="submit" value="提交注册"/></p>
    </form>
  <script type="text/javascript">
    $("#checkBtn").click(function(){
      //发送ajax请求，验证用户名是否可用
      var name = $("#userName").val();
     /* $.ajax({
        url:"CheckUserNameServlet?userName="+name,  //url传递用户名
        type:"get",
        success:function(res){
            console.log(res);
            if(res.code == 1000){
               $("#tipsLabel").replaceWith("<label id='tipsLabel' style='color:green'>用户名可用！</label>");
            }else{
               $("#tipsLabel").replaceWith("<label id='tipsLabel' style='color:red'>用户名不可用！</label>");
            }
        }
      });
      */
      // 参数1：请求的url
      // 参数2：传递的参数
      // 参数3：回调函数
      // 参数4：服务器返回的数据的格式  （json,html,text,xml）
     $.post("CheckUserNameServlet",{userName:name},function(res){
         if(res.code == 1000){
           $("#tipsLabel").replaceWith("<label id='tipsLabel' style='color:green'>用户名可用！</label>");
         }else{
           $("#tipsLabel").replaceWith("<label id='tipsLabel' style='color:red'>用户名不可用！</label>");
         }
     },"json");

    });
  </script>
  </body>
</html>
