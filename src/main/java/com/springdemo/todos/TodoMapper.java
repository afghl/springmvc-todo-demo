package com.springdemo.todos;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by afghl on 16/10/15.
 */
public class TodoMapper implements RowMapper<Todo> {
    public Todo mapRow(ResultSet rs, int i) throws SQLException {
        Todo todo = new Todo();
        todo.setId(rs.getInt("id"));
        todo.setStatus(rs.getInt("status"));
        todo.setContent(rs.getString("content"));
        return todo;
    }
}
//
//public class StudentMapper implements RowMapper<Student> {
//
//    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Student student = new Student();
//        student.setId(rs.getInt("id"));
//        student.setName(rs.getString("name"));
//        student.setAge(rs.getInt("age"));
//        return student;
//    }
//}
