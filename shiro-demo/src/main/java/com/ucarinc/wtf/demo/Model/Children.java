package com.ucarinc.wtf.demo.Model;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Model
 * @ClassName: Children
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/4/29 15:34
 * @Version: 1.0
 */
public class Children extends Parent {
    private Integer childrenNum;
    private String chiledrenName;

    public Integer getChildrenNum() {
        return childrenNum;
    }

    public void setChildrenNum(Integer childrenNum) {
        this.childrenNum = childrenNum;
    }

    public String getChiledrenName() {
        return chiledrenName;
    }

    public void setChiledrenName(String chiledrenName) {
        this.chiledrenName = chiledrenName;
    }

    public Children(Integer childrenNum, String chiledrenName) {
        super(childrenNum+12,chiledrenName+" parent");
        this.childrenNum = childrenNum;
        this.chiledrenName = chiledrenName;
    }


    @Override
    public String toString() {
        return "Children{" +
                "childrenNum=" + childrenNum +
                ", chiledrenName='" + chiledrenName + '\'' +
                '}';
    }
}
