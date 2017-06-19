package com.luxoft.datastructures.list;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class LinkedListTest {

    private List list=  new LinkedList() {{
            add("str1");
            add("str2");
            add("str3");
        }};


    @Test

    public void testAddIntoEmptyList() {
        list.clear();
        assertEquals(list.size(), 0);
        System.out.println(11111);
        list.add("one");
        System.out.println(list.size());
        assertEquals(list.get(0), "one");
        assertEquals(list.size(), 1);
    }

    @Test
    public void testAddIntoNotEmptyList() {
        list.add("str4");
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "str3");
        assertEquals(list.get(3), "str4");
        assertEquals(list.size(), 4);
    }

    @Test
    public void testAddEnsureCapacity() {
        list.add("str4");
        list.add("str5");
        list.add("str6");
        assertEquals(list.get(5), "str6");
        assertEquals(list.size(), 6);
    }

    @Test
    public void testAddIndexEmptyList() {
        list.clear();
        assertEquals(list.size(), 0);
        list.add(0, "begin");
        System.out.println(list.size());
        System.out.println(list.get(0));
        assertEquals(list.get(0), "begin");
        assertEquals(list.size(), 1);
    }

    @Test
    public void testAddIndexBegin() {
        System.out.println(list);
        list.add(0, "begin");
        assertEquals(list.get(0), "begin");
        assertEquals(list.get(1), "str1");
        assertEquals(list.get(2), "str2");
        assertEquals(list.get(3), "str3");
        assertEquals(list.size(), 4);
    }

    @Test
    public void testAddIndexCenter() {
        list.add(1, "center");
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "center");
        assertEquals(list.get(2), "str2");
        assertEquals(list.get(3), "str3");
        assertEquals(list.size(), 4);
    }

    @Test
    public void testAddIndexEnd() {
        list.add(3, "end");
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "str3");
        assertEquals(list.get(3), "end");
        assertEquals(list.size(), 4);
    }

    @Test
    public void testIndexOf() {
        int actual = list.indexOf("str2");
        assertEquals(actual, 1);
    }


    @Test
    public void testLastIndexOf() {
        list.add(2, "str2");
        int actual = list.lastIndexOf("str2");
        assertEquals(actual, 2);
    }

    @Test
    public void testLastIndexOfDoesNotExist() {
        int actual = list.lastIndexOf("str50");
        assertEquals(actual, -1);
    }

    @Test
    public void testContainsTrue() {
        System.out.println(list);
        assertTrue(list.contains("str3"));
    }


    @Test
    public void testContainsFalse() {
        System.out.println(list.indexOf("str50"));
        assertFalse(list.contains("str50"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmptyList() {
        list.clear();
        assertEquals(list.size(), 0);
        list.set(0, "setValue");
        assertEquals(list.get(0), "setValue");
        assertEquals(list.size(), 1);
    }

    @Test
    public void testSetBegin() {
        list.set(0, "setValue");
        assertEquals(list.get(0), "setValue");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "str3");
        assertEquals(list.size(), 3);
    }

    @Test
    public void testSetCenter() {
        list.set(1, "setValue");
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "setValue");
        assertEquals(list.get(2), "str3");
        assertEquals(list.size(), 3);
    }

    @Test
    public void testSetEnd() {
        list.set(2, "setValue");
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "setValue");
        assertEquals(list.size(), 3);
    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testGetBegin() {
        Object actual = list.get(0);
        assertEquals(actual, "str1");
    }

    @Test
    public void testGetCenter() {
        Object actual = list.get(1);
        assertEquals(actual, "str2");
    }

    @Test
    public void testGetEnd() {
        Object actual = list.get(2);
        assertEquals(actual, "str3");
    }

    @Test
    public void testRemoveBegin() {
        list.remove(0);
        assertEquals(list.get(0), "str2");
        assertEquals(list.get(1), "str3");
        assertEquals(list.size(), 2);
    }

    @Test
    public void testRemoveCenter() {
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str3");
        assertEquals(list.size(), 2);
    }

    @Test
    public void testRemoveEnd() {
        list.remove(2);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.size(), 2);
    }

}
