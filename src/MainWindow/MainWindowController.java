package MainWindow;


import TreeView.TreeViewController;
import Pdf.ErstellePDF;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainWindowController implements Initializable {

    TreeViewController treeViewController = new TreeViewController();

    @FXML
    private AnchorPane anchorPaneMainWindow;

    @FXML
    private ScrollPane scrollPaneMainWindow;

    @FXML
    private Window owner;

    @FXML
    private TextField textFieldProjektbezeichnung;

    @FXML
    private TextField textFieldProjektnummer;

    @FXML
    private TextField textFieldDatum;

    @FXML
    private TextField textfieldBauherrName;

    @FXML
    private TextField textfieldBauherrFirma;

    @FXML
    private TextField textfieldBauherrStraße;

    @FXML
    private TextField textfieldBauherrOrt;

    @FXML
    private TextField textfieldBauherrTelefon;

    @FXML
    private TextField textfieldBauherrEmail;

    @FXML
    private TextField textfieldBrandschutzName;

    @FXML
    private TextField textfieldBrandschutzFirma;

    @FXML
    private TextField textfieldBrandschutzStraße;

    @FXML
    private TextField textfieldBrandschutzOrt;

    @FXML
    private TextField textfieldBrandschutzTelefon;

    @FXML
    private TextField textfieldBrandschutzEmail;

    @FXML
    private AnchorPane anchorPaneTreeView;

    @FXML
    private Button buttonErstellePDF;

    @FXML
    private Label labelBBA;

    @FXML
    private Button buttonTestweiseBerechnen;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Methoden für Projekt-, Bauherr- und Brandschutzinformationen
     *
     * @return
     */

    public String getProjektbezeichnung() {
        return textFieldProjektbezeichnung.getText().toString();
    }

    public String getProjektnummer() {
        return textFieldProjektnummer.getText().toString();
    }

    public String getDatum() {
        return textFieldDatum.getText().toString();
    }

    public String getBauherrName() {
        return textfieldBauherrName.getText().toString();
    }

    public String getBauherrFirma() {
        return textfieldBauherrFirma.getText().toString();
    }

    public String getBauherrStraße() {
        return textfieldBauherrStraße.getText().toString();
    }

    public String getBauherrOrt() {
        return textfieldBauherrOrt.getText().toString();
    }

    public String getBauherrTelefon() {
        return textfieldBauherrTelefon.getText().toString();
    }

    public String getBauherrEmail() {
        return textfieldBauherrEmail.getText().toString();
    }

    public String getBrandschutzName() {
        return textfieldBrandschutzName.getText().toString();
    }

    public String getBrandschutzFirma() {
        return textfieldBrandschutzFirma.getText().toString();
    }

    public String getBrandschutzStraße() {
        return textfieldBrandschutzStraße.getText().toString();
    }

    public String getBrandschutzOrt() {
        return textfieldBrandschutzOrt.getText().toString();
    }

    public String getBrandschutzTelefon() {
        return textfieldBrandschutzTelefon.getText().toString();
    }

    public String getBrandschutzEmail() {
        return textfieldBrandschutzEmail.getText().toString();
    }

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Die AnchorPane mit dem TreeView etc. wird in das MainWindow geladen
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Node node;
        try {
            node = (Node) FXMLLoader.load(getClass().getResource("../TreeView/TreeView.fxml"));
            anchorPaneTreeView.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Erstellt und öffnet das Fenster Ergebnis.fxml
     *
     * @throws IOException
     */
    public void buttonErstellePDFClicked() throws IOException {


        //PDF Projektinformationen wird erstellt
        ErstellePDF neuePdf = new ErstellePDF(this);
        neuePdf.erstellePdf();
        System.out.println("PDF Projektinformationen Datei wurde erstellt");

        //Die erstellten PDF Dateien werden zu einer Datei zusammengefügt
        PDFMergerUtility PDFmerger = new PDFMergerUtility();

        //Der Dateipfad wird auf den Desktop gesetzt (Windows)
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String dateiPfad = desktopPath.replace("\\", "/");

        PDFmerger.setDestinationFileName(dateiPfad + "/Brandschutznachweis nach DIN 18230.pdf");

        File Projektinformationen = new File("C:\\Users\\Lukas\\IdeaProjects\\MasterArbeit 3.0\\Projektinformationen.pdf");
        File BBA1 = new File("C:\\Users\\Lukas\\IdeaProjects\\MasterArbeit 3.0\\BBA1.pdf");

        PDFmerger.addSource(Projektinformationen);
        PDFmerger.addSource(BBA1);

        PDFmerger.mergeDocuments();
        System.out.println("Dateien zusammengefügt");





        // Pop-Up "Ergebnis" wird geladen, ist im Moment nur Deko
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Ergebnis/Ergebnis.fxml"));
        Parent root1 = (Parent) loader.load();
        Stage stage = new Stage();

        stage.setTitle("Ergebnis");
        stage.setScene(new Scene(root1));
        stage.show();

    }

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

}
