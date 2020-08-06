package com.ucarinc.wtf.demo;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: MinSubArrayLen
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 长度最小的子数组
 * @Date: 2020/6/28 15:22
 * @Version: 1.0
 */
public class MinSubArrayLen {
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int minLength = 0;
        int sum = nums[0];
        int i = 0,j = 0;
        do {
            if (sum >= s){
                if (minLength == 0){
                    minLength = i-j+1;
                }else {
                    minLength = Math.min(i-j+1,minLength);
                }
                sum -= nums[j];
                j++;
            }else {
                i++;
                if (i >= nums.length){
                    break;
                }
                sum += nums[i];
            }
        }while (true);
        return minLength;
    }
}
