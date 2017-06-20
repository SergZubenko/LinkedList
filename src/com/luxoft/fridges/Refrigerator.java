package com.luxoft.fridges;

import com.luxoft.datastructures.list.ArrayList;

import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by dp-ptcstd-37 on 20.06.2017.
 */
public class Refrigerator {




    class Matrix{
        private int array[][];

        private int sizex = 4;

        private int sizey = 4;

        public Matrix(){
            array = new int[sizex][sizey];
            Random random = new Random();

            for (int i = 0; i < sizex; i++) {
                for (int j = 0; j < sizey; j++) {
                    array[i][j] = random.nextInt(2)-1;
                }
            }

        }

        @Override
        public String toString(){
            StringBuilder stringBuilder = new StringBuilder(sizex * sizey);
            for (int i = 0; i < sizex; i++) {
                for (int j = 0; j < sizey; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }
            return "";
        }

        public Matrix(int[][] inputArray){
            array = inputArray;
        }


        public boolean checkMartix(){
            return false;
        }

    }
}
