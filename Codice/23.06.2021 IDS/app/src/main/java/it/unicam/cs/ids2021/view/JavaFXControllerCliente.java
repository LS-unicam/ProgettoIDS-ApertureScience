package it.unicam.cs.ids2021.view;

import it.unicam.cs.ids2021.utenti.Cassiere;
import it.unicam.cs.ids2021.utenti.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class JavaFXControllerCliente implements Initializable{

    private Cliente selectedCliente;
//LABEL----------------------------------------------------------
    @FXML
    private Label cognomeLabel;

    @FXML
    private Label nomeLabel;

    public void initData(Cliente utenteCliente) {
        selectedCliente = utenteCliente;
        nomeLabel.setText(selectedCliente.getNome());
        cognomeLabel.setText(selectedCliente.getCognome());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
