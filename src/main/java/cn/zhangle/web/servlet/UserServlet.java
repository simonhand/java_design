package cn.zhangle.web.servlet;


import cn.dsna.util.images.ValidateCode;
import cn.zhangle.dao.impl.UserDaoImpl;
import cn.zhangle.domain.*;
import cn.zhangle.service.UserService;
import cn.zhangle.service.impl.AddressServiceImpl;
import cn.zhangle.service.impl.UserServiceImpl;
import cn.zhangle.untils.Base64Utils;
import cn.zhangle.untils.EmailUtils;
import cn.zhangle.untils.RandUtils;
import cn.zhangle.untils.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2020/12/16 13:41
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
@WebServlet(name = "UserServlet",value = "/userservlet")
public class UserServlet extends BaseServlet {

    public String register(HttpServletRequest request, HttpServletResponse response) {

        try {
            User user = new User();
            BeanUtils.populate(user, request.getParameterMap());
            System.out.println(user);
            String repassword = request.getParameter("repassword");
            if (StringUtils.isEmpty(user.getUsername())) {
                request.setAttribute("registerMsg", "用户名不能为空");
                return "/register1.jsp";
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                request.setAttribute("registerMsg", "密码不能为空");
                return "/register1.jsp";
            }
            if (!user.getPassword().equals(repassword)) {
                request.setAttribute("registerMsg", "两次密码不一致");
                return "/register1.jsp";
            }
            if (StringUtils.isEmpty(user.getEmail())) {
                request.setAttribute("registerMsg", "邮箱不可为空");
                return "/register1.jsp";
            }
            UserServiceImpl userService = new UserServiceImpl();

            user.setFlag(0);
            user.setRole(1);
            user.setCode(RandUtils.createActive());
            userService.register(user);
            request.getSession().setAttribute("registerUser",user);
            return "/registerSuccess1.jsp";
        } catch (Exception e) {
            request.setAttribute("registerMsg", "注册失败");
            e.printStackTrace();
        }

//        System.out.println("用户注册");
        return "/register1.jsp";
    }

    public void active(HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        User registerUser = (User) request.getSession().getAttribute("registerUser");
        if (registerUser==null){
            response.getWriter().write("<script type='text/javascript'>alert('请先登录');window.location='index.jsp'</script>");
        }
        EmailUtils.sendEmail(registerUser);
        System.out.println("提示");
        response.getWriter().write("<script type='text/javascript'>alert('激活邮件已发送,请在邮箱内点击邮件激活！');window.location='index.jsp'</script>");
        request.getSession().removeAttribute("registerUser");
    }

    public void activate(HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        String e = Base64Utils.decode(request.getParameter("e"));
        String c = Base64Utils.decode(request.getParameter("c"));
        UserService userService = new UserServiceImpl();
        userService.activate(e,c);
        response.getWriter().write("<script type='text/javascript'>alert('激活成功,请前往登录页面登录！');window.location='login1.jsp'</script>");
    }

    public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        if (username == null || username.trim().length() == 0) {
            return null;
        }
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(username);
        User user = userService.checkUserName(username);

