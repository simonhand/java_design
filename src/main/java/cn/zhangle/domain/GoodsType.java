package cn.zhangle.domain;

/**
 * @Classname GoodsType
 * @Description TODO
 * @Date 2020/12/15 0:18
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class GoodsType {
    private Integer id;
    private String name;
    private Integer level;
    private Integer parent;

    public GoodsType(Integer id, String name, Integer level, Integer parent) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.parent = parent;
    }

    public GoodsType() {
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", parent=" + parent +
                '}';
    }
}
