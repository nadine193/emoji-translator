package com.emoji.translator.web;

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
	
	@GetMapping("/getEmoji")
	public String getEmoji(@RequestParam String hexCode) {
		return this.emojiResource.getEmojiDescription(hexCode);
	}

}
