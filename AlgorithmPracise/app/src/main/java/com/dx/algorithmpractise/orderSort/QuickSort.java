package com.dx.algorithmpractise.orderSort;
/** 假设数组A[p ---- r]
 * 基本思想：分治思想，从 p 到 r 之间挑一个元素 pivot , 比这个大的放左边，比这个小的放右边
 * 这样数据就分成三部分   > pivot   pivot   <pivot
 *
 * 递归公式：（q是pivot）
 * quick_sort(p...r) = quick_sort(p...q-1) + quick_sort(q+1....r)
 * 终止条件：
 * p >= r   （数组只剩下一个元素）
 * **/


/**
 * 伪代码
 *
 // 快速排序，A是数组，n表示数组的大小
 quick_sort(A, n) {
 quick_sort_c(A, 0, n-1)
 }

 // 快速排序递归函数，p,r为下标
 quick_sort_c(A, p, r) {
 if p >= r then return

 q = partition(A, p, r) // 获取分区点
 quick_sort_c(A, p, q-1)
 quick_sort_c(A, q+1, r)
 }
 *
 *
 * //分区函数
 * 1.通过游标i 把 A[p...r-1]分成两部分 已处理区 A[p ... i-1] 和 未处理区 A[ i ... r-1]
 * 2.每次都是未处理区A[i .. r-1] 中取出一个元素 A[j] 与 pivot对比 ，
 * 3。如果小于 则插入已处理区 A[p ... i -1]的尾部 也就是 A[i]
 partition(A, p, r) {
 pivot := A[r]
 i := p
 for j := p to r-1 do {
 if A[j] < pivot {
 swap A[i] with A[j]
 i := i+1
 }
 }
 swap A[i] with A[r]
 return i
 *
 * **/

/***
 * 1.时间复杂度  递归分析
 * T(1) = C  只要常量级别的执行时间
 * T(n) = 2*T(n/2) + n
 * 剩下的就跟归并排序的一样的
 * 所以时间复杂度是 O(nlogn)
 *
 * 但是上面的前提是数组恰巧能一分为二，实际上很难，会出现下面这样的情况
 * T(1) = C； n=1时，只需要常量级的执行时间，所以表示为C。
 * T(n) = T(n/10) + T(9*n/10) + n； n>1
 * 要用递归树的方法来推导了
 * 先给出结论;
 * 大部分时候： 时间复杂度是 O(nlogn)
 * 极端情况下： 退化到O(n^2)
 *
 * 2.是原地排序
 *
 * 3.不是稳定排序
 * */


/**
 * 求数组中 第 K 大元素，可以用 快排， 因为 快排会把数组排好顺序分成两个，所以可以 用来查找第K
 */
public class QuickSort {

    /**
     * 如果数组中有两个相同的元素，比如序列6,8,7,6,3,5,9,4,进过第一次分区操作之后，两个6的先后顺序会改变，所以快速排序不是一个稳定的排序
     * 1.pivot是4， i= j= 0
     * 2.A[j]是6大于4，不动，i不动，j++
     * 3.A[j]是8，同理
     * 4.A[j]是7，同理
     * 5.A[j]是6，同理
     * 6.A[j]是3小于4，A[i]和A[j]交换位置，i,j加1
     * 现在数据是3,8,7,6,6,5,9,4
     */
    public static void doQuickSort(int[] items, int n) {
        quickSortInternally(items, 0, n - 1);
    }

    private static void quickSortInternally(int[] items, int start, int end) {
        //说明只有一个元素  递归终止
        if (start >= end) return;
        //按middle把数组分成两部分
        int middle = partition(items, start, end);
        quickSortInternally(items, start, middle - 1);
        quickSortInternally(items, middle + 1, end);
        System.out.println("xcqw finalResult");
    }


    private static int partition(int[] items, int start, int end) {
        //取最后一个值为pivot
        int pivot = items[end];
        int i = start;

        //用A[i]，A[j]互换避免数据搬移
        for (int j = start; j < end; j++) {
            //如果小于 i+1 , j+1 //然后互换位置
            if (items[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int temp = items[i];
                    items[i++] = items[j];
                    items[j] = temp;
                }
            }
        }
        //j 不能取到 end , 直接换就行了
        //因为最后那个是中值 ，所以结尾肯定是应该换到中间来的
        int tmp = items[i];
        items[i] = items[end];
        items[end] = tmp;
        return i;
    }
}
