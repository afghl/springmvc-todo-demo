package com.springdemo.todos;

import java.util.List;

/**
 * Created by afghl on 16/10/15.
 */
public interface TodoDao {
    public List<Todo> findAll();
}
