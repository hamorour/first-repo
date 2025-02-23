package com.file;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObIS {
    public static void main(String[] args) throws Exception{
        String path = "D:\\A_Java_\\b.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        //读取反序列化的顺序，需要和你保存数据的顺序一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();
        System.out.println("运行类型="+dog.getClass());
        System.out.println("dog信息="+dog);
        ois.close();

    }
}
