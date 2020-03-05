package com.emoji.translator.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class EmojiResource {

	private final Path filePath;

	public EmojiResource(Path filePath) {
		this.filePath = filePath;
	}
	
	
	// return emoji description when given hex code
	public String getEmojiDescription(String hexCode) throws IOException {
		// load file
		Map<String, Emoji> emojiMap = readEmojiFile();
		
		Map<String, String> hexToDescriptionMap = new HashMap<String, String>();
		
		// create map of hex code and description
		for(Map.Entry<String, Emoji> entry : emojiMap.entrySet()) {
			hexToDescriptionMap.put(entry.getKey(), entry.getValue().getDescription());
		}

		// look up the hex code
		String emojiDescription = hexToDescriptionMap.get(hexCode);
		// if found, return the emoji description
		return emojiDescription;
	} 
	
	Map<String, String> hexToTagsMap = new HashMap<String, String>();
	
	// return emoji tags when given hex code
	public String getEmojiTags(String hexCode) throws IOException {
		// load file
		Map<String, Emoji> emojiMap = readEmojiFile();
		
		// create map of hex code and tags
		for(Map.Entry<String, Emoji> entry : emojiMap.entrySet()) {
			hexToTagsMap.put(entry.getKey(), entry.getValue().getTags());
		}

		// look up the hex code
		String emojiTags = hexToTagsMap.get(hexCode);
		// if found, return the emoji tags
		return emojiTags;
	} 
	
	private Map<String, Emoji> readEmojiFile() {
		
		List<Emoji> emojiList = new ArrayList<>();
		Map<String, Emoji> emojiMap = new HashMap<>();
				
		try {
			Stream<String> readLines = Files.lines(filePath);
			emojiList = readLines.map(line -> line.split(","))
	                .map(a -> new Emoji(a[1], a[2], a[3], a[4], String.join(",", a[5], a[6])))
	                .collect(Collectors.toList());
			emojiMap = emojiList.stream()
								.collect(Collectors.toMap(Emoji::getHexCode, Function.identity()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
		
		return emojiMap;
	}
}


