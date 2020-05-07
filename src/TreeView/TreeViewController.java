package TreeView;


import BBA.BBA;
import BBA.Umfassungsbauteil;
import BBA.VWAF;
import BBA.HWAF;
import BBA.Teilbereich;
import Fehlermeldungen.FehlerBBATableViewUmfassungsbauteileController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;



public class TreeViewController implements Initializable {


    @FXML
    private AnchorPane anchorPaneTreeViewInhalt;

    @FXML
    public TreeView<String> treeViewBBA;

    @FXML
    private AnchorPane anchorPaneTableView;

    @FXML
    private StackPane stackPaneTableView;

    @FXML
    private AnchorPane anchorPaneTableViewBBA1;

    @FXML
    private AnchorPane anchorPaneTableViewBBA2;

    @FXML
    private AnchorPane anchorPaneTableViewTB1_1;

    @FXML
    public Label labelTableViewBBA1;
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Objekte zur Erfassung der Grunddaten
     */

    @FXML
    private ChoiceBox<String> choiceBoxBTIBBA1;

    @FXML
    private TextField textFieldGrundflaecheBBA1;

    @FXML
    private TextField textFieldLagerguthoeheBBA1;

    @FXML
    private TextField textFieldmittlereHoeheBBA1;

    @FXML
    private ComboBox<String> comboBoxWerkfeuerwehrSchichstaerke;

    @FXML
    private CheckBox checkBoxWerkfeuerwehrHauptberuflich;

    @FXML
    private CheckBox checkBoxWerkfeuerwehrNebenberuflich;

    @FXML
    private CheckBox checkBoxLoeschanlagenNein;

    @FXML
    private CheckBox checkBoxLoeschanlagenHalbstationaer;

    @FXML
    private CheckBox checkBoxLoeschanlagenSelbsttaetig;

    @FXML
    private CheckBox checkBoxAutomatischeBrandmeldeanlangenJa;

    @FXML
    private CheckBox checkBoxAutomatischeBrandmeldeanlangenNein;

    @FXML
    private CheckBox checkBoxMehrgeschossigesGebaeude;

    @FXML
    private CheckBox checkBoxMehrereEbenen;

    @FXML
    private Label labelAnzahlDerGeschosse;

    @FXML
    private Label labelAnzahlDerEbenen;

    @FXML
    private TextField textFieldAnzahlderGeschosse;

    @FXML
    private TextField textFieldAnzahlderEbenen;

    @FXML
    private TextField textFieldHoehenlageFussboden;

    @FXML
    private CheckBox checkBoxHWAFUngleichmaessigVerteilt;
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Objekte zum Nachweis mit vorberechneten Werten
     */

    @FXML
    private CheckBox checkBoxUngeschuetzeBrandlast;

    @FXML
    private TextField textFieldUngeschuetzeBrandlast;

    @FXML
    private CheckBox checkBoxGeschuetzeBrandlast;

    @FXML
    private TextField textFieldGeschuetzeBrandlast;

    @FXML
    private CheckBox checkBoxHorizontaleWAO;

    @FXML
    private TextField textFieldHorizontaleWAO;

    @FXML
    private CheckBox checkBoxVertikaleWAO;

    @FXML
    private TextField textFieldVertikaleWAO;

    @FXML
    private CheckBox checkBoxUmrechnungsfaktorC;

    @FXML
    private TextField textFieldUmrechnungsfaktorC;

//----------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button buttonHinzufuegenUmfassungsbauteileBBA1;

    @FXML
    private Button buttonLoeschenUmfassungsbauteileBBA1;

    @FXML
    private TableView<Umfassungsbauteil> tableViewBBA1Umfassungsbauteile;

    @FXML
    private TableColumn<Umfassungsbauteil, String> tableColumnUmfassungsbauteileBBA1Bauteil;

    @FXML
    private TableColumn<Umfassungsbauteil, Double> tableColumnUmfassungsbauteileBBA1Flaeche;

    @FXML
    private TableColumn<Umfassungsbauteil, String> tableColumnUmfassungsbauteileBBA1Einflussgruppe;

    @FXML
    private TableColumn<Umfassungsbauteil, Double> tableColumnUmfassungsbauteileBBA1CFaktor;

    @FXML
    private ComboBox<String> comboBoxUmfassungsbauteleEinflussgruppeBBA1;

    @FXML
    private ComboBox<String> comboBoxVWAFBBA1LageInDerWand;

    @FXML
    private TextField textFieldUmfassungsbauteileBauteilBBA1;

    @FXML
    private TextField textFieldUmfassungsbauteileFlaecheBBA1;

//----------------------------------------------------------------------------------------------------------------------
    /**
     * Objekte in der TabPane VWAF für BBA1
     */

    @FXML
    private TableView<VWAF> tableViewBBA1VWAF;

    @FXML
    private TableColumn<VWAF, String>tableColumnVWAFBBA1Bauteil;

    @FXML
    private TableColumn<VWAF, String>tableColumnVWAFBBA1Anrechenbarkeit;

    @FXML
    private TableColumn<VWAF, String>tableColumnVWAFBBA1LageInDerWand;

    @FXML
    private TableColumn<VWAF, Integer> tableColumnVWAFBBA1Anzahl;

    @FXML
    private TableColumn<VWAF, Double>tableColumnVWAFBBA1FlaecheRohbau;

    @FXML
    private TextField textFieldVWAFBauteilBBA1;

    @FXML
    private ComboBox<String> comboBoxVWAFBBA1Anrechenbarkeit;

    @FXML
    private TextField textFieldVWAFAnzahlBBA1;
    @FXML
    private TextField textFieldVWAFFlaecheBBA1;

    @FXML
    private Button buttonHinzufuegenVWAFBBA1;

    @FXML
    private Button buttonLoeschenVWAFBBA1;
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Objekte in der TabPane HWAF für BBA1
     */

    @FXML
    private TabPane tabPaneBBA1;

    @FXML
    private Tab tabBBA1HorizontaleWAF;

    @FXML
    private TableView<HWAF> tableViewBBA1HWAF;

    @FXML
    private TableColumn<HWAF, String> tableColumnHWAFBBA1Bauteil;

