package com.ucarinc.wtf.train.Model;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Model
 * @ClassName: Parent
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/4/29 15:33
 * @Version: 1.0
 */
public class Parent implements Comparable<Parent>{
    private Integer parentNum;
    private String parentName;

    public Integer getParentNum() {
        return parentNum;
    }

    public void setParentNum(Integer parentNum) {
        this.parentNum = parentNum;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Parent(Integer parentNum, String parentName) {
        this.parentNum = parentNum;
        this.parentName = parentName;
    }

    @Override
    public int compareTo(Parent o) {
        if (this.parentNum.compareTo(o.parentNum) == 0){
            return this.parentName.compareTo(o.parentName);
        }else {
            return this.parentNum.compareTo(o.parentNum);
        }
    }
}
