package com.luxoft.fridges;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dp-ptcstd-37 on 20.06.2017.
 */
public class Refrigerator {


    public static void main(String[] args) {

         int[][] array = {{1, 1}, {1, 1}};

//        int[][] array = {
//                {1, 0, 1},
//                {0, 1, 0},
//                {1, 1, 0}
//        };

        Matrix matrix = new Matrix(array);

        //Matrix matrix = new Matrix();

        //System.out.println(matrix);
        // matrix.switchValue(1,1);
        System.out.println(matrix);

        System.out.println(matrix.resolveMatrix());

        //System.out.println(matrix);
     /*   */
    }

}


class Matrix {
    private int matrix[][];

    private int size = 3;


    int level = 0;


    long switchesCount = 0;

 /*   public boolean checkLevel() {
        if (checkMartix()) {
            return true;
        }
        ;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //System.out.println("Switch "+((i+1)*size+j-size+1));
                // System.out.println("x=" + i + "  y=" + j);
                if (switchValue(i, j)) {
                    System.out.println("Switch " + ((i + 1) * size + j - size + 1));
                    return true;
                } else {
                    switchValue(i, j);
                }
            }
        }
        return false;
    }*/

    public boolean resolveMatrix() {
        return resolveMatrix(-1, 0);
    }


    private boolean resolveMatrix(int upperLevel, int allowedLevel) {
        int currentLevel = upperLevel + 1;


        //System.out.println("level " + currentLevel);
        //System.out.println(this);

//        if (checkLevel()) {
//            return true;
//        }

        if (allowedLevel < currentLevel) {
            return false;
        }

        for (int l = currentLevel; l <= allowedLevel; l++) {
            if (currentLevel == size * size - 1) {
                return false;
            }

            for (int c = currentLevel; c < size * size; c++) {
                int i = (int) c / size;
                int j = c - size * i;


                if (currentLevel == 3 || switchesCount > 1000){
                    return true;
                }

                // for (int i = 0; i < size; i++) {
                //  for (int j = 0; j < size; j++) {
                //System.out.println("level "+ l +" x="+ i + " y="+j);
                System.out.println("L"+currentLevel + " sw "+(c+1));
                switchValue(i, j);
                System.out.println(this);
                if (checkMartix()) {
                    System.out.println("Switch " + ((i + 1) * size + j - size + 1));
                    return true;
                }
                ;
                if (currentLevel < allowedLevel) {
                    if (resolveMatrix(currentLevel, allowedLevel)) {
                        System.out.println("Switch " + ((i + 1) * size + j - size + 1));
                        return true;
                    }
                }
                // System.out.println("Switch "+((i+1)*size+j-size+1));
                switchValue(i, j);
            }
            //}
            if (currentLevel == 0) {
                allowedLevel++;
            }
        }


        return false;
    }


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
        // stringBuilder.append("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append('\n');
            stringBuilder.append("[");
            for (int j = 0; j < size; j++) {
                stringBuilder.append(matrix[i][j]);
                stringBuilder.append('\t');
            }
            stringBuilder.append("]");
        }
        //stringBuilder.append('\n');
        //stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Matrix(int[][] inputArray) {
        matrix = inputArray;
        size = inputArray.length;
    }

    public boolean checkMartix() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1) {
                    return false;
                }
            }
        }

        System.out.println();
        return true;
    }

    public void switchValue(int x, int y) {
        switchesCount++;
        if (switchesCount % 1000000 == 0) {
            System.out.println(switchesCount);
        }
        for (int i = 0; i < size; i++) {
            matrix[x][i] = ~matrix[x][i] + 2;
            if (x != i) {
                matrix[i][y] = ~matrix[i][y] + 2;
            }
        }

        //System.out.println(this);

        //return checkMartix();
    }

}
