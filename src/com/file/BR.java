package com.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class BR {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\A_Java_\\a.txt"));

        String line;
        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
