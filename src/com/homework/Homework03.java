package com.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\A_Java_\\a.txt"));
        String line = "";
        int i=0;
        while((line=bufferedReader.readLine())!=null){
            System.out.println(++i+"  "+line);
        }

        bufferedReader.close();
    }
}
