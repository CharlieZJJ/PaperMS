package com.database.paperms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: com.database.paperms.controller.SwaggerController
 * Created by zjj
 * Date: 2022-05-20 10:04
 */
@Controller
public class SwaggerController {
    @RequestMapping("/api")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
