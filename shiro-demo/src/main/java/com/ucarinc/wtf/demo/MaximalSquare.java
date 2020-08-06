package com.ucarinc.wtf.demo;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: MaximalSquare
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 最大正方形
 * @Date: 2020/5/8 13:54
 * @Version: 1.0
 */
public class MaximalSquare {
    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  暴力破解法
     * @date 2020/5/8 16:51
     * @param matrix 二维数组
     * @return int
    */
    public static int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        for (int x = 0; x < matrix.length; x++){
            for (int y = 0; y < matrix[x].length; y++){
                //循环遍历二维数组，当某一位置值为'1'时，通过迭代获取其最长边长
                if (matrix[x][y] == '1'){
                    int indexX = x;
                    int indexY = y;
                    int maxLength = 0;
                    for (; ;++x,++y,++maxLength){
                        //如果以x,y为左上角，x+1，y+1的格子作为右下角的时候围成的图形满足正方形的条件，则进一步伸展右下角
                        if (isSquare(matrix,indexX,indexY,x,y)){
                            continue;
                        }else {
                            //若不满足条件则返回目前最大面积
                            maxSize = Math.max(maxSize,maxLength*maxLength);
                            break;
                        }
                    }
                    x = indexX;
                    y = indexY;
                }
            }
        }
        return maxSize;
    }
    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  判断是否为正方形
     * @date 2020/5/8 16:54
     * @param matrix 二维数组
     * @param startX 左上角x坐标
     * @param startY 左上角y坐标
     * @param endX 右下角x坐标
     * @param endY 右下角y坐标
     * @return boolean
    */
    public static boolean isSquare(char[][] matrix, int startX, int startY, int endX, int endY){
        for (; startX <= endX; startX++){
            if (startX >= matrix.length){
                return false;
            }
            for (int start = startY; start <= endY; start++){
                if (start >= matrix[startX].length){
                    return false;
                }
                if (matrix[startX][start] == '1'){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  动态规划算法
     * @date 2020/5/8 16:56
     * @param matrix
     * @return int
    */
    public static int maximalSquareV2(char[][] matrix) {
        int maxLength = 0;
        for (int x = 0; x < matrix.length; x++){
            for (int y = 0; y < matrix[x].length; y++){
                if (matrix[x][y] >= '1'){
                    //如果该点处于边界，则最大长度一定为1
                    if (x == 0 || y == 0){
                        matrix[x][y] = '1';
                    }
                    else {
                        //如果越界了，则无法与其他坐标构成正方形，因此最大长度为1
                        if (y >= matrix[x-1].length){
                            matrix[x][y] = '1';
                        }else {
                            //如果该坐标的其他三个角都可以与别的坐标点构成正方形，那么这个点同样可以与这三个角构成正方形，取最短长度+1作为新正方形的边长
                            int val = Math.min(Math.min(matrix[x-1][y] - '0',matrix[x][y-1] - '0'),matrix[x-1][y-1] - '0') + 1;
                            matrix[x][y] = (char) (val+'0');
                        }
                    }
                }
                maxLength = Math.max(matrix[x][y] - '0',maxLength);
            }
        }
        return maxLength*maxLength;
    }
}
