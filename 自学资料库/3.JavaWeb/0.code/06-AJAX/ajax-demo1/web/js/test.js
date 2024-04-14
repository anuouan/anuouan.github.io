var ajaxReq;

function checkUserName(){
    //发送ajax请求到CheckUserNameServlet，并将用户名传递
    //1、创建ajax请求对象
    if(window.XMLHttpRequest){
        ajaxReq = new XMLHttpRequest();
    }else{
        ajaxReq = new ActiveXObject("Microsoft.XMLHTTP");
    }
    console.log("---------"+ajaxReq.readyState);

    //2、封装ajax请求数据（初始化）
    var userName = document.getElementById("userName").value;
    var method = "GET";
    var url = "CheckUserNameServlet?userName="+userName;
    var async = true;
    ajaxReq.open(method,url,async);
    console.log("---------"+ajaxReq.readyState);

    //3、指定ajax请求的回调函数
    // ajaxReq请求对象是有状态的，可以通过ajaxReq.readyState获取状态值
    // ajaxReq请求对象的不同状态值表示异步交互的不同阶段
    // ajaxReq.readyState == 0  表示ajax请求对象完成创建但并未初始化
    // ajaxReq.readyState == 1  表示ajax请求对象完成初始化但未发送请求
    // ajaxReq.readyState == 2  表示ajax请求已经发送并到达服务器
    // ajaxReq.readyState == 3  表示服务器正在处理ajax请求（通信....）
    // ajaxReq.readyState == 4  表示服务器正处理完成，ajax请求对象已经成功获取响应结果

    // 只要ajax请求状态发送变化，就会触发这个回调函数的执行
    ajaxReq.onreadystatechange = callback;

    //4、发送请求
    ajaxReq.send(null);
}

//回调函数：处理结果
function callback(){
    //获取服务器响应结果的两个条件：
    //1.异步请求完成 ajaxReq.readyState == 4
    //2.http状态为200  ajaxReq.status == 200
    if(ajaxReq.readyState == 4 && ajaxReq.status == 200){
        //获取结果
        // 如果服务器响应的是文本数据（字符串），使用responseText属性接收
        var result = ajaxReq.responseText;
        // 如果服务器响应的是XML文件，使用responseXML属性接收
        // var doc = ajaxReq.responseXML;
        // 将获取的响应结果显示到网页的标签中
        document.getElementById("tipsLabel").innerHTML = result;
    }
}