package com.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.store.support.BookShopRepositoryImpl;

@SpringBootApplication
// 该注解覆盖掉spring一些默认行为，可以使用自定义的repository，告诉spring jpa在生成代理的时候，基于自定义实现来生成代理
@EnableJpaRepositories(repositoryBaseClass = BookShopRepositoryImpl.class)
public class BookshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
	}

}
