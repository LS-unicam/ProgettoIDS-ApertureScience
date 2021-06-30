package it.unicam.cs.ids2021.view;

import it.unicam.cs.ids2021.JavaFX;
import it.unicam.cs.ids2021.consegne.GestoreOrdini;
import it.unicam.cs.ids2021.consegne.GestoreOrdiniI;
import it.unicam.cs.ids2021.consegne.Ordine;
import it.unicam.cs.ids2021.locker.GestoreLocker;
import it.unicam.cs.ids2021.locker.GestoreLockerI;
import it.unicam.cs.ids2021.locker.LockerI;
import it.unicam.cs.ids2021.negozio.Negozio;
import it.unicam.cs.ids2021.utenti.Cassieri;
import it.unicam.cs.ids2021.utenti.Corrieri;
import it.unicam.cs.ids2021.utenti.Utente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JavaFXControllerUtenti {

    Utente utente;
    boolean registrati = true;
    //BOTTONI--------------------------------------------------------
    @FXML
    private Button buttonCassiere;

    @FXML
    private Button buttonCorriere;

    @FXML
    private Button buttonAssistenza;

    @FXML
    private Button buttonCliente;

    @FXML
    private Button buttonEntra;

    @FXML
    private Button buttonRegistrati;
    //TEXT FIELD ------------------------------------------------
    @FXML
    private TextField textNome;

    @FXML
    private TextField textCognome;

    @FXML
    private TextField textEmail;

    //LISTVIEW------------------------------------------------------
    @FXML
    private ListView<String> listViewNegozi;
    //METODI--------------------------------------------------------
    @FXML
    void ActionEntra(ActionEvent event) {
        buttonAssistenza.setVisible(true);
        buttonCassiere.setVisible(true);
        buttonCliente.setVisible(true);
        buttonCorriere.setVisible(true);
    }

    @FXML
    void ActionRegistrati(ActionEvent event) {
        buttonAssistenza.setVisible(false);
        buttonCassiere.setVisible(false);
        buttonCliente.setVisible(false);
        buttonCorriere.setVisible(false);
    }

    @FXML
    void AssistenzaScene(ActionEvent event) throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource("/Assistenza.fxml"));
        Scene scene = new Scene(view);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void CassiereScene(ActionEvent event) throws IOException {
        listViewNegozi.setVisible(true);
       // if(registrati==true)
         //   utente =new Cassieri(textNome.toString(),textCognome.toString(),textEmail.toString(),listViewNegozi.getSelectionModel().getSelectedItem());
        Parent view = FXMLLoader.load(getClass().getResource("/Cassiere.fxml"));
        Scene scene = new Scene(view);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void ClienteScene(ActionEvent event) throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource("/Cliente.fxml"));
        Scene scene = new Scene(view);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
    void CorriereScene(ActionEvent event) throws IOException {

        Parent view = FXMLLoader.load(getClass().getResource("/Corriere.fxml"));
        Scene scene = new Scene(view);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    private ObservableList<String> getListaNegozi(){
        ObservableList<String> lista = FXCollections.observableArrayList();
        //-- da finire
        return lista; }

    @FXML
    public void initialize() {
        buttonAssistenza.setVisible(false);
        buttonCassiere.setVisible(false);
        buttonCliente.setVisible(false);
        buttonCorriere.setVisible(false);
        listViewNegozi.getItems().setAll(getListaNegozi());
        listViewNegozi.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewNegozi.setVisible(false);
    }

}
