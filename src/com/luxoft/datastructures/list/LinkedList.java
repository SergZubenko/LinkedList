package com.luxoft.datastructures.list;

import java.util.Iterator;

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
            for (int i = 1; i<size - index; i++) {
                currentNode = currentNode.prev;
            }
        } else {
            currentNode = firstNode;
            for (int i = 0; i < index; i++) {
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

        if (size == 0 && index == 0) {
            firstNode = lastNode = new Node(value);
        } else if (index == size) {
            lastNode.next = new Node(value);
            lastNode.next.prev = lastNode;
            lastNode = lastNode.next;
        } else {
            Node oldNode = getNode(index);
            Node newNode = new Node(value);
            newNode.next = oldNode;
            newNode.prev = oldNode.prev;
            if (oldNode.prev != null){
                oldNode.prev.next = newNode;
            }
            oldNode.prev = newNode;
            if (firstNode==oldNode) {
                firstNode = newNode;
            }
            if (lastNode==oldNode) {
                lastNode = newNode;
            }
        }

        size++;
    }

    @Override
    public Object set(int index, Object value) {
        Node oldNode = getNode(index);
        Node newNode = new Node(value);
        newNode.prev = oldNode.prev;
        newNode.next = oldNode.next;
        if(oldNode.prev !=null){
            oldNode.prev.next = newNode;
        }
        if(oldNode.next !=null){
            oldNode.next.prev = newNode;
        }
        if (firstNode == oldNode){
            firstNode = newNode;
        }
        if(lastNode == oldNode){
            lastNode = newNode;
        }
        return oldNode.value;
    }

    @Override
    public void clear() {

        size = 0;
        firstNode = lastNode = null;

    }

    @Override
    public Object remove(int index) {
        //
        Node currentNode;
        if (firstNode == lastNode && index == 0) {
            currentNode = firstNode;
            firstNode = lastNode = null;
        } else if (index == 0) {
            currentNode = firstNode;
            firstNode = firstNode.next;
            firstNode.prev = null;
        } else if (index == size - 1) {
            currentNode = lastNode;
            lastNode = lastNode.prev;
            lastNode.next = null;
        } else {
            currentNode = getNode(index);
            currentNode.next.prev = currentNode.prev;
            currentNode.prev.next = currentNode.next;
        }
        size--;
        return currentNode.value;
    }

    @Override
    public Object get(int index) {
        return getNode(index).value;
    }

    @Override
    public int indexOf(Object value) {
        int index = -1;
        for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next){
            index ++;
            if (currentNode.value.equals(value)) {
                return index;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object value) {
        int index = size-1;
        for (Node currentNode = lastNode; currentNode != null; currentNode = currentNode.prev){
            index --;
            if (currentNode.value.equals(value)) {
                break;
            }
        }
        return index;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private static class Node {
        Node next;
        Node prev;
        Object value;

        Node(Object value) {
            this.value = value;
        }
    }


    class MyIterator implements Iterator {

        int currentIndex = -1;


        @Override
        public boolean hasNext() {

            return currentIndex < (size - 1);

        }

        @Override
        public Object next() {
            return get(++currentIndex);
        }


        @Override
        public void remove() {
            LinkedList.this.remove(currentIndex);
        }

    }
}
