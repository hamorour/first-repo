package com.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String path = "D:\\A_Java_\\a.txt";
        FileReader fileReader = null;
        int readLen =0 ;
        char[] buf = new char[8];
        try {
            fileReader = new FileReader(path);

            while( (readLen=fileReader.read(buf))!=-1){
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(fileReader !=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }


}
