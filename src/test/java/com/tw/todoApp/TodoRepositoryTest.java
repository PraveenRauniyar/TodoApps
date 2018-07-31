package com.tw.todoApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


@SpringBootTest
@ActiveProfiles("test")
@Transactional
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
public class TodoRepositoryTest {

    @Autowired
    com.tw.todoApp.TodoRepository todoRepository;


    @Test
    public void shouldAddTodoInRepository() {
        Todo todo = new Todo("Tea", "water", "sugar");
        long id = todoRepository.addTodo(todo);
        assertEquals(todoRepository.getTodoById(id),todo);
    }

    @Test
    public void shouldFindTodoById() {
        Todo todo = new Todo("cooking", "rice", "water");
        long id = todoRepository.addTodo(todo);
        Todo addedTodo = todoRepository.getTodoById(id);
        assertEquals(addedTodo.getTodoTitle(),"cooking");
        assertEquals(addedTodo.getTodoItem(),"rice");
        assertEquals(addedTodo.getComment(),"water");
    }

    @Test
    public void shouldGiveNullIfTodoNotFindById() {
        assertNull(todoRepository.getTodoById(0));
    }

    @Test
    public void shouldDeleteTodoByIdAndReturnTrue() {
        Todo todo = new Todo("what", "why", "how");
        long id = todoRepository.addTodo(todo);
        assertTrue(todoRepository.isExistedById(id));
        assertTrue(todoRepository.deleteById(id));
        assertFalse(todoRepository.isExistedById(id));

    }

    @Test
    public void shouldGiveFalseForDeleteByIdIfIdNotPresent() {
        assertFalse(todoRepository.deleteById(0));
    }

    @Test
    public void editTitleById() {
        Todo todo = new Todo("hi", "hello", "bye");
        long id = todoRepository.addTodo(todo);
        assertTrue(todoRepository.isExistedById(id));
        long editedId = todoRepository.editTitleById(id, "awesome");
        todo.setTodoItem("awesome");
        assertEquals(todoRepository.getTodoById(editedId),todo);

    }
}
