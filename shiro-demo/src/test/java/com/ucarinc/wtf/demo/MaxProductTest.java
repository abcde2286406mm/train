package com.ucarinc.wtf.demo;

import com.ucarinc.wtf.train.MaxProduct;
import org.junit.Test;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: maxProductTest
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/18 10:27
 * @Version: 1.0
 */
public class MaxProductTest {

    @Test
    public void maxProduct() {
        System.out.println(MaxProduct.maxProduct(new int[]{1, 2, -3, 4, 5, 1}));
    }
}