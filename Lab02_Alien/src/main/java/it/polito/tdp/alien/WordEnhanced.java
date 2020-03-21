package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> traduzioni = new LinkedList<String>();
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.traduzioni.add(translation);
	}

	public WordEnhanced(WordEnhanced w) {
		// TODO Auto-generated constructor stub
		this.alienWord = w.getAlienWord();
		this.traduzioni = w.getLista();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
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
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTraduzioni() {
		String ret = "";
		for(String s : this.traduzioni) {
			ret += s+", ";
		}
		return ret.substring(0, ret.length()-2);
	}

	public void setTraduzioni(List<String> traduzioni) {
		this.traduzioni = traduzioni;
	}
	
	public List<String> getLista(){
		return this.traduzioni;
	}
	

}
