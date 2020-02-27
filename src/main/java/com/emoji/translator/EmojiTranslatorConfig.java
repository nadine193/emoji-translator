package com.emoji.translator;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.emoji.translator.core.EmojiResource;

@Configuration
public class EmojiTranslatorConfig {

	@Bean
	public EmojiResource emojiResource() throws URISyntaxException {
		return new EmojiResource(getEmojiFilePath("openmoji.csv"));
	}
	
	// get file path of resource 
    private Path getEmojiFilePath(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return Paths.get(resource.toURI());
        }

    }
    
    
	
}
