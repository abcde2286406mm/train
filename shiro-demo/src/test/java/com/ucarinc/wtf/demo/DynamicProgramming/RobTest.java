package com.ucarinc.wtf.demo.DynamicProgramming;

import com.ucarinc.wtf.train.DynamicProgramming.Rob;
import org.junit.Test;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.DynamicProgramming
 * @ClassName: RobTest
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/29 14:17
 * @Version: 1.0
 */
public class RobTest {

    @Test
    public void rob() {
        System.out.println(Rob.rob(new int[]{2,1,1,2}));
    }
}