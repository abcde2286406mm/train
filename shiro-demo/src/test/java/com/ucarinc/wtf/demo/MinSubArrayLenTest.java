package com.ucarinc.wtf.demo;

import com.ucarinc.wtf.train.MinSubArrayLen;
import org.junit.Test;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: MinSubArrayLenTest
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/6/28 15:30
 * @Version: 1.0
 */
public class MinSubArrayLenTest {

    @Test
    public void minSubArrayLen() {
        int[] ints = {1,2,3,4,5,5,10};
        MinSubArrayLen.minSubArrayLen(10,ints);
    }
}