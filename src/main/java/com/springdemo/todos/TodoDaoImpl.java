package com.springdemo.todos;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by afghl on 16/10/15.
 */

@Repository(value = "todoDao")
public class TodoDaoImpl implements TodoDao {

    private DataSource dataSource;
    private JdbcTemplate template;

    public TodoDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Todo> findAll() {
        String sql = "select * from todos";
        List<Todo> todos = template.query(sql, new TodoMapper());
        return todos;
    }

    public Todo findTodo(int id) {
        String sql = "select * from todos where id = ?";
        return template.queryForObject(sql, new TodoMapper(), id);
    }

    public void addTodo(Todo todo) {
//        TODO
        String sql = "insert into todos value(?, ?, ?)";
    }

    public void deleteTodo(int id) {

    }

    public void updateTodo(Todo todo) {

    }
}
