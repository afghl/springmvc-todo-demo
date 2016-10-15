package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by afghl on 16/10/15.
 */

@Controller
@RequestMapping("/hello")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model) {
        System.out.println("goto HomeController....");
        return "test";
    }
}
