package com.store.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Sort.Direction;

import com.store.BaseTest;
import com.store.domain.Book;

public class RepositoryTest extends BaseTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void test() {
//		System.out.println(bookRepository.getClass().getName());
//		bookRepository.findByName("战争与和平");
		
//		bookRepository.findByNameAndCategoryName("战争与和平", "世界名著");
		
//		Book book = new Book();
//		book.setName("name1");
//		bookRepository.save(book);
		
//		List<Long> ids = new ArrayList<>();
//		ids.add(1L);
//		ids.add(2L);
//		ids.add(3L);
//		Iterable<Book> books = bookRepository.findAllById(ids);
		
//		System.out.println(bookRepository.count());

//		Iterable<Book> findAll = bookRepository.findAll(Sort.by(Direction.DESC, "name", "id"));
		
//		Iterable<Book> findAll = bookRepository.findAll(Sort.by(Order.asc("name"), Order.desc("id")));
		
//		Pageable pageable = PageRequest.of(0, 10, Sort.by(Direction.DESC, "name"));
//		Page<Book> books = bookRepository.findAll(pageable);
		
		
//		Pageable pageable = PageRequest.of(0, 10, Sort.by(Direction.DESC, "name"));
//		Book book = new Book();
//		book.setName("战争");
//		
//		ExampleMatcher matcher = ExampleMatcher.matching()
//				.withStringMatcher(StringMatcher.CONTAINING);
//	
//		Example<Book> example = Example.of(book, matcher);
//		Page<Book> books = bookRepository.findAll(example, pageable);
		
	}
}
