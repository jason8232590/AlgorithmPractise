package com.dx.algorithmpractise.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Task:
 * 1.实现单链表，循环链表，双向链表，支持增删操作
 * 2.实现单链表反转
 * 3.实现两个有序的链表合并为一个有序链表
 * 4.实现求链表的中间节点
 *
 *
 * action:1.数组右移需要思考一下
 *        2.需要数组来存储这些元素
 *        3.需要一个hashmap 来查找元素的在数组中的index
 */
public class LinkedListPractiseJava<T> {
    private static final int DEFAULT_CAPACITY = 1 << 3;
    //容量
    private int capacity;
    //真实元素个数
    private int count;
    private T[] value;
    //
    private Map<T, Integer> holder;

    public LinkedListPractiseJava(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }

    private boolean isFull() {
        return count == capacity;
    }

    public void visit(T object) {
        if (object == null) {
            throw new IllegalArgumentException("null is not supported");
        }

        Integer index = holder.get(object);
        if (index == null) {
            //判断当前链表是否满了
            if (isFull()) {
                //如果满了，删除尾节点，头插查询的节点
                removeAndCache(object);

            } else {
                //如果没满，头插查询的节点
                cache(object, count);
            }
        } else {
            //如果当前链表中有这个值，则删除，并头插
            update(index);
        }
    }

    /**
     * 若缓存中有指定的值，则更新位置
     */
    private void update(int end) {
        T target = value[end];
        rightShift(end);
        //头插
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * end 左边的数据统一右移一位
     * @param end
     * */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    /**
     * 缓存数据到头部，但要先右移(因为需要头插元素，后面的元素需要右移)
     *
     * @param object
     * @param end    数组右移的边界
     */
    private void cache(T object, int end) {
        rightShift(end);
        //头插查询元素
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 缓存满了，删除尾节点，再把查询的节点头插
     */
    private void removeAndCache(T object) {
        //获取尾节点
        T key = value[--count];
        //删除尾节点
        holder.remove(key);
        //头插 查询的节点
        cache(object, count);

    }


}
