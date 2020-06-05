package com.store.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.web.servlet.setup.ConfigurableMockMvcBuilder;

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
		
//		Pageable pageable = PageRequest.of(0, 10, Sort.by(Direction.DESC, "name"));
//		bookRepository.findByNameLikeAndCategoryNameOrderByNameDesc("战争与和平", "世界名著", pageable);
		
//		bookRepository.updateBooks("战争与和平", 1L);
		
		Specification<Book> specification = new Specification<Book>() {
			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// 1. 组合模式，自身即使容器又是实体
				// 2. 可以根据前台传过来的参赛是否为空，来决定是否生成查询条件，达到动态查询的目的
				Predicate p1 = criteriaBuilder.equal(root.get("name"), "战争与和平");
				Predicate p2 = criteriaBuilder.equal(root.get("category").get("name"), "世界名著");
				Predicate p3 = criteriaBuilder.and(p1, p2);
				// 指定连接方式 ，如果不指定，jpa会自己生成
				root.fetch("category", JoinType.LEFT);
				return p3;
			}
		};
		
		bookRepository.findOne(specification);
	}
}
