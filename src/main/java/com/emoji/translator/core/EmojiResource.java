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
	public String getEmojiDescription(String hexCode) throws IOException {
		// load file
		Map<String, Emoji> emojiMap = readEmojiFile();
	    Emoji emoji = emojiMap.get(hexCode);

	    return emoji.getDescription();
	}
	   
	// return emoji tags when given hex code
	public List<String> getEmojiTags(String hexCode) throws IOException {
	    // load file
	    Map<String, Emoji> emojiMap = readEmojiFile();
	    Emoji emoji = emojiMap.get(hexCode);

	    // look up the hex code
	    List<String> emojiTags = emoji.getTags();
	    // if found, return the emoji tags
	    return emojiTags;
	   } 
	   
	   private Map<String, Emoji> readEmojiFile() {
	      try {
	         Map<String, Emoji> emojiMap = Files.lines(filePath).skip(1)
	               .map(line -> line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"))
	                   .map(a -> new Emoji(a[1], a[2], a[3], a[4], readTags(a[5], a[6])))
	               .collect(Collectors.toMap(Emoji::getHexCode, Function.identity()));

	         return emojiMap;

	      } catch (IOException e) {
	         throw new RuntimeException(e);
	      }
	   }

	   private List<String> readTags(String firstTags, String secondTags) {
	      // firstTags example: "face, grin"     secondTags: "smile, happy"

	      String[] firstTagsSplit = firstTags
	                           .replaceAll("\"","")
	                           .replaceAll(" ","")
	                           .split(",");
	      String[] secondTagsSplit = secondTags
	                           .replaceAll("\"","")
	                           .replaceAll(" ","")
	                           .split(",");

	      List<String> result = new ArrayList<>();

	      result.addAll(Arrays.asList(firstTagsSplit));
	      result.addAll(Arrays.asList(secondTagsSplit));

	      return result;
	      // create a list
	      // split first tags ["face", "grin"] 2 items
	      // split secondTags ["smile", "happy"] 2 items
	      // result {"face, grin", "smile, happy"}


	      // result {"face", "grin", "smile", "happy"} 4 items
	      
	   }
	   
}
