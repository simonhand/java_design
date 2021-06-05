package cn.zhangle.dao.impl;

import cn.zhangle.dao.OrderDetailDao;
import cn.zhangle.domain.Order;
import cn.zhangle.domain.OrderDetail;
import cn.zhangle.untils.DataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Classname OrderDetailImpl
 * @Description TODO
 * @Date 2020/12/21 0:16
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class OrderDetailImpl implements OrderDetailDao {
    private JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());
    @Override
    public void add(OrderDetail orderDetail)  {
        String sql = "insert into tb_orderdetail(oid,pid,num,money) values(?,?,?,?)";
        try {
            template.update(sql,orderDetail.getOid(),orderDetail.getPid(),orderDetail.getNum(),orderDetail.getMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
