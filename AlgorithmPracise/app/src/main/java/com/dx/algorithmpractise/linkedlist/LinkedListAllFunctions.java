package com.dx.algorithmpractise.linkedlist;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 */
public class LinkedListAllFunctions {

    /**
     * 单链表反转
     */
    public Node reverse(Node headNode) {
        Node tempNode = headNode;
        Node preNode = null;
        while (tempNode != null) {
            //获取当前节点的下一个节点
            Node nextNode = tempNode.getNext();

            tempNode.setNext(preNode);
            //反转
            //下一个节点为当前节点
            preNode = tempNode;
            tempNode = nextNode;
        }
        //返回之前最后的一个节点，也就是现在最开始的一个节点
        return preNode;
    }

    /**
     * 检测环
     * //使用快慢指针来 判断两个会不会相等 或者 找到最后一个节点 来结束
     */

    public boolean isCircle(Node headNode) {
        if (headNode == null) return false;
        Node fast = headNode.getNext();
        Node slow = headNode;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
            if (fast == slow) return true;
        }

        return false;
    }

    /**
     * 合并两个有序链表
     */
    public Node merge2SortedLinkedList(Node nodeOne, Node nodeTwo) {
        if (nodeOne == null && nodeTwo == null) return null;
        if (nodeOne == null && nodeTwo != null) return nodeTwo;
        if (nodeOne != null && nodeTwo == null) return nodeOne;

        Node tempNodeOne = nodeOne;
        Node tempNodeTwo = nodeTwo;
        Node head;
        if (tempNodeOne.getData() < tempNodeTwo.getData()) {
            head = tempNodeTwo;
            tempNodeTwo = tempNodeTwo.getNext();
        } else {
            head = tempNodeOne;
            tempNodeOne = tempNodeOne.getNext();
        }

        Node preNode = head;

        while (tempNodeOne != null && tempNodeTwo != null) {
            if (tempNodeOne.getData() < tempNodeTwo.getData()) {
                preNode.setNext(tempNodeTwo);
                tempNodeTwo = tempNodeTwo.getNext();
            } else {
                preNode.setNext(tempNodeOne);
                tempNodeOne = tempNodeOne.getNext();
            }
            //节点需要不断往下移
            preNode = preNode.getNext();
        }

        //如果tempNodeOne 或者 tempNodeTwo 有一个为null 意味着其中一个结束了，需要连接上那个没完的
        if (tempNodeOne != null) {
            preNode.setNext(tempNodeOne);
        } else if (tempNodeTwo != null) {
            preNode.setNext(tempNodeTwo);
        }
        return head;
    }

    /**
     * 删除倒数第K个节点
     * //也可以使用快慢指针，利用快慢指针中间隔为K
     */
    public Node deleteLastKthElement(Node headNode, int lastKthIndex) {
        Node fastNode = headNode;
        int i = 1;
        //获取正数第K个节点
        while (fastNode != null && i < lastKthIndex) {
            fastNode = fastNode.getNext();
            i++;
        }

        if (fastNode == null) return fastNode;

        Node slow = headNode;
        Node prev = null;

        // 获取的正数第K个节点(快指针) 往后走
        // 头节点也随之往后走（慢指针），慢指针和快指针之间相差K，所以当快指针下一个为null的时候，慢指针就是倒数第K个
        while (fastNode.getNext() != null) {
            fastNode = fastNode.getNext();
            prev = slow;
            slow = slow.getNext();
        }

        //这一段感觉没啥用呀 ???????
//        if (prev == null) {
//            headNode = headNode.getNext();
//        } else {
//            prev.setNext(prev.getNext().getNext());
//        }

        return headNode;
    }

    /**
     * 获取中间节点
     * 还是用快慢指针
     * 试想一下    中间节点 为K   那最后那个节点2K 或者 2K -1
     * 所以快慢节点 步长的差距是两倍
     */
    public Node getMiddleNode(Node headNode) {
        Node slowNode = headNode;
        Node fastNode = headNode;
        while (fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
            fastNode = fastNode.getNext().getNext();
            slowNode = slowNode.getNext();
        }

        return slowNode;
    }
}
