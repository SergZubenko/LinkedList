package com.luxoft.annotations;

/**
 * Created by dp-ptcstd-37 on 19.06.2017.
 */
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


//        String[] array = new String[10];
//        for (int i = 0; i < 10; i++) {
//            array[i] = "Dima";
//        }



        MyTestInjectObject myObj = new MyTestInjectObject();

        Class myClass = myObj.getClass();


        for (Field field : myClass.getDeclaredFields()) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                field.setAccessible(true);
                field.set(myObj, (new Random()).nextInt(annotation.max() - annotation.min()) + annotation.min() + 1);
                field.setAccessible(false);
            }

            Inject injection = field.getAnnotation(Inject.class);
            if (injection != null) {
                field.setAccessible(true);
                field.set(myObj, injection.setClass().getConstructor(int.class).newInstance(111));
                field.setAccessible(false);
            }


        }
        myObj.print();


        for (Method method : myClass.getDeclaredMethods()) {
            Run run = method.getAnnotation(Run.class);

            if (run !=null){
                method.setAccessible(true);
                method.invoke(myObj);
                method.setAccessible(false);
            }
        }
    }





//        String obj = "Dima";
//        Class clazz;
//        clazz = obj.getClass();
//        clazz = String.class;
//        clazz = Class.forName("java.lang.String");

//        Method[] methods = clazz.getDeclaredMethods();
//        for (Method method : methods) {
//            method.in
//        }
/*
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

    }*/

    //print(new String[]{"Hello", "World", "!!!"});
//    public static void print(String... array) {
//        for (String s : array) {
//            System.out.println(s);
//        }
//    }


     static class MyTestInjectObject {

        @InjectRandomInt(min = 2, max = 5)
        int value;

        @Inject(setClass = Integer.class, initValue = "11")
        Object injection;

        MyTestInjectObject(){
            System.out.println(value);
        }


        @Run
        private void print(){
            System.out.println(value);
        }
//
//        @Run
//        private void print1(){
//            System.out.println("Here is print 1 again");
//        }
//
//         @Run
//         private void print2(){
//             System.out.println("Here is print 2 again");
//         }


         @Run
         private void printInject(){
             System.out.println(injection.getClass());
             System.out.println(injection);
         }



     }



}