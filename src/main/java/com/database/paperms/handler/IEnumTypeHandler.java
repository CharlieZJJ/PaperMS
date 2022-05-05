package com.database.paperms.handler;

import com.database.paperms.entity.type.IEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: com.database.paperms.handler.IEnumTypeHandler
 * Created by zjj
 * Date: 2022-05-05 15:47
 */
public class IEnumTypeHandler<E extends Enum<?> & IEnum> extends BaseTypeHandler<IEnum> {

    private final Class<E> type;

    public IEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Enum type must be not null!");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, IEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.getCode());
    }

    @Override
    public IEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Integer code = (Integer) rs.getObject(columnName);
        return rs.wasNull() ? null : IEnum.GetByCode(type, code);
    }

    @Override
    public IEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.wasNull() ? null : IEnum.GetByCode(type, columnIndex);
    }

    @Override
    public IEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer code = (Integer) cs.getObject(columnIndex);
        return cs.wasNull() ? null : IEnum.GetByCode(type, code);
    }
}