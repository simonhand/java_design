package cn.zhangle.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Classname Goods
 * @Description TODO
 * @Date 2020/12/15 0:11
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class Goods {
    private Integer id;
    private String name;
    private Date pubdate;
    private String picture;
    private BigDecimal price;
    private Integer star;
    private String intro;
    private Integer typeid;
    private GoodsType goodsType;

    public Goods(Integer id, String name, Date pubdate, String picture, BigDecimal price, Integer star, String intro, Integer typeid) {
        this.id = id;
        this.name = name;
        this.pubdate = pubdate;
        this.picture = picture;
        this.price = price;
        this.star = star;
        this.intro = intro;
        this.typeid = typeid;
    }


    public Goods() {
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pubdate=" + pubdate +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", star=" + star +
                ", intro='" + intro + '\'' +
                ", typeid=" + typeid +
                '}';
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
}
