package com.springdemo.todos;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by afghl on 16/10/15.
 */
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
}
