package com.ucarinc.wtf.demo;

import com.ucarinc.wtf.demo.Order.Order;
import org.junit.Test;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: OrderTest
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/14 13:51
 * @Version: 1.0
 */
public class OrderTest {

    @Test
    public void bubbleSort() {
        int[] ints = new int[20];
        for (int i = 0; i < ints.length; i++){
            ints[i] = (int) (Math.random() * 20);
        }
        long a = System.currentTimeMillis();
//        ints = Order.heapSort(ints);
//        System.out.println("堆排序"+(System.currentTimeMillis() - a) + "毫秒");
//
//        a = System.currentTimeMillis();
//        ints = Order.selectSort(ints);
//        System.out.println("选择排序"+(System.currentTimeMillis() - a) + "毫秒");
//
//        a = System.currentTimeMillis();
//        ints = Order.bubbleSort(ints);
//        System.out.println("冒泡排序"+(System.currentTimeMillis() - a) + "毫秒");
//        a = System.currentTimeMillis();
        for (int i : ints){
            System.out.println(i);
        }
        ints = Order.fastSort(ints,0,ints.length-1);
        System.out.println("快速排序"+(System.currentTimeMillis() - a) + "毫秒");
        for (int i : ints){
            System.out.println(i);
        }
//        a = System.currentTimeMillis();
//        ints = Order.insertionSort(ints);
//        System.out.println("插入排序"+(System.currentTimeMillis() - a) + "毫秒");
//        a = System.currentTimeMillis();
//        ints = Order.MergeSort(ints,0,ints.length-1);
//        System.out.println("归并排序"+(System.currentTimeMillis() - a) + "毫秒");
    }
}