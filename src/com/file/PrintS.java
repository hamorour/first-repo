package com.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PrintS {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\com\\file\\mysql.propertis"));
        String line="";
        while((line=bufferedReader.readLine())!=null){
            String[] split = line.split("=");
            System.out.println(split[0]+"的值是："+split[1]);

        }
        bufferedReader.close();
    }
}
