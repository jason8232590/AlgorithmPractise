package com.dx.algorithmpractise.orderSort;
/**
 * 采用分治思想
 * 把数组分成两半(子数组继续拆，直到最后一个元素是1个！！！)， 然后分别进行排序最后进行合并
 * merge_sort(p..r) 就可以分成 Merge_sort(p...q) 和Merge_Sort(q...r)
 * 然后再把两个有序子数组合并在一起(需要比大小)
 * 合并两个子数组的方法：
 * 1.创建一个临时数组temp,大小跟A[p..r]一样大
 * 2.取出两个子数组的第一个数B[i]  c[j] 比大小，
 * 3.如果B[i] <= C[j] 那么就把B[i] 放进数组，然后i加1
 * 4.否则 就把C[j]放入数组，j+1
 */


/***
 * 1.时间复杂度  用递归方法来分析
 * (1)假设将n个元素进行归并排序需要的时间是T(n),那么可以将分拆成2*T（n/2）+ n
 *  T(n/2)是一个子数组的排序,  O(n)是最后合并两个子数组的复杂度
 *  T(1) = 1
 *  T(n) = 2 * T(n/2)+n
 *  T(n) = 2 * (2*T(n/4)+n/2) +n = 4*T(n/4)+ 2n
 *  T(n) = 4*(2*T(n/8)+ 4/n )+ 2n = 8*T(n/8) +3n
 *
 *  假如总共要拆分k次到就剩1个元素 T(1) = 1
 *
 *  T(n) = 2^k*T(n/2^k) + k*n
 *  因为拆到只有一个元素，所以 T(n/2^k) = T(1) (拆一次，是两个数组，里面有个n/2个元素，假设拆k次，是x个数组，但是里面元素只有1个，也就是n/2^k = 1 )
 *  k = logn 省略了底数2，将K代入原来的公式
 *  得到 T(n) = Cn + nlogn
 *
 *  所以归并排序的复杂度是 O(nlogn)
 *
 * 2.是稳定排序    相同元素位置不会发生改变
 * 3.不是原地排序  因为最后合并两个子数组的时候创建了临时数组，空间复杂度是O(n)
 *
 *
 * */
public class mergeSort {

    public static void mergeSort(int[] items, int n) {
        mergeSortInternally(items, 0, n - 1);
    }

    private static void mergeSortInternally(int[] items, int start, int end) {
        //递归终止条件
        //拆到一个元素的时候就是 等于了，不能在再拆了
        if (start >= end) return;

        //如果直接用 (start + end)/2, 可能（start + end）超过int 类型最大值
        int middle = start + (end - start) / 2;

        //分别递归
        mergeSortInternally(items, start, middle);
        mergeSortInternally(items, middle + 1, end);

        //最后合并两个子数组
        merge(items, start, middle, end);
    }

    private static void merge(int[] items, int start, int middle, int end) {
        //创建一个 同样大小的临时数组
        int[] tempItems = new int[end - start + 1];
        int tempStart = start;
        int tempSecondStart = middle + 1;
        int tempSecondEnd = end;
        int index = 0;

        while (tempStart <= middle && tempSecondStart <= tempSecondEnd) {
            if (items[tempStart] < items[tempSecondStart]) {
                tempItems[index] = items[tempStart];
                index++;
                tempStart++;
            } else {
                tempItems[index] = items[tempSecondStart];
                index++;
                tempSecondStart++;
            }
        }

        //然后存在某个数组先放完（全部放进临时数组的情况）的情况
        int finalStart;
        int finalEnd;
        if (tempStart == middle) {
            //说明前半部分数组放完了
            //于是就是把后半部分数组剩下的放进去
            finalStart = tempSecondStart;
            finalEnd = tempSecondEnd;
        } else {
            finalStart = tempStart;
            finalEnd = middle;
        }
        //将剩余的数组放进临时数组
        while (finalStart <= finalEnd) {
            tempItems[index++] = items[finalStart++];
        }

        //将临时数组的值放进原始数组
        for (int i = 0; i < end - start + 1; i++) {
            items[start + i] = tempItems[i];
        }
    }
}
