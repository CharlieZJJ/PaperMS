package com.database.paperms.entity.type.Impl;

import com.database.paperms.entity.type.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: com.database.paperms.entity.type.Paper
 * Created by zjj
 * Date: 2022-05-04 22:55
 */
public enum PaperType implements IEnum {

    THEORY_PROOF(0, "理论证明型"),

    REVIEW(1, "综述型"),

    EXPERIMENTAL(2, "实验型"),

    TOOL(3, "工具型"),

    DATA_SET(4, "数据集型");

    private final Integer code;
    private final String value;

    PaperType(int code, String value) {
        this.code = code;
        this.value = value;
    }

    private static Map<Integer,PaperType> map = new HashMap<>();
    static {
        for (PaperType value : PaperType .values()) {
            map.put(value.getCode(),value);
        }
    }
    public static PaperType getByCode(Integer code){
        return map.get(code);
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
