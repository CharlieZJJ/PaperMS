package com.database.paperms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class hello {
    @RequestMapping(value = "/hello")
    @ResponseBody public String act(){
        return "hello!!!!!!!!";
    }
}
