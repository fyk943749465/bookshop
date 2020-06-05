package com.store.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.store.BaseTest;
import com.store.domain.Book;

public class RepositoryTest extends BaseTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void test() {
//		System.out.println(bookRepository.getClass().getName());
//		bookRepository.findByName("战争与和平");
		
		Book book = new Book();
		book.setName("name1");
		bookRepository.save(book);
	}
}
