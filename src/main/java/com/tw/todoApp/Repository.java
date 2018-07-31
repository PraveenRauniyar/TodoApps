package com.tw.todoApp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Todo,Long> {
}
