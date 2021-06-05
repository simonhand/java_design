package cn.zhangle.service.impl;

import cn.zhangle.dao.CartDao;
import cn.zhangle.dao.impl.CartDaoImpl;
import cn.zhangle.domain.Cart;
import cn.zhangle.service.CartService;

import java.util.List;

/**
 * @Classname CartServiceImpl
 * @Description TODO
 * @Date 2020/12/19 16:42
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class CartServiceImpl implements CartService {
    private CartDao cartDao = new CartDaoImpl();
    @Override
    public Cart findByUidAndPid(int uid, int pid) {
        return cartDao.findByUidAndPid(uid,pid);
    }

    @Override
    public void add(Cart cart) {
        cartDao.add(cart);
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
    }

    @Override
    public List<Cart> findById(Integer id) {
        List<Cart> carts = cartDao.findById(id);
        if (carts!=null){
            GoodsServiceImpl goodsService = new GoodsServiceImpl();
            for (Cart cart : carts) {
                cart.setGoods(goodsService.findById(cart.getPid()));
            }
        }
        return carts;
    }

    @Override
    public void addCartAjax(int uid, int goodsId, int number) {
        cartDao.addCartAjax(uid,goodsId,number);
    }
}
