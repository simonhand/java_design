package cn.zhangle.dao;

import cn.zhangle.domain.GoodsType;

import java.util.List;

/**
 * @Classname GoodsTypeDao
 * @Description TODO
 * @Date 2020/12/18 14:14
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface GoodsTypeDao {
    List<GoodsType> findBylevel(int i);

    GoodsType findByid(Integer typeid);
}
