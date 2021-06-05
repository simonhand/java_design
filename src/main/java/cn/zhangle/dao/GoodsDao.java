package cn.zhangle.dao;

import cn.zhangle.domain.Goods;

import java.util.List;

/**
 * @Classname GoodsDao
 * @Description TODO
 * @Date 2020/12/18 16:39
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface GoodsDao {
    long getCount(String condition);

    List<Goods> findPageByWhere(int pageNUm,int pageSize,String condition);

    Goods findById(int parseInt);

    List<Goods> findPageByName(int pageNum, int pageSize, String condition);

    long getCountByName(String condition);
}
