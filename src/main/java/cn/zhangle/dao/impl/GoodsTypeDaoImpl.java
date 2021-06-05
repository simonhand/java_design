package cn.zhangle.dao.impl;

import cn.zhangle.dao.GoodsTypeDao;
import cn.zhangle.domain.GoodsType;
import cn.zhangle.untils.DataSourceUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Classname GoodsTypeDaoImpl
 * @Description TODO
 * @Date 2020/12/18 14:14
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class GoodsTypeDaoImpl implements GoodsTypeDao {
    private JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());
    @Override
    public List<GoodsType> findBylevel(int i) {
        try {
            List<GoodsType> goodsType = template.query("select * from tb_goods_type where level = ?",
                    new BeanPropertyRowMapper<>(GoodsType.class), i);
            return goodsType;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品类型失败",e);
        }
    }

    @Override
    public GoodsType findByid(Integer typeid) {
        try {
           GoodsType goodsType = template.queryForObject("select * from tb_goods_type where id = ?",
                    new BeanPropertyRowMapper<>(GoodsType.class), typeid);
            return goodsType;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品id失败",e);
        }
    }
}
