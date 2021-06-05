package cn.zhangle.dao.impl;

import cn.zhangle.dao.GoodsDao;
import cn.zhangle.domain.Goods;
import cn.zhangle.untils.DataSourceUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Classname GoodsDapImpl
 * @Description TODO
 * @Date 2020/12/18 16:39
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class GoodsDapImpl implements GoodsDao {
    private JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());
    @Override
    public long getCount(String condition) {
        String sql = "select count(*) from tb_goods";
        if (condition!=null&&condition.trim().length()!=0){
            sql = sql + " where " +condition;
        }
        try {
            return template.queryForObject(sql,long.class);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品个数失败", e);
        }


    }


    @Override
    public List<Goods> findPageByWhere(int pageNum,int pageSize,String condition) {
        String sql = "select * from tb_goods";
        if (condition != null && condition.trim().length() != 0) {
            sql = sql + " where " + condition;
        }
        sql += " order by id limit ?,? ";
        try {
            return template.query(sql,new BeanPropertyRowMapper<>(Goods.class),(pageNum-1)*pageSize,pageSize);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品个数失败", e);
        }

    }

    @Override
    public Goods findById(int parseInt) {
        String sql = "select * from tb_goods where id = ?";
        try {
            Goods goods = template.queryForObject(sql,new BeanPropertyRowMapper<>(Goods.class),parseInt);
            return goods;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Goods> findPageByName(int pageNum, int pageSize, String condition) {
        String sql = "select * from tb_goods";
        if (condition != null && condition.trim().length() != 0) {
            sql = sql +  " where " + condition;
        }
        sql += " order by id limit ?,? ";
        try {
            return template.query(sql,new BeanPropertyRowMapper<>(Goods.class),(pageNum-1)*pageSize,pageSize);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品个数失败", e);
        }

    }

    @Override
    public long getCountByName(String condition) {
        String sql = "select count(*) from tb_goods";
        if (condition!=null&&condition.trim().length()!=0){
            sql = sql + " where " +condition;
        }
        try {
            return template.queryForObject(sql,long.class);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品个数失败", e);
        }
    }
}
