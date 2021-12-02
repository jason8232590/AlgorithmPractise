package com.dx.algorithmpractise.search;

/**
 * <1>基本思想
 * 二分查找针对的是一个有序的数据集合，查找思想类似分治思想，每次都通过跟区间的中间元素对比，将待查找的区间缩小一半，直到找到要查找的元素，或者区间被缩小为0
 * <2>使用场景
 * 1)必须是顺序结构，因为二分查找通过下标随机访问元素
 * 2)数据太少不适合，直接遍历就好，数据太大也不适合，因为二分查找依赖数组这种数据结构，它的空间是连续的，如果要查找1GB的数据，那就意味要1GB的连续空间
 * <3>时间复杂度
 * 时间复杂度是O(logn)
 * 1.每次都只是两个元素比对
 * 第一次是 查找区间 n个元素
 * 第二次是 查找区间 n/2 个元素
 * 第K次是 查找区间 n/2^k-1 个元素
 * 第K次区间变成1个元素
 * K = logn
 * 所以时间复杂度是O(logn)
 */

public class BinarySearch {

    /**
     * 正常实现
     */
    public static int doBinarySearch(int[] items, int n, int value) {
        int low = 0;
        int high = n - 1;
        //1,2,3,4,5,7
        //low 0  high 5  middle 2
        //low 0  high 1 middle 0
        while (low <= high) {
//            int middleIndex = high - ((high - low) >> 1); //这种 middleIndex 会比下面多 1 不过不会影响最终结果 //会出现 low == high的情况
            int middleIndex = low + ((high - low) >> 1);  //这种 middleIndex 会比上面小1 不过不会影响最终结果
            if (value > items[middleIndex]) {
                //说明在后半部分
                low = middleIndex + 1;
            } else if (value < items[middleIndex]) {
                high = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     */
    public int binarySearchRecursion(int[] items, int n, int value) {
        return searchRecursionInternally(items, 0, n - 1, value);
    }

    private int searchRecursionInternally(int[] items, int low, int high, int value) {
        if (low > high) return -1;
        int middleIndex = low + ((high - low) >> 1);
        if (items[middleIndex] == value) {
            return middleIndex;
        } else if (value > items[middleIndex]) {
            //说明value在后半部分
            return searchRecursionInternally(items, middleIndex + 1, high, value);
        } else {
            //说明value在前半部分
            return searchRecursionInternally(items, low, middleIndex - 1, value);
        }
    }


    /**
     * 变种问题(这时候数组里面有重复的元素)
     * 1.查找第一个等于 value 的， 只需要判断index-1是不是也等于value就行了
     * 2.查找最后一个等于vlaue的， 只需要判断index+1 是不是也等于value就行了
     * 3.查找第一个大于等于value的，
     * 如果a[mid] 大于等于给定vlaue
     * (1)a[mid]是不是第一个元素，如果不是就判断a[mid-1]是不是也大于等于value
     * (2)如果不是那a[mid]就是我们要找的
     * (3)如果是那就说明我们要找的数在 low .. mid-1 这个范围里
     * 4.查找最后一个大于等于value的
     * 原理同上
     */
    /**
     * 查找第一个大于等于 某个值
     */
    public int getFirstCertainValue(int[] items, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middleIndex = low + ((high - low) >> 1);
            if (value > items[middleIndex]) {
                //在后半部分
                low = middleIndex + 1;
            } else if (value < items[middleIndex]) {
                high = middleIndex - 1;
            } else {
                //这里就是差别的地方   判断 index - 1对应的值是否相等
                if (middleIndex == 0 || value != items[middleIndex - 1]) {
                    return middleIndex;
                } else {
                    high = middleIndex - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 获取最后一个等于该定值的元素
     */
    public int getLastCertain(int[] items, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middleIndex = low + ((high - low) >> 1);
            if (value > items[middleIndex]) {
                //在后半部分
                low = middleIndex + 1;
            } else if (value < items[middleIndex]) {
                high = middleIndex - 1;
            } else {
                //这里就是差别的地方   判断 index + 1对应的值是否相等
                if (middleIndex == n - 1 || value != items[middleIndex + 1]) {
                    return middleIndex;
                } else {
                    low = middleIndex + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 找到第一个大于等于 value 的index
     */
    public int getFirstBigEqual(int[] items, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middleIndex = low + ((high - low) >> 1);
            if (items[middleIndex] > value) {
                if (middleIndex == 0 || items[middleIndex] - 1 < value) {
                    return middleIndex;
                } else {
                    high = middleIndex - 1;
                }
            } else {
                low = middleIndex + 1;
            }
        }

        return -1;
    }


}
