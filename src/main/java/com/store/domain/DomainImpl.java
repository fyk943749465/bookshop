package com.store.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass  //标有这个注解的类，在被其他类继承的时候，其属性会映射到相应的子类上去
public class DomainImpl {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // primary key generation's strategy
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime = new Date(); 
}
