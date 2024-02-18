package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Todo;
public interface TodoRepository extends JpaRepository<Todo, Serializable> {

}
