package com.luxoft.datastructures.list;

public class LinkedList extends AbstractList {
    private Node firstNode;
    private Node lastNode;


    @Override
    public int size() {
        return size;
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node currentNode;
        if (index > size / 2) {
            currentNode = lastNode;
            for (int i = size; i >= index; i--) {
                currentNode = currentNode.prev;
            }
        } else {
            currentNode = firstNode;
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }


    @Override
    public void add(Object value) {

        Node node = new Node(value);
        if (size == 0) {
            firstNode = lastNode = node;
        } else {
            lastNode.next = node;
            node.prev = lastNode;
            lastNode = node;
        }
        size++;
    }

    @Override
    public void add(int index, Object value) {

        if (size == 0 && index ==0) {
            firstNode = lastNode = new Node (value);
        }else
            if (index == size){
                lastNode.next = new Node(value);
                lastNode.next.prev = lastNode;
                lastNode = lastNode.next;
            } else
            {
                Node oldNode = getNode(index);
                Node newNode = new Node(value);
                newNode.next = oldNode;
                newNode.prev = oldNode.prev;
                oldNode.prev = newNode;
                if (firstNode.equals(oldNode)) {
                    firstNode = newNode;
                }
                if (lastNode.equals(oldNode)) {
                    lastNode = newNode;
                }
        }

        size++;
    }

    @Override
    public Object set(int index, Object value) {
        return null;
    }

    @Override
    public void clear() {

        size = 0;
        firstNode = lastNode = null;

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object get(int index) {
        return getNode(index).value;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    private static class Node {
        Node next;
        Node prev;
        Object value;

        Node(Object value) {
            this.value = value;
        }
    }
}
