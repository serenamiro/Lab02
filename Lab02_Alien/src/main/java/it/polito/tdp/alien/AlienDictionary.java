package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	List<WordEnhanced> dizionario;

	public AlienDictionary() {
		this.dizionario = new LinkedList<WordEnhanced>();
	}

	public void addWord(String alienWord, String translation) {
		WordEnhanced nuova = new WordEnhanced(alienWord.toLowerCase(), translation.toLowerCase());
		if(!this.isEsistente(nuova)) {
			this.dizionario.add(nuova);
		} else {
			WordEnhanced esistente = this.cercaWord(alienWord);
			int indice = this.dizionario.indexOf(esistente);
			this.dizionario.get(indice).getLista().add(translation);
		}
	}
	
	public WordEnhanced cercaWord(String alienWord) {
		int pos = this.dizionario.indexOf(new WordEnhanced(alienWord, null));
		if ( pos != -1) {
			// la parola esiste già nel dizionario
			return this.dizionario.get(pos);
		} else {
			return null;
		}
	}
	
	public boolean isEsistente(WordEnhanced w) {
		WordEnhanced esiste = this.cercaWord(w.getAlienWord());
		if(esiste == null) {
			// parola non esistente
			return false;
		}
		return (esiste.getAlienWord().toLowerCase().equals(w.getAlienWord().toLowerCase()));
	}
	
	public String translateWord(String alienWord) {
		WordEnhanced cercata = this.cercaWord(alienWord);
		if(cercata == null)
			return null;
		return cercata.getTraduzioni();
	}

	/**
	 * Cerco le corrispondenze tra la parola cercata e quelle nel dizionario
	 * @param lowerCase
	 * @return stringa con le traduzioni
	 */
	public String translateWordNascosta(String daCercare) {
		int posCarattere = daCercare.indexOf("?");
		List<WordEnhanced> dizNuovo = new LinkedList();
		List<WordEnhanced> compatibili = new LinkedList<WordEnhanced>();
		for(WordEnhanced w : this.dizionario) {
			WordEnhanced w2 = new WordEnhanced(w);
			dizNuovo.add(w2);
		}
		for(WordEnhanced w : dizNuovo) {
			if(w.getAlienWord().length() == daCercare.length()) {
				w.setAlienWord(w.getAlienWord().substring(0, posCarattere-1)+w.getAlienWord().substring(posCarattere+1, w.getAlienWord().length()));
				if(w.getAlienWord().equals(daCercare.substring(0, posCarattere-1)+daCercare.substring(posCarattere+1, daCercare.length()))) {
					compatibili.add(w);
				}
			}
		}
		if(compatibili.size() == 0) {
			return null;
		}
		String ret = "";
		for(WordEnhanced ww : compatibili) {
			ret += ww.getTraduzioni()+", ";
		}
		return ret.substring(0, ret.length()-2);
	}
	
}
