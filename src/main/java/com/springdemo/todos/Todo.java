package com.springdemo.todos;

/**
 * Created by afghl on 16/10/15.
 */


public class Todo {
    private int id;
    private String content;
    private int status;

    public Todo() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "content is" + content + ", and state is :" + status;
    }
}
