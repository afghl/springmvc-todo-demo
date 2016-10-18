package com.springdemo.controller;

import com.springdemo.todos.RecordNotFoundException;
import com.springdemo.todos.Todo;
import com.springdemo.todos.TodoDao;
import com.springdemo.todos.TodoDaoImpl;
import com.springdemo.utils.SpringJdbcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.ws.rs.Path;
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

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        List<Todo> todos = todoDao.findAll();
        model.addAttribute("todos", todos);
        return "todo/index";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable(value = "id") String idStr, Model model) {
        int id = Integer.parseInt(idStr);
        try {
            Todo todo = todoDao.findTodo(id);
            model.addAttribute("todo", todo);
            return "todo/show";
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
            return "static/404";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestParam String content) {
        Todo t = new Todo();
        t.setContent(content);
        todoDao.addTodo(t);
        return "redirect:/todos";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") String idStr) {
        int id = Integer.parseInt(idStr);
        todoDao.deleteTodo(id);
        return "redirect:/todos";
    }

}
