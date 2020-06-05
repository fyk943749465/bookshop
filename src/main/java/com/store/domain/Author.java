package com.store.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Author extends DomainImpl{

	private String name; // no annotation, default @Basic annotation
	
	@Column(columnDefinition = "INT(3)") // defination about filed length
	private int age;
	
	@Temporal(TemporalType.DATE)  // Date annotation
	private Date birthday;
	
	@Enumerated(EnumType.STRING)  //enum annotation
	private Sex sex;
	
	@Embedded // address object embedded, used when main object and embedded object have the same lifetime 
	private Address address;
	
	@ElementCollection  // collection's annotation, simple type
	private List<String> hobbies;
	
	@ElementCollection  // object type use collection's annotation
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "author")
	@OrderBy("book.name DESC")  // This is an ordered collection, default order by id(primay key)
	private List<BookAuthor> books;
	
	@OneToOne
	private AuthorInfo authorInfo;
}
