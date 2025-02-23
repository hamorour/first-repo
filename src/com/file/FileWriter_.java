package com.file;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {
        String path = "D:\\A_Java_\\b.txt";
        FileWriter fileWriter = null;
        char[] chars = {'a','b','c','d'};
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write('H');
            fileWriter.write(chars);
            fileWriter.write("上海天津",0,2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
