package com.luxoft.IO;

import java.io.File;

import java.io.IOException;

public class IOTest {


    public static void main(String[] args) throws IOException {
//        File path = new File("test.txt");
//        System.out.println(path.exists());
//        System.out.println(path.getAbsolutePath());
//        path.createNewFile();
//        System.out.println(path.exists());

//        System.out.println(path.isDirectory());

        File path = new File("C:\\Program Files");

        System.out.println(new Counts().getFileCountByPath(path));
        System.out.println(new Counts().getDirCountByPath(path));

    }



}

class Counts {

    public int getFileCountByPath(File path) {
        int countFiles = 0;
        File[] innerPaths = path.listFiles();
        if (innerPaths == null){
            return countFiles;
        }
        for (File innerPath : innerPaths) {
            if(innerPath==null){
                continue;
            }
            if (innerPath.isFile()) {
                countFiles++;
            } else {
                countFiles += getFileCountByPath(innerPath);
            }
        }
        return countFiles;
    }


    public int getDirCountByPath(File path) {
        int countFiles = 0;
        File[] innerPaths = path.listFiles();
        if (innerPaths == null){
            return countFiles;
        }
        for (File innerPath : innerPaths) {
            if (!innerPath.isFile()) {
                countFiles++;
                countFiles += getDirCountByPath(innerPath);
            }
        }
        return countFiles;
    }

}