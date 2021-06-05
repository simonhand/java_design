package cn.zhangle.dao;

import cn.zhangle.domain.Order;
import cn.zhangle.domain.OrderPage;
import cn.zhangle.domain.User;

import java.util.List;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2020/12/16 15:11
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface UserDao {
    List<User> findAll();
    User findByUserNameAndPassword(String username,String password);
    User findById(Integer id);
    User findByUserName(String username);
    void add(User user);
    void delete(Integer id);
    void update(User user);

    List<Order> findOrderDetailById(int id);

    String findOrderAddressByaid(int aid);

    long getOrderCountByUid(String condition);

    List<Order> getOrderPageByUid(int pageNum, int pageSize, String condition);

    void activate(String e, String c);
}
