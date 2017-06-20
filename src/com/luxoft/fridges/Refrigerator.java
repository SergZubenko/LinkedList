package com.luxoft.fridges;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dp-ptcstd-37 on 20.06.2017.
 */
public class Refrigerator {


    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        System.out.println(matrix);
        System.out.println(matrix.switchValue(1,1));
        System.out.println(matrix);
    }


    public static void resolveMatrix(){



    }


    static class Matrix {
        private int matrix[][];

        private int size = 4;


        public Matrix() {
            matrix = new int[size][size];
            Random random = new Random();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = random.nextInt(2);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(size * size);
            stringBuilder.append("[");

            for (int i = 0; i < size; i++) {
                stringBuilder.append('\n');
                stringBuilder.append("[");
                for (int j = 0; j < size; j++) {
                    stringBuilder.append(matrix[i][j]);
                    stringBuilder.append('\t');
                }
                stringBuilder.append("]");
            }
            stringBuilder.append('\n');
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public Matrix(int[][] inputArray) {
            matrix = inputArray;
        }

        public boolean checkMartix() {

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (matrix[i][j] == 1) {
                        return false;
                    }
                }
            }

            return true;
        }

        public boolean switchValue(int x, int y){
            for (int i = 0; i < size; i++) {
                matrix[x][i] = ~matrix[x][i]+2;
            }

            return checkMartix();
        }

    }
}
