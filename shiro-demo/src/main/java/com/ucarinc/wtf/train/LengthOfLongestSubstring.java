package com.ucarinc.wtf.train;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: LengthOfLongestSubstring
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的最长子串 的长度。
 * @Date: 2020/5/6 16:53
 * @Version: 1.0
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int index = 0;//设置标记位
        int maxLength = 0;
        char[] chars = s.toCharArray();
        if (s.length() <= 1){
            return s.length();
        }
        for (int i = 1; i < s.length(); i++){
           for (int j = index; j < i; j++){
               if (chars[j] == chars[i]){
                   maxLength = Math.max(maxLength,i-index);
                   index = ++j;//将标记位放置于前一个数的后一个位置
               }
           }
        }
        maxLength = Math.max(maxLength,s.length()-index);
        return maxLength;
    }
}
