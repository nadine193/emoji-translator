package com.emoji.translator.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class EmojiResource {

	private final Path filePath;

	public EmojiResource(Path filePath) {
		this.filePath = filePath;
	}
	
	Map<String, String> hexToDescriptionMap = new HashMap<String, String>();
	
	// return emoji description when given hex code
	public String getEmojiDescription(String hexCode) throws IOException {
		// load file
		List<Emoji> emojiList = readEmojiFile();
		
		// create map of hex code and description
		for(int i=0; i < emojiList.size(); i++) {
			hexToDescriptionMap.put(emojiList.get(i).getHexCode(), emojiList.get(i).getDescription());
		}

		// look up the hex code
		String emojiDescription = hexToDescriptionMap.get(hexCode);
		// if found, return the emoji description
		return emojiDescription;
	} 
	
	Map<String, String> hexToTagsMap = new HashMap<String, String>();
	
	// return emoji description when given hex code
	public String getEmojiTags(String hexCode) throws IOException {
		// load file
		List<Emoji> emojiList = readEmojiFile();
		
		// create map of hex code and description
		for(int i=0; i < emojiList.size(); i++) {
			hexToTagsMap.put(emojiList.get(i).getHexCode(), emojiList.get(i).getTags());
		}

		// look up the hex code
		String emojiTags = hexToTagsMap.get(hexCode);
		// if found, return the emoji description
		return emojiTags;
	} 
	/*Map<String, String> tagToHexMap = new HashMap<String, String>();
	
	public String getEmojiFromTags(String tags) throws IOException {
		//load file
		List<Emoji> emojiList = readEmojiFile();
		
		//create map of every tag to its emoji, in a many-to-one manner
		for(int i=0; i<emojiList.size(); i++) {
			tagToHexMap.put
		}
	} */
	
	private List<Emoji> readEmojiFile() throws IOException {
		
		List<Emoji> emojiList = new ArrayList();
		
		try {
			Stream<String> readLines = Files.lines(filePath);
			emojiList = readLines.map(line -> line.split(","))
					 .map(a -> new Emoji(a[1], a[2], a[3], a[4], String.join(",", a[5], a[6])))
					 .collect(Collectors.toList());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
		
		return emojiList;
	}
}


