package cn.zhangle.dao;

import cn.zhangle.domain.Address;

import java.util.List;

/**
 * @Classname AddressDao
 * @Description TODO
 * @Date 2020/12/20 21:21
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface AddressDao {
    List<Address> findByUid(Integer id);

    void add(Address address);

    void updateDefault(int aid, Integer uid);

    void delete(int parseInt);

    void update(Address address);
}
