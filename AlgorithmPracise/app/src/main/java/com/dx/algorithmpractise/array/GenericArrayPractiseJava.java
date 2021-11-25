package com.dx.algorithmpractise.array;
/**
 * 所有任务
 * 1.T: 实现一个支持动态扩容的数组
 * <p>
 * 2.T:实现一个大小固定的有序数组，支持动态增删改
 * <p>
 * 3.T:实现两个有序数组合并为一个有序数组
 * <p>
 *
 *
 *
 * Result: 1.插入的尾插法
 * 2.删除的写法
 */

/**
 * 这里我们实现
 * 1.通用数组，实现可动态扩容，和合并两个有序数组为一个有序数组
 * 2.数组中的数据是int类型
 */
public class GenericArrayPractiseJava<T> {
    private T[] data;
    private int size;

    public GenericArrayPractiseJava(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArrayPractiseJava() {
        this(10);
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    //获取当前元素个数
    public int count() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    //check if contain certain element
    public boolean isContain(T e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    //update certain index element value
    public void set(int index, T element) {
        checkIndex(index);
        data[index] = element;
    }

    //return the value of certain index element
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    //get the index of certain element
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void resize(int capacity) {
        //创建新的数组
        T[] newData = (T[]) new Object[capacity];
        //进行数组迁移
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void add(int index, T e) {
        checkIndex(index);

        if (size == data.length) {
            //扩容
            resize(2 * data.length);
        }

        //尾插法
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }
    }

    public T remove(int index) {
        checkIndexForRemove(index);
        T element = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //末尾元素归null
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return element;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


}
