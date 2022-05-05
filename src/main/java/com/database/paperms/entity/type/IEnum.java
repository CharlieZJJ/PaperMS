package com.database.paperms.entity.type;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.Arrays;

/**
 * ClassName: com.database.paperms.entity.type.IEnum
 * Created by zjj
 * Date: 2022-05-05 15:41
 */
public interface IEnum{
    /**
     * 获取枚举的code
     * @return code
     */
    Integer getCode();

    /**
     * 获取枚举的value
     * @return value
     */
    String getValue();


    /**
     * 根据code从指定枚举类中获取枚举值
     * @param clazz 枚举类
     * @param code code
     * @return 枚举值
     * @param <E> 枚举的类型
     */
    @NotNull
    static <E extends Enum<?> & IEnum> E GetByCode(Class<E> clazz, Integer code){
        E[] elements = clazz.getEnumConstants();
        for (E element : elements) {
            if(element.getCode().equals(code)){
                return element;
            }
        }
        return null;
    }

}
