package com.file;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObS {
    public static void main(String[] args) throws Exception{
        String path = "D:\\A_Java_\\b.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));

        //序列化数据到文件中
        objectOutputStream.writeInt(100);
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeChar('a');
        objectOutputStream.writeDouble(9.5);
        objectOutputStream.writeUTF("教育");
        objectOutputStream.writeObject(new Dog("jack",10));

        objectOutputStream.close();

        System.out.println("数据保存完毕！");
    }
}

class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}