    @FXML
    private TableColumn<HWAF, String> tableColumnHWAFBBA1Anrechenbarkeit;

    @FXML
    private TableColumn<HWAF, Integer> tableColumnHWAFBBA1Anzahl;

    @FXML
    private TableColumn<HWAF, Double> tableColumnHWAFBBA1FlaecheRohbau;

    @FXML
    private TextField textFieldHWAFBauteilBBA1;

    @FXML
    private ComboBox<String> comboBoxHWAFBBA1Anrechenbarkeit;

    @FXML
    private TextField textFieldHWAFAnzahlBBA1;

    @FXML
    private TextField textFieldHWAFFlaecheBBA1;

    @FXML
    private Button buttonHinzufuegenHWAFBBA1;

    @FXML
    private Button buttonLoeschenHWAFBBA1;


//----------------------------------------------------------------------------------------------------------------------
    /**
     * Objekte in der Tabpane HVAW für Teilbereich 1.1
     */

    @FXML
    private Label labelTableViewTB1_1;
    @FXML
    private TableView<HWAF> tableViewTB1_1HWAF;

    @FXML
    private TableColumn<HWAF, String> tableColumnHWAFTB1_1Bauteil;

    @FXML
    private TableColumn<HWAF, Double> tableColumnHWAFTB1_1Flaeche;

    @FXML
    private TextField textFieldHWAFBauteilTB1_1;

    @FXML
    private TextField textFieldHWAFFlaecheTB1_1;

    @FXML
    private Button buttonHinzufuegenHWAFTB1_1;

    @FXML
    private Button buttonLoeschenHWAFTB1_1;


//----------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button buttonBerechnungStarten;

    @FXML
    private Button buttonMaterialbibliothek;

    @FXML
    private Button buttonNutzungen;

//----------------------------------------------------------------------------------------------------------------------
    public BBA bba1 = new BBA();
    public Teilbereich tb1_1 = new Teilbereich();
//----------------------------------------------------------------------------------------------------------------------

    public void initialize(URL url, ResourceBundle resourceBundle) {

//----------------------------------------------------------------------------------------------------------------------

        /**
         * TreeView (Anfangsausgabe) wird erstellt
         */
        TreeItem<String> rootItem = new TreeItem<>("NeuesProjekt");

        treeViewBBA.setRoot(rootItem);
        treeViewBBA.setShowRoot(false);
        rootItem.setExpanded(true);

        /**
         * Manuelles hinzufügen der TreeItems, da sie nach Namen (bba1) unterschieden werden sollen,
         * nicht nach den später vergebenen Namen
         */
        TreeItem<String> bba1 = new TreeItem<>("Neuer BBA 1");
        TreeItem<String> bba2 = new TreeItem<>("Neuer BBA 2");
        TreeItem<String> bba3 = new TreeItem<>("Neuer BBA 3");
        TreeItem<String> bba4 = new TreeItem<>("Neuer BBA 4");
        TreeItem<String> bba5 = new TreeItem<>("Neuer BBA 5");

        rootItem.getChildren().addAll(bba1, bba2, bba3, bba4, bba5);

        //hinzufügen der TB zu BBA1
        TreeItem<String> tb_1_1 = new TreeItem<>("Neuer Teilbereich 1.1");
        TreeItem<String> tb_1_2 = new TreeItem<>("Neuer Teilbereich 1.2");
        TreeItem<String> tb_1_3 = new TreeItem<>("Neuer Teilbereich 1.3");
        TreeItem<String> tb_1_4 = new TreeItem<>("Neuer Teilbereich 1.4");
        TreeItem<String> tb_1_5 = new TreeItem<>("Neuer Teilbereich 1.5");

        bba1.getChildren().addAll(tb_1_1, tb_1_2, tb_1_3, tb_1_4, tb_1_5);

        //hinzufügen der TB zu BBA2
        TreeItem<String> tb_2_1 = new TreeItem<>("Neuer Teilbereich 2.1");
        TreeItem<String> tb_2_2 = new TreeItem<>("Neuer Teilbereich 2.2");
        TreeItem<String> tb_2_3 = new TreeItem<>("Neuer Teilbereich 2.3");
        TreeItem<String> tb_2_4 = new TreeItem<>("Neuer Teilbereich 2.4");
        TreeItem<String> tb_2_5 = new TreeItem<>("Neuer Teilbereich 2.5");

        bba2.getChildren().addAll(tb_2_1, tb_2_2, tb_2_3, tb_2_4, tb_2_5);

        //hinzufügen der TB zu BBA3
        TreeItem<String> tb_3_1 = new TreeItem<>("Neuer Teilbereich 3.1");
        TreeItem<String> tb_3_2 = new TreeItem<>("Neuer Teilbereich 3.2");
        TreeItem<String> tb_3_3 = new TreeItem<>("Neuer Teilbereich 3.3");
        TreeItem<String> tb_3_4 = new TreeItem<>("Neuer Teilbereich 3.4");
        TreeItem<String> tb_3_5 = new TreeItem<>("Neuer Teilbereich 3.5");

        bba3.getChildren().addAll(tb_3_1, tb_3_2, tb_3_3, tb_3_4, tb_3_5);

        //hinzufügen der TB zu BBA4
        TreeItem<String> tb_4_1 = new TreeItem<>("Neuer Teilbereich 4.1");
        TreeItem<String> tb_4_2 = new TreeItem<>("Neuer Teilbereich 4.2");
        TreeItem<String> tb_4_3 = new TreeItem<>("Neuer Teilbereich 4.3");
        TreeItem<String> tb_4_4 = new TreeItem<>("Neuer Teilbereich 4.4");
        TreeItem<String> tb_4_5 = new TreeItem<>("Neuer Teilbereich 4.5");

        bba4.getChildren().addAll(tb_4_1, tb_4_2, tb_4_3, tb_4_4, tb_4_5);

        //hinzufügen der TB zu BBA5
        TreeItem<String> tb_5_1 = new TreeItem<>("Neuer Teilbereich 5.1");
        TreeItem<String> tb_5_2 = new TreeItem<>("Neuer Teilbereich 5.2");
        TreeItem<String> tb_5_3 = new TreeItem<>("Neuer Teilbereich 5.3");
        TreeItem<String> tb_5_4 = new TreeItem<>("Neuer Teilbereich 5.4");
        TreeItem<String> tb_5_5 = new TreeItem<>("Neuer Teilbereich 5.5");

        bba5.getChildren().addAll(tb_5_1, tb_5_2, tb_5_3, tb_5_4, tb_5_5);
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
        /**
         * Anfangsausgabe der TableViews wird festgelegt
         * TableView für BBA1 ist sichtbar
         */
        anchorPaneTableViewBBA1.setVisible(true);
        anchorPaneTableViewBBA2.setVisible(false);
        anchorPaneTableViewTB1_1.setVisible(false);

        /**
         * Setzt die, in der TreeView gewählte, TableView sichtbar,
         * alle anderen werden auf nicht sichtbar gesetzt
         */
        treeViewBBA.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // BBA 1 TableView wird sichtbar
            if (newValue != null && newValue != oldValue && newValue.equals(bba1)) {
                anchorPaneTableViewBBA1.setVisible(true);
                anchorPaneTableViewBBA2.setVisible(false);
                anchorPaneTableViewTB1_1.setVisible(false);
            }

            // BBA 2 Tableview wird sichtbar
            else if (newValue != null && newValue != oldValue && newValue.equals(bba2)) {
                anchorPaneTableViewBBA1.setVisible(false);
                anchorPaneTableViewBBA2.setVisible(true);
                anchorPaneTableViewTB1_1.setVisible(false);
            }

            // Teilbereich 1.1 Tableview wird sichtbar
            else if (newValue != null && newValue != oldValue && newValue.equals(tb_1_1)) {
                anchorPaneTableViewBBA1.setVisible(false);
                anchorPaneTableViewBBA2.setVisible(false);
                anchorPaneTableViewTB1_1.setVisible(true);
            }
        });

        treeViewBBA.setEditable(true);
        treeViewBBA.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            @Override
            public TreeCell<String> call(TreeView<String> p) {
                return new TextFieldTreeCellImpl();
            }
        });

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
        /**
         * ChoiceBoxen Brandschutztechnische Infrastruktur werden initialisiert
         */
        choiceBoxBTIBBA1.getItems().add("K 1");
        choiceBoxBTIBBA1.getItems().add("K 2");
        choiceBoxBTIBBA1.getItems().add("K 3.1");
        choiceBoxBTIBBA1.getItems().add("K 3.2");
        choiceBoxBTIBBA1.getItems().add("K 3.3");
        choiceBoxBTIBBA1.getItems().add("K 3.4");
        choiceBoxBTIBBA1.getItems().add("K 4");

