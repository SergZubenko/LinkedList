package com.luxoft.datastructures.list;

public class LinkedList implements List {
    private Node head;
    private Node tail;
    private int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object value) {
        Node node = new Node(value);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, Object value) {



    }

    @Override
    public Object set(int index, Object value) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
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

        public Node(Object value) {
            this.value = value;
        }
    }
}
