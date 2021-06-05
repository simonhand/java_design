package cn.zhangle.service.impl;

import cn.zhangle.dao.impl.UserDaoImpl;
import cn.zhangle.domain.*;
import cn.zhangle.service.UserService;
import cn.zhangle.untils.EmailUtils;
import cn.zhangle.untils.Md5Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2020/12/16 22:01
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public void register(User user) {
        user.setPassword(Md5Utils.md5(user.getPassword()));
        userDao.add(user);
        EmailUtils.sendEmail(user);
    }

    @Override
    public User checkUserName(String username) {
        User user = userDao.findByUserName(username);
        return user;
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.findByUserNameAndPassword(username, Md5Utils.md5(password));
        return user;
    }

    @Override
    public List<Order> getOrderList(int id) {
        return userDao.findOrderDetailById(id);
    }

    @Override
    public String getOrderAddress(int parseInt) {
        return userDao.findOrderAddressByaid(parseInt);
    }

    @Override
    public PageBean<OrderPage> getOrderPageById(int pageNum, int pageSize, String condition) {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(condition);
        long totalSize = userDao.getOrderCountByUid(condition);
        System.out.println("totalSize:"+totalSize);
        List<Order>  data = userDao.getOrderPageByUid(pageNum,pageSize,condition);

        List<OrderPage> orderPages = new ArrayList<>();
        for (Order order : data) {
            OrderPage orderPage = new OrderPage();
            orderPage.setId(order.getId());
            orderPage.setAid(order.getAid());
            orderPage.setAddress(new UserDaoImpl().findOrderAddressByaid(order.getAid()));
            orderPage.setTime(order.getTime());
            orderPage.setMoney(order.getMoney());
            orderPage.setStatus(order.getStatus());
            orderPage.setUid(order.getUid());
            orderPages.add(orderPage);
        }

        PageBean<OrderPage> orderPagePageBean = new PageBean<>(pageNum, pageSize, totalSize, orderPages);
        return orderPagePageBean;
    }

    @Override
    public void activate(String e, String c) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.activate(e,c);
    }
}
