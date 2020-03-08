package com.emoji.translator.core;

import java.util.List;

public class Emoji {
	
	// set fields 
	private String emojiIcon;
	private String hexCode;
	private String group;
	private String subgroups;
	private String description;
	private List<String> tags;
	
	// emoji constructor 
	public Emoji(String emojiIcon, String hexCode, String group, String subgroups, String description, List<String> tags) {
		this.emojiIcon = emojiIcon;
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
	
	public List<String> getTags() {
		return this.tags;
	}
	
	public String getIcon() {
		return this.emojiIcon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((emojiIcon == null) ? 0 : emojiIcon.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((hexCode == null) ? 0 : hexCode.hashCode());
		result = prime * result + ((subgroups == null) ? 0 : subgroups.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emoji other = (Emoji) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (emojiIcon == null) {
			if (other.emojiIcon != null)
				return false;
		} else if (!emojiIcon.equals(other.emojiIcon))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (hexCode == null) {
			if (other.hexCode != null)
				return false;
		} else if (!hexCode.equals(other.hexCode))
			return false;
		if (subgroups == null) {
			if (other.subgroups != null)
				return false;
		} else if (!subgroups.equals(other.subgroups))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}
	
	

}
