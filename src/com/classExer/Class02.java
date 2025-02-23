package com.classExer;

public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Car> cls = Car.class;
        System.out.println(cls);

        Car car = new Car();
        Class<? extends Car> cls1 = car.getClass();
        System.out.println(cls1);

        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?> cls2 = classLoader.loadClass("com.classExer.Car");
        System.out.println(cls2);

        System.out.println(cls.hashCode());
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
    }
}
