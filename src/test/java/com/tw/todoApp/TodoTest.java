package com.tw.todoApp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class TodoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldAddTodoInRepository() {
        Todo todo = new Todo("tea", "milk", "hotwater");
        Todo addedTodo = this.entityManager.persistAndFlush(todo);
        assertThat(addedTodo.getTodoItem(), is("milk"));
        assertThat(addedTodo.getTodoTitle(), is("tea"));
        assertThat(addedTodo.getComment(), is("hotwater"));
    }

    @Test
    public void shouldThrowExceptionForInsertingNullTitle() {
        this.thrown.expect(ConstraintViolationException.class);
        Todo todo = new Todo("tea",null, "not getting time");
        Todo addedTodo = this.entityManager.persistAndFlush(todo);
    }

    @Test
    public void shouldThrowExceptionForInsertingNullItem() {
        this.thrown.expect(ConstraintViolationException.class);
        Todo todo = new Todo(null,"Hi", "not getting time");
        Todo addedTodo = this.entityManager.persistAndFlush(todo);
    }
}
