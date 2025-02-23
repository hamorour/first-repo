package com.file;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOut {
    public static void main(String[] args) {

    }
    @Test
    public void writeFile(){
        String path = "D:\\A_Java_\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(path);
            String s = "helloworld";
            fileOutputStream.write('a');
            fileOutputStream.write(s.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
