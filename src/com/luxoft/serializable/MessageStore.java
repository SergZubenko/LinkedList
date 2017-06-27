package com.luxoft.serializable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Serg on 26.06.2017.
 */
public interface MessageStore {
    List<Message> read() throws ClassNotFoundException, IOException;

    void persist(Collection<Message> list) throws IOException;

}
