package com.luxoft.annotations;

/**
 * Created by dp-ptcstd-37 on 19.06.2017.
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException {


        String[] array = new String[10];
        for (int i = 0; i < 10; i++) {
            array[i] = "Dima";
        }


        String obj = "Dima";
        Class clazz;
        clazz = obj.getClass();
//        clazz = String.class;
//        clazz = Class.forName("java.lang.String");

//        Method[] methods = clazz.getDeclaredMethods();
//        for (Method method : methods) {
//            method.in
//        }

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals("value")) {
                System.out.println(field);
                char[] newValue = "Dima durak".toCharArray();
                field.setAccessible(true);
                field.set(obj, newValue);
                field.setAccessible(false);
            }
        }

        System.out.println(obj);
        //print("Hello", "World", "!!!");

        for (String s : array) {
            System.out.println(s);
        }

    }

    //print(new String[]{"Hello", "World", "!!!"});
    public static void print(String... array) {
        for (String s : array) {
            System.out.println(s);
        }
    }


    public


}