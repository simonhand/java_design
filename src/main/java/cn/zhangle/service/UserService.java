package cn.zhangle.service;

import cn.zhangle.domain.*;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2020/12/16 21:58
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface UserService {
    void register(User user);
    //检查用户名
    User checkUserName(String username);

    User login(String username,String password);

    List<Order> getOrderList(int id);

    String getOrderAddress(int parseInt);

    PageBean<OrderPage> getOrderPageById(int pageNum, int pageSize, String condition);

    void activate(String e, String c);
}
