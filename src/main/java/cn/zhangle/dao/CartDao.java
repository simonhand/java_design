package cn.zhangle.dao;

import cn.zhangle.domain.Cart;

import java.util.List;

/**
 * @Classname CartDao
 * @Description TODO
 * @Date 2020/12/19 16:58
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface CartDao {
    Cart findByUidAndPid(int uid, int pid);

    void add(Cart cart);

    void update(Cart cart);

    List<Cart> findById(Integer id);

    void addCartAjax(int uid, int goodsId, int number);
}
