package com.emoji.translator.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emoji.translator.core.EmojiResource;

@RestController("/emoji")
public class EmojiController {
	
	private EmojiResource emojiResource;

	@Autowired
	public EmojiController(EmojiResource emojiResource) {
		this.emojiResource = emojiResource;
	}
	
	@GetMapping("/getDescription")
	public String getDescription(@RequestParam String emojiIcon) throws IOException {
		return this.emojiResource.getEmojiDescription(emojiIcon);
	}
	
	@GetMapping("/getTags")
	public List<String> getTags(@RequestParam String emojiIcon) throws IOException {
		return this.emojiResource.getEmojiTags(emojiIcon);
	}

	@GetMapping("/getTagMatches")
	public List<String> getTagMatches(@RequestParam String tags) throws IOException {
		return this.emojiResource.getTagMatches(tags);
	}
}
