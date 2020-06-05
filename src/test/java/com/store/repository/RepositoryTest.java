package com.store.repository;

import java.util.Optional;

import javax.persistence.FetchType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.store.BaseTest;
import com.store.domain.Book;

public class RepositoryTest extends BaseTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
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
		
//		Specification<Book> specification = new Specification<Book>() {
//			@Override
//			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//				// 1. 组合模式，自身即使容器又是实体
//				// 2. 可以根据前台传过来的参赛是否为空，来决定是否生成查询条件，达到动态查询的目的
//				Predicate p1 = criteriaBuilder.equal(root.get("name"), "战争与和平");
//				Predicate p2 = criteriaBuilder.equal(root.get("category").get("name"), "世界名著");
//				Predicate p3 = criteriaBuilder.and(p1, p2);
//				// 指定连接方式 ，如果不指定，jpa会自己生成
//				root.fetch("category", JoinType.LEFT);
//				return p3;
//			}
//		};
//		
//		bookRepository.findOne(specification);
		
//		bookRepository.save(new Book());
	}
	/**
	 * 持久化上下文的生命周期与系统事务一致
	 * 持久化上下文提供自动脏检测
	 * 持久化上下文是一级缓存
	 */
	@Test
	public void test1() {
		
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		Book book = bookRepository.findById(1L).get();
		book.setName("美女与野兽");
		// 这里其实可以不加，因为在查询的时候，查询出来的数据是放在持久化上下文中的
		// 而且在commit的时候，持久化会进行数据检测。如果发现与数据库中的数据不一致，执行update操作
		// bookRepository.save(book); 
		
		// saveAndFlush不是等到commit的时候，才保持与数据库同步，而是强制执行与数据库同步，这与save是不同的。
		bookRepository.saveAndFlush(book);
		
		transactionManager.commit(status);
	}
	
	/**
	 * 这是持久化上下文作为缓存其作用的例子
	 */
	@Test
	public void test2() {
		
		bookRepository.findById(1L);
		bookRepository.findById(1L);
	}
	
	@Test
	public void test3() {
        //这里生成了一条查询语句
//		Book book = bookRepository.findById(1L).get();
//		System.out.println(book.getCategory().getName());
		
		// 这里生成了两条查询语句，也就说 Book的category属性上定义的FetchType.EAGER抓取策略没有生效， 有几种方式可以解决
		// 1. 在findByName上，增加@Query注解，用JAPQL实现，这种方式不太合适，因为这样定义方法，就是为了减少开发量，但增加Query没能达到此效果
		// 2. 在findByName上增加@EntityGraph(attributePaths = {"category"}) 这样一个注解，达到使用关联查询抓取策略的目的
		Book book = bookRepository.findByName("美女与野兽");
		System.out.println(book.getCategory().getName());
	}
}
