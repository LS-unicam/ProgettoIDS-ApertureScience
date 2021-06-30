package it.unicam.cs.ids2021.view;

import it.unicam.cs.ids2021.JavaFX;
import it.unicam.cs.ids2021.consegne.GestoreOrdini;
import it.unicam.cs.ids2021.consegne.GestoreOrdiniI;
import it.unicam.cs.ids2021.consegne.Ordine;
import it.unicam.cs.ids2021.consegne.Ordini;
import it.unicam.cs.ids2021.locker.GestoreLocker;
import it.unicam.cs.ids2021.locker.GestoreLockerI;
import it.unicam.cs.ids2021.negozio.Prodotto;
import it.unicam.cs.ids2021.utenti.Utente;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.checkerframework.framework.qual.SubtypeOf;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaFXControllerCassiere {

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
    private Button buttonScegliOrdine;

    //TEXT FIELD----------------------------------------------------------------------
    @FXML
    private TextField textIdProdotto;

    @FXML
    private TextField textQuantita;

    @FXML
    private TextField textIdOrdine;

    //TABELLA NEGOZIO-----------------------------------------------------------------------
    @FXML
    private TableView<Map<Prodotto, Integer>> tabellaNegozio;

    @FXML
    private TableColumn<Map<Prodotto, Integer>, String> colonnaIdProdottoN;

    @FXML
    private TableColumn<Map<Prodotto, Integer>, String> colonnaProdottoN;

    //TABELLA SPESA---------------------------------------------------------------------

    @FXML
    private TableView<Map<Prodotto, Integer>> tabellaSpesa;

    @FXML
    private TableColumn<Map<Prodotto, Integer>, String> colonnaProdottoSpesa;

    @FXML
    private TableColumn<Map<Prodotto, Integer>, Integer> colonnaQuantitaSpesa;


    // Metodi----------------------------------------------------------------------------


    @FXML
    void ActionAggiungiProdotto(ActionEvent event) {
     //   ricavaOrdine().getMapProdotti().put()
    }

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
        Ordine o = new Ordini(new HashMap<Prodotto, Integer>());
        o.setIdOrdine(gO.generaId());
        gO.aggiungiOrdine(o);
        textIdOrdine.setText(o.getIdOrdine());
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


//INITIALIZE----------------------------------------------------------------------------------------------------------

    private Ordine ricavaOrdine(){
        return gO.cercaOrdine(textIdOrdine.getText());
    }

    private ObservableList<String> getNomeProdotto() {
        ObservableList<String> lista = FXCollections.observableArrayList();
        for (Prodotto p : ricavaOrdine().getMapProdotti().keySet()) {
            lista.add(p.getNome());
        }
        return lista;
    }

    public void initialize() {

        //inizializza tabella Negozio----------------------------------------------
        colonnaProdottoN.setCellValueFactory(new PropertyValueFactory<Map<Prodotto, Integer>, String>("nomeProdotto"));
        colonnaIdProdottoN.setCellValueFactory(new PropertyValueFactory<Map<Prodotto, Integer>, String>("nomeProdotto"));
        //inizializza tabella Spesa------------------------------------------------
        colonnaProdottoSpesa.setCellValueFactory(new PropertyValueFactory<Map<Prodotto, Integer>, String>("nomeProdotto"));
        colonnaQuantitaSpesa.setCellValueFactory(new PropertyValueFactory<Map<Prodotto, Integer>, Integer>("nomeProdotto"));

        //bottoni----------------------


        /* tabellaNegozio.setItems();
        colonnaDescrizione.setCellValueFactory(new PropertyValueFactory<Movimento, String>("descrizione"));
        colonnaUtente.setCellValueFactory(new PropertyValueFactory<Movimento, String>("utente"));
        colonnaMovimentoId.setCellValueFactory(new PropertyValueFactory<Movimento, String>("idMovimento"));
        colonnaListaTag.setCellValueFactory(new PropertyValueFactory<Movimento, String>("listaTag"));
        colonnaImporto.setCellValueFactory(new PropertyValueFactory<Movimento, Double>("importo"));
        colonnaUscita.setCellValueFactory(cell -> {
            String a;
            if (!cell.getValue().getUscita()) {
                a = "Uscita";
            } else a = "Entrata";
            return new SimpleStringProperty(a);
        });
        colonnaData.setCellValueFactory(new PropertyValueFactory<Movimento, LocalDate>("data"));
        tabellaMovimento.setItems(getlistaMovimento());
        data.setValue(LocalDate.now());
        listViewTag.getItems().setAll(getlistaTag());
        listViewTag.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        comboBoxUscita.getItems().setAll(getlistaUscita());
        comboBoxListaConto.getItems().setAll(getlistaConto());


        tabellaMovimento.setOnMouseClicked(new EventHandler<MouseEvent>() {
            //Una volta selezionato un elemento della tabella i campi si riempiono secondo i paramentri dell'elemento selezionato

            @Override
            public void handle(MouseEvent event) {
                if (tabellaMovimento.getSelectionModel().getSelectedItem() != null) {
                    comboBoxListaConto.getSelectionModel().clearSelection();
                    listViewTag.getSelectionModel().clearSelection();
                    Movimento selectedMovimento = tabellaMovimento.getSelectionModel().getSelectedItem();
                    if (!selectedMovimento.getUscita()) {
                        comboBoxUscita.getSelectionModel().select("Uscita");
                    } else {
                        comboBoxUscita.getSelectionModel().select("Entrata");
                    }
                    comboBoxListaConto.getSelectionModel().select((controller.c.c.contoDiUnMovimento(selectedMovimento.getIdMovimento())).getNome());
                    descrizione.setText(selectedMovimento.getDescrizione());
                    utente.setText(selectedMovimento.getUtente());
                    idMovimento.setText(selectedMovimento.getIdMovimento());
                    idMovimentoDaModificare.setText(selectedMovimento.getIdMovimento());
                    importoS.setText(String.valueOf(selectedMovimento.getImporto()));
                    data.setValue(selectedMovimento.getData());
                    for (int i = 0; i < selectedMovimento.getListaTag().size(); i++) {
                        listViewTag.getSelectionModel().select(selectedMovimento.getListaTag().get(i).toString());
                    }

                }
            }
        });*/
    }

}
