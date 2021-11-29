package com.dx.algorithmpractise.stack;

/**
 * 基于数组的栈
 */
public class StackBasedOnArray {
    private Integer[] data;
    private int DEFAULT_CAPACITY = 10;
    private int count = 0;


    /**
     * 入栈
     */

    public void push(int value) {
        if (data == null) {
            data = new Integer[DEFAULT_CAPACITY];
        }

        if (count >= data.length) {
            //需要扩容
            data = resizeArray();
        }

        //入栈放在数组第一个
        for (int i = count; i < 0; i--) {
            data[count] = data[count - 1];
        }
        data[0] = value;
    }

    private Integer[] resizeArray() {
        //扩容为原来的我两倍
        Integer[] newData = new Integer[2 * data.length];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        return newData;
    }


    /**
     * 出栈
     * -1 表示栈中无数据
     */
    public Integer pop() {
        //如果栈中无数据
        if (data == null || data.length == 0) return null;
        int value = data[0];
        //删除第一个元素
        deleteFirstElement();
        return value;
    }

    /**
     * 删除数组第一个元素
     */
    public boolean deleteFirstElement() {
        if (data == null || data.length == 0) return false;
        for (int i = 0; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        //原来最后一个元素 置为 null
        data[data.length - 1] = null;
        return true;
    }
}
