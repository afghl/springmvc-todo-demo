package com.springdemo.todos;

import java.util.List;

/**
 * Created by afghl on 16/10/15.
 */
public interface TodoDao {
    List<Todo> findAll();

    Todo findTodo(int id);

    void addTodo(Todo todo);

    void deleteTodo(int id);

    void updateTodo(Todo todo);
}
