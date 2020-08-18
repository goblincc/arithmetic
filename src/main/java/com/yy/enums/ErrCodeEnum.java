package com.yy.enums;

public enum ErrCodeEnum {
    ERR_SUCCESS(0, "success"),
    ERR_INVALID_PARAM(-1, "invalid parameter"),
    ERR_NOT_FOUND(-2, "not found"),

    ERR_UNKONW(-9999, "unknow error");


    private Integer code;

    private String desc;

    ErrCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ErrCodeEnum getEnum(Integer code) {
        if (code == null) {
            return null;
        }
        for (ErrCodeEnum e : ErrCodeEnum.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static String getDesc(Integer code) {
        if (code == null) {
            return null;
        }
        for (ErrCodeEnum e : ErrCodeEnum.values()) {
            if (e.getCode().equals(code)) {
                return e.desc;
            }
        }
        return null;
    }
}
