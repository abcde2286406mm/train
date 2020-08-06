package com.ucarinc.wtf.train;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: Bargain
 * @Author: tengfei.wu01
 * @Description: 组团砍价
 * @Date: 2020/4/26 17:25
 * @Version: 1.0
 */
public class Bargain {
    private static Double price = 100D;//总价
    private static Double bargainPrice = 0D;//已减金额
    private static Integer bargainUserNum = 0;//已减人数
    private static Double cardinalNumber = 0.5D;//砍价基数
    private static Integer newUserMultiple = 10;//新用户砍价倍数
    private static Integer preUserMultiple = 10;//老用户前期砍价倍数(后期砍价倍数为1)
    private static List<BargainUser> bargainUsers = new LinkedList<>();
    class BargainUser{
        private String userType;//用户类型
        private Double bargainPrice;//用户砍价金额

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public Double getBargainPrice() {
            return bargainPrice;
        }

        public void setBargainPrice(Double bargainPrice) {
            this.bargainPrice = bargainPrice;
        }

        @Override
        public String toString() {
            return userType + " " + bargainPrice;
        }
    }
    /***
     * @author tengfei.wu
     * @description  砍价
     * @date 2020/4/26 18:46
     * @param price 商品总价值
     * @param bargainPrice 已砍金额
     * @param bargainUserNum 已砍人数
     * @param userType 用户类型
     * @return void
    */
    public void bargainProduct(Double price, Double bargainPrice, Integer bargainUserNum, String userType){
        //获取砍价基数（0.4-0.6）
        BigDecimal bd = new BigDecimal(Math.random()*0.2 - 0.1);
        Double subtractedPrice = cardinalNumber + bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        BargainUser bargainUser = new BargainUser();

        //判断是否符合条件(以100为拼团人数上限)
        if (!"oldUser".equals(userType) || !"oldUser".equals(userType) || bargainPrice >= price || bargainUserNum >= 100){
            return;
        }else {
            if ("oldUser".equals(userType)){
                //如果是老用户且在前期拼团阶段
                if (bargainPrice < 50D){
                    subtractedPrice = subtractedPrice * preUserMultiple;
                }
                //当可砍价金额小于砍价基数*砍价倍数时，以可砍价金额为准
                if (bargainPrice + subtractedPrice > price){
                    bargainPrice = price - subtractedPrice;
                }
                Bargain.bargainUserNum++;
                Bargain.bargainPrice += subtractedPrice;

            }else if ("newUser".equals(userType)){
                subtractedPrice = subtractedPrice * newUserMultiple;
                //当可砍价金额小于砍价基数*砍价倍数时，以可砍价金额为准
                if (bargainPrice + subtractedPrice > price){
                    bargainPrice = price - subtractedPrice;
                }
                Bargain.bargainUserNum++;
                Bargain.bargainPrice += subtractedPrice;
            }
        }
        bargainUser.setUserType(userType);
        bargainUser.setBargainPrice(subtractedPrice);
        bargainUsers.add(bargainUser);
    }
    /***
     * @author tengfei.wu01
     * @description  展示砍价列表
     * @date 2020/4/26 18:46
     * @param
     * @return void
    */
    public void showBargainList(){
        for (BargainUser bargainUser:bargainUsers){
            System.out.println(bargainUser.toString());
        }
        System.out.println(bargainUserNum);
    }
    public static void main(String[] args) {
        Bargain bargain = new Bargain();
        for (int i = 0; i < 120; i++){
            bargain.bargainProduct(price,bargainPrice,bargainUserNum,"oldUser");
        }
        bargain.showBargainList();
    }
}
