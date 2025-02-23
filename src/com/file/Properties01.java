package com.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties01 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("charser","utf8");
        properties.setProperty("user","汤姆");
        properties.setProperty("pwd","abc111");

        properties.store(new FileOutputStream("src\\com\\file\\mysql2.properties"),null);
        System.out.println("保存配置文件成功");
    }
}
