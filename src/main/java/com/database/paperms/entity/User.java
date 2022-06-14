package com.database.paperms.entity;


import com.database.paperms.entity.type.Impl.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: com.database.paperms.entity.User
 * Created by zjj
 * Date: 2022-05-04 22:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String userName;

    private String userAccount;

    private String userPassword;

    private Permission userPermission;

}
