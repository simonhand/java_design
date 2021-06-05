package cn.zhangle.service.impl;

import cn.zhangle.dao.GoodsTypeDao;
import cn.zhangle.dao.impl.GoodsTypeDaoImpl;
import cn.zhangle.domain.GoodsType;
import cn.zhangle.service.GoodsTypeService;

import java.util.List;

/**
 * @Classname GoodsTypeServiceImpl
 * @Description TODO
 * @Date 2020/12/18 14:10
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class GoodsTypeServiceImpl implements GoodsTypeService {
    GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
    @Override
    public List<GoodsType> getTypeBylevel(int i) {

        return  goodsTypeDao.findBylevel(i);
    }
}
