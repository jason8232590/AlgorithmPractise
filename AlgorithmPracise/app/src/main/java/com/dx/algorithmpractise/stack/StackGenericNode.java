package com.dx.algorithmpractise.stack;

public class StackGenericNode<T> {
    private T element;
    private StackGenericNode<T> next;

    public StackGenericNode(T element, StackGenericNode<T> next) {
        this.element = element;
        this.next = next;
    }

    public StackGenericNode() {
        this.next = null;
    }

    public StackGenericNode(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public StackGenericNode<T> getNext() {
        return next;
    }

    public void setNext(StackGenericNode<T> next) {
        this.next = next;
    }
}
