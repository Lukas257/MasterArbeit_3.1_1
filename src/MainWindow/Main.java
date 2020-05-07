package MainWindow;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @FXML
    private ScrollPane root;
    public Stage window;

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/MainWindow/MainWindow.fxml"));
        this.root = loader.load();

        MainWindowController mwc = loader.getController();
        mwc.setMain(this);

        Scene scene = new Scene(root);
        window.setTitle("Brandschutznachweis nach DIN 18230");
        window.setScene(scene);
        window.show();
    }



    public static void main(String[] args) { launch(args); }
}
