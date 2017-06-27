package com.luxoft.serializable;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Serg on 26.06.2017.
 *
 * Дан класс Message (int id, java.util.Date date, String content). Дан интерфейс MessageStore c двумя методами:
 - List<Message> read();
 - void persist(Collection<Message> list);
 Написать две реализации этого интерфейса: SerializationMessageStore и CustomMessageStore. CustomMessageStore реализовать c использованием DataOutputStream.
 */
public class Message implements Serializable{

    int id;
    Date date;
    String content;

    public Message(int id, Date date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    public Message(String content, int id) {
        this.id = id;
        this.date = new Date();
        this.content = "Some message " + date.toString();
    }

    @Override
    public String toString(){
        return id+ "  " + date.toString() + "   " + content.toString();
    }

}


