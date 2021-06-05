package cn.zhangle.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2020/12/22 16:37
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
@WebServlet(name = "PayServlet",value = "/payservlet")
public class PayServlet extends BaseServlet {
    public String pay(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String url = "https://www.yeepay.com/app-merchant-proxy/node?";
        response.sendRedirect(url);
        return null;
    }

}
