package com.preparation.data.structure;

/**
 * Created by vlados on 9/30/2017.
 */
public class Stack<T> {
    private int size = 0;
    private Stack<T> node;
    private T element;

    public void push(T element) {
        if (size == 0) {
            node = new Stack<>();
            node.element = element;
        }

        if (size > 0) {
            Stack<T> temporaryNode = node;
            node = new Stack<>();
            node.node = temporaryNode;
            node.element = element;
        }

        size++;
    }

    public T pop() {
        if (size < 0) {
            size = 0;
            throw new RuntimeException("Empty stack");
        }

        T currentElement = node.element;

        if (size == 0) {
            node = null;
        }

        if (size > 0) {
            node = node.node;
        }

        size--;

        return currentElement;
    }

    public int size() {
        return size;
    }
}