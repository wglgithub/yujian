package com.topmobile.bean;

import java.io.Serializable;

public class UserSelectModel implements Serializable{

	private static final long serialVersionUID = 3269892798154471142L;

	private String name ;
	
	private Character letter ;
	
	public UserSelectModel() {
	}

	/**
	 * @param name
	 * @param letter
	 */
	public UserSelectModel(String name, Character letter) {
		super();
		this.name = name;
		this.letter = letter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getLetter() {
		return letter;
	}

	public void setLetter(Character letter) {
		this.letter = letter;
	}
	
	
}
