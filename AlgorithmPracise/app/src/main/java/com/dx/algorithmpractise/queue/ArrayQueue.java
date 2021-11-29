package com.dx.algorithmpractise.queue;

/**
 * 1.用数组实现一个 顺序队列
 */
public class ArrayQueue {
    private String[] items;
    private int capacity;
    //有多少个元素
    private int count;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }


    /**
     * 入队
     */
    public boolean enqueue(String item) {
        //如果 tail == n 表示队列已经满了
        if (tail == count) return false;
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * 出队
     */
    public String dequeue() {
        if (head == tail) return null;
        head++;
        return items[head];
    }
}
