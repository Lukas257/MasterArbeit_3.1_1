package Fehlermeldungen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FehlerWTB1_1Controller {

    public void ladeFensterFehlerMeldungWTB1_1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Fehlermeldungen/FehlerWTB1_1.fxml"));
        Parent root1 = (Parent) loader.load();
        Stage stage = new Stage();

        stage.setTitle("Achtung");
        stage.setScene(new Scene(root1));
        stage.show();

    }
}
