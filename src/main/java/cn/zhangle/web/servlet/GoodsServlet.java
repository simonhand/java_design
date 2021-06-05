package cn.zhangle.web.servlet;

import cn.zhangle.domain.Goods;
import cn.zhangle.domain.PageBean;
import cn.zhangle.service.GoodsService;
import cn.zhangle.service.impl.GoodsServiceImpl;
import cn.zhangle.untils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2020/12/18 15:09
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
@WebServlet(name = "GoodsServlet",value = "/goodsservlet")
public class GoodsServlet extends BaseServlet {
    public String getGoodsListByTypeId(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String typeId = request.getParameter("typeId");
        String _pageNum = request.getParameter("pageNum");
        String _pageSize = request.getParameter("pageSize");
        int pageNum =1;
        int pageSize=8;
        if (!StringUtils.isEmpty(_pageNum)){
            pageNum = Integer.parseInt(_pageNum);
            if (pageNum<1){
                pageNum = 1;
            }
        }
        if (!StringUtils.isEmpty(_pageSize)){
            pageSize = Integer.parseInt(_pageSize);
           if (pageSize<1){
               pageSize = 8;
           }
        }
        GoodsService goodsService = new GoodsServiceImpl();
        String condition = null;
        if (typeId!=null) {
            condition = "typeid = "+typeId;
        }
        try {
            //8\7\8bba858c-79da-4cdc-a974-eb4526d7408b_696673-1_w.jpg
//            System.out.println(pageNum+","+pageSize+","+condition);
            PageBean<Goods> pageBean = goodsService.findPageByWhere(pageNum,pageSize,condition);
//            System.out.println("pageBEan:"+pageBean);
            request.setAttribute("pageBean",pageBean);
            request.setAttribute("typeId", typeId);
            return "/goodsList.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/index.jsp";
        }
    }

    public String getGoodsById(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String id = request.getParameter("id");
        GoodsServiceImpl goodsService = new GoodsServiceImpl();

        if (StringUtils.isEmpty(id)){
            return "redirect:/index.jsp";
        }
        Goods goods = goodsService.findById(Integer.parseInt(id));
        request.setAttribute("goods",goods);
        return "/goodsDetail.jsp";
    }

    public String SearchGoods(HttpServletRequest request,HttpServletResponse response){
        String goodName = request.getParameter("GoodName");
        String _pageNum = request.getParameter("pageNum");
        String _pageSize = request.getParameter("pageSize");
        String typeId = request.getParameter("typeId");
        int pageNum =1;
        int pageSize=8;
        if (!StringUtils.isEmpty(_pageNum)){
            pageNum = Integer.parseInt(_pageNum);
            if (pageNum<1){
                pageNum = 1;
            }
        }
        if (!StringUtils.isEmpty(_pageSize)){
            pageSize = Integer.parseInt(_pageSize);
            if (pageSize<1){
                pageSize = 8;
            }
        }
        GoodsService goodsService = new GoodsServiceImpl();
        String condition = null;
        if (goodName!=null) {
            condition = "name like '%"+goodName+"%'";
        }
        try {
            //8\7\8bba858c-79da-4cdc-a974-eb4526d7408b_696673-1_w.jpg
            System.out.println(pageNum+","+pageSize+","+condition);
            PageBean<Goods> pageBean = goodsService.findPageByName(pageNum,pageSize,condition);
//            System.out.println("pageBEan:"+pageBean);
            request.setAttribute("pageBean",pageBean);
            request.setAttribute("typeId", typeId);
            return "/goodsList.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/index.jsp";
        }
    }
}
