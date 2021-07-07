package it.unicam.cs.ids2021.view;

import it.unicam.cs.ids2021.utenti.AssistenzaI;
import it.unicam.cs.ids2021.utenti.Cassiere;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class JavaFXControllerAssistenza implements Initializable {
    private AssistenzaI selectedAssistenza;
    //LABEL---------------------------------------------
        @FXML
        private Label cognomeLabel;

        @FXML
        private Label nomeLabel;

        public void initData(AssistenzaI utenteAssistenza) {
            selectedAssistenza = utenteAssistenza;
            nomeLabel.setText(selectedAssistenza.getNome());
            cognomeLabel.setText(selectedAssistenza.getCognome());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
