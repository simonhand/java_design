package cn.zhangle.dao.impl;

import cn.zhangle.dao.UserDao;
import cn.zhangle.domain.*;
import cn.zhangle.untils.DataSourceUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2020/12/16 15:11
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());
    @Override
    public List<User> findAll() {
        try {
            String sql = "select * from tb_user;";
            return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findByUserNameAndPassword(String username, String password) {
        User user = null;
        try {
            String sql = "select * from tb_user where username = ? and password = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),
                    username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findById(Integer id) {
        try {
            String sql = "select * from tb_user where id = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findByUserName(String username) {

        try {
            String sql = "select * from tb_user where username = ?";
//            System.out.println(username);
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
//            System.out.println("dao："+user);
            return user;
//            return template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public void add(User user) {
        try {
            template.update("insert into tb_user(username,password,email,gender,flag,role,code) values(?,?,?,?,?,?,?)",
                    user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getFlag(),user.getRole(),user.getCode());
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("操作失败");
        }
    }

    @Override
    public void delete(Integer id) {
//        String sql = "delete from tb_user where id = ?";
//        2.执行sql
//        template.update(sql, id);
        try {
            template.update("delete from tb_user where id = ?",id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("操作失败");
        }
    }

    @Override
    public void update(User user) {
        try {
            template.update("update tb_user set username=?,password=?,email=?,gender=?,flag=? where id = ?",
                    user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getFlag(),user.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("操作失败");
        }
    }

    @Override
    public List<Order> findOrderDetailById(int id) {
        String sql = "select * from tb_order where uid = ?";
        return template.query(sql,new BeanPropertyRowMapper<>(Order.class),id);
    }

    @Override
    public String findOrderAddressByaid(int aid) {
//        System.out.println(aid);
        try {
            String sql = "select * from tb_address where id = ?";
            Address address = template.queryForObject(sql,new BeanPropertyRowMapper<>(Address.class),aid);
            return address.getDetail();
        } catch (DataAccessException e) {
            e.printStackTrace();
            return "(该收货地址已经被删除无法查看！)";
        }
    }

    @Override
    public long getOrderCountByUid(String condition) {
        String sql = "select count(*) from tb_order";
        if (condition!=null&&condition.trim().length()!=0){
            sql = sql + " where " +condition;
        }
        try {
            return template.queryForObject(sql,long.class);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("查询订单个数失败", e);
        }

    }

    @Override
    public List<Order> getOrderPageByUid(int pageNum, int pageSize, String condition) {
        String sql = "select * from tb_order";
        if (condition != null && condition.trim().length() != 0) {
            sql = sql +  " where " + condition;
        }
        sql += " order by id limit ?,? ";
        try {
            return template.query(sql,new BeanPropertyRowMapper<>(Order.class),(pageNum-1)*pageSize,pageSize);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("查询订单个数失败", e);
        }
    }

    @Override
    public void activate(String e, String c) {
        String sql = "update tb_user set flag = 1 where email = ? and code = ?";
        try {
            template.update(sql,e,c);
        } catch (DataAccessException dataAccessException) {
            dataAccessException.printStackTrace();
        }
    }
}
