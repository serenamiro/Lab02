package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	AlienDictionary dizionario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtRisposta;

    @FXML
    private Button btnClear;

    @FXML
    void doReset(ActionEvent event) {
    	txtRisposta.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String s = txtInsert.getText();
    	txtInsert.clear();
    	if(s.contains(" ")) {
    		String[] parole = s.split(" ");
    		String alien = parole[0].toLowerCase();
    		String trad = parole[1].toLowerCase();
    		if(!alien.matches("[a-zA-Z]*") || !trad.matches("[a-zA-Z]*")) {
    			txtRisposta.appendText("Input non valido!\n");
    			return;
    		}
    		this.dizionario.addWord(alien.toLowerCase(), trad.toLowerCase());
    		txtRisposta.appendText("Parola inserita nel dizionario.\n");
    	} else {
    		if(s.contains("?")) {
    			String ret = this.dizionario.translateWordNascosta(s.toLowerCase());
    			txtRisposta.appendText(ret+"\n");
    			return;
    		}
    		if(!s.matches("[a-zA-Z]*")) {
    			txtRisposta.appendText("Input non valido!\n");
    			return;
    		} 
    		String risposta = this.dizionario.translateWord(s.toLowerCase());
    		txtRisposta.appendText(risposta+"\n");
    	}
    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisposta != null : "fx:id=\"txtRisposta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        dizionario = new AlienDictionary();
    }
}
