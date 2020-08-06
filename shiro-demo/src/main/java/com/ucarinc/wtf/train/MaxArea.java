package com.ucarinc.wtf.train;
/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: MaxArea
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/13 11:11
 * @Version: 1.0
 */
public class MaxArea {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        for (; i < j;){
            maxArea = Math.max(Math.min(height[i] , height[j]) * (j - i),maxArea);
            if (height[i] < height[j]){
                i ++;
            }else {
                j--;
            }
        }
        return maxArea;
    }
}
