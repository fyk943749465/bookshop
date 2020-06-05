package com.store.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Table(name = "rc_category") //该注解会在标识数据库中生成表的名字
@Entity  //该注解表明是实体，在启动的时候，会将实体在数据库中创建一张表
public class Category extends DomainImpl{
	
	@Basic
	//@Column(name = "roncoo_name", length = 10, nullable = false, unique = true)
	//这里的命名,会覆盖掉全局的命名策略
	private String name;  //该字段不加注解，默认情况下是@Basic
	
	@Transient            //该注解表明该字段不会被加入到数据库中
	private String xxxx;
	
//	@OneToMany            // 这样的注解，会在数据库中产品一张表，来维护category 和 book之间的关系 
//	                      // 尽量不要建立单项的一对多关系 如果要建立关系，应该建立在多的一端 即book端而不是category端
//	                      // 最佳实践，应该建立双向的关系
//	private List<Book> books;
	
	// orphanRemoval = true | false 默认false 表明 从books中删除一个对象时候，是否需要执行数据库删除操作
	// cascade = CascadeType.REMOVE 表明是否级联删除，默认什么都不做的
	@OneToMany(mappedBy = "category") //这里表明，一对多关系，不需要category这一端来维护，而是要book端的category来维护
	private List<Book> books;

}