//----------------------------------------------------------------------------------------------------------------------
        comboBoxWerkfeuerwehrSchichstaerke.getItems().add("keine");
        comboBoxWerkfeuerwehrSchichstaerke.getItems().add("1 Staffel (6)");
        comboBoxWerkfeuerwehrSchichstaerke.getItems().add("1 Gruppe (9)");
        comboBoxWerkfeuerwehrSchichstaerke.getItems().add("2 Staffeln (12)");
        comboBoxWerkfeuerwehrSchichstaerke.getItems().add("3 Staffeln (18)");
        comboBoxWerkfeuerwehrSchichstaerke.getItems().add("4 Staffeln (24)");
        comboBoxWerkfeuerwehrSchichstaerke.setPromptText("Schichtstärke (Personen)");

//----------------------------------------------------------------------------------------------------------------------

        /**
         * TableView Umfassungsbauteile BBA1
         */
        tableColumnUmfassungsbauteileBBA1Bauteil.setCellValueFactory(new PropertyValueFactory<>("nameUmfassungsbauteil"));
        tableColumnUmfassungsbauteileBBA1Flaeche.setCellValueFactory(new PropertyValueFactory<>("flaecheUmfassungsbauteil"));
        tableColumnUmfassungsbauteileBBA1Einflussgruppe.setCellValueFactory(new PropertyValueFactory<>("einflussgruppeUmfassungbauteile"));
        tableColumnUmfassungsbauteileBBA1CFaktor.setCellValueFactory(new PropertyValueFactory<>("cFaktor"));
        tableViewBBA1Umfassungsbauteile.setPlaceholder(new Label("Fügen Sie Umfassungsbauteile hinzu!"));

        /**
         * TableView Vertikale Wärmeabzugsflächen BBA1
         */
        tableColumnVWAFBBA1Bauteil.setCellValueFactory(new PropertyValueFactory<>("nameVWAF"));
        tableColumnVWAFBBA1Anrechenbarkeit.setCellValueFactory(new PropertyValueFactory<>("anrechenbarkeit"));
        tableColumnVWAFBBA1LageInDerWand.setCellValueFactory(new PropertyValueFactory<>("lageInDerWand"));
        tableColumnVWAFBBA1Anzahl.setCellValueFactory(new PropertyValueFactory<>("anzahl"));
        tableColumnVWAFBBA1FlaecheRohbau.setCellValueFactory(new PropertyValueFactory<>("flaecheRohbauEinzeln"));
        tableViewBBA1VWAF.setPlaceholder(new Label("Fügen Sie vertikale Wärmeabzugsflächen hinzu!"));

        /**
         * ComboBox Anrechenbarkeit bei vertikalen Wärmeabzugsöffnungen wird initialisiert
         */
        comboBoxVWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 1");
        comboBoxVWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 2");
        comboBoxVWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 3");
        comboBoxVWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 4");
        comboBoxVWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 5 (1)");
        comboBoxVWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 5 (2)");
        comboBoxVWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 6");
        comboBoxVWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 7");

        /**
         * ComboBox Lage in der Wand bei vertikalen Wärmeabzugsöfnnungen wird initialisiert
         */
        comboBoxVWAFBBA1LageInDerWand.getItems().add("obere Hälfte");
        comboBoxVWAFBBA1LageInDerWand.getItems().add("untere Hälfte");

        /**
         * TableView HWAF BBA1
         */
        tableColumnHWAFBBA1Bauteil.setCellValueFactory(new PropertyValueFactory<>("nameHWAF"));
        tableColumnHWAFBBA1Anrechenbarkeit.setCellValueFactory(new PropertyValueFactory<>("anrechenbarkeit"));
        tableColumnHWAFBBA1Anzahl.setCellValueFactory(new PropertyValueFactory<>("anzahl"));
        tableColumnHWAFBBA1FlaecheRohbau.setCellValueFactory(new PropertyValueFactory<>("flaecheRohbauEinzeln"));
        tableViewBBA1HWAF.setPlaceholder(new Label("Fügen Sie horizontale Wärmeabzugsflächen hinzu!"));

        comboBoxHWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 1");
        comboBoxHWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 2");
        comboBoxHWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 3");
        comboBoxHWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 4");
        comboBoxHWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 5 (1)");
        comboBoxHWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 5 (2)");
        comboBoxHWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 6");
        comboBoxHWAFBBA1Anrechenbarkeit.getItems().add("Tabelle E.3 Zeile 7");

        /**
         *TableView Horizontale Wärmeabzugsflächen für TB1_1
         */
        tableColumnHWAFTB1_1Bauteil.setCellValueFactory(new PropertyValueFactory<>("nameHWAF"));
        tableColumnHWAFTB1_1Flaeche.setCellValueFactory(new PropertyValueFactory<>("flaecheHWAF"));
        tableViewTB1_1HWAF.setPlaceholder(new Label("Fügen Sie horizontale Wärmeabzugsflächen hinzu!"));

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
        // großes i
        comboBoxUmfassungsbauteleEinflussgruppeBBA1.getItems().addAll("I", "II", "III");
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
    //Ende der initialize-Methode
    }
