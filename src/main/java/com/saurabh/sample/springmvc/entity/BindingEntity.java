package com.saurabh.sample.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Binding")
public class BindingEntity {

	@Id
	@Column(name="BINDINGTYPE")
	private String bindingType;

	public String getBindingType() {
		return bindingType;
	}

	public void setBindingType(String bindingType) {
		this.bindingType = bindingType;
	}
	
}
