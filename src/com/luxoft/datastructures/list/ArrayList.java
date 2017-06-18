package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayList extends  AbstractList{

    Object[] array;


    public String toString() {
        String str = "[ ";
        for (int i = 0; i < size; i++) {
            str += array[i] + " ";
        }

        str += "]";
        return str;
    }

    public ArrayList() {
        array = new Object[5];
    }


    //private methods
    private void checkExpandList(){
        if ((size + 1) > array.length) {
            Object[] newArray = new Object[(int)Math.round(array.length * 1.5)];
            System.arraycopy( array, 0, newArray, 0, array.length );
            array = newArray;
        }
    }


    //public methods
    public void add(Object value) {
        checkExpandList();
        array[size] = value;
        size++;
    }

    //add to position
    public void add(int index, Object value){
        checkExpandList();
        checkIndex(index, size+1);
        for (int i =size; i>index; i--){
            array[i] = array[i-1];
        }

        array[index] = value;

        size++;

    }


    public Object get(int index) {
        checkIndex(index);
        return array[index];
    }


    public Object set(int index, Object value){

        checkIndex(index);
        Object oldValue = array[index];

        array[index] = value;
        return oldValue;

    }

    public Object remove(int index){
        if(index == size-1){
            size --;
            return array[size];
        }
        System.arraycopy(array, index+1, array, index, size-1);
        Object foundObject = array[--size];
        array[size] = null;
        return foundObject;
    }

    public void clear(){
        size = 0;
    }

    public void trimToSize(int newSize) {
        if (newSize > size || newSize<0) {
            String msg = "New size " + newSize +
                    " should be between 0 and " + (size - 1) + " inclusive";
            throw new IndexOutOfBoundsException(msg);
        }
        size = newSize;
    }


    // return index, if element not present return -1
    public int indexOf(Object value) {

        for (int i=0; i<size; i++){
            if (array[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object value) {
        for (int i=size-1; i>=0; i--){
            if (array[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(Object object) {

        return indexOf(object)>=0;
    }


    @Override
    public Iterator iterator() {

        return new MyIterator();
    }


    @Override
    public Spliterator spliterator() {
        return null;
    }


    class MyIterator implements Iterator{

        int currentIndex = -1;


        @Override
        public boolean hasNext() {

            return currentIndex <ArrayList.this.size - 1;

        }

        @Override
        public Object next() {
            return array[++currentIndex];
        }


        @Override
        public void remove(){


        }
    }




}

