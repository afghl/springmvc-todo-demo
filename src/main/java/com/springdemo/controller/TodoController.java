package com.springdemo.controller;

import com.springdemo.todos.Todo;
import com.springdemo.todos.TodoDao;
import com.springdemo.todos.TodoDaoImpl;
import com.springdemo.utils.SpringJdbcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by afghl on 16/10/15.
 */

@RequestMapping("/todos")
@Controller
public class TodoController {

    @Resource(name = "todoDao")
    private TodoDao todoDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        List<Todo> todos = todoDao.findAll();
        System.out.println(todos);
        return "todo/index";
    }
}
