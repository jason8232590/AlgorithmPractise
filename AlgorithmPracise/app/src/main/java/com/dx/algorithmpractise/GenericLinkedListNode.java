package com.dx.algorithmpractise;

public class GenericLinkedListNode<T> {
    private T element;
    private GenericLinkedListNode<T> next;

    public GenericLinkedListNode(T element, GenericLinkedListNode<T> next) {
        this.element = element;
        this.next = next;
    }

    public GenericLinkedListNode() {
        this.next = null;
    }

    public GenericLinkedListNode(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public GenericLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(GenericLinkedListNode<T> next) {
        this.next = next;
    }
}
