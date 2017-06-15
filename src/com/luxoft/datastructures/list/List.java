package com.luxoft.datastructures.list;

public interface List {
    int size();

    void add(Object value);

    void add(int index, Object value);

    Object set(int index, Object value);

    void clear();

    Object remove(int index);

    Object get(int index);

    // return index, if element not present return -1
    int indexOf(Object value);

    int lastIndexOf(Object value);

    boolean contains(Object value);
}
