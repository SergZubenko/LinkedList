package com.luxoft.datastructures.list;

/**
 * Created by dp-ptcstd-37 on 16.06.2017.
 */
public abstract class AbstractList  implements  List{

    int size;

    public boolean contains(Object object) {

        return indexOf(object)>=0;
    }

    public int size(){
        return size;
    }

    protected void checkIndex(int index, int size){
        if (index < 0 || index >= size) {
            String msg = "Index " + index +
                    " should be between 0 and " + (size - 1) + " inclusive";
            throw new IndexOutOfBoundsException(msg);
        }
    }

    protected void checkIndex(int index){
        checkIndex( index,  size);
    }

}
