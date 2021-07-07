package it.unicam.cs.ids2021.view;

import it.unicam.cs.ids2021.utenti.Cassiere;
import it.unicam.cs.ids2021.utenti.Corriere;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class JavaFXControllerCorriere implements Initializable {
    private Corriere selectedCorriere;
   //LABEL------------------------------------------------------
    @FXML
    private Label cognomeLabel;

    @FXML
    private Label nomeLabel;

    public void initData(Corriere utenteCorriere) {
      selectedCorriere = utenteCorriere;
      nomeLabel.setText(selectedCorriere.getNome());
      cognomeLabel.setText(selectedCorriere.getCognome());
     }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
