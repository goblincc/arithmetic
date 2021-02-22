package com.offer.single;

/**
 * 饿汉单例
 */
public class Singleton {

    //使用private将构造方法私有化， 防止外界构造实例
    private Singleton(){

    }

    //使用private封装该实例， 添加get方法实现对外开放
    private static Singleton instatnce = new Singleton();

    //添加static将方法变为类通过类名访问
    public static Singleton getInstance(){
        return instatnce;
    }
}
