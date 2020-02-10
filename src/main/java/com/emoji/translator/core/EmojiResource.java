package com.emoji.translator.core;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.io.Files;

public class EmojiResource {

	private final Path filePath;

	public EmojiResource(Path filePath) {
		this.filePath = filePath;
	}

	public String getEmojiDescription(String hexCode) {
		// load file
		Map<String, String> emojiFileMap = readEmojiFile();
		// look up the hex code
		String emojiDescription = emojiFileMap.get(hexCode);
		// if found, return the emoji description
		return emojiDescription;
	}

	private Map<String, String> readEmojiFile() {
		// TODO: Read files properly
		try {
			List<String> readLines = Files.readLines(this.filePath.toFile(), Charset.defaultCharset());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return Collections.emptyMap();
	}

}
