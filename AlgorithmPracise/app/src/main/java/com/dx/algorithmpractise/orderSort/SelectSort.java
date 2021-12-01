package com.dx.algorithmpractise.orderSort;
/**
 * 跟插入排序有点类似，把数据分成已排序空间和未排序空间
 * 差别：选择排序会在未排序中选择最小的元素放在已排序的末尾(通过交换位置)
 */

/**
 * 1.时间复杂度      最好的情况也要遍历一遍O(n2),最坏的情况跟插入一样O(n2)
 * 2.是原地排序      空间复杂度是O(1)
 * 3.不是稳定排序
 * 例如 5.1(代表第一个5) 8 5.2(代表第二个5)  2   9
 * 第一次  2  8  5.2  5.1  9
 * 可以看到相同元素的前后顺序已经变了
 */
public class SelectSort {

    /**
     * Action:
     * 1.假设第一个元素就是最小的，然后找出最小值的index，最后交换即可
     */
    public static void doSelectSort(int[] items, int n) {
        if (n < 2) return;
        //最小值的index
        int minIndex;
        int tempValue;

        for (int i = 0; i < n - 1 ; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                //这里就是找出最小值的index
                if (items[j] < items[minIndex]) {
                    //如果值小于minIndex;
                    minIndex = j;
                }
            }
            tempValue = items[i];
            items[i] = items[minIndex];
            items[minIndex] = tempValue;
        }
    }
}
