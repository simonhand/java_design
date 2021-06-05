/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-16 14:46:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"#username\").change(function(){\r\n");
      out.write("\t\t\tif (this.value==null || this.value.trim().length==0){\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//使用ajax 做username 的异步验证 checkUsername?username=xxxx\r\n");
      out.write("\t\t\t$.post(\"userservlet?method=checkUserName\",\"username=\"+this.value,function(data){\r\n");
      out.write("\t\t\t\t//alert(data);\r\n");
      out.write("\t\t\t\tif(data==\"1\"){\r\n");
      out.write("\t\t\t\t\t$(\"#usernameMsg\").html(\"用户名已经存在\").css(\"color\",\"red\");\r\n");
      out.write("\t\t\t\t\t$(\"#registerBtn\").attr(\"disabled\",true);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t$(\"#usernameMsg\").html(\"用户名可用\").css(\"color\",\"green\");\r\n");
      out.write("\t\t\t\t\t$(\"#registerBtn\").removeAttr(\"disabled\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t});\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("<title>注册</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"regist\">\r\n");
      out.write("\t\t<div class=\"regist_center\">\r\n");
      out.write("\t\t\t<div class=\"regist_top\">\r\n");
      out.write("\t\t\t\t<div class=\"left fl\"><span class=\"glyphicon glyphicon-user\"></span>&nbsp;&nbsp;会员注册</div>\r\n");
      out.write("\t\t\t\t<div class=\"right fr\">\r\n");
      out.write("\t\t\t\t\t<a href=\"index.jsp\" target=\"_black\">小米商城</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"xian center\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"center-block\" style=\"margin-top: 80px;\">\r\n");
      out.write("\t\t\t\t<form id=\"form1\" class=\"form-horizontal\" action=\"userservlet?method=register\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2 control-label\">用户名</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\" style=\"width: 40%\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"username\" name=\"username\" class=\"form-control col-sm-10\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Username\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"text-danger\"><span class=\"help-block \" id=\"usernameMsg\"></span></p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2 control-label\">密码</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\" style=\"width: 40%\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"password\" id=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control col-sm-10\" placeholder=\"Password\"  />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"text-danger\"><span id=\"helpBlock\" class=\"help-block \">请输入6位以上字符</span></p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2 control-label\">确认密码</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\" style=\"width: 40%\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"repassword\" class=\"form-control col-sm-10\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Password Again\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"text-danger\"><span id=\"helpBlock\" class=\"help-block \">两次密码要输入一致哦</span></p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2 control-label\">邮箱</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\" style=\"width: 40%\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"email\" name=\"email\" class=\"form-control col-sm-10\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Email\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"text-danger\"><span id=\"helpBlock\" class=\"help-block \">填写正确邮箱格式</span></p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2 control-label\">性别</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\" style=\"width: 40%\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"radio-inline\"> <input type=\"radio\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"gender\" value=\"男\" checked=\"checked\"> 男\r\n");
      out.write("\t\t\t\t\t\t\t</label> <label class=\"radio-inline\"> <input type=\"radio\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"gender\" value=\"女\"> 女\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"text-danger\"><span id=\"helpBlock\" class=\"help-block \">你是帅哥 还是美女</span></p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<hr>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-7 col-sm-push-2\">\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"registerBtn\" type=\"submit\" value=\"注册\" class=\"btn btn-primary  btn-lg\" style=\"width: 200px;\" disabled/> &nbsp; &nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"reset\" value=\"重置\" class=\"btn btn-default  btn-lg\" style=\"width: 200px;\"  />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"text-center\" style=\"color:red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${registerMsg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
