package com.homework;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        String directionpath ="D:\\A_Java_";
        File file = new File(directionpath);
        if(!file.exists()){
            if(file.mkdirs()){
                System.out.println("创建 "+directionpath+" 成功");
            }else {
                System.out.println("创建失败");
            }
        }

        String filepath = directionpath+"\\d.txt";
        file = new File(filepath);
        if(!file.exists()){
            if(file.createNewFile()){
                System.out.println(filepath+" 创建成功");
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));
                bufferedWriter.write("hello,world");
                bufferedWriter.close();
            }else {
                System.out.println(filepath+" 创建失败");
            }
        }else {
            System.out.println(filepath+" 文件已存在");
        }

    }
}
