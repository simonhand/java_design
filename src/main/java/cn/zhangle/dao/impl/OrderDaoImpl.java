package cn.zhangle.dao.impl;

import cn.zhangle.dao.OrderDao;
import cn.zhangle.domain.Order;
import cn.zhangle.untils.DataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * @Classname OrderDaoImpl
 * @Description TODO
 * @Date 2020/12/21 0:14
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());
    @Override
    public void add(Order order)  {

            String sql = "insert into tb_order(id,uid,money,status,time,aid) values(?,?,?,?,?,?)";
        try {
            template.update(sql,order.getId(),order.getUid(),order.getMoney(),order.getStatus(),order.getTime(),order.getAid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
