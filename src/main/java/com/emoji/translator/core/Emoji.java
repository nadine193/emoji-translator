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
	
	public String getHexCode() {
		return this.hexCode;
	}
	
	public String getGroup() {
		return this.group;
	}
	
	public String getSubGroups() {
		return this.subgroups;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getTags() {
		return this.tags;
	}
	
	

}
