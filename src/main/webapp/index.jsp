<%--
  Created by IntelliJ IDEA.
  User: zl363
  Date: 2020/12/18
  Time: 11:11
  To change this template use File | Settings | File Templates.
  仙人保佑，阿乐的代码永无bug
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>安工大商城-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
    <meta name="description" content="品优购JD.COM-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货、服装服饰、母婴、图书、食品等数万个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!" />
    <meta name="Keywords" content="网上购物,网上商城,手机,笔记本,电脑,MP3,CD,VCD,DV,相机,数码,配件,手表,存储卡,品优购" />
    <!-- 引入facicon.ico网页图标 -->
    <link rel="shortcut icon" href="favicon.ico"  type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/login2.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入css 初始化的css 文件 -->
    <link rel="stylesheet" href="css/base.css">
    <!-- 引入公共样式的css 文件 -->
    <link rel="stylesheet" href="css/common.css">
    <!-- 引入 首页的css文件 -->
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
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
            });
        })
    </script>
</head>
<body>

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

<div class="header w">


    <!-- logo -->
        <%--    <a href=""><img id="logo" src="image/logo_top.png" width="55" height="54"/></a>--%>
        <a href="" id="seimg" style=" margin-top:17px;"><img id="gif" src="img/logo.png" width="180" height="66" /></a>
        <p id="goodsType" style="position: relative;left: 100px;top: -20px">
            <!-- 根据ajax 回调函数 填写数据 到此id中 -->
        </p>
    </div>



    <!-- search -->
    <div class="search" style="position: relative;left: 450px;top: -50px;">
        <form action="${pageContext.request.contextPath}/goodsservlet?method=SearchGoods" method="post">
            <input type="text" class="text" placeholder="搜索一下好东西..." name="GoodName">
<%--            <button class="btn">搜索</button>--%>
            <input type="submit" class="btn" value="搜索">
        </form>
    </div>

    <div class="shopcar" style="position: relative;left: 1050px;top: -50px; ">
        <a href="${pageContext.request.contextPath}/cartservlet?method=getCart" style="position:relative;top: -35px;"><div><i class="car" > </i>我的购物车 <i class="arrow">  </i></div></a>
    </div>

<!-- header 结束 -->
<!-- nav start -->
<!-- nav end  -->
<!-- main 模块 -->
<%--中间模块--%>
<div id="thred">
    <img src="image/1111.jpg" width="1230" height="460" />
</div>
<div id="forth">
   		<span>
        	<a href=""><img src="image/hjh_01.gif" /></a>
            <a href=""><img src="image/hjh_02.gif" /></a>
            <a href=""><img src="image/hjh_03.gif" /></a>
            <a href=""><img src="image/hjh_04.gif" /></a>
            <a href=""><img src="image/hjh_05.gif" /></a>
            <a href=""><img src="image/hjh_06.gif" /></a>
        </span>
    <a href="" id="a_left"><img src="image/2222.jpg" width="316" height="170" /></a>
    <a href="" id="a_left"><img src="image/3333.jpg" width="316" height="170" /></a>
    <a href="" id="a_left"><img src="image/4444.jpg" width="316" height="170" /></a>
</div>
<div id="fifth">
    <span id="fif_text">小米明星单品</span>
</div>
<div id="sixth">
            <span style="margin-left:0px; border-top:#ffa500 1px solid">
            	<a href="" id="siximg"><img src="image/pinpai1.png" width="234" height="234" /></a>
            	<a href="" id="na">小米MIX</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">3499元起</p>
            </span>
    <span style=" border-top:#008000 1px solid">
            	<a href="" id="siximg"><img src="image/pinpai2.png" width="234" height="234" /></a>
                <a href="" id="na">小米MIX</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">3499元起</p>
            </span>
    <span style="border-top:#0000ff 1px solid">
            	<a href="" id="siximg"><img src="image/pinpai3.png" width="234" height="234" /></a>
                <a href="" id="na">小米MIX</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">3499元起</p>
            </span>
    <span style="border-top:#ff0000 1px solid">
            	<a href="" id="siximg"><img src="image/pinpai4.png" width="234" height="234" /></a>
                <a href="" id="na">小米MIX</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">3499元起</p>
            </span>
    <span style="border-top:#008080 1px solid">
            	<a href="" id="siximg"><img src="image/pinpai5.png" width="234" height="234" /></a>
                <a href="" id="na">小米MIX</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">3499元起</p>
            </span>
</div>


