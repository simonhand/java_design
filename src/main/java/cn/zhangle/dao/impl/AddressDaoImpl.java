package cn.zhangle.dao.impl;

import cn.zhangle.dao.AddressDao;
import cn.zhangle.domain.Address;
import cn.zhangle.untils.DataSourceUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Classname AddressDaoImpl
 * @Description TODO
 * @Date 2020/12/20 21:21
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class AddressDaoImpl implements AddressDao {
    private JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());

    public List<Address> findByUid(Integer id) {
        try {
            String sql = "select * from tb_address where uid = ?";
            return template.query(sql,new BeanPropertyRowMapper<>(Address.class),id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(Address address) {
        String sql = "insert into tb_address(detail,name,phone,uid,level) values(?,?,?,?,?)";
        template.update(sql,address.getDetail(),address.getName(),address.getPhone(),address.getUid(),address.getLevel());
    }

    @Override
    public void updateDefault(int aid, Integer uid) {
        try {
            String sql1 = "update tb_address set level = 0 where uid = ?";
            template.update(sql1,uid);
            String sql2 = "update tb_address set level = 1 where uid = ? and id = ?";
            template.update(sql2,uid,aid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int parseInt) {
        try {
            String sql = "delete from tb_address where id = ?";
            template.update(sql,parseInt);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Address address) {
        try {
            String sql = "update tb_address set name = ? ,phone = ? ,detail = ? where id = ?";
            template.update(sql,address.getName(),address.getPhone(),address.getDetail(),address.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }


}
