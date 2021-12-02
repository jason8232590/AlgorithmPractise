package com.dx.algorithmpractise.orderSort;
/**
 * 特殊的桶排序，区别在于桶的颗粒度的大小
 * 桶排序的桶可能存 0 -99
 * <p>
 * 但是计数排序的桶里面的值只能是一个  (用于统计不同分数的人数)
 * 叫计数排序的原因是因为他的实现方式是计数的
 * 只能从尾部去遍历原数组，否则就不是稳定排序
 */

/**
 * 1.时间复杂度  O（n）
 * 2.是稳定排序  从尾部遍历原数组
 * 3.不是原地排序  因为要创建数组
 */
public class CountingSort {

    public void doCountingSort(int items[], int n) {
        if (n < 1) return;

        //确认数据范围，看需要分多少个桶
        //比如说items 存的是 分数 0,1,2,1,3,4,5
        //假设第一个最大
        int maxValue = items[0];
        for (int i = 1; i < n; i++) {
            if (maxValue < items[i]) {
                maxValue = items[i];
            }
        }

        //申请一个长度为maxValue+1的数组（也就是多少个桶）
        //并全部置0
        //现在bucket就是长度就是6，下标即为对应的分数
        int[] bucket = new int[maxValue + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        //现在要用bucket[]来存储小于等于某个分数的个数
        for (int i = 0; i < n; i++) {
            bucket[items[i]]++;
        }
        //然后再把每个index前面一个index对应的value和自己加起来
        //就可以得到小于等于  这个index(也就是分数) 的元素个数
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] = bucket[i] + bucket[i - 1];
        }

        //最后开始排序 （从数组后面开始排）
        int[] orderArray = new int[n];

        //开始从后面遍历items ，避免称为不稳定的算法
        for (int i = n - 1; i >= 0; i--) {
//            简单写法
//            orderArray[bucket[items[i]]--] = items[i];
            //换一种容易理解的写法
            //先从items获取这个需要排序的值
            int value = items[n - 1];
            //通过这个值在bucket中找有几个小于等于这个的值 (value为bucket的某个下标),也就是后面排序的位置
            int index = bucket[value];
            //然后这个index 就是在 orderArray中的位置
            orderArray[index] = value;
            //这个index已经排过一次序。所以要--
            bucket[value]--;
        }

        //最后讲述拷贝给 items
        for (int i = 0; i < n; ++i) {
            items[i] = orderArray[i];
        }
    }
}
