package com.store.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.store.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book>{

	// CrudRepository 增删改查的一些方法
	// PagingAndSortingRepository 增加了带分页的查询
	// JpaRepository 最长继承的一个接口。 getOne 方法
	// JpaSpecificationExecutor 该接口是生成动态查询的接口，上面的都是静态查询接口，所以，一般一个Repository要继承静态查询和动态查询接口
	// 静态查询
	List<Book> findByName(String name);
	// 静态查询
	List<Book> findByNameAndCategoryName(String bookName, String categoryName);
	// 静态查询，根据属性来查询
    Page<Book> findByNameLikeAndCategoryNameOrderByNameDesc(String bookname, String category, Pageable pageable);
    
    //JPAQL 静态查询，用JPAQL来查询
    @Query("from Book b where b.name like ?1 and b.category.name = ?2 order by b.name desc")
    Page<Book> findBooks(String bookname, String categoryName, Pageable sort);
    
    @Query("update Book b set b.name = ?1 where b.id = ?2")
    @Modifying  //该注解表明需要动库
    int updateBooks(String bookname, Long bookId);
    
    // 原生sql
    @Query(value = "update book b set b.name = ?1 where b.id = ?2", nativeQuery = true)
    @Modifying
    int updateBooks2(String bookname, Long bookId);
}
