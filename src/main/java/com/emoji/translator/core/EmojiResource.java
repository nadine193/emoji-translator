package com.emoji.translator.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
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
	public String getEmojiDescription(String emojiIcon) throws IOException {
		// load file
		Map<String, Emoji> emojiMap = readEmojiFile();
	    Emoji emoji = emojiMap.get(emojiIcon);

	    return emoji.getDescription();
	}
	   
	// return emoji tags when given hex code
	public List<String> getEmojiTags(String emojiIcon) throws IOException {
		
		
	    // load file
	    Map<String, Emoji> emojiMap = readEmojiFile();
	    Emoji emoji = emojiMap.get(emojiIcon);

	    // look up the hex code
	    List<String> emojiTags = emoji.getTags();
	    // if found, return the emoji tags
	    return emojiTags;
	   } 
	   
	public List<String> getTagMatches(String tags) throws IOException {
		int maxCount = 0;
		
		String[] inputTags = tags.split(" ");
		
		// load file
		Map<String, Emoji> emojiMap = readEmojiFile();
		Map<Emoji, Integer> matchTrackingMap = new HashMap<>();
		
		// for each entry in the emojimap
		for (Map.Entry<String, Emoji> entry : emojiMap.entrySet()) {
			int count = 0;
			// get tags from that emoji
			List<String> emojiTags = entry.getValue().getTags();
			
			// find match
			for (String tag : inputTags) {
				if (emojiTags.contains(tag)) {
					count++;
				}
			}
			
			if (count >= maxCount) {
				maxCount = count;
				matchTrackingMap.put(entry.getValue(), count);
			}
			
		}
		
		
		int finalMaxCount = maxCount;
		List<String> result = matchTrackingMap.entrySet()
									.stream()
									.filter(x -> x.getValue().equals(finalMaxCount))
									.map(Map.Entry::getKey)
									.map(Emoji::getIcon).collect(Collectors.toList());

		return result;
				
	}
	
	
	   private Map<String, Emoji> readEmojiFile() {
	      try {
	         Map<String, Emoji> emojiMap = Files.lines(filePath).skip(1)
	               .map(line -> line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"))
	                   .map(a -> new Emoji(a[0], a[1], a[2], a[3], a[4], readTags(a[5], a[6])))
	               .collect(Collectors.toMap(Emoji::getIcon, Function.identity()));
	         
	         return emojiMap;
	         

	      } catch (IOException e) {
	         throw new RuntimeException(e);
	      }
	   }
	   
	

	   private List<String> readTags(String firstTags, String secondTags) {
	      // firstTags example: "face, grin"     secondTags: "smile, happy"
		  
		  //split tags into individual strings
	      String[] firstTagsSplit = firstTags
	                           .replaceAll("\"","")
	                           .replaceAll(" ","")
	                           .split(",");
	      String[] secondTagsSplit = secondTags
	                           .replaceAll("\"","")
	                           .replaceAll(" ","")
	                           .split(",");

	      List<String> result = new ArrayList<>();
	      //add strings into list
	      result.addAll(Arrays.asList(firstTagsSplit));
	      result.addAll(Arrays.asList(secondTagsSplit));

	      return result;
	     	      
	   }
	   
}
