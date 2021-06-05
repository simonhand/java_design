package cn.zhangle.service;

import cn.zhangle.domain.Goods;
import cn.zhangle.domain.PageBean;

/**
 * @Classname GoodsService
 * @Description TODO
 * @Date 2020/12/18 15:14
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface GoodsService {
    PageBean<Goods> findPageByWhere(int pageNum,int pageSize,String condition);

    Goods findById(int GoodsId);

    PageBean<Goods> findPageByName(int pageNum, int pageSize, String condition);
}
