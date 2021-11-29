package com.dx.algorithmpractise.stack;

/**
 * Task:
 * 1.用数组实现一个顺序栈
 * 2.用链表实现一个链式栈
 * 3.编程模拟实现一个浏览器的前进，后退功能
 * <p>
 * 栈是  先进后出
 */
public class GenericStackBasedOnLinkedList<T> {

    private StackGenericNode<T> top = null;
    private int size;


    public void clear() {
        this.top = null;
        this.size = 0;
    }

    /**
     * 入栈
     */
    public void push(T value) {
        StackGenericNode newNode = new StackGenericNode<T>(value, null);
        //判断栈是否为空
        if (top == null) {
            top = newNode;
        } else {
            //如果当前这个值出栈 ， 那 栈顶的是 当前的top
            newNode.setNext(top);
            top = newNode;
        }
        this.size++;
    }

    /**
     * 出栈
     * 用 -1 表示栈中没有数据
     */
    public T pop() {
        if (top == null) return null;
        T value = top.getElement();
        top = top.getNext();
        size--;
        return value;
    }

    public int size() {
        return this.size;
    }
}
