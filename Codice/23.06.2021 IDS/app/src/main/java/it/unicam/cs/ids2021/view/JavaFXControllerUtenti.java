package it.unicam.cs.ids2021.view;

import it.unicam.cs.ids2021.JavaFX;

import it.unicam.cs.ids2021.consegne.Posizione;
import it.unicam.cs.ids2021.negozio.GestoreNegozioI;
import it.unicam.cs.ids2021.negozio.Negozi;
import it.unicam.cs.ids2021.negozio.Negozio;
import it.unicam.cs.ids2021.utenti.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.checkerframework.checker.signature.qual.ClassGetName;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class JavaFXControllerUtenti implements Initializable {
    GestoreNegozioI gN = JavaFX.gNegozio;
    Cassiere utenteCassiere;
    Corriere utenteCorriere;
    Cliente utenteCliente;
    AssistenzaI utenteAssistenza;
    int intUtente = 0;

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


    private void loadController(String nomeFile, FXMLLoader loader) {
        switch (nomeFile) {
            case "/Cassiere.fxml": {
                JavaFXControllerCassiere controller = loader.getController();
                controller.initData(utenteCassiere);
                break;
            }
            case "/Corriere.fxml": {
                JavaFXControllerCorriere controller = loader.getController();
                controller.initData(utenteCorriere);
                break;
            }
            case "/Cliente.fxml": {
                JavaFXControllerCliente controller = loader.getController();
                controller.initData(utenteCliente);
                break;
            }
            default:
                JavaFXControllerAssistenza controller = loader.getController();
                controller.initData(utenteAssistenza);
                break;
        }
    }

    /**
     * Cambia la scena  e inizializza i valori passando i dati da una scena all'altra
     *
     * @param event    evento che attiva il metodo
     * @param resource Il nome del file da caricare
     * @throws IOException
     */
    private void cambiaScena(ActionEvent event, String resource) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(resource));

        Parent view = loader.load();
        Scene scene = new Scene(view);

        loadController(resource, loader);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void ActionEntra(ActionEvent event) throws IOException {
       /* FXMLLoader loader = new FXMLLoader();
        if (cassiere == true) {
            cambiaScena(event, "/Cassiere.fxml");
        }
        if (corriere == true) {
            cambiaScena(event, "/Corriere.fxml");
        }
        if (assistenza == true) {
            cambiaScena(event, "/Assistenza.fxml");
        }
        if (cliente == true) {
            cambiaScena(event, "/Cliente.fxml");
        }*/

    }

    @FXML
    void ActionRegistrati(ActionEvent event) throws IOException {
        switch (intUtente) {
            case 1: {
                utenteCassiere = new Cassieri(textNome.getText(), textCognome.getText(), textEmail.getText(), gN.cercaNegozio(listViewNegozi.getSelectionModel().getSelectedItem()));
                cambiaScena(event, "/Cassiere.fxml");
                break;
            }
            case 2: {
                utenteCorriere = new Corrieri(textNome.getText(), textCognome.getText(), textEmail.getText());
                cambiaScena(event, "/Corriere.fxml");
                break;
            }
            case 3: {
                utenteCliente = new Clienti(textNome.getText(), textCognome.getText(), textEmail.getText());
                cambiaScena(event, "/Cliente.fxml");
                break;
            }
            case 4:
                utenteAssistenza= new Assistenza(textNome.getText(), textCognome.getText(), textEmail.getText());
                cambiaScena(event, "/Assistenza.fxml");
                break;
        }
    }

    @FXML
    void CassiereScene(ActionEvent event) throws IOException {
        listViewNegozi.setVisible(true);
        listViewNegozi.getSelectionModel().clearSelection();
        listViewNegozi.setItems(getListaNegozi());
        intUtente = 1;
    }

    @FXML
    void CorriereScene(ActionEvent event) throws IOException { intUtente = 2; }

    @FXML
    void ClienteScene(ActionEvent event) throws IOException { intUtente = 3; }

    @FXML
    void AssistenzaScene(ActionEvent event) throws IOException { intUtente = 4; }

    private ObservableList<String> getListaNegozi() {
        ObservableList<String> lista = FXCollections.observableArrayList();
        for (Negozio n : gN.getSetNegozi()) {
            lista.add(n.getNome());
        }
        return lista;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listViewNegozi.setVisible(false);
        listViewNegozi.getSelectionModel().clearSelection();
        listViewNegozi.setItems(getListaNegozi());
        listViewNegozi.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
}
