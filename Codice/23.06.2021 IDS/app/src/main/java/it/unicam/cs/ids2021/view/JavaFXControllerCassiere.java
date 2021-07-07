package it.unicam.cs.ids2021.view;

import com.google.common.net.UrlEscapers;
import it.unicam.cs.ids2021.JavaFX;
import it.unicam.cs.ids2021.consegne.GestoreOrdiniI;
import it.unicam.cs.ids2021.consegne.Ordine;
import it.unicam.cs.ids2021.locker.GestoreLockerI;
import it.unicam.cs.ids2021.negozio.Negozio;
import it.unicam.cs.ids2021.negozio.Prodotto;
import it.unicam.cs.ids2021.utenti.Cassiere;
import it.unicam.cs.ids2021.utenti.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class JavaFXControllerCassiere implements Initializable {

    Ordine o;
    private Cassiere selectedCassiere;
    GestoreOrdiniI gO = JavaFX.gOrdini;
    GestoreLockerI gL = JavaFX.gLocker;

    //BOTTONI---------------------------------------------------------
    @FXML
    private Button buttonMostraLocker;
    @FXML
    private Button buttonAggiungiProdotto;
    @FXML
    private Button buttonEliminaProdotto;
    @FXML
    private Button buttonCreaOrdine;
    @FXML
    private Button buttonEliminaOrdine;
    @FXML
    private Button buttonScegliOrdine;
    //TEXT FIELD----------------------------------------------------------------------
    @FXML
    private TextField textIdProdotto;
    @FXML
    private TextField textQuantita;
    @FXML
    private TextField textIdOrdine;
    // LABEL -------------------------------------------------------------------------------
    @FXML
    private Label nomeLabel;
    @FXML
    private Label cognomeLabel;
    @FXML
    private Label negozioLabel;
    
    //METODI--------------------------------------------------------------------------------

    private void alertError(String headerText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("STAI SBAGLIANDO");
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    @FXML
    void ActionAggiungiProdotto(ActionEvent event) { }

    /**
     * Crea una mappa di prodotti
     *
     * @return
     */
    /*Map<Prodotto, Integer> creaMappaProdotti() {
        Map<Prodotto, Integer> mappa = new HashMap<>();
        //  mappa.put();
        return mappa;
    }*/
    @FXML
    void ActionCreaOrdine(ActionEvent event) {
        o= gO.creaOrdine(new HashMap<Prodotto, Integer>());
        textIdOrdine.setText(o.getIdOrdine());
    }
    @FXML
    void ActionEliminaOrdine(ActionEvent event) {
        if(!gO.containsOrdine(textIdOrdine.getText())) alertError("L'ordine che si vuole eliminare non è presente.");
        gO.eliminaOrdine(textIdOrdine.getText());
    }

    @FXML
    void ActionScegliOrdine(ActionEvent event) {
       if(!gO.containsOrdine(textIdOrdine.getText()))
           alertError("L'id da lei inserito non corrisponde a nessun ordine.");
        else o= gO.cercaOrdine(textIdOrdine.getText());

    }

    @FXML
    void ActionEliminaProdotto(ActionEvent event) {
        gO.eliminaProdotto(gO.cercaOrdine(textIdOrdine.getText()),textIdProdotto.getText());
    }

    @FXML
    void ActionMostraLocker(ActionEvent event) {
    }

    @FXML
    void MenuPrincipaleScene(ActionEvent event) throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource("/Utenti.fxml"));
        Scene scene = new Scene(view);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


//INITIALIZE----------------------------------------------------------------------------------------------------------

    public void initData(Cassiere cassiere) {
        selectedCassiere = cassiere;
        nomeLabel.setText(selectedCassiere.getNome());
        cognomeLabel.setText(selectedCassiere.getCognome());
        negozioLabel.setText(selectedCassiere.getNegozio().getNome());
    }

    private Ordine ricavaOrdine() {
        return gO.cercaOrdine(textIdOrdine.getText());
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }
}


