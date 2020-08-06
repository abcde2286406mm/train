package com.ucarinc.wtf.demo.Enum;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Enum
 * @ClassName: Operation
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 枚举demo
 * @Date: 2020/5/6 11:06
 * @Version: 1.0
 */
public enum Operation implements OperationInterface{
    PLUS("+") {
        @Override
        public double apply(double x, double y) { return x + y; }
        },
    MINUS("-") {
        @Override
        public double apply(double x, double y) { return x - y; }
        }
    ;
    private final String symbol;


    Operation(String symbol) {
        this.symbol = symbol;
    }

}
