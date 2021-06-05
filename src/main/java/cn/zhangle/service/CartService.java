package cn.zhangle.service;

import cn.zhangle.domain.Cart;

import java.util.List;

/**
 * @Classname CartService
 * @Description TODO
 * @Date 2020/12/19 16:42
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface CartService {
    Cart findByUidAndPid(int id, int pid);

    void add(Cart cart);

    void update(Cart cart);

    List<Cart> findById(Integer id);

    void addCartAjax(int uid, int parseInt, int parseInt1);
}
