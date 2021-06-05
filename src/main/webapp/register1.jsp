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
    <meta charset="UTF-8">
    <title>注册页面</title>
    <!-- 初始化css -->
    <link rel="stylesheet" href="css/base.css">
    <!-- register css文件 -->
    <link rel="stylesheet" href="css/register.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(function(){
            $("#username").blur(checkUsername);
            $("#password1").blur(checkPassword1);
            $("#password2").blur(checkPassword2);
            $("#email").blur(checkEmail);
            $("#pro").blur(checkPro);

            $("#registerForm").submit(function () {
                if (checkUsername()&&checkPassword1()&&checkPassword2()&&checkEmail()&&checkPro()){
                    $.post("userservlet?method=register",$(this).serialize(),function (data){
                            //注册成功
                        location.href="userservlet?method=register";
                    });
                }
            });

        })
        function checkUsername(){
            if (this.value==null || this.value.trim().length==0){
                return;
            }
            //使用ajax 做username 的异步验证 checkUsername?username=xxxx
            $.post("userservlet?method=checkUserName","username="+this.value,function(data){
                //alert(data);
                if(data=="1"){
                    $("#i1").removeClass("success_icon").addClass("error_icon");
                    $("#username_span").html("<i class='error_icon''></i>用户名已经存在").removeClass("success").addClass("error");
                    $("#registerBtn").attr("disabled",true);
                    return false;
                }
                else{
                    $("#i1").removeClass("error_icon").addClass("success_icon");
                    $("#username_span").html("<i class='success_icon''></i>用户名可用").removeClass("error").addClass("success");
                    $("#registerBtn").removeAttr("disabled");
                    return true;
                }
            })
        }

        function checkPassword1() {
            if (this.value==null || this.value.trim().length==0){
                return;
            }
            var password = $("#password1").val();
            // alert(password);
            var reg_password = /^\w{8,20}$/;
            var flag = reg_password.test(password);

            var regex1 = new RegExp('(?=.*[0-9]).{8,20}');
            var regex2 = new RegExp('(?=.*[0-9])(?=.*[a-z])(?=.*[a-z0-9]).{8,20}');
            var regex3 = new RegExp('(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{8,20}');
            if (regex1.test(password)){
                $("#safe").html("安全程度&nbsp&nbsp<em class='ruo'>弱</em>");
                if(regex2.test(password)){
                    $("#safe").html("安全程度&nbsp&nbsp<em class='zhong'>中</em>");
                    if (regex3.test(password)){
                        $("#safe").html("安全程度&nbsp&nbsp<em class='qiang'>高</em>");
                    }
                }
            }


            if (flag){
                $("#sp2").html("<i class='success_icon''></i>密码格式正确").removeClass("error").addClass("success");
                $("#i2").removeClass("error_icon").addClass("success_icon");
                $("#registerBtn").removeAttr("disabled");
                return true;
            }else {
                $("#sp2").html("<i class='error_icon''></i>密码需要非特殊字符8-20位").removeClass("success").addClass("error");
                $("#i2").removeClass("success_icon").addClass("error_icon");
                $("#registerBtn").attr("disabled",true);
                return false;
            }
        }
        function checkPassword2() {
            if (this.value==null || this.value.trim().length==0){
                return;
            }
            var password1 = $("#password1").val();
            var password2 = $("#password2").val();
            // alert(password);
            if (password1==password2){
                $("#sp3").html("<i class='success_icon''></i>两次密码一致").removeClass("error").addClass("success");
                $("#i3").removeClass("error_icon").addClass("success_icon");
                $("#registerBtn").removeAttr("disabled");
                return true;
            }else {
                $("#sp3").html("<i class='error_icon''></i>两次密码不一致").removeClass("success").addClass("error");
                $("#i3").removeClass("success_icon").addClass("error_icon");
                $("#registerBtn").attr("disabled",true);
                return false;
            }
        }
        function checkEmail(){
            var email = $("#email").val();
            var reg_email = /^\w+@\w+\.\w+$/
            let flag = reg_email.test(email);
            if (flag){
                $("#sp5").html("<i class='success_icon''></i>邮箱格式正确").removeClass("error").addClass("success");
                $("#registerBtn").removeAttr("disabled");
            }else {
                $("#sp5").html("<i class='error_icon''></i>邮箱格式不正确").removeClass("success").addClass("error");
                $("#i5").removeClass("success_icon").addClass("error_icon");
                $("#registerBtn").attr("disabled",true);
            }
            return flag;
        }
        function checkPro() {
            if ($("#pro").is(':checked')){
                $("#sp4").html("<i class='success_icon''></i>已勾选用户协议").removeClass("error").addClass("success");
                $("#i4").removeClass("error_icon").addClass("success_icon");
                $("#registerBtn").removeAttr("disabled");
                return true;
            }else {
                $("#sp4").html("<i class='error_icon''></i>请勾选用户协议").removeClass("success").addClass("error");
                $("#i4").removeClass("success_icon").addClass("error_icon");
                $("#registerBtn").attr("disabled",true);
                return false;
            }
        return false;}

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
            注册新用户
            <em>
                我有账号，去<a href="login1.jsp">登陆</a>
            </em>
        </h3>
        <div class="reg_form">

            <form action="userservlet?method=register" id="registerForm" method="post">
                <ul>
<%--                    <input type="hidden" name="method" value="register" style="">--%>
                    <li>
                        <label >用户名:</label>
                        <input type="text" class="inp" id="username" name="username">
                        <span id="username_span">

						</span>
                    </li>
                    <li>
                        <label >注册邮箱:</label>
                        <input type="text" class="inp" id="email" name="email">
                        <span id="sp5">
							<i  id="i5"></i>
						</span>
                    </li>
                    <li>
                        <label >登陆密码:</label>
                        <input type="password" class="inp" name="password" id="password1">
                        <span id="sp2">
							<i  id="i2"></i>
						</span>
                    </li>
                    <li class="safe" id="safe">

                    </li>

                    <li>
                        <label >确认密码:</label>
                        <input type="password" class="inp" id="password2" name="repassword">
                        <span id="sp3" >
							<i id="i3"></i>
						</span>
                    </li>
                    <li>
                        <label >性别:</label>
                        &nbsp&nbsp&nbsp&nbsp<input type="radio"  name="gender" checked="checked" value="男"> 男
                        &nbsp<input type="radio"  name="gender" value="女"> 女

                    </li>
                    <li style="height: 15px">&nbsp;&nbsp;
                        <div class="text-center" style="color:red ;position: relative;left: 200px" >${registerMsg}</div>
                    </li>
                    <li class="agree">

                        <input type="checkbox" id="pro">同意协议并注册
                        <a href="#">《工大购用户协议》</a>
                        <span id="sp4">
							<i  id="i4"></i>
						</span>
                    </li>
                    <li>
                        <input type="submit" value="完成注册" class="over" id="registerBtn" disabled>
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
            地址：北京市昌平区建材城西路金燕龙办公楼一层 邮编：100096 电话：400-618-4000 传真：010-82935100 邮箱: zhanghj+itcast.cn <br>
            京ICP备08001421号京公网安备110108007702
        </p>
    </div>
</div>
</body>
</html>
