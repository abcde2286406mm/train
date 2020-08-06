package com.ucarinc.wtf.train;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: PlalindromeArithmetic
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 消除字符串中的回文（基于栈）
 * @Date: 2020/4/1 14:02
 * @Version: 1.0
 */
public class PlalindromeArithmetic {
    private static int del = 0;

    public static String clearPlalindromeWithStack(String inputStr){
        //当长度大于2时才可能存在回文
        if (inputStr.length() < 2){
            return inputStr;
        }
        char[] inputChars = inputStr.toCharArray();
        char[] outputChars = new char[1000];
        int j = 0;
        for (char inputChar:inputChars){
            //此处若栈内无元素则直接入栈
            if (outputChars[j] == '\u0000'){
                outputChars[j] = inputChar;
            }else {
                //此处栈内有元素，判断栈顶元素outputChars[j]是否等于入栈元素inputChar，相等则弹出栈顶元素
                //此处判断123321类回文
                if (outputChars[j] == inputChar){
                    outputChars[j] = '\u0000';
                    if (j != 0){
                        j -= 1;
                    }
                    //在栈顶元素不等于入栈元素的情况下，判断栈元素是否大于2，若大于2则判断栈顶的下一个元素outputChars[j-1]是否等于入栈元素inputChar
                    //此处判断12321类回文
                } else if (j-1 >= 0 && outputChars[j-1] == inputChar){
                    outputChars[j] = '\u0000';
                    j -= 1;
                    outputChars[j] = '\u0000';
                    if (j != 0){
                        j -= 1;
                    }
                    //在栈顶元素以及栈顶下一元素都不等于入栈元素的情况下，入栈
                } else {
                    j += 1;
                    outputChars[j] = inputChar;
                }
            }
        }
        return String.copyValueOf(outputChars);
    }

    public static String clearPlalindromeWithStackV2(String inputStr) {
        //当长度大于2时才可能存在回文
        if (inputStr.length() < 2) {
            return inputStr;
        }
        char[] inputChars = inputStr.toCharArray();
        char[] outputChars = new char[1000];
        int j = 0;
        int i = j;
        int protect = 0;
        for (char inputChar : inputChars) {
            //此处若栈内无元素则直接入栈
            if (outputChars[j] == '\u0000') {
                outputChars[j] = inputChar;
                i = j;
            } else {
                //此处栈内有元素，判断栈顶元素outputChars[i]是否等于入栈元素inputChar，相等则标记栈顶元素并向下遍历
                //此处判断123321类回文
                if (outputChars[i] == inputChar) {
                    if (i == 0){
                        while(j >= 0){
                            outputChars[j] = '\u0000';
                            j--;
                            if (j<0){
                                j++;
                                break;
                            }
                        }
                        protect = 0;
                    }else {
                        j++;
                        outputChars[j] = inputChar;
                        i--;
                    }
                    //在栈顶元素不等于入栈元素的情况下，判断栈第i-1个元素是否大于被保护元素下标protect，若大于protect则判断下一个元素outputChars[i-1]是否等于入栈元素inputChar
                    //此处判断12321类回文
                }else if (i-1 > protect && outputChars[i-1] == inputChar){
                    if (j-i == 0){
                        i--;
                    }
                    j++;
                    outputChars[j] = inputChar;
                    i--;
                }else {
                    //每次清除的时候将栈顶元素设置为被保护元素，该元素不再有可能被新生成的回文所识别判断
                    if (i != j){
                        while(j > i){
                            outputChars[j] = '\u0000';
                            if (j > 0){
                                j--;
                            };
                        }
                        protect = i;
                    }
                    j++;
                    outputChars[j] = inputChar;
                    i = j;
                }
            }
        }
        return String.copyValueOf(outputChars);
    }
    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  验证回文字符串
     * @date 2020/5/19 9:12
     * @param s
     * @return boolean
    */
    public static boolean validPalindrome(String s) {
        int i = 0,j = s.length()-1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                //不相等的话，若没有删除字符，则删除左边或右边的字符再判断；若删除过一次，则不是回文串
                if(del == 0){
                    del++;
                    return validPalindrome(s.substring(i,j)) || validPalindrome(s.substring(i+1,j+1));
                }
                return false;
            }
        }
        return true;
//        Stack stack = new Stack();
//        int tag = 0;
//        boolean isContinue = false;
//        for (int i = 0; i<s.length(); i++){
//            char c = s.charAt(i);
//            if (stack.isEmpty()){
//                stack.push(c);
//            }else if (stack.get(stack.size() - 1).equals(c)){
//                isContinue = true;
//                stack.pop();
//            }else if (!isContinue && stack.size() > 2 && stack.get(stack.size() - 2).equals(c)){
//                stack.pop();
//                stack.pop();
//                isContinue = true;
//            }else {
//                if (isContinue){
//                    ++tag;
//                    s.substring(i,i);
//                    if (tag > 1){
//                        return false;
//                    }
//                    continue;
//                }
//                stack.push(c);
//            }
//        }
//        if (stack.size() < 1 && s.equals()){
//            return false;
//        }
//        return true;
    }
}
