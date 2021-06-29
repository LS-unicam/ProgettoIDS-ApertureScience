package it.unicam.cs.ids2021.view;

import it.unicam.cs.ids2021.JavaFX;
import it.unicam.cs.ids2021.consegne.GestoreOrdini;
import it.unicam.cs.ids2021.consegne.GestoreOrdiniI;
import it.unicam.cs.ids2021.consegne.Ordini;
import it.unicam.cs.ids2021.locker.GestoreLocker;
import it.unicam.cs.ids2021.locker.GestoreLockerI;
import it.unicam.cs.ids2021.negozio.Prodotto;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class JavaFXControllerCassiere {
    GestoreOrdiniI gO = JavaFX.gOrdini;

    @FXML
    private TableView<Map<Prodotto,Integer>> tabellaProdotti;

    @FXML
    private TableColumn<Map<Prodotto,Integer>, Prodotto> colonnaProdotto;

    @FXML
    private TableColumn<Map<Prodotto,Integer>, Integer> colonnaQuantita;

    @FXML
    private Button buttonAggiungiProdotto;

    @FXML
    private Button buttonEliminaProdotto;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textIdProdotto;

    @FXML
    private TextField textPrezzo;

    @FXML
    private TextField textVolume;

    @FXML
    private TextField textQuantita;

    @FXML
    private ComboBox<?> comboBoxCategoria;

    @FXML
    private Button buttonCreaOrdine;

    @FXML
    private Button buttonMostraLocker;

    @FXML
    void ActionAggiungiProdotto(ActionEvent event) {
  //  gO.aggiungiProdotto(new Ordini());
    }

    @FXML
    void ActionCreaOrdine(ActionEvent event) {

    }

    @FXML
    void ActionEliminaProdotto(ActionEvent event) {

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

}
