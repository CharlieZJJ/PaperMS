package com.database.paperms.utils;

import java.util.regex.Pattern;

/**
 * ClassName: com.database.paperms.utils.RegexUtil
 * Created by zjj
 * Date: 2022-05-06 19:46
 */
public class RegexUtil {
    public static boolean checkEmail(String email) {
        String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return Pattern.matches(regex, email);
    }
}
