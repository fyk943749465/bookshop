package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	// CrudRepository 增删改查的一些方法
	// PagingAndSortingRepository 增加了带分页的查询
	// JpaRepository 最长继承的一个接口。 getOne 方法
	List<Book> findByName(String name);
	
	List<Book> findByNameAndCategoryName(String bookName, String categoryName);
}
