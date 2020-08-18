package com.yy.enums;

public class Main {
    public static void main(String[] args) {
//        ErrCodeEnum anEnum = ErrCodeEnum.getEnum(0);
//        System.out.println(anEnum.getDesc());
        ErrCodeEnum[] values = ErrCodeEnum.values();

        for (ErrCodeEnum e:values) {
            System.out.println(e);
        }
    }
}
