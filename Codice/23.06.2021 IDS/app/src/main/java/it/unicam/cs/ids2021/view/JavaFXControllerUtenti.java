package it.unicam.cs.ids2021.view;

import it.unicam.cs.ids2021.JavaFX;
import it.unicam.cs.ids2021.consegne.GestoreOrdini;
import it.unicam.cs.ids2021.consegne.GestoreOrdiniI;
import it.unicam.cs.ids2021.consegne.Ordine;
import it.unicam.cs.ids2021.locker.GestoreLocker;
import it.unicam.cs.ids2021.locker.GestoreLockerI;
import it.unicam.cs.ids2021.locker.LockerI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JavaFXControllerUtenti {

    @FXML
    private Button buttonCassiere;

    @FXML
    private Button buttonCorriere;

    @FXML
    private Button buttonAssiestenza;

    @FXML
    private Button buttonCliente;

    @FXML
    void AssistenzaScene(ActionEvent event) throws IOException {
        Parent view= FXMLLoader.load(getClass().getResource("/Assistenza.fxml"));
        Scene scene = new Scene(view);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
    void CassiereScene(ActionEvent event) throws IOException {
        Parent view= FXMLLoader.load(getClass().getResource("/Cassiere.fxml"));
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
    void CorriereScene(ActionEvent event)  throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource("/Corriere.fxml"));
        Scene scene = new Scene(view);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }


    @FXML
    public void initialize (){}

}
