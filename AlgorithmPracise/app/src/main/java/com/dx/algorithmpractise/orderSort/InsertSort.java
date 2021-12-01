package com.dx.algorithmpractise.orderSort;

/**
 * 基本思想:就是将数组分成两个区间
 * 已排序区间
 * 和
 * 未排序区间
 * 从未排序区间取元素插入到已排序区间， 初始已排序区间默认只有一个元素，直到未排序区间元素为空，则排序结束
 */


/**
 * 这里从小到大排 5， 4,3,2,1
 * <p>
 * 1.时间复杂度   最好情况也要每个都比较一下，O(n),
 * 最坏的情况倒序每次都要在第一个位置插入数据（第一次移动1个数据，第n次移动n个数据）
 * 所以最坏时间复杂度是O(n2)
 * 2.是原地排序   空间复杂度是O(1)
 * 3.是稳定排序   后面出现的元素，可以插在前面出现元素的后面
 */
public class InsertSort {

    /**
     * Action:
     * 1.把数组分成两个区间的写法
     * 2. 默认第一个元素是已经 排序的区间
     */
    public static void doInsertSort(int[] items, int n) {
        if (n < 2) return;

        for (int i = 1; i < n; i++) {
            //未排序的区间
            int value = items[i];
            //已排序的最后一个元素
            int j = i - 1;
            for (; j >= 0; j--) {
                if (items[j] > value) {
                    items[j + 1] = items[j];
                } else {
                    break;
                }
            }
            items[j + 1] = value;
        }
    }
}
