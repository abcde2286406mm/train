package com.ucarinc.wtf.train;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: myPown
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/11 9:31
 * @Version: 1.0
 */
public class MyPow {
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0){
            N = -N;
            x = 1/x;
        }
        double ans = 1;
        for (int i = 0; i < N; i++){
            ans = ans*x;
        }
        return ans;
    }
    public static double myPowV2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        else if (n > 0 && n % 2 == 0){
            return myPow(x * x, n / 2);
        }
        else if (n > 0) {
            return myPow(x, n - 1) * x;
        }
        else {
            return 1 / myPow(x, -n);
        }
    }
}
