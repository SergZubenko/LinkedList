package com.luxoft.datastructures.list;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class ArrayListTest {

    ArrayList arrayList = new ArrayList() {{
        add("str1");
        add("str2");
        add("str3");
    }};


    @Test
    public void testAddIntoEmptyList() {
        arrayList.clear();
        assertEquals(arrayList.size(), 0);

        arrayList.add("one");
        assertEquals(arrayList.get(0), "one");
        assertEquals(arrayList.size(), 1);
    }

    @Test
    public void testAddIntoNotEmptyList() {
        arrayList.add("str4");
        assertEquals(arrayList.get(0), "str1");
        assertEquals(arrayList.get(1), "str2");
        assertEquals(arrayList.get(2), "str3");
        assertEquals(arrayList.get(3), "str4");
        assertEquals(arrayList.size(), 4);
    }

    @Test
    public void testAddEnsureCapacity() {
        arrayList.add("str4");
        arrayList.add("str5");
        arrayList.add("str6");
        assertEquals(arrayList.get(5), "str6");
        assertEquals(arrayList.size(), 6);
    }

    @Test
    public void testAddIndexEmptyList() {
        arrayList.clear();
        assertEquals(arrayList.size(), 0);
        arrayList.add(0, "begin");
        assertEquals(arrayList.get(0), "begin");
        assertEquals(arrayList.size(), 1);
    }

    @Test
    public void testAddIndexBegin() {
        arrayList.add(0, "begin");
        assertEquals(arrayList.get(0), "begin");
        assertEquals(arrayList.get(1), "str1");
        assertEquals(arrayList.get(2), "str2");
        assertEquals(arrayList.get(3), "str3");
        assertEquals(arrayList.size(), 4);
    }

    @Test
    public void testAddIndexCenter() {
        arrayList.add(1, "center");
        assertEquals(arrayList.get(0), "str1");
        assertEquals(arrayList.get(1), "center");
        assertEquals(arrayList.get(2), "str2");
        assertEquals(arrayList.get(3), "str3");
        assertEquals(arrayList.size(), 4);
    }

    @Test
    public void testAddIndexEnd() {
        arrayList.add(3, "end");
        assertEquals(arrayList.get(0), "str1");
        assertEquals(arrayList.get(1), "str2");
        assertEquals(arrayList.get(2), "str3");
        assertEquals(arrayList.get(3), "end");
        assertEquals(arrayList.size(), 4);
    }

    @Test
    public void testIndexOf() {
        int actual = arrayList.indexOf("str2");
        assertEquals(actual, 1);
    }

    @Test
    public void testIndexOfDoesNotExist() {
        int actual = arrayList.indexOf("str50");
        assertEquals(actual, -1);
    }

    @Test
    public void testLastIndexOf() {
        arrayList.add(2, "str2");
        int actual = arrayList.lastIndexOf("str2");
        assertEquals(actual, 2);
    }

    @Test
    public void testLastIndexOfDoesNotExist() {
        int actual = arrayList.lastIndexOf("str50");
        assertEquals(actual, -1);
    }

    @Test
    public void testContainsTrue() {
        assertTrue(arrayList.contains("str3"));
    }


    @Test
    public void testContainsFalse() {
        assertFalse(arrayList.contains("str50"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmptyList() {
        arrayList.clear();
        assertEquals(arrayList.size(), 0);
        arrayList.set(0, "setValue");
        assertEquals(arrayList.get(0), "setValue");
        assertEquals(arrayList.size(), 1);
    }

    @Test
    public void testSetBegin() {
        arrayList.set(0, "setValue");
        assertEquals(arrayList.get(0), "setValue");
        assertEquals(arrayList.get(1), "str2");
        assertEquals(arrayList.get(2), "str3");
        assertEquals(arrayList.size(), 3);
    }

    @Test
    public void testSetCenter() {
        arrayList.set(1, "setValue");
        assertEquals(arrayList.get(0), "str1");
        assertEquals(arrayList.get(1), "setValue");
        assertEquals(arrayList.get(2), "str3");
        assertEquals(arrayList.size(), 3);
    }

    @Test
    public void testSetEnd() {
        arrayList.set(2, "setValue");
        assertEquals(arrayList.get(0), "str1");
        assertEquals(arrayList.get(1), "str2");
        assertEquals(arrayList.get(2), "setValue");
        assertEquals(arrayList.size(), 3);
    }

    @Test
    public void testClear() {
        arrayList.clear();
        assertEquals(arrayList.size(), 0);
    }

    @Test
    public void testGetBegin() {
        Object actual = arrayList.get(0);
        assertEquals(actual, "str1");
    }

    @Test
    public void testGetCenter() {
        Object actual = arrayList.get(1);
        assertEquals(actual, "str2");
    }

    @Test
    public void testGetEnd() {
        Object actual = arrayList.get(2);
        assertEquals(actual, "str3");
    }

    @Test
    public void testRemoveBegin() {
        arrayList.remove(0);
        assertEquals(arrayList.get(0), "str2");
        assertEquals(arrayList.get(1), "str3");
        assertEquals(arrayList.size(), 2);
    }

    @Test
    public void testRemoveCenter() {
        arrayList.remove(1);
        assertEquals(arrayList.get(0), "str1");
        assertEquals(arrayList.get(1), "str3");
        assertEquals(arrayList.size(), 2);
    }

    @Test
    public void testRemoveEnd() {
        arrayList.remove(2);
        assertEquals(arrayList.get(0), "str1");
        assertEquals(arrayList.get(1), "str2");
        assertEquals(arrayList.size(), 2);
    }
}