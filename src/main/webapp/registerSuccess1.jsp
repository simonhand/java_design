
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
    <link rel="shortcut icon" href="favicon.ico"  type="image/x-icon"/>
    <!-- register css文件 -->
    <link rel="stylesheet" href="css/register.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

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
            验证新用户
            <em>
                我有账号，去<a href="login1.jsp">登陆</a>
            </em>
        </h3>
        <div class="reg_form" style="position: relative">
            <a href="${pageContext.request.contextPath}/userservlet?method=active" style="position: relative;left: 100px;" ><input type="button" name=""  class="over" id="" value="现在激活"></a>
            <a href="${pageContext.request.contextPath}/index.jsp" style="position: relative;left: 100px;"><input type="button" name="" class="over" id="" value="稍后激活"></a>
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

