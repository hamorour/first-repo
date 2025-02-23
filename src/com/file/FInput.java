package com.file;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FInput {
    public static void main(String[] args) throws Exception{
        String path = "D:\\A_Java_\\c.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path),"gbk");
        osw.write("韩顺平教育");
        osw.close();
    }
}
