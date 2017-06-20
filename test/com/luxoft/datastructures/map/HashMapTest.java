package com.luxoft.datastructures.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SZubenko on 20.06.2017.
 */
public class HashMapTest {

    HashMap map;

    @Before
    public void setUp() throws Exception {

        map = new HashMap();
        map.put("key1",1);
        map.put("key2",2);
        map.put("key3",3);
        map.put("key4",4);
        map.put("key5",5);
    }

    @Test
    public void put() throws Exception {
        map.put("testKey","some value");
        assertEquals("some value", map.get("testKey"));

        map.put(111,222);
        assertEquals(222, map.get(111));

        assertEquals("some value", map.put("testKey","some value updated"));
        assertEquals("some value updated", map.get("testKey"));
    }

    @Test
    public void putIfAbsent() throws Exception {
        map.putIfAbsent("testKey","some value");
        assertEquals("some value", map.get("testKey"));

        map.putIfAbsent(111,222);
        assertEquals(222, map.get(111));

        assertEquals("some value",map.putIfAbsent("testKey","some value updated"));
        assertEquals("some value", map.get("testKey"));

    }

    @Test
    public void putAllToEmpty() throws Exception {
        map.print();
        HashMap newMap = new HashMap();
        newMap.putAll(map);
        newMap.print();

        assertEquals(1, map.get("key1"));
        assertEquals(2, map.get("key2"));
        assertEquals(3, map.get("key3"));
        assertEquals(4, map.get("key4"));
        assertEquals(5, map.get("key5"));
    }

    @Test
    public void putAll() throws Exception {

        HashMap map2;
        map2 = new HashMap();
        map2.put("nkey1",10);
        map2.put("nkey2",20);
        map2.put("nkey3",30);
        map2.put("nkey4",40);
        map2.put("nkey5",50);

        map2.put("key3",130);
        map2.put("key4",140);


        map.putAll(map2);
        map.print();

        assertEquals(10, map.get("nkey1"));
        assertEquals(20, map.get("nkey2"));
        assertEquals(30, map.get("nkey3"));
        assertEquals(40, map.get("nkey4"));
        assertEquals(50, map.get("nkey5"));
        assertEquals(130, map.get("key3"));
        assertEquals(140, map.get("key4"));
    }


    @Test
    public void putAllIfAbsent() throws Exception {

        HashMap map2;
        map2 = new HashMap();
        map2.put("nkey1",10);
        map2.put("nkey2",20);
        map2.put("nkey3",30);
        map2.put("nkey4",40);
        map2.put("nkey5",50);

        map2.put("key3",130);
        map2.put("key4",140);


        map.putAllIfAbsent(map2);
        map.print();

        assertEquals(10, map.get("nkey1"));
        assertEquals(20, map.get("nkey2"));
        assertEquals(30, map.get("nkey3"));
        assertEquals(40, map.get("nkey4"));
        assertEquals(50, map.get("nkey5"));
        assertEquals(3, map.get("key3"));
        assertEquals(4, map.get("key4"));

    }


    @Test
    public void containsKey() throws Exception {
        assertTrue(map.containsKey("key2"));
        assertFalse(map.containsKey("key20"));
    }

    @Test
    public void size() throws Exception {
        assertEquals(5, map.size());
    }


    @Test
    public void nullKey() throws Exception {

        map.put(null, "null key");
        assertEquals("null key", map.get(null));


        map.put(null, "new null key");
        assertEquals("new null key", map.get(null));
    }



    @Test
    public void nullValue() throws Exception {

        map.put("null", null);
        assertNull(map.get("null"));
    }

}