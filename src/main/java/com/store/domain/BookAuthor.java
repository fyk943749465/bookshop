package com.store.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class BookAuthor extends DomainImpl{
	
	@ManyToOne
	private Book book;
	
	@ManyToOne
	private Author author;

}
