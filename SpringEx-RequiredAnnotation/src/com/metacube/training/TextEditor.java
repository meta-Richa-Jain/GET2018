package com.metacube.training;

import org.springframework.beans.factory.annotation.Required;

public class TextEditor {

	private SpellChecker spellChecker;
	private String word;

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public String getWord() {
		return word;
	}

	@Required
	public void setWord(String word) {
		this.word = word;
	}

	public void spellCheck() {
		System.out.println(spellChecker.checkSpelling() + " of the word : " + getWord());
	}

}
