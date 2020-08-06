package com.ucarinc.wtf.train.DynamicProgramming;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.DynamicProgramming
 * @ClassName: Rob
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 打家劫舍
 * @Date: 2020/5/29 14:14
 * @Version: 1.0
 */
public class Rob {
    public static int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }else if (nums.length == 1){
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }else {
            nums[1] = Math.max(nums[0],nums[1]);
            for (int i = 2; i < nums.length; i++){
                nums[i] = Math.max(nums[i-1],nums[i-2]+nums[i]);
            }
            return nums[nums.length-1];
        }
    }
}
