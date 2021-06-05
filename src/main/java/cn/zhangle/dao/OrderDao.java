package cn.zhangle.dao;

import cn.zhangle.domain.Order;

import java.sql.SQLException;

/**
 * @Classname OrderDao
 * @Description TODO
 * @Date 2020/12/21 0:14
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface OrderDao {
    void add(Order order) throws SQLException;
}
