package cn.zhangle.service;

import cn.zhangle.domain.Order;
import cn.zhangle.domain.OrderDetail;

import java.sql.SQLException;
import java.util.List;

/**
 * @Classname OrderService
 * @Description TODO
 * @Date 2020/12/21 0:09
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface OrderService {
    void saveOrder(Order order, List<OrderDetail> orderDetails) throws SQLException;
}
