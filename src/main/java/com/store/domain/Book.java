package com.store.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.type.TrueFalseType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book extends DomainImpl {
	
	private String name;
	
	// FetchType.LAZY 不查询category对应的表 | FetchType.EAGER 表明要查询category对应的表
	// optional = true 表示category可以为空 | false 表示category不能为空
	@ManyToOne(fetch = FetchType.EAGER, optional = true) 
	private Category category;
	
	@OneToMany(mappedBy = "book")
	private List<BookAuthor> authors;
}