        if (user != null) {
            response.getWriter().write("1");
//            System.out.println("ser:"+ user);
        } else {
            response.getWriter().write("0");
//            System.out.println("ser111:"+ user);
        }
        return null;
    }

    public String login(HttpServletRequest request, HttpServletResponse response) {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String auto = request.getParameter("auto");
        String valcode = request.getParameter("valcode");
        String servercode = (String) request.getSession().getAttribute("vcode");

        if (StringUtils.isEmpty(valcode)) {
            request.setAttribute("msg", "验证码不能为空");
            return "/login1.jsp";
        }
        if (!valcode.equalsIgnoreCase(servercode)) {
            request.setAttribute("msg", "验证码输入有误");
            return "/login1.jsp";
        }


        if (StringUtils.isEmpty(username)) {
            request.setAttribute("msg", "用户名不能为空");
            return "/login1.jsp";
        }
        if (StringUtils.isEmpty(password)) {
            request.setAttribute("msg", "密码不能为空");
            return "/login1.jsp";
        }
        //验证用户名和密码是否正确
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(username, password);

        if (user == null) {
            request.setAttribute("msg", "用户名或密码有误");
            return "/login1.jsp";
        } else {
            //有用户
            //有没有激活
            if (user.getFlag() != 1) {
                System.out.println("执行login");
                request.getSession().setAttribute("registerUser",user);
                request.setAttribute("msg", "<a href='/java_desin//registerSuccess1.jsp'>用户尚未激活,点击此处去激活？</a>");
                return "login1.jsp";
            }
            //有没有权限
            if (user.getRole() != 1) {
                request.setAttribute("msg", "用户没有权限");
                return "/login1.jsp";
            }
            //登录成功
            request.getSession().setAttribute("user", user);
            if (auto != null) {
                //创建cookie
                String userinfo = username + "#" + password;
                Cookie cookie = new Cookie("userinfo", Base64Utils.encode(userinfo));
                cookie.setMaxAge(60 * 60 * 24 * 14);
                cookie.setPath("/");
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
            }
            //重定向到首页
            return "redirect:/index.jsp";

        }
    }

    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        Cookie cooike = new Cookie("userinfo", "");
        cooike.setMaxAge(0);
        cooike.setPath("/");
        cooike.setHttpOnly(true);
        response.addCookie(cooike);
        return "redirect:/index.jsp";
    }

    public String code(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        System.out.println("测试code");
        ValidateCode validateCode = new ValidateCode(100, 40, 4, 20);
        String code = validateCode.getCode();
        request.getSession().setAttribute("vcode", code);
        validateCode.write(response.getOutputStream());
        return null;
    }

    public String getAddress(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login1.jsp";
        }
        AddressServiceImpl addressService = new AddressServiceImpl();
        List<Address> addList = addressService.findByUid(user.getId());

        request.setAttribute("addList", addList);
        return "/self_info.jsp";

    }

    public String addAddress(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login1.jsp";
        }
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String detail = request.getParameter("detail");
        if (StringUtils.isEmpty(name)) {
            request.setAttribute("msg", "收件人不可为空");
            return getAddress(request, response);
        }
        if (StringUtils.isEmpty(phone)) {
            request.setAttribute("msg", "手机号不可为空");
            return getAddress(request, response);
        }
        if (StringUtils.isEmpty(detail)) {
            request.setAttribute("msg", "收件地址不可为空");
            return getAddress(request, response);
        }
        Address address = new Address(null,detail, name, phone, user.getId(), 0);
        AddressServiceImpl addressService = new AddressServiceImpl();
        addressService.add(address);

        return getAddress(request, response);
    }

    public String defaultAddress(HttpServletRequest request,HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login1.jsp";
        }
        String id = request.getParameter("id");
        AddressServiceImpl addressService = new AddressServiceImpl();

        addressService.updateDefault(Integer.parseInt(id),user.getId());

        return getAddress(request,response);
    }

    public String deleteAddress(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login1.jsp";
        }
        String id = request.getParameter("id");
        AddressServiceImpl addressService = new AddressServiceImpl();
        addressService.delete(Integer.parseInt(id));


        return getAddress(request,response);
    }

    public String updateAddress(HttpServletRequest request,HttpServletResponse response) throws Exception{
        User user = (User) request.getSession().getAttribute("user");
        response.setContentType("text/html;charset=utf-8");
        if (user == null) {
            return "redirect:/login1.jsp";
        }
        String id = request.getParameter("id");
        String level = request.getParameter("level");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String detail = request.getParameter("detail");
        if (StringUtils.isEmpty(name)){
            response.getWriter().write("<script type='text/javascript'>alert('收件人不可为空');window.location='userservlet?method=getAddress'</script>");
            return null;
        }
        if (StringUtils.isEmpty(phone)){
            response.getWriter().write("<script type='text/javascript'>alert('手机号不可为空');window.location='userservlet?method=getAddress'</script>");
            return null;
        }
        if (StringUtils.isEmpty(detail)){
            response.getWriter().write("<script type='text/javascript'>alert('收件地址不可为空');window.location='userservlet?method=getAddress'</script>");
            return null;
        }

        Address address = new Address(Integer.parseInt(id),detail,name,phone,user.getId(),Integer.parseInt(level));
        AddressServiceImpl addressService = new AddressServiceImpl();
        addressService.update(address);

        return getAddress(request,response);
    }

    public String getOrderList(HttpServletRequest request,HttpServletResponse response)throws Exception{
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("loginUser",user);
        String _pageNum = request.getParameter("pageNum");
        String _pageSize = request.getParameter("pageSize");
        String typeId = request.getParameter("typeId");
        int pageNum =1;
        int pageSize=5;
        if (!StringUtils.isEmpty(_pageNum)){
            pageNum = Integer.parseInt(_pageNum);
            if (pageNum<1){
                pageNum = 1;
            }
        }
        if (!StringUtils.isEmpty(_pageSize)){
            pageSize = Integer.parseInt(_pageSize);
            if (pageSize<1){
                pageSize = 5;
            }
        }
        response.setContentType("text/html;charset=utf-8");
        if (user == null) {
            return "redirect:/login1.jsp";
        }
        int id = user.getId();
        UserServiceImpl userService = new UserServiceImpl();
        List<Order> orders = userService.getOrderList(id);
        if (orders==null){
            return "index.jsp";
        }

        String condition = null;
        if (user!=null) {
            condition = " uid = "+id;
        }
        PageBean<OrderPage> orderPagePageBean = userService.getOrderPageById(pageNum,pageSize,condition);
        request.setAttribute("pageBean",orderPagePageBean);
        return "/orderList1.jsp";
    }

    public void goodOrderAddress(HttpServletRequest request,HttpServletResponse response)throws Exception{
        response.setContentType("application/json;charset=utf-8");
        String aid = request.getParameter("aid");
        UserServiceImpl userService = new UserServiceImpl();
        String orderAddress = userService.getOrderAddress(Integer.parseInt(aid));
        String json = JSON.toJSONString(orderAddress);
        System.out.println(json);
        response.getWriter().write(json);
    }
}