//----------------------------------------------------------------------------------------------------------------------
    //Entfernen und Hinzufuegen des Reiter "HWAF" zum BBA, abhängig von Checkbox
    public void setCheckBoxHWAFUngleichmaessigVerteilt() {
        if (checkBoxHWAFUngleichmaessigVerteilt.isSelected()) {
            tabPaneBBA1.getTabs().remove(tabBBA1HorizontaleWAF);
        } else {
            tabPaneBBA1.getTabs().add(tabBBA1HorizontaleWAF);
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Methoden zum Hinzufügen bzw. Löschen von Umfassungsbauteilen zu BBA1
     * @throws IOException
     */
    public void setButtonHinzufuegenUmfassungsbauteileBBA1() throws IOException {

        if (textFieldUmfassungsbauteileBauteilBBA1.getText().isEmpty() || textFieldUmfassungsbauteileFlaecheBBA1.getText().isEmpty()
                || comboBoxUmfassungsbauteleEinflussgruppeBBA1.getSelectionModel().isEmpty()) {

            //Fehlermeldung wird geladen
            FehlerBBATableViewUmfassungsbauteileController controller = new FehlerBBATableViewUmfassungsbauteileController();
            controller.ladeFensterFehlerMeldung();

        } else {
            Umfassungsbauteil umfassungsbauteil = new Umfassungsbauteil();
            umfassungsbauteil.setNameUmfassungsbauteil(textFieldUmfassungsbauteileBauteilBBA1.getText());
            umfassungsbauteil.setFlaecheUmfassungsbauteil(Double.parseDouble(textFieldUmfassungsbauteileFlaecheBBA1.getText()));
            umfassungsbauteil.setEinflussgruppeUmfassungbauteile(comboBoxUmfassungsbauteleEinflussgruppeBBA1.getValue());

            if (comboBoxUmfassungsbauteleEinflussgruppeBBA1.getValue().equals("I")) {
                umfassungsbauteil.setCFaktor(0.15);
            } else if (comboBoxUmfassungsbauteleEinflussgruppeBBA1.getValue().equals("II")) {
                umfassungsbauteil.setCFaktor(0.20);
            } else if (comboBoxUmfassungsbauteleEinflussgruppeBBA1.getValue().equals("III")) {
                umfassungsbauteil.setCFaktor(0.25);
            }

            tableViewBBA1Umfassungsbauteile.getItems().add(umfassungsbauteil);

            bba1.umfassungsbauteileList.add(umfassungsbauteil);

            textFieldUmfassungsbauteileBauteilBBA1.clear();
            textFieldUmfassungsbauteileFlaecheBBA1.clear();
            comboBoxUmfassungsbauteleEinflussgruppeBBA1.getSelectionModel().select(-1);

            //zum Test
            for (int i = 0; i < bba1.umfassungsbauteileList.size(); i++) {
                System.out.println(bba1.umfassungsbauteileList.get(i).getNameUmfassungsbauteil());
            }
            System.out.println("");
            System.out.println("");

        }
    }

    public void setButtonLoeschenUmfassungsbauteileBBA1() {

        int Index = tableViewBBA1Umfassungsbauteile.getSelectionModel().getSelectedIndex();
        bba1.umfassungsbauteileList.remove(bba1.umfassungsbauteileList.get(Index));

        tableViewBBA1Umfassungsbauteile.getItems().removeAll(tableViewBBA1Umfassungsbauteile.getSelectionModel().getSelectedItem());

        //zum Test
        for (int i = 0; i < bba1.umfassungsbauteileList.size(); i++) {
            System.out.println(bba1.umfassungsbauteileList.get(i).getNameUmfassungsbauteil());
        }
        System.out.println("Ende der Liste");
        System.out.println("");

    }

    /**
     * Methoden zum Hinzufügen bzw. Löschen von VWAF zu BBA1
     */
    public void setButtonHinzufuegenVWAFBBA1() throws IOException {


        if (textFieldVWAFBauteilBBA1.getText().isEmpty() || textFieldVWAFFlaecheBBA1.getText().isEmpty() || textFieldVWAFAnzahlBBA1.getText().isEmpty()
            || comboBoxVWAFBBA1Anrechenbarkeit.getSelectionModel().isEmpty() || comboBoxVWAFBBA1LageInDerWand.getSelectionModel().isEmpty()) {

            //Fehlermeldung wird geladen
            FehlerBBATableViewUmfassungsbauteileController controller = new FehlerBBATableViewUmfassungsbauteileController();
            controller.ladeFensterFehlerMeldung();

        } else {
            VWAF vwaf = new VWAF();
            vwaf.setNameVWAF(textFieldVWAFBauteilBBA1.getText());
            vwaf.setAnrechenbarkeit(comboBoxVWAFBBA1Anrechenbarkeit.getValue());
            vwaf.setLageInDerWand(comboBoxVWAFBBA1LageInDerWand.getValue());
            vwaf.setAnzahl(Integer.parseInt(textFieldVWAFAnzahlBBA1.getText()));
            vwaf.setFlaecheRohbauEinzeln(Double.parseDouble(textFieldVWAFFlaecheBBA1.getText()));

            tableViewBBA1VWAF.getItems().add(vwaf);
            //Fläche wird der ArrayList von BBA1 hinzugefügt
            bba1.vwafList.add(vwaf);

            textFieldVWAFBauteilBBA1.clear();
            comboBoxVWAFBBA1Anrechenbarkeit.getSelectionModel().select(-1);
            comboBoxVWAFBBA1LageInDerWand.getSelectionModel().select(-1);
            textFieldVWAFAnzahlBBA1.clear();
            textFieldVWAFFlaecheBBA1.clear();

            //zum Test
            for (int i = 0; i < bba1.vwafList.size(); i++) {
                System.out.println(bba1.vwafList.get(i).getNameVWAF());
            }
            System.out.println("");
            System.out.println("");

        }
    }

    public void setButtonLoeschenVWAFBBA1() {

        //Index wird bestimmt und entsprechnde VWAF aus der ArrayList geloescht
        int Index = tableViewBBA1VWAF.getSelectionModel().getSelectedIndex();
        bba1.vwafList.remove(bba1.vwafList.get(Index));

        //gewaehlte Reihe wird aus der TableView geloescht
        tableViewBBA1VWAF.getItems().removeAll(tableViewBBA1VWAF.getSelectionModel().getSelectedItem());

        //zum Test
        for (int i = 0; i < bba1.vwafList.size(); i++) {
            System.out.println(bba1.vwafList.get(i).getNameVWAF());
        }
        System.out.println("Ende der Liste");
        System.out.println("");
    }

    public void setButtonHinzufuegenHWAFBBA1() throws IOException {

        if (textFieldHWAFBauteilBBA1.getText().isEmpty() || comboBoxHWAFBBA1Anrechenbarkeit.getSelectionModel().isEmpty() ||
            textFieldHWAFAnzahlBBA1.getText().isEmpty() || textFieldHWAFFlaecheBBA1.getText().isEmpty()) {

            FehlerBBATableViewUmfassungsbauteileController controller = new FehlerBBATableViewUmfassungsbauteileController();
            controller.ladeFensterFehlerMeldung();

        } else {
            HWAF hwaf = new HWAF();
            hwaf.setNameHWAF(textFieldHWAFBauteilBBA1.getText());
            hwaf.setAnrechenbarkeit(comboBoxHWAFBBA1Anrechenbarkeit.getValue());
            hwaf.setAnzahl(Integer.parseInt(textFieldHWAFAnzahlBBA1.getText()));
            hwaf.setFlaecheRohbauEinzeln(Double.parseDouble(textFieldHWAFFlaecheBBA1.getText()));

            tableViewBBA1HWAF.getItems().add(hwaf);
            // Flaeche wird der ArrayList HWAF hinzugefügt
            bba1.hwafList.add(hwaf);

            textFieldHWAFBauteilBBA1.clear();
            comboBoxHWAFBBA1Anrechenbarkeit.getSelectionModel().select(-1);
            textFieldHWAFAnzahlBBA1.clear();
            textFieldHWAFFlaecheBBA1.clear();

            //zum Test
            for (int i = 0; i < bba1.hwafList.size(); i++) {
                System.out.println(bba1.hwafList.get(i).getNameHWAF());
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public void setButtonLoeschenHWAFBBA1() {

        //Index wird bestimmt und entsprechnde VWAF aus der ArrayList geloescht
        int Index = tableViewBBA1HWAF.getSelectionModel().getSelectedIndex();
        bba1.hwafList.remove(bba1.hwafList.get(Index));

        //gewaehlte Reihe wird aus der TableView geloescht
        tableViewBBA1HWAF.getItems().removeAll(tableViewBBA1HWAF.getSelectionModel().getSelectedItem());

        //zum Test
        for (int i = 0; i < bba1.hwafList.size(); i++) {
            System.out.println(bba1.hwafList.get(i).getNameHWAF());
        }
        System.out.println("Ende der Liste");
        System.out.println("");
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Methoden um Label und TextFelder für Anzahl der Geschosse und Ebenen bei den Grunddaten des BBA sichtbar zu machen
     */

    public void setCheckBoxMehrgeschossigesGebaeude() {
        if (checkBoxMehrgeschossigesGebaeude.isSelected()) {
            labelAnzahlDerGeschosse.setVisible(true);
            textFieldAnzahlderGeschosse.setVisible(true);
        } else {
            labelAnzahlDerGeschosse.setVisible(false);
            textFieldAnzahlderGeschosse.setVisible(false);
        }
    }

    public void setCheckBoxMehrereEbenen() {
        if (checkBoxMehrereEbenen.isSelected()) {
            labelAnzahlDerEbenen.setVisible(true);
            textFieldAnzahlderEbenen.setVisible(true);
        } else {
            labelAnzahlDerEbenen.setVisible(false);
            textFieldAnzahlderEbenen.setVisible(false);
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Die Methode zur Nachweisführung (Berechnung)
     * @throws IOException
     */

    public void buttonBerechnungStartenClicked() throws IOException{

        System.out.println("Berechnung gestartet");
        System.out.println("");
        System.out.println("");

//----------------------------------------------------------------------------------------------------------------------
        /**
         * Setzen der Grunddaten anhand der Nutzereingaben
         */
        bba1.setGrundflaeche(Double.parseDouble(textFieldGrundflaecheBBA1.getText()));

        bba1.setMittlereHoehe(Double.parseDouble(textFieldmittlereHoeheBBA1.getText()));

        bba1.setbTI(choiceBoxBTIBBA1.getValue());

        if (checkBoxWerkfeuerwehrHauptberuflich.isSelected()){
            bba1.setWerkfeuerwehrHauptberuflich(true);
        } else if (checkBoxWerkfeuerwehrNebenberuflich.isSelected()) {
            bba1.setWerkfeuerwehrHauptberuflich(false);
        } else {
            bba1.setWerkfeuerwehrHauptberuflich(false);
        }

        bba1.setWerkfeuerwehrschichtstaerke(comboBoxWerkfeuerwehrSchichstaerke.getValue());

        if (checkBoxAutomatischeBrandmeldeanlangenJa.isSelected()) {
            bba1.setAutomatischeBrandmeldeanlagen(true);
        } else if(checkBoxAutomatischeBrandmeldeanlangenNein.isSelected()) {
            bba1.setAutomatischeBrandmeldeanlagen(false);
        } else {
            bba1.setAutomatischeBrandmeldeanlagen(false);
        }

        if (checkBoxLoeschanlagenNein.isSelected()) {
            bba1.setLoeschanlagenVorhanden(false);
            bba1.setSelbsttaetigeLoeschanlageVorhanden(false);
        } else if(checkBoxLoeschanlagenHalbstationaer.isSelected()) {
            bba1.setLoeschanlagenVorhanden(true);
            bba1.setSelbsttaetigeLoeschanlageVorhanden(false);
        } else if (checkBoxLoeschanlagenSelbsttaetig.isSelected()) {
            bba1.setLoeschanlagenVorhanden(true);
            bba1.setSelbsttaetigeLoeschanlageVorhanden(true);
        }

        if(checkBoxMehrgeschossigesGebaeude.isSelected()) {
            bba1.setAnzahlGeschosse(Integer.parseInt(textFieldAnzahlderGeschosse.getText()));
        }

        if (checkBoxMehrereEbenen.isSelected()) {
            bba1.setAnzahlEbenen(Integer.parseInt(textFieldAnzahlderEbenen.getText()));
        }

        bba1.setHoehenLageFussboden(Double.parseDouble(textFieldHoehenlageFussboden.getText()));

        bba1.setEingeschossig(!(checkBoxMehrgeschossigesGebaeude.isSelected()));

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

        /**
         * Setzen der vorberechneten Werte anhand der Nutzereingaben
         */
        //TODO
        // Wenn die Checkboxen nicht genutzt werden müssen die Werte anders gesetzt werden!

        if (checkBoxUngeschuetzeBrandlast.isSelected()) {
            bba1.setUngeschuetzteBrandlastGesamt(Double.parseDouble(textFieldUngeschuetzeBrandlast.getText()));
        }

        if (checkBoxGeschuetzeBrandlast.isSelected()) {
            bba1.setGeschuetzteBrandlastGesamt(Double.parseDouble(textFieldGeschuetzeBrandlast.getText()));
        }

        if (checkBoxHorizontaleWAO.isSelected()) {
            bba1.setHorizontaleAbzugsflächenGesamt(Double.parseDouble(textFieldHorizontaleWAO.getText()));
        }

        if (checkBoxVertikaleWAO.isSelected()) {
            bba1.setVertikaleAbzugsflächenGesamt(Double.parseDouble(textFieldVertikaleWAO.getText()));
        }

        if (checkBoxUmrechnungsfaktorC.isSelected()) {
            bba1.setcGlobal(Double.parseDouble(textFieldUmrechnungsfaktorC.getText()));
        }
//----------------------------------------------------------------------------------------------------------------------
        /**
         * Setzen der Werte anhand der Eingabe in die Tabelle (hor. WAÖ sind gleichmäßig verteilt), wenn die CheckBoxen nicht ausgewählt sind
         */

        if (!checkBoxVertikaleWAO.isSelected()) {
            bba1.berechneVWAFAusTabelle();
            bba1.berechneVWAFObenAusTabelle();
        }

        if(!checkBoxUmrechnungsfaktorC.isSelected()) {
            bba1.berechneCresAusTabelle();
        }

        if (!checkBoxHorizontaleWAO.isSelected() && !checkBoxHWAFUngleichmaessigVerteilt.isSelected()) {
            bba1.berechneHWAFAusTabelle();
        }

//----------------------------------------------------------------------------------------------------------------------

        bba1.fuehreGlobalenNachweis();

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

        /**
         * Start der Berechnung für BBA 1
         */
//----------------------------------------------------------------------------------------------------------------------

        //Liste der Umfassungsbauteile von BBA1 wird erstellt
//        ObservableList<Umfassungsbauteil> umfassungsbauteilBBA1Liste = tableViewBBA1Umfassungsbauteile.getItems();
//
//        //liefert Summe c_i * A_i der Umfassungsbauteile von BBA1
//        double summeCiAiBBA1 = 0;
//        for (Umfassungsbauteil umfassungsbauteil : umfassungsbauteilBBA1Liste) {
//            umfassungsbauteil.cFaktorFlaeche();
//            System.out.println(umfassungsbauteil.cFaktorFlaeche());
//
//            summeCiAiBBA1 = summeCiAiBBA1 + umfassungsbauteil.cFaktorFlaeche();
//            System.out.println(summeCiAiBBA1);
//        }
//
//        //liefert Summe A_i der Umfassungsbauteile von BBA1
//        double summeAiBBA1 = 0;
//        for (Umfassungsbauteil umfassungsbauteilFlaeche : tableViewBBA1Umfassungsbauteile.getItems()) {
//            summeAiBBA1 = summeAiBBA1 + umfassungsbauteilFlaeche.getFlaecheUmfassungsbauteil();
//        }
//        System.out.println("Gesamtfläche der Umfassungsbauteile: " + summeAiBBA1);
//
//        //liefert c_resultierend der eingegebenen Umfassungsbauteile
//        double cResBBA1= summeCiAiBBA1 / summeAiBBA1;
////        bba1.setcRes(cResBBA1);
//
//        System.out.println("C_res BBA1 = " + cResBBA1);
//
////----------------------------------------------------------------------------------------------------------------------
//        //Liste der vertikalen Wärmeabzugsflächen für BBA1 wird erstellt
//        ObservableList<VWAF> vwafBBA1Liste = tableViewBBA1VWAF.getItems();
//
//        //Summe der Flächen der VWAF von BBA1 wird berechnet
//        double summeAiVWAFBBA1 = 0;
//        for (VWAF vwaf : vwafBBA1Liste) {
//            summeAiVWAFBBA1 = summeAiVWAFBBA1 + vwaf.getFlaecheVWAF();
//        }
//        System.out.println("Gesamtfläche der vertikalen WAF: " + summeAiVWAFBBA1);
//
//        //av von BBA1 wird berechnet
//        double avBBA1 = summeAiVWAFBBA1/bba1.getGrundflaeche();
//
//        //prüft und legt av nach DIN 18230 fest
//        //bba1.pruefeAv();
//
//
//        System.out.println("a_v von BBA1 = " + avBBA1);
////----------------------------------------------------------------------------------------------------------------------
//
//        //Liste der horizontalen Wärmeabzugsflächen für TB1_1 wird erstellt
//        ObservableList<HWAF> hwafTB1_1Liste = tableViewTB1_1HWAF.getItems();
//
//        //Summe der Flächen der HWAF von TB1_1 wird berechnet
//        double summeAiHWAFTB1_1 = 0;
//        for (HWAF hwaf : hwafTB1_1Liste) {
//            summeAiHWAFTB1_1 = summeAiHWAFTB1_1 + hwaf.getFlaecheHWAF();
//        }

//        //ah von TB1_1 berechnen
//        double ahTB1_1 = summeAiHWAFTB1_1/bba1.getGrundflaeche();
//        bba1.pruefeAh();
//        bba1.setAhTB1(ahTB1_1);
//
//        System.out.println("a_h von TB1_1 = " + bba1.getAhTB1());
//
//        bba1.beta_w();
//        bba1.pruefeBeta_w();
//        System.out.println(bba1.beta_w());
//
//        bba1.alpha_w();
//        System.out.println(bba1.alpha_w());
//
//        bba1.w_o();
//        bba1.pruefeW0();
//        System.out.println(bba1.w_o());
//
//        bba1.w();
//        bba1.pruefeW();
//        System.out.println(bba1.w());


//----------------------------------------------------------------------------------------------------------------------

        // Ende der Berechnung für BBA1
//----------------------------------------------------------------------------------------------------------------------

        //TODO PDF Datei überarbeiten!
        //erstellt die PDF Datei für BBA 1
        erstellePdfBBA1();

//----------------------------------------------------------------------------------------------------------------------

    // Ende der Methode zur Berechnung
    }

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Klasse um die Namensänderung und
     * das Hinzufügen neuer TreeItems zu ermöglichen
     */
    private final class TextFieldTreeCellImpl extends TreeCell<String> {

        private TextField textField;
        private ContextMenu contextMenu = new ContextMenu();

        public TextFieldTreeCellImpl() {

            //Context Menu wird erstellt
            MenuItem entfernenMenu = new MenuItem("Entfernen");
            contextMenu.getItems().addAll(entfernenMenu);
            treeViewBBA.setContextMenu(contextMenu);

            //entfernt den gewählten BBA oder TB aus der TreeView
            entfernenMenu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    //für das Löschen aus der TreeView
                    TreeItem entfernenItem = (TreeItem)treeViewBBA.getSelectionModel().getSelectedItem();
                    boolean remove = entfernenItem.getParent().getChildren().remove(entfernenItem);
                }
            });
        }

        @Override
        public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText((String) getItem());
            setGraphic(getTreeItem().getGraphic());
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(getTreeItem().getGraphic());
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setOnKeyReleased(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(textField.getText());

                        //das Label des entsprechenden BBA's wird auf den eingegebenen Namen gesetzt
                        System.out.println("EingabeTaste gedrückt, Name geändert");

                        //es wird der Index des ausgewählten BBA's bzw. TB's bestimmt
                        TreeItem<String> aktuelleAuswahl = treeViewBBA.getSelectionModel().getSelectedItem();
                        TreeItem<String> parentAktuelleAuswahl = treeViewBBA.getSelectionModel().getSelectedItem().getParent();
                        TreeItem<String> grandparentAktuelleAuswahl = parentAktuelleAuswahl.getParent();
                        int index = aktuelleAuswahl.getParent().getChildren().indexOf(aktuelleAuswahl);
                        int indexParent = parentAktuelleAuswahl.getParent().getChildren().indexOf(parentAktuelleAuswahl);


                        //BBA1 (Parent ist der Root, Parent des Parent ist also null)
                        //Index 0 entspricht BBA1, Index 1 entspricht BBA2 usw.

                        //Es müssen noch alle anderen BBA's und Teilbereiche eingearbeitet werden!

                        if (index == 0 && parentAktuelleAuswahl.getParent() == null) {
                            labelTableViewBBA1.setText(textField.getText());
                            bba1.setName(textField.getText());

                          //TB1_1 Index = 0, Index vom Parent (BBA1) = 0, Parent vom Parent vom Parent = 0
                        } else if (index == 0 && indexParent == 0 && grandparentAktuelleAuswahl.getParent() == null){
                            labelTableViewTB1_1.setText(textField.getText());
                            tb1_1.setNameTB(textField.getText());

                        } else {
                            System.out.println("Name != bba1");
                        }

                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }

// Ende der TreeCell-Klasse die die Umbenennung möglich macht
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
    // Es folgen die Methoden die die PDF Dateien zu den BBA's 1-5 erstellen


    /**
     * erstellt die PDF-Datei zu BBA1 und den zugehörigen Teilbereichen
     * @throws IOException
     */
    public void erstellePdfBBA1() throws IOException {

        // Create a document and add a page to it
        PDDocument documentBBA1 = new PDDocument();
        PDPage page = new PDPage();
        documentBBA1.addPage( page );

        // Create a new font object selecting one of the PDF base fonts
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont text = PDType1Font.HELVETICA;

        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream contentStream = new PDPageContentStream(documentBBA1, page);

//------------------------------------------------------------------------------------------Überschrift-Anfang: Name BBA

        contentStream.beginText();
        contentStream.setFont( font, 14 );
        contentStream.moveTextPositionByAmount( 50, 750 );
        contentStream.drawString( "Brandbekämpfungsabschnitt 1: " + bba1.getNameBBA());
        contentStream.endText();

//------------------------------------------------------------------------------------------Überschrift-Ende: Namme BBA

        contentStream.beginText();
        contentStream.setFont( font, 13 );
        contentStream.moveTextPositionByAmount( 50, 710 );
        contentStream.drawString( "Grunddaten");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(text, 12 );
        contentStream.moveTextPositionByAmount( 50, 680 );
        contentStream.drawString("Brandschutztechnische Infrakstruktur: " + bba1.getbTI() );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(text, 12 );
        contentStream.moveTextPositionByAmount( 50, 660 );
        contentStream.drawString("Grundfläche: " + bba1.getGrundflaeche() + "m²");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(text, 12 );
        contentStream.moveTextPositionByAmount( 50, 640 );
        contentStream.drawString("Lagerguthöhe: " + bba1.getLagerguthoehe() + "m" );
        contentStream.endText();




//----------------------------------------------------------------------------------------------------------------------

        //Umfassungsbauteile

        contentStream.beginText();
        contentStream.setFont( font, 13 );
        contentStream.moveTextPositionByAmount( 50, 610 );
        contentStream.drawString( "Umfassungsbauteile");
        contentStream.endText();



        contentStream.beginText();
        contentStream.setFont(font, 13 );
        contentStream.moveTextPositionByAmount( 50, 580 );
        contentStream.drawString("Bauteil");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 13 );
        contentStream.moveTextPositionByAmount( 200, 580 );
        contentStream.drawString("Fläche [m²]");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 13 );
        contentStream.moveTextPositionByAmount( 300, 580 );
        contentStream.drawString("c-Faktor [min*m²/(kWh)]");
        contentStream.endText();

        //erstellt eine Liste der Umfassungsbauteile von BBA 1
        ObservableList<Umfassungsbauteil> umfassungsbauteilBBA1Liste = tableViewBBA1Umfassungsbauteile.getItems();

        int tyUmfassungsbauteile = 560;

        for (Umfassungsbauteil umfassungsbauteil : umfassungsbauteilBBA1Liste) {
            contentStream.beginText();
            contentStream.setFont(text, 12 );
            contentStream.moveTextPositionByAmount( 50, tyUmfassungsbauteile  );
            contentStream.drawString(umfassungsbauteil.getNameUmfassungsbauteil());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(text, 12 );
            contentStream.moveTextPositionByAmount( 200, tyUmfassungsbauteile  );
            contentStream.drawString(String.valueOf(umfassungsbauteil.getFlaecheUmfassungsbauteil()));
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(text, 12 );
            contentStream.moveTextPositionByAmount( 300, tyUmfassungsbauteile  );
            contentStream.drawString(String.valueOf(umfassungsbauteil.getCFaktor()));
            contentStream.endText();

            tyUmfassungsbauteile  = tyUmfassungsbauteile -20;
        }

        //Zur besseren Abgrenzung von c-res in der PDF-Datei
        tyUmfassungsbauteile = tyUmfassungsbauteile-10;

        contentStream.beginText();
        contentStream.setFont(font, 12 );
        contentStream.moveTextPositionByAmount( 50, tyUmfassungsbauteile );
        contentStream.drawString("Resultierender c-Faktor: ");
        contentStream.endText();

//----------------------------------------------------------------------------------------------------------------------
        //Vertikale Wärmeabzugsflächen BBA1

        int tyVWAF = tyUmfassungsbauteile-30;

        contentStream.beginText();
        contentStream.setFont( font, 13 );
        contentStream.moveTextPositionByAmount( 50, tyVWAF );
        contentStream.drawString( "Vertikale Wärmeabzugsflächen");
        contentStream.endText();

        tyVWAF = tyVWAF-30;

        contentStream.beginText();
        contentStream.setFont(font, 13 );
        contentStream.moveTextPositionByAmount( 50, tyVWAF );
        contentStream.drawString("Bauteil");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(font, 13 );
        contentStream.moveTextPositionByAmount( 200, tyVWAF );
        contentStream.drawString("Fläche [m²]");
        contentStream.endText();

        tyVWAF = tyVWAF-20;

        //erstellt eine Liste der VWAF von BBA 1
        ObservableList<VWAF> vwafBBA1Liste = tableViewBBA1VWAF.getItems();

        for(VWAF vwaf : vwafBBA1Liste) {
            contentStream.beginText();
            contentStream.setFont(text, 12 );
            contentStream.moveTextPositionByAmount( 50, tyVWAF  );
            contentStream.drawString(vwaf.getNameVWAF());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(text, 12 );
            contentStream.moveTextPositionByAmount( 200, tyVWAF  );
            contentStream.drawString(String.valueOf(vwaf.getAnrechenBareFlaeche()));
            contentStream.endText();

            tyVWAF = tyVWAF-20;
        }

        tyVWAF = tyVWAF-10;

        contentStream.beginText();
        contentStream.setFont(font, 12 );
        contentStream.moveTextPositionByAmount( 50, tyVWAF );
        contentStream.drawString("Bezogene vertikale Fläche: av = " + bba1.getAv());
        contentStream.endText();


//----------------------------------------------------------------------------------------------------------------------
        //TB1_1 horizontale WAF
//----------------------------------------------------------------------------------------------------------------------


        contentStream.close();
        documentBBA1.save("C:\\Users\\Lukas\\IdeaProjects\\MasterArbeit 3.0\\BBA1.pdf");
        documentBBA1.close();

    // Ende der Methode zur Erstellung der PDF-Datei zu BBA 1
    }


//----------------------------------------------------------------------------------------------------------------------
    /**
     * Methode zum Öffnen der Matrialbibliothek
     */
    public void setButtonMaterialbibliothek() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Materialbibliothek/Materialbibliothek.fxml"));
        Parent root1 = (Parent) loader.load();
        Stage stage = new Stage();

        stage.setTitle("Materialbibliothek");
        stage.setScene(new Scene(root1));
        stage.show();

    }

    public void setButtonNutzungen() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Materialbibliothek/NutzungBrandlast.fxml"));
        Parent root1 = (Parent) loader.load();
        Stage stage = new Stage();

        stage.setTitle("Nutzungen");
        stage.setScene(new Scene(root1));
        stage.show();
    }

// Ende des TreeViewControllers
}


