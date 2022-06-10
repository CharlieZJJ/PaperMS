package com.database.paperms.entity.type.Impl;

import com.database.paperms.entity.type.IEnum;

/**
 * ClassName: com.database.paperms.entity.type.Impl.Permission
 * Created by zjj
 * Date: 2022-05-04 22:47
 */
public enum Permission implements IEnum {
    ADMIN(1, "管理员"),
    USER(0, "用户");

    private final Integer code;
    private final String value;

    Permission(int code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public final Integer getCode() {
        return code;
    }

    @Override
    public final String getValue() {
        return value;
    }
}
