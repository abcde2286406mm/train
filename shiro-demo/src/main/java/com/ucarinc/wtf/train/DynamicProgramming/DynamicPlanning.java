package com.ucarinc.wtf.train.DynamicProgramming;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: DynamicPlanning
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 火车票最低价（动态规划）
 * @Date: 2020/5/6 15:00
 * @Version: 1.0
 */
public class DynamicPlanning {
    public static int mincostTickets(int[] days, int[] costs) {
        int len = days[days.length - 1];//获取小的天数长度
        int[] dp = new int[len+1];//第一天是0天，由于最小天数为1天，因此补上一天
        int dayIndex = 0;
        for (int i = 0; i < dp.length; i++){
            //当第i天需要是需要旅游的天数时
            if (i == days[dayIndex]){
                //买一天的票所花费的钱
                int cost = dp[i-1] + costs[0];
                //目前总花费与一周前买7天票所花费的钱对比，取小。
                cost = Math.min(dp[i - 7 < 0 ? 0 : i - 7] + costs[1],cost);
                //目前总花费与一个月前买30天票所花费的钱对比，取小。
                cost = Math.min(dp[i - 30 < 0 ? 0 : i - 30] + costs[2],cost);
                dp[i] = cost;
                dayIndex ++;
            }else {
                //当第i天不需要旅游时，不花费额外的钱
                if (i >= 1){
                    dp[i] = dp[i-1];
                }else {
                    dp[i] = 0;
                }
            }
        }
        return dp[len];
    }
}
