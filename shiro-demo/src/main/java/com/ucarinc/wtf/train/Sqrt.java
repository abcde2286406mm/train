package com.ucarinc.wtf.train;

/**
 * @ProjectName: ucarcdmsos
 * @Package: com.ucar.cdmsos.remoteV2.dispatch
 * @ClassName: Sqrt
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 求平方根
 * @Date: 2020/5/9 9:33
 * @Version: 1.0
 */
public class Sqrt {
    public static int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        int m = 1;
        for (; x/m >= m; m++) {
        }
        return m-1;
    }
    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  
     * @date 2020/5/9 10:21
     * @param x
     * @return int
    */
    public static int mySqrtV2(int x){
        int l = 0,r = x,result = 0;
        if (x <= 1){
            return x;
        }
        while (l <= r){
            int mid = (l + (r-1)+1) / 2;
            if (x / mid < mid){
                r = mid-1;
            }else{
                result = mid;
                l = mid+1;
            }
        }
        return result;
    }

    public int mySqrtV3(int x) {
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}
