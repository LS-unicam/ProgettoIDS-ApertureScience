package it.unicam.cs.ids2021;
import it.unicam.cs.ids2021.consegne.GestoreOrdini;
import it.unicam.cs.ids2021.consegne.GestoreOrdiniI;
import it.unicam.cs.ids2021.consegne.Ordine;
import it.unicam.cs.ids2021.locker.GestoreLocker;
import it.unicam.cs.ids2021.locker.GestoreLockerI;
import it.unicam.cs.ids2021.locker.LockerI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class JavaFX extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Utenti.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static GestoreOrdiniI gOrdini = new GestoreOrdini(new HashSet<Ordine>());
    public static GestoreLockerI gLocker = new GestoreLocker(new ArrayList<LockerI>());


    public void stop() throws Exception {  super.stop(); }

//main----------------------------------------------------------------
    public static void main(String[] args) { Application.launch(args); }

}
