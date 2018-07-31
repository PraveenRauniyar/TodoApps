package com.tw.todoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TodoRepository {

    @Autowired
    private Repository repository;


    public long addTodo(Todo todo) {
        repository.save(todo);
        return todo.getId();
    }

    public Todo getTodoById(long id) {
        if (!isExistedById(id)){
            return null;
        }
        return repository.findById(id).get();
    }

    public boolean isExistedById(long id){
        return repository.existsById(id);
    }

    public boolean deleteById(long id) {
        if (isExistedById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public long editTitleById(long id, String title) {
        if (isExistedById(id)){
            Todo todo = getTodoById(id);
            todo.setTodoItem(title);
            id =  addTodo(todo);
        }
        return id;
    }
}
