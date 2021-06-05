package cn.zhangle.web.filter;

import cn.zhangle.domain.User;
import cn.zhangle.service.impl.UserServiceImpl;
import cn.zhangle.untils.Base64Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2020/12/18 10:28
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
@WebFilter(value = "/index.jsp")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
        chain.doFilter(req, resp);
        return;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userinfo")){
                    String value =cookie.getValue();
                    String userinfo = Base64Utils.decode(value);
                    String[] userinfos = userinfo.split("#");
                    UserServiceImpl userService = new UserServiceImpl();
                    User user2 = userService.login(userinfos[0], userinfos[1]);
                    if (user2!=null){
                        if(user2.getFlag()==1){
                            request.getSession().setAttribute("user",user2);
                            chain.doFilter(req, resp);
                            return;
                        }
                    }else {
                        Cookie cookie1 = new Cookie("userinfo", "");
                        cookie1.setMaxAge(0);
                        cookie1.setPath("/");
                        response.addCookie(cookie1);
                    }
                }
            }

        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
