package com.dx.algorithmpractise.queue;

/**
 * 写一个循环队列
 *   0 1 2 3 4
 *   假设head 在 2 ，tails 在 4 ， 这时候有个新元素入队，以前的话只能数据搬移，那么循环队列就可以，把新元素放在 0
 *   循环队列满了的判断条件就是 (tail + 1) % n = head
 *
 *
 *   action: 循环队列满了的条件
 */
public class CircleQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public CircleQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }


    /**
     * 入队
     */
    public boolean enqueue(String item) {
        //队列满了
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     */
    public String dequeue() {
        //如果 head == tail 表示队列为空
        if (head == tail) return null;
        String data = items[head];
        head = (head + 1) % n;
        return data;
    }

}
