package com.dx.algorithmpractise.linkedlist;


/**
 * 1.实现单链表，这里链表存储的是int（插入，删除，查找）
 * <p>
 * action: 1.注意判断是否是头节点
 * 2.头结点是否为null
 */
public class SingleLinkedList {
    private Node head = null;


    /**
     * 查找某个节点
     */
    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.getData() != value) {
            p = p.getNext();
        }
        return p;
    }

    /**
     * 节点 头插
     */
    public void insertToHead(Node node) {
        Node newNode = new Node(node.getData(), null);
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    /**
     * 节点尾插
     */
    public void insertTail(Node node) {
        Node newNode = new Node(node.getData(), null);
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.getNext() != null) {
                q = q.getNext();
            }
            //如果q.getNext 为null 说明是最后一个节点
            q.setNext(newNode);
        }
    }

    /**
     * 在某个节点后  插入该节点
     */
    public void insertAfterCertainNode(Node p, Node insertNode) {
        if (p == null) return;
        Node newInsertNode = new Node(insertNode.getData(), null);
        newInsertNode.setNext(p.getNext());
        p.setNext(newInsertNode);
    }


    /**
     * 在某个节点前  插入该节点
     */
    public void insertBeforeCertainNode(Node p, Node insertNode) {
        if (p == null) return;
        Node newInsertNode = new Node(insertNode.getData(), null);

        //如果需要插入在头节点之前
        if (head == p) {
            insertToHead(insertNode);
            return;
        }

        Node tempNode = head;
        while (tempNode.getNext() != p) {
            tempNode = tempNode.getNext();
        }

        if (tempNode == null) return;
        newInsertNode.setNext(p);
        tempNode.setNext(newInsertNode);
    }

    /**
     * 删除某个节点
     * */
    public void deleteByNode(Node p) {
        if (p == null || head == null) return;
        //如果是头节点
        if (p == head) {
            head = head.getNext();
            return;
        }

        Node tempNode = head;
        while (tempNode != null && tempNode.getNext() != p) {
            tempNode = tempNode.getNext();
        }

        //这样就找要删除节点的上一个节点
        tempNode.setNext(p.getNext());
        p.setNext(null);
    }

    /**
     *  删除某个/多个节点 值为 X
     * */
    public void deleteByValue(int value){

    }


}
