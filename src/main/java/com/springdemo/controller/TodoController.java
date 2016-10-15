package com.springdemo.controller;

import com.springdemo.todos.Todo;
import com.springdemo.todos.TodoDao;
import com.springdemo.todos.TodoDaoImpl;
import com.springdemo.utils.SpringJdbcConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by afghl on 16/10/15.
 */

@RequestMapping("/todo")
@Controller
public class TodoController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        TodoDao dao = new TodoDaoImpl(new SpringJdbcConfig().mysqlDataSource());
        List<Todo> todos = dao.findAll();
        System.out.println(todos);
        return "todo/index";
    }
}
