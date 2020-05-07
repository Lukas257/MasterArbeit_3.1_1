package Ergebnis;

import MainWindow.MainWindowController;
import MainWindow.PDF;
import Pdf.ErstellePDF;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ErgebnisController implements Initializable {

    @FXML
    private VBox vBoxErgebnis;

    @FXML
    private Button buttonDrucken;

    @FXML
    private Window owner;

    //PDF pdf = new PDF();

    public void buttonDruckenClick() throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
