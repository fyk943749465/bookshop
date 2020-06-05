package com.store.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/**
 * 这里存放一些不常用字段，但是跟用户Author相关
 * @author asteroid
 *
 */
@Entity
public class AuthorInfo extends DomainImpl{
	
	private String school;
	
	@OneToOne(mappedBy = "authorInfo")
	private Author author;
}
