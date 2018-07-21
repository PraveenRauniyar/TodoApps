package com.example.todoApp;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
@Validated
public class Todo  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Item can not be null.")
    @Column(name = "Item")
    private String todoItem;

    @NotNull(message = "title can not be null.")
    @Column(name = "title")
    private String todoTitle;

    private String comment;

    public Todo() { }

    public Todo(String todoItem, String todoTitle, String comment) {
        this.todoItem = todoItem;
        this.todoTitle = todoTitle;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(String todoItem) {
        this.todoItem = todoItem;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
