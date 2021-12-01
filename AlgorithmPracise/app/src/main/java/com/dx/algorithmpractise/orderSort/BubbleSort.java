package com.dx.algorithmpractise.orderSort;

public class BubbleSort {

    /**
     * 冒泡排序
     * 基于比较
     * 比较相邻的两个元素，大的或者小的往后排，直到没有数据交换操作
     * 这里我们排个从小到大的数组
     * */

    /**
     * 如何分析算法的
     * 1.排序算法的执行效率    时间复杂度，最好，最坏复杂度等等
     * 2.排序算法的内存消耗    是否是原地排序(空间复杂度为O（1）)
     * 3.排序算法的稳定        值相等的元素的位置是否变换
     * */

    /**
     * 冒泡排序分析
     * 1.最好是O(n),最坏就是需要进行n次冒泡(第一次交换 n-1， 第二次 n-2,第n次1),所以最坏时间复杂度是O(n2)
     * 2.是原地排序，只消耗了一个临时变量,时间复杂度是O(1)
     * 3.是稳定排序    相等的值前后顺序没有变
     */

    /**
     * Action:
     * 1.用两个循环来保证，每次循环之后都会比上一次少一次循环（即 n -1 , n -2 ....）
     * 2.注意提前中断的标志
     */
    public static void doBubbleSort(int[] items, int n) {
        if (n <= 1) return;
        int temp;
        Boolean breakFlag = true;
        for (int i = 0; i < n; i++) {
            //注意 n - j - 1(不写的话回取到item[n])
            for (int j = 0; j < n - i - 1; j++) {
                if (items[j] > items[j + 1]) {
                    //前者比后者大
                    temp = items[j + 1];
                    items[j + 1] = items[j];
                    items[j] = temp;
                    breakFlag = false;
                }
            }
            if (breakFlag) break;
        }
    }
}