<div class="footer">
    <div class="w">
        <!-- mod_service -->
        <div class="mod_service">
            <ul>
                <li>
                    <i class="mod-service-icon mod_service_zheng"></i>
                    <div class="mod_service_tit">
                        <h5>正品保障</h5>
                        <p>正品保障，提供发票</p>
                    </div>
                </li>
                <li>
                    <i class="mod-service-icon mod_service_kuai"></i>
                    <div class="mod_service_tit">
                        <h5>正品保障</h5>
                        <p>正品保障，提供发票</p>
                    </div>
                </li>
                <li>
                    <i class="mod-service-icon mod_service_bao"></i>
                    <div class="mod_service_tit">
                        <h5>正品保障</h5>
                        <p>正品保障，提供发票</p>
                    </div>
                </li>
                <li>
                    <i class="mod-service-icon mod_service_bao"></i>
                    <div class="mod_service_tit">
                        <h5>正品保障</h5>
                        <p>正品保障，提供发票</p>
                    </div>
                </li>
                <li>
                    <i class="mod-service-icon mod_service_bao"></i>
                    <div class="mod_service_tit">
                        <h5>正品保障</h5>
                        <p>正品保障，提供发票</p>
                    </div>
                </li>
            </ul>
        </div>
        <!-- mod_help -->
        <div class="mod_help">
            <dl class="mod_help_item">
                <dt>购物指南</dt>
                <dd> <a href="#">购物流程 </a></dd>
                <dd> <a href="#">会员介绍 </a></dd>
                <dd> <a href="#">生活旅行/团购 </a></dd>
                <dd> <a href="#">常见问题 </a></dd>
                <dd> <a href="#">大家电 </a></dd>
                <dd> <a href="#">联系客服 </a></dd>
            </dl>
            <dl class="mod_help_item">
                <dt>购物指南</dt>
                <dd> <a href="#">购物流程 </a></dd>
                <dd> <a href="#">会员介绍 </a></dd>
                <dd> <a href="#">生活旅行/团购 </a></dd>
                <dd> <a href="#">常见问题 </a></dd>
                <dd> <a href="#">大家电 </a></dd>
                <dd> <a href="#">联系客服 </a></dd>
            </dl>
            <dl class="mod_help_item">
                <dt>购物指南</dt>
                <dd> <a href="#">购物流程 </a></dd>
                <dd> <a href="#">会员介绍 </a></dd>
                <dd> <a href="#">生活旅行/团购 </a></dd>
                <dd> <a href="#">常见问题 </a></dd>
                <dd> <a href="#">大家电 </a></dd>
                <dd> <a href="#">联系客服 </a></dd>
            </dl>
            <dl class="mod_help_item">
                <dt>购物指南</dt>
                <dd> <a href="#">购物流程 </a></dd>
                <dd> <a href="#">会员介绍 </a></dd>
                <dd> <a href="#">生活旅行/团购 </a></dd>
                <dd> <a href="#">常见问题 </a></dd>
                <dd> <a href="#">大家电 </a></dd>
                <dd> <a href="#">联系客服 </a></dd>
            </dl>
            <dl class="mod_help_item">
                <dt>购物指南</dt>
                <dd> <a href="#">购物流程 </a></dd>
                <dd> <a href="#">会员介绍 </a></dd>
                <dd> <a href="#">生活旅行/团购 </a></dd>
                <dd> <a href="#">常见问题 </a></dd>
                <dd> <a href="#">大家电 </a></dd>
                <dd> <a href="#">联系客服 </a></dd>
            </dl>
            <dl class="mod_help_item mod_help_app">
                <dt>帮助中心</dt>
                <dd>
                    <img src="upload/erweima.png" alt="">
                    <p>品优购客户端</p>
                </dd>
            </dl>
        </div>

        <!-- mod_copyright  -->
        <div class="mod_copyright">
            <p class="mod_copyright_links">
                关于我们  |  联系我们  |  联系客服  |  商家入驻  |  营销中心  |  手机品优购  |  友情链接  |  销售联盟  |  品优购社区  |  品优购公益  |  English Site  |  Contact U
            </p>
            <p class="mod_copyright_info">
                地址：安徽省马鞍山市雨山区马向路安徽工业大学秀山校区 邮编：100096 电话：400-618-4000 传真：010-82935100 邮箱: zhanghj+itcast.cn  <br>
                皖ICP备08001421号京公网安备110108007702
            </p>
        </div>
    </div>
</div>
<!-- footer end -->
</body>
</html>
