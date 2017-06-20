package com.luxoft.datastructures.map;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;


//TODO: generate tests
public class HashMap implements  Iterable{

    int bucketsCount = 10;


    ArrayList[] entries = new ArrayList[bucketsCount];

    private int getBucketNumber(Object key){
        if (key == null){
            return 0;
        }
        return Math.abs(31*key.hashCode()%bucketsCount);
    }


    private void resize(){


        ArrayList[] entries = new ArrayList[bucketsCount];
    }


    public HashMap(){
        for (int i = 0; i < bucketsCount; i++) {
            entries[i] = new ArrayList();
        }
    }


    private Object put(Object key, Object value, boolean replace) {
        Entry entry  = getEntry(key);

        Object oldValue = null;

        if (entry == null)
        {
            entry = new Entry(key, value);
            entries[getBucketNumber(key)].add(entry);
        } else
        {
            oldValue = entry.value;
            if(replace){
                entry.value = value;
            }
        }
        return  oldValue;
    }


    public Object put(Object key, Object value) {
        return put(key, value, true);
    }

    public Object putIfAbsent(Object key, Object value) {
        return put(key, value, false);
    }

    @Nullable
    private Entry getEntry(Object key) {
        ArrayList  currentList= entries[getBucketNumber(key)];
        for (Object entry : currentList) {
            Object oldKey = ((Entry)entry).key;
            if (oldKey  == key || (oldKey != null && oldKey.equals(key))){
                return (Entry)entry;
            }
        }
        return null;
    }



    public void clear(){
        for (int i = 0; i < bucketsCount; i++) {
            entries[i].clear();
        }
    }

    public void print() {
        for (int i = 0; i < bucketsCount; i++) {
            if (entries[i].size() > 0) {
                System.out.println("bucket " + i + ": " + entries[i]);
            }
        }
    }


    public void putAll(HashMap map) {
        for (Object newEntry : map) {
            put(((Entry)newEntry).getKey(), ((Entry)newEntry).getValue());
        }

    }

    public void putAllIfAbsent(HashMap map) {
        for (Object newEntry : map) {
            putIfAbsent(((Entry)newEntry).getKey(), ((Entry)newEntry).getValue());
        }
    }

    public Object get(Object key) {
        Entry entry = getEntry(key);
        if (entry != null){
            return  entry.value;
        }
        else
        {
            return null;
        }
    }

    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    public int size(){
        int size = 0;
        for (int i = 0; i < bucketsCount; i++) {
            size += entries[i].size();
        }
        return size;
    };

    @Override
    public Iterator iterator() {
        return new HashIterator();
    }


    class HashIterator implements Iterator {

        int currentBucket;

        Iterator currentIterator = entries[currentBucket].iterator();

        @Override
        public boolean hasNext() {
           if  (currentIterator.hasNext()){
               return true;
           }
            for (int i = currentBucket+1; i < entries.length; i++) {
                currentIterator = entries[i].iterator();
                if (currentIterator.hasNext()){
                    currentBucket = i;
                    return true;
                }
            }
            return false;
        }

        @Override
        public Object next() {
            return currentIterator.next();
        }
    }

    class Entry {
        Object key;
        Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Entry clone(){
            return new Entry(key, value);
        }

        public String toString(){
            return "Key = " + key + "  value = " + value;
        }

        public void print(){
            System.out.println(toString());
        }

        public Object getKey(){
            return key;
        }

        public Object getValue(){
            return value;
        }
    }
}