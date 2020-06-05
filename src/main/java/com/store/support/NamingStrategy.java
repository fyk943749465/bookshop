package com.store.support;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;

public class NamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690959940055459924L;
	
	@Override
	protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
		return super.toIdentifier("rc_" + stringForm, buildingContext);
	}

}
