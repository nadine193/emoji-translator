package com.emoji.translator.core;

public class Emoji {
	
	// set fields 
	private String hexCode;
	private String group;
	private String subgroups;
	private String description;
	private String tags;
	
	// emoji constructor 
	public Emoji(String hexCode, String group, String subgroups, String description, String tags) {
		this.hexCode = hexCode;
		this.group = group;
		this.subgroups = subgroups;
		this.description = description;
		this.tags = tags;
	}
	
	
	

}
