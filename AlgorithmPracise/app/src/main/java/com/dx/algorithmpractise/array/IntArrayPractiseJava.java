package com.dx.algorithmpractise.array;

/**
 * 所有任务
 * 1.T: 实现一个支持动态扩容的数组
 * <p>
 * 2.T:实现一个大小固定的有序数组，支持动态增删改
 * <p>
 * 3.T:实现两个有序数组合并为一个有序数组
 */

/**
 * 这里我们实现
 * 1.数组的插入，删除，按照下标随机随机访问
 * 2.数组中的数据是int类型
 */
public class IntArrayPractiseJava {
    //定义整型数据data保存数据
    public int data[];
    //定义數組長度
    private int n;
    //定义数组中实际个数
    private int count;


    public IntArrayPractiseJava(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * find certain element
     */
    public int find(int index) {
        if (index < 0 || index >= count) return -1;
        return data[index];
    }

    /**
     * insert element
     * count from 0
     */
    public boolean insert(int index, int value) throws Exception {

        //数组满了
        if (count == n) {
            throw new Exception("The array is full");
        }

        //插入位置非法
        if (index < 0 || index > count) {
            throw new Exception(("Index is illegal"));
        }

        //尾部插入 用i-- 可以吗？
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    /**
     * delete certain index element
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) return false;

        //从删除位置开始，将后面的元素向前移动1位
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print("xcqw-----" + data[i] + " ");
        }
        System.out.println();
    }

}
