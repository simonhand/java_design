package cn.zhangle.service.impl;

import cn.zhangle.dao.AddressDao;
import cn.zhangle.dao.impl.AddressDaoImpl;
import cn.zhangle.domain.Address;
import cn.zhangle.service.AddressService;
import cn.zhangle.untils.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Classname AddressServiceImpl
 * @Description TODO
 * @Date 2020/12/20 21:08
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class AddressServiceImpl implements AddressService {
    AddressDao addressDao = new AddressDaoImpl();
    @Override
    public List<Address> findByUid(Integer id) {
        return addressDao.findByUid(id);
    }

    @Override
    public void add(Address address) {
        addressDao.add(address);
    }

    @Override
    public void updateDefault(int aid, Integer uid) {
        addressDao.updateDefault(aid,uid);
    }

    @Override
    public void delete(int parseInt) {
        addressDao.delete(parseInt);
    }

    @Override
    public void update(Address address) {
        addressDao.update(address);
    }
}
