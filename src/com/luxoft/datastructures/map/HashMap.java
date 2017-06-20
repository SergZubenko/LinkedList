package com.luxoft.datastructures.map;

import java.util.ArrayList;

public class HashMap {

    int size;
    int bucketsCount = 10;


    ArrayList[] entries = new ArrayList[bucketsCount];

    private int getBucketNumber(int hashCode){
        return hashCode%10;
    }

    public HashMap(){
        for (int i = 0; i < bucketsCount; i++) {
            entries[i] = new ArrayList();
        }
    }

    public Object put(Object key, Object value) {
        Entry entry  = getEntry(key);

        Object oldValue = null;

        if (entry == null)
        {
            oldValue = entry.value;
            entry.value = value;
        } else
        {



        }
        return  oldValue;

    }

    private Entry getEntry(Object key) {
        ArrayList  currentList= entries[getBucketNumber(key.hashCode())];
        boolean  found = false;
        for (Object entry : currentList) {
            if (((Entry)entry).key.equals(key)){
                return (Entry)entry;
            }
        }

        return null;
    }

    public Object putIfAbsent(Object key, Object value) {
       Entry entry  = getEntry(key);

        Object oldValue = null;

        if (entry == null)
        {
            oldValue = value;
            entry.value = value;
        }
       return  oldValue;

    }

    public void putAll(HashMap map) {

    }

    public void putAllIfAbsent(HashMap map) {

    }

    public Object get(Object key) {

    }

    public boolean containsKey(Object key) {

    }

    public int size(){
        return size;
    };


    class Entry {
        Object key;
        Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

//        @Override
//        public boolean equals(Object object){
//            Entry entry = (Entry)object;
//
//            return this.key.equals(entry.key)&&this.key.equals(entry)
//        }
    }
}