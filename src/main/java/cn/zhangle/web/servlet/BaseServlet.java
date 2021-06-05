package cn.zhangle.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2020/12/16 14:33
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        try {
            Method method = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            String url = (String) method.invoke(this, request, response);//this.method();
            if (url!=null&&url.trim().length()!=0) {
                //转发
                /*
                * 重定向是response.sendRedirect,，地址不变，客户端行为，重定向速度慢；重定向会执行重定向之后的代码
                * 转发request.getRequestDispatcher，地址变化，服务器行为，.转发的速度快;.转发不会执行转发后的代码;
                * */
                if (url.startsWith("redirect:")) {
                    response.sendRedirect(request.getContextPath() + url.split(":")[1]);
                } else {
                    request.getRequestDispatcher(url).forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
