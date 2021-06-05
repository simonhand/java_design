package cn.zhangle.web.servlet;

import cn.zhangle.domain.GoodsType;
import cn.zhangle.service.GoodsTypeService;
import cn.zhangle.service.impl.GoodsTypeServiceImpl;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2020/12/18 14:03
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
@WebServlet(name = "GoodsTypeServlet" ,value = "/goodstypeservlet")
public class GoodsTypeServlet extends BaseServlet {
    public String goodstypelist(HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("application/json;charset=utf-8");
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        List<GoodsType> goodsTypes = goodsTypeService.getTypeBylevel(1);
        //集合转成json
        String json = JSON.toJSONString(goodsTypes);
        response.getWriter().write(json);
        return null;
    }

}
