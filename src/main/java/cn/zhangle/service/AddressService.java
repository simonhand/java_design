package cn.zhangle.service;

import cn.zhangle.domain.Address;

import java.util.List;

/**
 * @Classname AddressService
 * @Description TODO
 * @Date 2020/12/20 21:07
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface AddressService {
    List<Address> findByUid(Integer id);

    void add(Address address);

    void updateDefault(int parseInt, Integer id);

    void delete(int parseInt);

    void update(Address address);
}
