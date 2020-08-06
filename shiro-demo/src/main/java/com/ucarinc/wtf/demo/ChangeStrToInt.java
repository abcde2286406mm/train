package com.ucarinc.wtf.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: ChangeStrToInt
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 字符串转int型
 * @Date: 2020/4/3 14:43
 * @Version: 1.0
 */
public class ChangeStrToInt {
    public static int myAtoi(String str) {
        boolean isContinue = false;
        int negative = 1;
        int max_int = 0x7fffffff;
        int min_int = 0x80000000;

        StringBuilder sb = new StringBuilder();
        Long result = 0L;
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == ' ' && isContinue == false){
                continue;
            }else if ((c < '0' || c > '9') && c != '-' && c != '+'){
                break;
            }else {
                if (c == '-'){
                    if (isContinue == false){
                        isContinue = true;
                        negative = -1;
                    }else {
                        break;
                    }
                }else if(c == '+' ){
                    if (isContinue == false){
                        isContinue = true;
                        continue;
                    }else {
                        break;
                    }
                }else if ('9' >= c && c >= '0'){
                    if (isContinue == false){
                        isContinue = true;
                    }
                    result = result * 10 + (c - '0');
                    if (result*negative > max_int){
                        return max_int;
                    }else if (result*negative < min_int){
                        return min_int;
                    }
                }
            }
        }
        result = result*negative;
        return result.intValue();
//        //第二部分String转成int
//        String out = stringBuilder.toString();
//        if ("".equals(out)){
//            result = 0;
//        }else {
//            try {
//                result = Integer.parseInt(out);
//            }catch (NumberFormatException e){
//                if (out.substring(0,1).equals("-")){
//                    if (out.length() == 1){
//                        result = 0;
//                    }else {
//                        result = 0x80000000;
//                    }
//                }else {
//                    result = 0x7fffffff;
//                }
//            }
//        }
//        return result;
    }
}
