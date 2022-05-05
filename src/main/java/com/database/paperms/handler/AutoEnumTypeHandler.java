package com.database.paperms.handler;

import com.database.paperms.entity.type.IEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: com.database.paperms.handler.AutoEnumTypeHandler
 * Created by zjj
 * Date: 2022-05-05 18:13
 */
public class AutoEnumTypeHandler <E extends Enum<E>> extends BaseTypeHandler<E> {

    private final BaseTypeHandler<E> typeHandler;

    public AutoEnumTypeHandler(Class<E> type){
        if(type == null)
            throw new IllegalArgumentException("Type can not be null!!");
        if(IEnum.class.isAssignableFrom(type))
            typeHandler = new IEnumTypeHandler(type);
        else typeHandler = new EnumOrdinalTypeHandler<>(type);
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        typeHandler.setNonNullParameter(preparedStatement,i,e,jdbcType);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return typeHandler.getNullableResult(resultSet,s);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return typeHandler.getNullableResult(resultSet,i);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return typeHandler.getNullableResult(callableStatement,i);
    }
}
