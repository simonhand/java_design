package cn.zhangle.dao.impl;

import cn.zhangle.dao.CartDao;
import cn.zhangle.domain.Cart;
import cn.zhangle.domain.Goods;
import cn.zhangle.untils.DataSourceUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Classname CartDaoImpl
 * @Description TODO
 * @Date 2020/12/19 16:58
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class CartDaoImpl implements CartDao {
    private JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());
    @Override
    public Cart findByUidAndPid(int uid, int pid) {
        try {
            String sql = "select * from tb_cart where id = ? and pid = ?";
            Cart cart = template.queryForObject(sql, new BeanPropertyRowMapper<>(Cart.class), uid, pid);
            return cart;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(Cart cart) {
        try {
            String sql = "insert into tb_cart (id,pid,num,money) values(?,?,?,?)";
            template.update(sql,cart.getId(),cart.getPid(),cart.getNum(),cart.getMoney());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cart cart) {
        try {
            String sql = "update tb_cart set (num,money) values(?,?) where id = ? and pid = ?";
            template.update(sql,cart.getNum(),cart.getMoney(),cart.getId(),cart.getPid());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cart> findById(Integer id) {
        try {
            String sql = "select * from tb_cart where id = ?";
            List<Cart> carts = template.query(sql, new BeanPropertyRowMapper<>(Cart.class), id);
            return carts;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addCartAjax(int uid, int goodsId, int number) {
        String sql = null;
        Goods byId = new GoodsDapImpl().findById(goodsId);
        if (number == -1) {
            sql = "update tb_cart set Num = Num-1,money = money - ? where id = ? and pid = ?";
        }
        else if (number == 1){

            sql = "update tb_cart set Num = Num+1,money = money + ? where id = ? and pid = ?";
        }
        else if (number == 0){

            sql = "delete from tb_cart where id = ? and pid = ?";
            template.update(sql,uid,goodsId);
            return;
        }else {
            sql = "delete from tb_cart where id = ?";
            template.update(sql,uid);
            return;
        }
        template.update(sql,byId.getPrice(),uid,goodsId);
    }
}
