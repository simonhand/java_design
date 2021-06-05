package cn.zhangle.service.impl;

import cn.zhangle.dao.OrderDao;
import cn.zhangle.dao.OrderDetailDao;
import cn.zhangle.dao.impl.CartDaoImpl;
import cn.zhangle.dao.impl.OrderDaoImpl;
import cn.zhangle.dao.impl.OrderDetailImpl;
import cn.zhangle.domain.Order;
import cn.zhangle.domain.OrderDetail;
import cn.zhangle.service.OrderService;
import cn.zhangle.untils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2020/12/21 0:09
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder(Order order, List<OrderDetail> orderDetails) throws SQLException {

        //开启事务
        //调用dao操作数据向order添加订单
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(order);
        orderDao.add(order);
        //向订单详情表添加数据
            OrderDetailDao orderDetailDao = new OrderDetailImpl();
            for (OrderDetail orderDetail : orderDetails) {
                orderDetailDao.add(orderDetail);
            }
        //清空购物车
        CartDaoImpl cartDao = new CartDaoImpl();
        cartDao.addCartAjax(order.getUid(),999,999);
        //提交

        }
    }
