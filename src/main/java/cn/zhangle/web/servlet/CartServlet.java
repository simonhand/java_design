package cn.zhangle.web.servlet;

import cn.zhangle.dao.impl.GoodsDapImpl;
import cn.zhangle.domain.Cart;
import cn.zhangle.domain.Goods;
import cn.zhangle.domain.User;
import cn.zhangle.service.CartService;
import cn.zhangle.service.GoodsService;
import cn.zhangle.service.impl.CartServiceImpl;
import cn.zhangle.service.impl.GoodsServiceImpl;
import cn.zhangle.untils.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2020/12/19 16:34
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
@WebServlet(name = "CartServlet" ,value = "/cartservlet")
public class CartServlet extends BaseServlet {
    public String addCart(HttpServletRequest request,HttpServletResponse response){
        //判断登录
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("msg","请先登录，再添加商品到购物车");
            return "/login1.jsp";
        }


        String goodsId = request.getParameter("goodsId");
        String number = request.getParameter("number");

        if(StringUtils.isEmpty(goodsId)){
            return "redirect:/index.jsp";
        }
        //2添加至购物车
        CartService cartService = new CartServiceImpl();
        Cart cart = cartService.findByUidAndPid(user.getId(),Integer.parseInt(goodsId));

        GoodsService goodsService = new GoodsServiceImpl();
        Goods goods = goodsService.findById(Integer.parseInt(goodsId));
        int num = Integer.parseInt(number);
        try {
            if (cart == null){

                cart = new Cart(user.getId(),Integer.parseInt(goodsId),num,goods.getPrice().multiply(new BigDecimal(num)));
                cartService.add(cart);
            }else {
                cart.setNum(cart.getNum()+num);
                cart.setMoney(goods.getPrice().multiply(new BigDecimal(cart.getNum())));
                cartService.update(cart);
            }
            return "redirect:/cartSuccess.jsp";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "redirect:/index.jsp";
        }
    }

    public String getCart(HttpServletRequest request,HttpServletResponse response){
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("msg","请先登录再查看购物车");
            return "/login1.jsp";
        }
        List<Cart> carts = null;
        CartServiceImpl cartService = new CartServiceImpl();
        try {
            carts = cartService.findById(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return "/index.jsp";
        }
        request.setAttribute("carts",carts);
        return "/cart.jsp";
    }
    public void addCartAjax(HttpServletRequest request,HttpServletResponse response){

        String goodsId = request.getParameter("goodsId");//商品id
        String number = request.getParameter("number");
        String id = request.getParameter("id");//用户id
        int uid = Integer.parseInt(id);
        CartServiceImpl cartService = new CartServiceImpl();
        cartService.addCartAjax(uid,Integer.parseInt(goodsId),Integer.parseInt(number));
    }
}
