package com.store.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 * embeddable object
 * @author asteroid
 *
 */
@Getter
@Setter
@Embeddable
public class Address {

	private String province;
	
	private String city;
	
	private String area;
	
	private String address;
	
	private String zipcode;
}
