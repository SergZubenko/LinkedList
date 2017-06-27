package com.luxoft.serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Serg on 26.06.2017.
 */
public class CustomMessageStore implements MessageStore {
    String fileName;

    public CustomMessageStore(String fileName) {
        this.fileName = fileName;
    }



    @Override
    public List<Message> read() throws ClassNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        List<Message> messages = new ArrayList<>();
        while (true) {
            try {
                messages.add((Message) objectInputStream.readObject());
            } catch (IOException e) {
                //e.printStackTrace();
                break;
            }
        }
        objectInputStream.close();

        return messages;

    }

    @Override
    public void persist(Collection<Message> list) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        System.out.println(fileOutputStream);

        for (Message message : list) {
            objectOutputStream.writeObject(message);
        }

        objectOutputStream.close();

    }
}
