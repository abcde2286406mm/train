package com.ucarinc.wtf.demo.Enum;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Enum
 * @ClassName: OperationV2
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/7 17:53
 * @Version: 1.0
 */
public enum OperationV2 {

    PLUS  ("+", Double::sum),
    MINUS ("-", (x, y) -> x - y),
    TIMES ("*", Double::max),
    ;
    private final String symbol;
    private final DoubleBinaryOperator op;


    OperationV2(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public String getSymbol() {
        return symbol;
    }

    public DoubleBinaryOperator getOp() {
        return op;
    }
    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
