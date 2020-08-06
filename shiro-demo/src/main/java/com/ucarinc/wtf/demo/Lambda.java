package com.ucarinc.wtf.demo;


import com.ucarinc.wtf.demo.Model.AnonymityClass;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: Lambda
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/7 17:47
 * @Version: 1.0
 */
public class Lambda {
    public static Integer intLambda(Integer a,Function<Integer,Integer> function){
        return function.apply(a);
    }
    public static Integer intLambdaV2(Integer a,Integer b, BiFunction<Integer,Integer,Integer> function2){
        return function2.apply(a,b);
    }
    //xxbinaryOperator是二元的，xxUnaryOperator是一元的
    public static Integer intLambdaV3(Integer a,Integer b, IntBinaryOperator intBinaryOperator){
        return intBinaryOperator.applyAsInt(a,b);
    }
    public static Integer intLambdaV4(Integer a,Integer b, AnonymityClass anonymityClass){
        return anonymityClass.calculate(a,b);
    }

}
