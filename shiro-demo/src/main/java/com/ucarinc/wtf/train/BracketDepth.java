package com.ucarinc.wtf.train;

import java.util.Stack;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: Solution
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 计算有效字符串嵌套深度
 * @Date: 2020/4/1 17:23
 * @Version: 1.0
 */
public class BracketDepth {
    public static int[] maxDepthAfterSplit(String seq) {

        int[] answer=new int[seq.length()];
        int length = 0;
        char[] chars = seq.toCharArray();
        for (int i = 0; i < seq.length(); i ++){
            if (chars[i] == '('){
                length++;
                answer[i] = (length%2);
            }else {
                answer[i] = (length%2);
                length--;
            }
        }
        return answer;


//        char[] str=seq.toCharArray();
//        int n=seq.length();
//        int[] answer=new int[n];
//        int length=0;
//        int i=0;
//        for(int j=0;j<n;j++){
//            if(str[j]=='(') {
//                length++;
//                answer[i++]=length%2;
//            }else {
//                answer[i++]=length%2;
//                length--;
//            }
//        }
//        return answer;

//        int[] outInt = new int[seq.length()];
//        int depth = 0;
//        if (seq.length() == 0  || seq.length() % 2 != 0){
//            return outInt;
//        }
//        char[] chars = seq.toCharArray();
//        Stack bracket = new Stack();
//        //这边为了提升可读性，我分开判断，先判断输入字符串是否合法，再输入深度
//        for (char c:chars){
//            if (c == '('){
//                bracket.push(c);
//            }else if (c == ')'){
//                if (bracket.size() > 0){
//                    bracket.pop();
//                }
//                else {
//                    return outInt;
//                }
//            }else {
//                return outInt;
//            }
//        }
//        if (bracket.size() == 0){
//            for (int i = 0; i < chars.length; i++){
//                char c = chars[i];
//                if (c == '('){
//                    outInt[i] = depth;
//                    depth++;
//                    bracket.push(c);
//                }else {
//                    depth--;
//                    outInt[i] = depth;
//                    bracket.pop();
//                }
//            }
//            return outInt;
//        }else {
//            return outInt;
//        }
    }
}
