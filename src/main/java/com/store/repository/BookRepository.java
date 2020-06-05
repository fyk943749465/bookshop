package com.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.store.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByName(String name);
}
