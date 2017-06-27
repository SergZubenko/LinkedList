package com.luxoft.serializable;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Serg on 26.06.2017.
 */
public class SerializationMessageStoreTest {

    private String fileName = "test.txt";

    @Test
    public void read() throws Exception {


        SerializationMessageStore serializationMessageStore = new SerializationMessageStore(fileName);

        List<Message> list = serializationMessageStore.read();

        assertEquals(4, list.size());

        for (Message message : list) {
            System.out.println(message);
        }

    }

    @Test
    public void persist() throws Exception {
        List<Message>  list = new ArrayList<>();
        list.add(new Message("Some message 1",1));
        list.add(new Message("Some message 2",2));
        list.add(new Message("Some message 3",3));
        list.add(new Message("Some message 4",4));

        SerializationMessageStore serializationMessageStore = new SerializationMessageStore(fileName);
        serializationMessageStore.persist(list);
    }

}