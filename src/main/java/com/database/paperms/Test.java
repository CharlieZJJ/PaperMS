package com.database.paperms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: com.database.paperms.Test
 * Created by zjj
 * Date: 2022-05-03 10:56
 */
@Controller
public class Test {
    @RequestMapping("/hello")
    @ResponseBody
    public String test(){
        return "hello???";
    }
}