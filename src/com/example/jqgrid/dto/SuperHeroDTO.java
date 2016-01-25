package com.example.jqgrid.dto;

import java.io.Serializable;

/**
 * 
 * @author Dinuka Arseculeratne
 *
 */
public class SuperHeroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1420635747715993129L;

	private String name;
	private String alias;
	private String power;

	public SuperHeroDTO(String name, String alias, String power) {
		this.name = name;
		this.alias = alias;
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

}
