package com.ucarinc.wtf.train;

import com.ucarinc.wtf.train.Model.Parent;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: CompareUtil
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 创建父类比较器
 * @Date: 2020/4/29 15:52
 * @Version: 1.0
 */
public class CompareUtil {
    public static <E extends Comparable<Parent>> E max(Collection<E> c){
        if (c.isEmpty()){
            throw new IllegalArgumentException("Empty collection");
        }
        E result = null;
        for (E e : c){
            if (result == null || e.compareTo((Parent) result) > 0){
                result =  Objects.requireNonNull(e);
            }
        }
        return result;
    }
    public static <E extends Parent> Set<E> union(Set<E> s1, Set<E> s2){
        if (s1.addAll(s2)){
            return s1;
        }
        return null ;
    }
    //判断父类
    public static <T> Boolean checkClass(T clazz){
        if (clazz.getClass().getSuperclass().getName().equals(Parent.class.getName())){
            return true;
        }else {
            return false;
        }
    }
}
