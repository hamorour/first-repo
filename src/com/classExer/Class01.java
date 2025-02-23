package com.classExer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.classExer.Car";
        Class cls = Class.forName(classAllPath);
        System.out.println(cls.getClass());
        System.out.println(cls);

        System.out.println(cls.getPackage().getName());

        System.out.println(cls.getName());

        Car car = (Car) cls.getDeclaredConstructor().newInstance();

        System.out.println(car);

        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));

        //通过反射给属性设置
        brand.set(car,"奔驰");
        System.out.println(car);

        Field[] fields = cls.getFields();
        for(Field f : fields){
            System.out.println(f.getName());
        }
    }
}
