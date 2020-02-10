package com.emoji.translator;

import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.emoji.translator.core.EmojiResource;

@Configuration
public class EmojiTranslatorConfig {

	@Bean
	public EmojiResource emojiResource() {
		return new EmojiResource(Paths.get("C:\\Users\\Nadine\\app\\openmoji\\data\\openmoji.json"));
	}
}
