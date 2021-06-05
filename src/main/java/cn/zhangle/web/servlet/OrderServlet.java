package cn.zhangle.web.servlet;

import cn.zhangle.domain.*;
import cn.zhangle.service.AddressService;
import cn.zhangle.service.OrderService;
import cn.zhangle.service.impl.AddressServiceImpl;
import cn.zhangle.service.impl.CartServiceImpl;
import cn.zhangle.service.impl.OrderServiceImpl;
import cn.zhangle.untils.RandUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2020/12/16 14:30
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
@WebServlet(name = "OrderServlet",value = "/orderservlet")
public class OrderServlet extends BaseServlet {

    public String getOrderView(HttpServletRequest request,HttpServletResponse response){
        //判断登录
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("msg","请先登录，再添加商品到购物车");
            return "/login1.jsp";
        }
        //购车
        CartServiceImpl cartService = new CartServiceImpl();
        List<Cart> carts = cartService.findById(user.getId());
        request.setAttribute("carts",carts);
        //收货地址
        AddressService addressService = new AddressServiceImpl();
        List<Address> addresses =  addressService.findByUid(user.getId());
        request.setAttribute("addList",addresses);
        return "/order.jsp";
    }

    public void delOrder(HttpServletRequest request,HttpServletResponse response){

    }

    public String addOrder(HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        //判断登录
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("msg","请先登录，再添加商品到购物车");
            return "/login1.jsp";
        }

        String aid = request.getParameter("aid");
        //获取购物车数据
        CartServiceImpl cartService = new CartServiceImpl();
        List<Cart> carts = cartService.findById(user.getId());

        if(carts ==null || carts.size() == 0){
            response.getWriter().write("<script type='text/javascript'>alert('购物车不能为空请选择商品');window.location='index.jsp'</script>");
            return null;
        }

        //创建订单详情
        List<OrderDetail> orderDetails = new ArrayList<>();
        String orderId = RandUtils.createOrderId();
        BigDecimal sum = new BigDecimal(0);
        for (Cart cart : carts) {
            OrderDetail orderDetail = new OrderDetail(null,orderId,cart.getPid(),cart.getNum(),cart.getMoney());
            orderDetails.add(orderDetail);
            sum = sum.add(cart.getMoney());
        }
        //创建订单
        Order order = new Order(orderId ,user.getId(),sum,"1",new Date(),Integer.parseInt(aid));
        OrderService orderService = new OrderServiceImpl();
        try {
            orderService.saveOrder(order,orderDetails);
            request.setAttribute("order",order);
            return "/orderSuccess.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","订单提交失败"+e.getMessage());
            return "/message.jsp";
        }

    }
}
