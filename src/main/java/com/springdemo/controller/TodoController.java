package com.springdemo.controller;

import com.springdemo.todos.Todo;
import com.springdemo.todos.TodoDao;
import com.springdemo.todos.TodoDaoImpl;
import com.springdemo.utils.SpringJdbcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by afghl on 16/10/15.
 */

@RequestMapping("/todos")
@Controller
public class TodoController {

    @Resource(name = "todoDao")
    private TodoDao todoDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {

        List<Todo> todos = todoDao.findAll();
        model.addAttribute("todos", todos);
        return "todo/index";
    }

}
