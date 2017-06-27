package com.luxoft;

/**
 * Created by Serg on 23.06.2017.
 */
public class EnumsTest {
    enum Season { WINTER, SPRING, SUMMER, AUTUMN;

        @Override
        public String toString() {
            return super.toString()+"   epta";
        }


    }

    public static void main(String[] args) {
        for (Season season:Season.values()){
            System.out.println(season.name());
        }
    }

}
