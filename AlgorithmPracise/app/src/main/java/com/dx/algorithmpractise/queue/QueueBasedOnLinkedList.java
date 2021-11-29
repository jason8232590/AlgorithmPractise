package com.dx.algorithmpractise.queue;

import com.dx.algorithmpractise.GenericLinkedListNode;

/**
 * 用链表实现的队列
 */
public class QueueBasedOnLinkedList {

    private GenericLinkedListNode<String> headNode;
    private GenericLinkedListNode<String> tailNode;

    /**
     * 入队
     */
    public void enqueue(String value) {
        if (headNode == null) {
            GenericLinkedListNode<String> enqueueNode = new GenericLinkedListNode<String>();
            headNode = enqueueNode;
            tailNode = enqueueNode;
        } else {
            //这个地方有的难想到！！！！
            tailNode.setNext(new GenericLinkedListNode<String>(value, null));
            tailNode = tailNode.getNext();
        }
    }

    public String dequeue(String value){
        if(headNode == null) return null;
        String data = headNode.getElement();
        //下一个节点是在哪里设置的？？？ 在上面
        headNode = headNode.getNext();
        if(headNode == null){
            tailNode = null;
        }
        return data;
    }

}
