package com.dx.algorithmpractise.orderSort;

/**
 * 查找第K大元素
 */
public class SortFunction {

    /**
     * 查找第K大元素， 可以用链表（快慢指针），或者快排
     * <p>
     * 这里用快排的方式
     */
    public static int findKthBiggestElement(int[] items, int kthIndex) {
        if (items == null || items.length < kthIndex) {
            return -1;
        }

        //3 2 1 4  3
        int middleIndex = partition(items, 0, items.length - 1);
        //如果kthIndex 是从1开始  middleIndex 是从 0开始
        while (middleIndex + 1 != kthIndex) {
            if (middleIndex + 1 < kthIndex) {
                //说明在后半部分
                middleIndex = partition(items, middleIndex + 1, items.length - 1);
            } else {
                //说明在前半部分
                middleIndex = partition(items, 0, middleIndex - 1);
            }
        }

        return items[middleIndex];
    }

    //获取中间值的index
    private static int partition(int[] items, int start, int end) {
        //默认取最后一个值为 pivot
        int pivot = items[end];
        int i = start;
        for (int j = 0; j < end; j++) {
            if (items[i] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    //需要i,j互换
                    int tempValue = items[i];
                    items[i++] = items[j];
                    items[j] = tempValue;
                }
            }
        }

        // j不能去end
        //最后 把  i 和 j 交换 ，也就是把middle值放到中间
        int tmp = items[i];
        items[i] = items[end];
        items[end] = tmp;
        return i;
    }
}
