package com.luxoft.datastructures.list;

public class ArrayList implements  List{
    int size=0;
    Object[] array;


    public int size(){
        return size;
    }

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

    private void checkIndex(int index){
        if (index < 0 || index > size) {
            String msg = "Index " + index +
                    " should be between 0 and " + (size - 1) + " inclusive";
            throw new IndexOutOfBoundsException(msg);
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
        checkIndex(index);
        checkExpandList();

        for (int i =size-1; i>index; i--){
            array[i+1] = array[i];
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
        System.arraycopy(array, index+1, array, index, array.length);
        Object foundObject = array[--size];
        array[size] = null;
        return foundObject;
    }

    public void clear(){
        size = 0;
    }

    public void trimToSize(int newSize) {
        if (newSize > size || newSize<0) {

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
        return -1;
    }

    public boolean contains(Object object) {
        return false;
    }



}


