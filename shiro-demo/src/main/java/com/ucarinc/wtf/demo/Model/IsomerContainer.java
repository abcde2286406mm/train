package com.ucarinc.wtf.demo.Model;

import java.util.*;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Model
 * @ClassName: IsomerContainer
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 异构容器
 * @Date: 2020/4/30 10:30
 * @Version: 1.0
 */
public class IsomerContainer {
    private Map<Class<?>, Object> favorites = new HashMap<>();
    public<T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public<T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
