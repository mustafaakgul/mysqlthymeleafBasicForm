package com.example.mysqlthymeleaf;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface TodoDao extends CrudRepository<Todo, Long> {
}
