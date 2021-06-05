package cn.zhangle.service.impl;

import cn.zhangle.dao.GoodsDao;
import cn.zhangle.dao.GoodsTypeDao;
import cn.zhangle.dao.impl.GoodsDapImpl;
import cn.zhangle.dao.impl.GoodsTypeDaoImpl;
import cn.zhangle.domain.Goods;
import cn.zhangle.domain.GoodsType;
import cn.zhangle.domain.PageBean;
import cn.zhangle.service.GoodsService;

import java.util.List;

/**
 * @Classname GoodsServiceImpl
 * @Description TODO
 * @Date 2020/12/18 15:14
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class GoodsServiceImpl implements GoodsService {
    @Override
    public PageBean<Goods> findPageByWhere(int pageNum,int pageSize,String condition) {
        GoodsDao goodsDao = new GoodsDapImpl();

        long totalSize = goodsDao.getCount(condition);

        List<Goods> data  = goodsDao.findPageByWhere(pageNum,pageSize,condition);

        PageBean<Goods> pageBean = new PageBean<>(pageNum, pageSize, totalSize,data);
        return pageBean;
    }

    @Override
    public Goods findById(int GoodsId) {
        GoodsDapImpl goodsDao = new GoodsDapImpl();
        Goods goods = goodsDao.findById(GoodsId);

        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        GoodsType goodsType = goodsTypeDao.findByid(goods.getTypeid());
        goods.setGoodsType(goodsType);
        return goods;
    }

    @Override
    public PageBean<Goods> findPageByName(int pageNum, int pageSize, String condition) {
        GoodsDao goodsDao = new GoodsDapImpl();

        long totalSize = goodsDao.getCountByName(condition);

        List<Goods> data  = goodsDao.findPageByName(pageNum,pageSize,condition);

        PageBean<Goods> pageBean = new PageBean<>(pageNum, pageSize, totalSize,data);
        return pageBean;
    }
}
