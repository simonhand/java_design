package cn.zhangle.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Classname OrderPage
 * @Description TODO
 * @Date 2020/12/24 18:52
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class OrderPage {
    private String id;
    private Integer uid;
    private BigDecimal money;
    private String status;
    private Date time;
    private Integer aid;
    private String address;

    public OrderPage() {
    }

    public OrderPage(String id, Integer uid, BigDecimal money, String status, Date time, Integer aid, String address) {
        this.id = id;
        this.uid = uid;
        this.money = money;
        this.status = status;
        this.time = time;
        this.aid = aid;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderPage{" +
                "id='" + id + '\'' +
                ", uid=" + uid +
                ", money=" + money +
                ", status='" + status + '\'' +
                ", time=" + time +
                ", aid=" + aid +
                ", address='" + address + '\'' +
                '}';
    }
}
