package com.ucarinc.wtf.train.DynamicProgramming;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.DynamicProgramming
 * @ClassName: TranslateNum
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 把数字翻译成字符串
 * @Date: 2020/6/9 14:20
 * @Version: 1.0
 */
public class TranslateNum {
    public static int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }
}
