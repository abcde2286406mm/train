package com.ucarinc.wtf.demo;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: maxProduct
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 乘积最大子数组
 * @Date: 2020/5/18 10:05
 * @Version: 1.0
 */
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int max = nums[0],min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++){
            max = Math.max(max*nums[i], Math.max(nums[i],min*nums[i]));
            min = Math.min(max*nums[i],Math.min(nums[i],min*nums[i]));
            ans = Math.max(max,ans);
        }
        return ans;
    }
}
