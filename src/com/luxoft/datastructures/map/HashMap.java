package com.luxoft.datastructures.map;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;


//TODO: generate tests
public class HashMap implements Iterable {

    private int bucketsCount = 10;
    private int size;


    ArrayList<Entry>[] entries = new ArrayList[bucketsCount];

    public HashMap() {
        for (int i = 0; i < bucketsCount; i++) {
            entries[i] = new ArrayList();
        }
    }

    private int getBucketNumber(Object key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % bucketsCount);
    }


    private void checkAndResize() {
        if (size / bucketsCount >= 0.75) {
            ArrayList<Entry>[] oldEntries = entries;
            bucketsCount = bucketsCount * 2;

            entries = new ArrayList[bucketsCount];

            for (ArrayList<Entry> entryList : oldEntries) {
                for (Entry entry : entryList) {
                    put(entry.key, entry.value);
                }
            }
        }
    }


    public HashMap(int capacity) {
        bucketsCount = 5;
        //init();
    }


    private Object put(Object key, Object value, boolean replace) {
        Entry entry = getEntry(key);

        Object oldValue = null;

        if (entry == null) {
            entry = new Entry(key, value);
            entries[getBucketNumber(key)].add(entry);
            size++;
        } else {
            oldValue = entry.value;
            if (replace) {
                entry.value = value;
            }
        }
        checkAndResize();
        return oldValue;
    }


    public Object put(Object key, Object value) {
        return put(key, value, true);
    }

    public Object putIfAbsent(Object key, Object value) {
        return put(key, value, false);
    }

    @Nullable
    private Entry getEntry(Object key) {
        ArrayList<Entry> currentList = entries[getBucketNumber(key)];
        for (Entry entry : currentList) {
            Object oldKey = entry.key;
            if (oldKey == key || (oldKey != null && oldKey.equals(key))) {
                return entry;
            }
        }
        return null;
    }


    public Object delete(Object key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entries[getBucketNumber(key)].remove(entry);
            return entry.getValue();
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < bucketsCount; i++) {
            entries[i].clear();
        }

        size = 0;
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
            put(((Entry) newEntry).getKey(), ((Entry) newEntry).getValue());
        }

    }

    public void putAllIfAbsent(HashMap map) {
        for (Object newEntry : map) {
            putIfAbsent(((Entry) newEntry).getKey(), ((Entry) newEntry).getValue());
        }
    }

    public Object get(Object key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            return entry.value;
        } else {
            return null;
        }
    }

    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    public int size() {
//        if (size == 0) {
//            for (int i = 0; i < bucketsCount; i++) {
//                size += entries[i].size();
//            }
//        }
        return size;
    }

    ;

    @Override
    public Iterator iterator() {
        return new HashIterator();
    }


    class HashIterator implements Iterator {

        int currentBucket;

        Iterator currentIterator = entries[currentBucket].iterator();

        @Override
        public boolean hasNext() {
            if (currentIterator.hasNext()) {
                return true;
            }
            for (int i = currentBucket + 1; i < entries.length; i++) {
                currentIterator = entries[i].iterator();
                if (currentIterator.hasNext()) {
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

        public Entry clone() {
            return new Entry(key, value);
        }

        public String toString() {
            return "Key = " + key + "  value = " + value;
        }

        public void print() {
            System.out.println(toString());
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }
}