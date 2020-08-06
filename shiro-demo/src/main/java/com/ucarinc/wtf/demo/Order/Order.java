package com.ucarinc.wtf.demo.Order;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: Order
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 排序集合
 * @Date: 2020/5/14 13:44
 * @Version: 1.0
 */
public class Order {
    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  冒泡排序(双循环，从前到后依次两两比较）
     * @date 2020/5/14 13:46
     * @param ints
     * @return int[]
    */
    public static int[] bubbleSort(int[] ints){
        for (int i = 0; i < ints.length; i++){
            for (int j = i; j < ints.length; j++){
                if (ints[j] < ints[i]){
                    int temp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = temp;
                }
            }
        }
        return ints;
    }

    /***
     * @author tengfei.wu01@ucarinc.com
     * @description 插入排序（双循环，从后往前比较，插入，位移），
     * @date 2020/5/14 14:11
     * @param ints
     * @return int[]
    */
    public static int[]  insertionSort(int[] ints){
        for (int i = 1; i < ints.length; i++){
            for (int j = i; j > 0; j--){
                if (ints[j] < ints[j-1]){
                    int temp = ints[j];
                    ints[j] = ints[j-1];
                    ints[j-1] = temp;
                }
            }
        }
        return ints;
    }
    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  选择排序：每次选择最小数的和第i个数进行交换
     * @date 2020/5/14 14:25
     * @param ints
     * @return int[]
    */
    public static int[] selectSort(int[] ints){
        for (int i = 0; i < ints.length; i ++){
            int min = ints[i];
            int index = i;
            for (int j = i; j < ints.length; j++){
                if (ints[j] < min){
                    min = ints[j];
                    index = j;
                }
            }
            int temp = ints[i];
            ints[i] = ints[index];
            ints[index] = temp;
        }
        return ints;
    }
    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  快速排序
     * @date 2020/5/14 14:33
     * @param ints
     * @return int[]
    */
    public static int[] fastSort(int[] ints, int start, int end){
       int i = start;
       int j = end;
       while (i < j){
           while (j > i && ints[j] >= ints[start]){
               j--;
           }
           while (i < j && ints[i] < ints[start]){
               i++;
           }
           int temp = ints[i];
           ints[i] = ints[j];
           ints[j] = temp;
       }
       if(i > start){
           ints = fastSort(ints,start,i);
       }
       if (j+1 < end){
           ints = fastSort(ints,j+1,end);
       }
       return ints;
    }
    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  归并排序
     * @date 2020/5/14 16:26
     * @param ints
     * @param left
     * @param right
     * @return int[]
    */
    public static int[] MergeSort(int[] ints,int left,int right){
        if (left == right){
            return new int[]{ints[left]};
        }
        int mid = (left + right - 1) / 2;
        int[] lefts = MergeSort(ints,left,mid);
        int[] rights = MergeSort(ints,mid+1,right);
        int[] merged = new int[lefts.length + rights.length];

        int m = 0, i = 0, j = 0;
        while (i < lefts.length && j < rights.length){
            merged[m++] = lefts[i] < rights[j] ? lefts[i++] : rights[j++];
        }
        while (i < lefts.length){
            merged[m++] = lefts[i++];
        }
        while (j < rights.length){
            merged[m++] = rights[j++];
        }
        return merged;
    }

    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  堆排序
     * @date 2020/5/14 17:22
     * @param ints
     * @return int[]
    */
    public static int[] heapSort(int[] ints){
        for (int j = ints.length; j > 0; j--){
            for (int i = 0; i < j; i++){
                int index = (i-1)/2;
                int m = i;
                for ( ;index>= 0 && ints[m] > ints[index];){
                    swap(ints,m,index);
                    m = index;
                    index = (index - 1)/2;
                }
            }
            swap(ints,0,j - 1);
        }
        return ints;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
