package com.tw.todoApp;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@Validated
public class Todo  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Item can not be null.")
    private String todoItem;

    @NotNull(message = "title can not be null.")
    private String todoTitle;

    private String comment;

    public Todo() { }

    public Todo(String todoTitle, String todoItem, String comment) {
        this.todoTitle = todoTitle;
        this.todoItem = todoItem;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;
        Todo todo = (Todo) o;
        return Objects.equals(getTodoItem(), todo.getTodoItem()) &&
                Objects.equals(getTodoTitle(), todo.getTodoTitle()) &&
                Objects.equals(getComment(), todo.getComment());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTodoItem(), getTodoTitle(), getComment());
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", todoItem='" + todoItem + '\'' +
                ", todoTitle='" + todoTitle + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
