<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="shortcut icon" href="favicon.ico"  type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- 引入css 初始化的css 文件 -->
<link rel="stylesheet" href="css/base.css">
<!-- 引入公共样式的css 文件 -->
<link rel="shortcut icon" href="favicon.ico"  type="image/x-icon"/>
<link rel="stylesheet" href="css/common.css">
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/goodstypeservlet?method=goodstypelist",
			type:"GET",
			success:function(data){
				for(var i in data){
					var a = $("<a href='${pageContext.request.contextPath}/goodsservlet?method=getGoodsListByTypeId&typeId="+data[i].id+"'>"+data[i].name+"</a>");
					$("#goodsType").append(a);
					
				}
			},
			dataType:"json",
			error:function(){
				alert("失败");
			}
		})
	})
</script>
		
<%-- <div id="top">--%>
<%--    	<div id="topdiv">--%>
<%--            <span>--%>
<%--                <a href="index.jsp" id="a_top" target="_blank">小米商城</a>--%>
<%--                <li>|</li>--%>
<%--                <a href="" id="a_top">小米商城移动版</a>--%>
<%--                <li>|</li>--%>
<%--                <a href="" id="a_top">问题反馈</a>--%>
<%--            </span>--%>
<%--            <span style="float:right">--%>
<%--           		<c:if test="${empty user}">--%>
<%--	                <a href="login.jsp" id="a_top">登录</a>--%>
<%--	                <li>|</li>--%>
<%--	                <a href="register.jsp" id="a_top">注册</a>--%>
<%--           		</c:if>--%>
<%--       			<c:if test="${not empty user}">--%>
<%--       				<a href="userAddress?flag=show" id="a_top">${user.username}</a>--%>
<%--       				<li>|</li>--%>
<%--       				<a href="userservlet?method=logOut" id="a_top">注销</a>--%>
<%--       				<li>|</li>--%>
<%--       				<a href="getOrderList" id="a_top">我的订单</a>--%>
<%--       				<li>|</li>--%>
<%--       				<a href="userservlet?method=getAddress" id="a_top">地址管理</a>--%>
<%--       			</c:if>--%>
<%--                <li>|</li>--%>
<%--                <a href="" id="a_top">消息通知</a>--%>
<%--                <a href="${pageContext.request.contextPath}/cartservlet?method=getCart" id="shorpcar">购物车</a>--%>
<%--            </span>--%>
<%--        </div>--%>
<%-- </div>--%>
<div id="top" style="background-color:#c81623;color: white">
	<div id="topdiv" >
            <span>
                <a href="index.jsp" id="a_top" target="_blank" style="color: white">安工大商城</a>
                <li>|</li>
                <a href="" id="a_top" style="color: white">安工大商城移动版</a>
                <li>|</li>
                <a href="" id="a_top" style="color: white">问题反馈</a>
            </span>
		<span style="float:right">
           		<c:if test="${empty user}">
					<a href="login1.jsp" id="a_top" style="color: white">登录</a>
					<li>|</li>
					<a href="register1.jsp" id="a_top" style="color: white">注册</a>
				</c:if>
       			<c:if test="${not empty user}">
					<a href="userservlet?method=getAddress" id="a_top">${user.username}</a>
					<li>|</li>
					<a href="userservlet?method=logOut" id="a_top">注销</a>
					<li>|</li>
					<a href="userservlet?method=getOrderList" id="a_top">我的订单</a>
					<li>|</li>
					<a href="userservlet?method=getAddress" id="a_top">地址管理</a>
				</c:if>
                <li>|</li>
                <a href="" id="a_top">消息通知</a>
                <a href="${pageContext.request.contextPath}/cartservlet?method=getCart" id="shorpcar">购物车</a>
            </span>
	</div>
</div>
<div id="second">
	    <a href="${pageContext.request.contextPath}/index.jsp" id="seimg" style=" margin-top:23px;"><img id="logo" src="img/logo.png" width="" height="54"/></a>
<%--        <a href="" id="seimg" style=" margin-top:17px;"><img id="gif" src="image/yyymix.gif" width="180" height="66" /></a>--%>
        <p id="goodsType">
			<!-- 根据ajax 回调函数 填写数据 到此id中 -->
        </p>
       <form class="form-inline pull-right" style="margin-top: 40px;margin-right: 10px;" action="${pageContext.request.contextPath}/goodsservlet?method=SearchGoods" method="post">
		
		  <div class="form-group">
		    <input type="text" class="form-control" style="width: 400px"  placeholder="搜索一下好东西..." name="GoodName">
		  </div>
		  <button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;搜索</button>
	  </form>
</div>
