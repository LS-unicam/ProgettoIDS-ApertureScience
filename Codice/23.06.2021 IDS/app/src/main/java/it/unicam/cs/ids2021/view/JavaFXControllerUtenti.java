package it.unicam.cs.ids2021.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

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
