package com.gmail.gor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.gmail.gor.exceptions.HaveNotFoundException;


public class Translator implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private Map<String, String> vocabulary = new HashMap<>();

	public Translator() {
		super();
	}

	public Translator(Map<String, String> vocabulary) {
		super();
		this.vocabulary = vocabulary;
	}

	public Map<String, String> getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(Map<String, String> vocabulary) {
		this.vocabulary = vocabulary;
	}
	public String translateWord(String englishWord)throws HaveNotFoundException {
		if(vocabulary.containsKey(englishWord)) {
			return vocabulary.get(englishWord);
		}else throw new HaveNotFoundException();
		
	}
	public void addWord() {
		try {
		String eng = JOptionPane.showInputDialog("Enter a word in english");
		String ukr = JOptionPane.showInputDialog("Enter a word in ukrainian");
		vocabulary.put(eng, ukr);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Cancel");
		}
		
	}

	@Override
	public String toString() {
		return "Translator [vocabulary=" + vocabulary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vocabulary == null) ? 0 : vocabulary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Translator other = (Translator) obj;
		if (vocabulary == null) {
			if (other.vocabulary != null)
				return false;
		} else if (!vocabulary.equals(other.vocabulary))
			return false;
		return true;
	}
	
}

