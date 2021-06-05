package cn.zhangle.service;

import cn.zhangle.domain.GoodsType;

import java.util.List;

/**
 * @Classname GoodsTypeService
 * @Description TODO
 * @Date 2020/12/18 14:09
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public interface GoodsTypeService {
    List<GoodsType> getTypeBylevel(int i);
}
