package com.dx.algorithmpractise.linkedlist;

public class LRUCacheNode<T> {
    private T element;
    private LRUCacheNode next;

    public LRUCacheNode(T element, LRUCacheNode next) {
        this.element = element;
        this.next = next;
    }

    public LRUCacheNode() {
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public LRUCacheNode getNext() {
        return next;
    }

    public void setNext(LRUCacheNode next) {
        this.next = next;
    }
}
