package com.dx.algorithmpractise.linkedlist;

/**
 * 1.维护一个单向有序链表，越靠近尾部的越早访问
 * 2.访问某个元素，如果在链表中存在，那么则删除，并头插
 * 3.访问某个元素，如果在链表中不存在
 * 3.1 链表未满，则直接头插
 * 3.2 链表满了，则删除尾节点，再头插
 */
public class LRUCacheLinkedList<T> {
    private final static int DEFAULT_CAPACITY = 10;

    //头结点
    private LRUCacheNode<T> headNode;

    /**
     * 链表长度
     */
    private int length;

    /**
     * 链表容量
     */
    private int capacity;

    public LRUCacheLinkedList() {
        this.headNode = new LRUCacheNode<T>();
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public LRUCacheLinkedList(int capacity) {
        this.headNode = new LRUCacheNode<T>();
        this.length = 0;
        this.capacity = capacity;
    }

    /**
     * 添加数据
     */
    public void add(T data) {
        LRUCacheNode preNode = findPreNode(data);

        if (preNode != null) {
            //链表中存在，删除原数据，再插入到链表的头部
            deleteNextElement(preNode);
            insertElementAtBegin(data);
        } else {
            //如果链表中不存在
            if (length >= this.capacity) {
                //链表满了
                //删除尾节点
                deleteEndElement();
            }
            //然后头插该节点
            insertElementAtBegin(data);
        }
    }

    /**
     * 删除preNode的下一个节点
     *
     * @param 要删除节点的上一个节点
     */
    public void deleteNextElement(LRUCacheNode preNode) {
        LRUCacheNode nextNode = preNode.getNext();
        preNode.setNext(nextNode.getNext());
        nextNode = null;
        length--;
    }

    /**
     * 头插 元素
     */
    public void insertElementAtBegin(T data) {
        LRUCacheNode insertNode = new LRUCacheNode(data, headNode);
        length++;
        headNode = insertNode;
//        LRUCacheNode next = headNode.getNext();
//        headNode.setNext(new LRUCacheNode(data, next));
//        length++;
    }


    /**
     * 获取查找元素的  前一个节点
     */
    public LRUCacheNode findPreNode(T data) {
        LRUCacheNode tempNode = headNode;
        while (tempNode != null && !data.equals(tempNode.getNext().getElement())) {
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }


    public void deleteEndElement() {
        LRUCacheNode tempNode = headNode;

        if (headNode == null || headNode.getNext() == null) {
            return;
        }

        //需要找出 倒数第三个元素
        while (tempNode.getNext().getNext() != null) {
            tempNode = tempNode.getNext();
        }
        //如果 tempNode.getNext().getNext()为null ，说明tempNode这是倒数第三个节点
        LRUCacheNode theOneBeforeEnd = tempNode.getNext();
        theOneBeforeEnd.setNext(null);
        length--;
    }


}
