<%--
  Created by IntelliJ IDEA.
  User: zl363
  Date: 2020/12/17
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="favicon.ico"  type="image/x-icon"/>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <!-- 初始化css -->
    <link rel="stylesheet" href="css/base.css">
    <!-- register css文件 -->
    <link rel="stylesheet" href="css/register.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(
            function(){
            $("#username").blur(checkUsername);
            $("#pagecode").click(function(){
                $("#pagecode").attr("src","userservlet?method=code&"+Math.random());
            });
            $("#autoLogin").click(function(){
            if(this.checked){
                $("#autoLoginMsg").html("非个人请勿勾选此项").css("color","red");
            }else{
                $("#autoLoginMsg").html("");
            }
        });
            }

        );


        function checkUsername(){
            if (this.value==null || this.value.trim().length==0){
                return;
            }
            //使用ajax 做username 的异步验证 checkUsername?username=xxxx
            $.post("userservlet?method=checkUserName","username="+this.value,function(data){
                if(data=="0"){
                    $("#i1").removeClass("success_icon").addClass("error_icon");
                    $("#username_span").html("<i class='error_icon''></i>该用户名尚未注册").removeClass("success").addClass("error");
                    $("#registerBtn").attr("disabled",true);
                    return false;
                }
                else{
                    $("#i1").removeClass("error_icon").addClass("success_icon");
                    $("#username_span").html("<i class='success_icon''></i>该用户名可登录").removeClass("error").addClass("success");
                    $("#registerBtn").removeAttr("disabled");
                    return true;
                }
            })
        }

    </script>
</head>

<body>
<div class="w">
    <!-- header -->
    <div class="header">
        <div class="logo">
            <a href="index.html">
                <img src="img/logo.png" alt="">
            </a>
        </div>
    </div>
    <!-- registerarea -->
    <div class="registerarea">
        <h3>
            用户登录
            <em>
                我没有账号，去<a href="register1.jsp">注册</a>
            </em>
        </h3>
        <div class="reg_form">

            <form action="userservlet?method=login" id="registerForm" method="post">
                <ul>
                    <%--                    <input type="hidden" name="method" value="register" style="">--%>
                    <li>
                        <label >用户名:</label>
                        <input type="text" class="inp" id="username" name="username">
                        <span id="username_span">

						</span>
                    </li>
                    <li>
                        <label >登陆密码:</label>
                        <input type="password" class="inp" name="password" id="password">
                        <span id="sp2">
							<i  id="i2"></i>
						</span>
                    </li>
                        <li>
                            <label >验证码:</label>
                            <input type="text" class="inp" name="valcode" id="" style="width: 150px">
                            <img  id="pagecode" src="userservlet?method=code"><label id="checkMsg"></label>
                            </span>
                        </li>
                        <li style="position: relative;left: 110px"><input id="autoLogin" name="auto" type="checkbox" />&nbsp;&nbsp;两周以内自动登录
                            <span id="autoLoginMsg"></span></li>
                    <li style="height: 15px">&nbsp;&nbsp;
                        <div class="text-center" style="color:red;position: relative;left: 110px" >${msg}</div>
                    </li>
                    <li>
                        <input type="submit" value="登录" class="over" id="registerBtn" disabled>

                    </li>
                </ul>
            </form>

        </div>
    </div>
    <div class="footer">
        <p class="links">
            关于我们  |  联系我们  |  联系客服  |  商家入驻  |  营销中心  |  手机品优购  |  友情链接  |  销售联盟  |  品优购社区  |  品优购公益  |  English Site  |  Contact U
        </p>

        <p class="copyright">
            地址：安徽省马鞍山市雨山区马向路安徽工业大学秀山校区 邮编：100096 电话：400-618-4000 传真：010-82935100 邮箱: zhanghj+itcast.cn <br>
            京ICP备08001421号京公网安备110108007702
        </p>
    </div>
</div>
</body>
</html>
