package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

	private SpellChecker spellChecker;
	private String word;

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	@Autowired
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public String getWord() {
		return word;
	}

	@Autowired
	public void setWord(String word) {
		this.word = word;
	}

	public void spellCheck() {
		System.out.println("With annotations");
	}

}
