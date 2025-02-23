package com.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileInformation {
    public static void main(String[] args) {
        new FileInformation().info();
    }


    public void info() {

        File file = new File("D:\\A_Java_\\news1.txt");
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("文件名 = " + file.getName());
        System.out.println("绝对路径 = " + file.getAbsolutePath());
    }
}
