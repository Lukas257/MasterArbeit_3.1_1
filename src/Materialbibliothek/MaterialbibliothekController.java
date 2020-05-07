package Materialbibliothek;

import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import org.apache.pdfbox.debugger.ui.Tree;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MaterialbibliothekController implements Initializable {

    @FXML
    private TreeTableView<Stoff> TreeTableViewMaterialbibliothek;

    @FXML
    private TreeTableColumn<Stoff, String> TreeTableColumnStoff;

    @FXML
    private TreeTableColumn<Stoff, String> TreeTableColumnBeschreibung;

    @FXML
    private TreeTableColumn<Stoff, Double> TreeTableColumnHeizwert;

    @FXML
    private TreeTableColumn<Stoff, Double> TreeTableColumnAbbrandfaktor;

    @FXML
    private  TreeTableColumn<Stoff, Integer> TreeTableColumnLagerungsdichte;
//----------------------------------------------------------------------------------------------------------------------
    private ImageView level1Icon = new ImageView(new Image(getClass().getResourceAsStream("../Icon/Level1.png")));
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Liste der "Stoffe" in der 1. Ebene der TreeTableView
     */
    List<Stoff> stoffe1Ebene = Arrays.<Stoff>asList(
            new Stoff ("Holz", null, null, null, null),
            new Stoff ("Papier", null, null, null, null),
            new Stoff ("Textilien", null, null,null, null),
            new Stoff ("Kunststoffe", null, null,null, null),
            new Stoff ("Kohleartige Stoffe", null, null,null, null),
            new Stoff ("Organische Verbindungen, flüssig", null,null, null, null),
            new Stoff ("Organische Verbindungen, fest", null,null, null, null),
            new Stoff ("Lebensmittel", null, null,null, null),
            new Stoff ("Kabelisolierungen", null, null,null, null),
            new Stoff ("Sonstige Stoffe oder Allgemein", null, null,null, null)
    );
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Liste der Stoffe zu Klasse Holz
     */
    List<Stoff> stoffeHolz = Arrays.<Stoff>asList(
            new Stoff("Arbeitsplatte aus Holz",	null,99,	0.20,	4.80),
            new Stoff("Bademöbel aus Holzwerkstoffen",	null,15,	1.20,	4.80),
            new Stoff("Bauplatten",	null,50,	0.20,	4.80),
            new Stoff("Bauteile aus Holz",	null,50,	0.80,	4.80),
            new Stoff("Besenstile, Durchmesser: 150 - 300 mm",	null,50,	0.70,	4.80),
            new Stoff("Bilderrahmen",	null,70,	0.80,	4.80),
            new Stoff("Fichtenholz-Blöcke, 500 * 500 mm, dicht gefügt",	null,50,	0.20,	4.80),
            new Stoff("Fichtenholz-Blöcke, 500 * 500 mm, dicht gefügt",	null,98,	0.20,	4.80),
            new Stoff("Fichtenholz-Bretter",	null,50,	1.00,	4.80),
            new Stoff("Fichtenholz-Bretter",	null,70,	0.80,	4.80),
            new Stoff("Fichtenholz-Kanthölzer, 100 * 100 mm",	null,50,	0.70,	4.80),
            new Stoff("Fichtenholz-Kanthölzer, 100 * 100 mm",	null,90,	0.50,	4.80),
            new Stoff("Fichtenholz-Kanthölzer, 200 * 200 mm",	null,50,	0.30,	4.80),
            new Stoff("Fichtenholz-Kanthölzer, 200 * 200 mm",	null,95,	0.20,	4.80),
            new Stoff("Fichtenholz-Kanthölzer, 40 * 40 mm",	null,50,	1.00,	4.80),
            new Stoff("Fichtenholz-Rundholz, geschält, Durchmesser: 150 - 300 mm",	null,50,	0.70,	4.80),
            new Stoff("Gardinenleiste",	null,70,	0.80,	4.80),
            new Stoff("Holzbekleidungen",	null,70,	0.80,	4.80),
            new Stoff("Holzfenster"	,	null, 	90	,	0.50	,	4.80	),
            new Stoff("Holzleisten"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Holzpaneele"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Holzparkett"	,	null, 	0	,	0.10	,	4.80	),
            new Stoff("Holzregale (Spanplatten)"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Holztisch"	,	null, 	70	,	0.80	,	4.80	),
            new Stoff("Holztüren"	,	null, 	50	,	0.20	,	4.80	),
            new Stoff("Holztürfutter"	,	null, 	50	,	0.20	,	4.80	),
            new Stoff("Holzwolle, gepreßt in Ballen"	,	null, 	60	,	0.20	,	4.80	),
            new Stoff("Holzwolle, lose Schüttung"	,	null, 	8	,	1.00	,	4.80	),
            new Stoff("Holzzargen"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Kassentisch"	,	null, 	70	,	0.80	,	4.80	),
            new Stoff("Kleinmöbel aus Holzwerkstoffen, unverpackt"	,	null, 	15	,	1.20	,	4.80	),
            new Stoff("Korbmöbel"	,	null, 	10	,	1.50	,	4.80	),
            new Stoff("Korbwaren"	,	null, 	10	,	1.50	,	4.80	),
            new Stoff("Kork-Platten"	,	null, 	0	,	1.00	,	6.00	),
            new Stoff("Lamellenplatten"	,	null, 	70	,	0.80	,	4.80	),
            new Stoff("Massivholz"	,	null, 	50	,	0.20	,	4.80	),
            new Stoff("Pflanzentrog"	,	null, 	70	,	0.80	,	4.80	),
            new Stoff("Podeste aus Spanplatten"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Rollo aus Holz/Textilstoff"	,	null, 	0	,	0.50	,	6.00	),
            new Stoff("Spannplatten, (DIN 4102-B2)"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Spanplatte Gestell"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Spanplatte Sockelleiste"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Spanplatten"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Spanplatten, (DIN 4102-B2)"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Sperrholz, horizontal dicht gestapelt"	,	null, 	0	,	0.20	,	4.80	),
            new Stoff("Sperrholz, horizontal dicht gestapelt auf Holzpaletten"	,	null, 	0	,	0.80	,	4.80	),
            new Stoff("Stiele, etc. aus Holz, Durchmesser: 150 - 300 mm"	,	null, 	50	,	0.80	,	4.80	),
            new Stoff("Tapeziertisch"	,	null, 	70	,	0.80	,	4.80	),
            new Stoff("Tischbeine aus Fichtenholz, Durchmesser: 150 - 300 mm"	,	null, 	50	,	0.70	,	4.80	),
            new Stoff("Trennwand aus Holz (Spanplatten)"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("WC-Sitz aus Holzwerkstoffen"	,	null, 	15	,	1.20	,	4.80	),
            new Stoff("Werkzeuge aus Holz"	,	null, 	50	,	0.80	,	4.80	)
            );
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Liste der Stoffe Klasse 2: Papier
     */
    List<Stoff> stoffePapier = Arrays.<Stoff>asList(
            new Stoff("Altpapier, einschließlich Karton zu Ballen gepreßt"	,	null, 	0	,	0.20	,	4.20	),
            new Stoff("Altpapier, lose"	,	null, 	3	,	2.00	,	4.20	),
            new Stoff("Dekorationspapier"	,	null, 	100	,	0.20	,	3.80	),
            new Stoff("Karton, gestrichen oder ungestrichen, Behälter, leer, gestapelt"	,	null, 	6	,	1.80	,	4.20	),
            new Stoff("Karton, gestrichen oder ungestrichen, geschnitten, auf Holzpaletten gelagert"	,	null, 	100	,	0.20	,	4.20	),
            new Stoff("Karton, gestrichen oder ungestrichen, lose, horizontal gestapelt"	,	null, 	20	,	0.40	,	4.20	),
            new Stoff("Karton, gestrichen oder ungestrichen, Rollen eng gewickelt, stehend/liegend lag."	,	null, 	75	,	0.20	,	4.20	),
            new Stoff("Karton, Verpackung"	,	null, 	6	,	0.70	,	4.20	),
            new Stoff("Kartonagen aus Pappe"	,	null, 	6	,	0.70	,	4.20	),
            new Stoff("Papier, auf Rollen eng gewickelt, Rollen stehend, liegend od. auf Holzpaletten"	,	null, 	75	,	0.20	,	3.80	),
            new Stoff("Papier, großformatig geschnitten, jeweils einzeln auf dem Boden abgest. Paletten"	,	null, 	100	,	0.05	,	3.80	),
            new Stoff("Papier, großformatig geschnitten, mehrlagige Holzpalettenlagerung"	,	null, 	100	,	0.20	,	3.80	),
            new Stoff("Papiersäcke"	,	null, 	100	,	0.20	,	3.80	),
            new Stoff("Papierzettel"	,	null, 	100	,	0.20	,	3.80	),
            new Stoff("Poster"	,	null, 	100	,	0.20	,	3.80	),
            new Stoff("Sanitärkreppapier, in Großrollen"	,	null, 	80	,	1.30	,	3.70	),
            new Stoff("Sanitärkreppapier, in Rollen, in Beuteln verpackt"	,	null, 	80	,	1.90	,	3.70	),
            new Stoff("Schleifbögen"	,	null, 	0	,	0.70	,	3.80	),
            new Stoff("Tapeten"	,	null, 	100	,	0.20	,	3.80	),
            new Stoff("Tapetenrollen"	,	null, 	100	,	0.20	,	3.80	),
            new Stoff("Tischtücher aus Papier"	,	null, 	100	,	0.20	,	3.80	)
    );

//----------------------------------------------------------------------------------------------------------------------
    /**
     * Liste der Stoffe Klasse 3: Textilien
     */
    List<Stoff> stoffeTextilien = Arrays.<Stoff>asList(
            new Stoff("Abfallmaterial, zu Ballen verpreßt aus Baumwolle-, Polyamid und Polyacrylnitril"	,	null, 	0	,	0.80	,	8.00	),
            new Stoff("Baumwolläufer"	,	null, 	0	,	0.40	,	4.30	),
            new Stoff("Baumwolle, Fasern zu Ballen gepreßt"	,	null, 	0	,	0.20	,	4.30	),
            new Stoff("Baumwolle, Gewebeballen"	,	null, 	0	,	0.40	,	4.30	),
            new Stoff("Baumwolle, Putzlappen, ölgetränkt, im offenen Blechbehälter"	,	null, 	10	,	0.70	,	8.80	),
            new Stoff("Bekleidungstextilien aus beliebigen Fasern, hängend"	,	"Lagerungsdichte: 10-30%", 	null	,	0.70	,	6.20	),
            new Stoff("Fasern aus pflanzlichen Produkten (Baumwolle, Flachs)"	,	null, 	100	,	1.30	,	4.60	),
            new Stoff("Fasern aus tierischen Fasern (Wolle, Seide)"	,	null, 	100	,	1.30	,	5.80	),
            new Stoff("Fußmatten aus Baumwolle"	,	null, 	0	,	0.40	,	4.30	),
            new Stoff("Polyacrylnitril zu Ballen verpreßt, Fasern modifiziert (35 % Vinyllidenclorid)"	,	null, 	0	,	0.20	,	6.60	),
            new Stoff("Polyacrylnitril zu Ballen verpreßt, Fasern, Gemisch aus Dralon, Perlon, Wolle"	,	null, 	0	,	0.80	,	8.20	),
            new Stoff("Polyamidfasern, zu Ballen verpreßt"	,	null, 	0	,	1.10	,	7.90	),
            new Stoff("Polyester, Fasern zu Ballen verpreßt"	,	null, 	30	,	0.20	,	7.60	),
            new Stoff("Schafwolle, lose gelagert"	,	null, 	10	,	0.80	,	5.80	),
            new Stoff("Schafwolle, zu Ballen verpreßt"	,	null, 	0	,	0.20	,	5.80	),
            new Stoff("Schwämme"	,	null, 	0	,	0.70	,	6.00	),
            new Stoff("Teppichboden"	,	null, 	0	,	0.80	,	8.00	),
            new Stoff("Teppichboden, aus Filzpaletten, aus Fasern aller Art, hor. dicht gest. Holzpal."	,	null, 	0	,	1.10	,	5.60	),
            new Stoff("Teppichboden, aus Filzpaletten, aus Fasern aller Art, horizontal dicht gestapelt"	,	null, 	0	,	0.20	,	6.00	),
            new Stoff("Teppichboden, Rohware ohne Rücken, aus Fasern aller Art, horiz. lose gelagert"	,	null, 	0	,	1.50	,	6.00	),
            new Stoff("Teppichboden, Rollen"	,	null, 	0	,	0.20	,	6.00	),
            new Stoff("Teppichboden-Fliesen"	,	null, 	0	,	1.10	,	5.60	),
            new Stoff("Textilbezüge, -Decken"	,	null, 	0	,	0.80	,	8.00	),
            new Stoff("Textil-Vorlagen (Teppich)"	,	null, 	0	,	0.20	,	6.00	)
            );

//----------------------------------------------------------------------------------------------------------------------
    /**
     * Liste der Stoffe Klasse 4: Kunststoffe
     */
    List<Stoff> stoffeKunststoffe = Arrays.<Stoff>asList(
            new Stoff("ABS-Griffe aus Polystyrol u. Styrolcopolymerisate"	,	null, 	10	,	0.90	,	9.90	),
            new Stoff("ABS-Schalter"	,	null, 	10	,	0.90	,	9.90	),
            new Stoff("Beschläge aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Bleester aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Boilergehäuse"	,	null, 	0	,	0.50	,	12.20	),
            new Stoff("Dämmplatten aus PS"	,	null, 	0	,	0.60	,	11.00	),
            new Stoff("Dekorationsplatten aus PS"	,	null, 	0	,	0.40	,	11.80	),
            new Stoff("Dosen aus PS"	,	null, 	0	,	0.40	,	11.00	),
            new Stoff("Duschvorhang aus PVC"	,	null, 	10	,	0.70	,	5.00	),
            new Stoff("Eimer aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Epoxydharz, nicht verstärkt, lose geschüttet"	,	null, 	80	,	0.60	,	9.10	),
            new Stoff("Flaschen aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Gartenmöbel aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Gießkannen aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Jacken aus PVC"	,	null, 	10	,	0.70	,	5.00	),
            new Stoff("Kabel mit PVC-Ummantelung"	,	null, 	10	,	0.70	,	5.00	),
            new Stoff("Kanister aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Kfz-Inst.tafel Ethylen-Propylen-DienMastik (¸20%), Pappkarton gel."	,	"Lagerungsdichte 30-90%", 	null	,	0.40	,	8.40	),
            new Stoff("Kfz-Radhausverkleidungen aus Polypropylen-Copolymere in Pappkart."	,	"Lagerungsdichte 30-90%", 	null	,	1.10	,	10.70	),
            new Stoff("Kofferkästen aus Polyethylen	"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Kunststoff-Fensterprofile, PVC-hart PVC-U-D-E-072-15-23 bzw. PVC-U-G-E-072-15-23"	,	null, 	90	,	0.40	,	5.00	),
            new Stoff("Möbel aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Pflanzenschalen aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Phenolharz, Hartschaumplatten mit od. ohne Glasvlieskaschierung (DIN 4102 - B1)"	,	null, 	100	,	0.70	,	6.00	),
            new Stoff("Polyamid, Folien auf Rollen gewickelt"	,	null, 	30	,	1.40	,	8.10	),
            new Stoff("Polycarbodiimid, Hartschaum (Dichte 16.8 kg/m3)"	,	null, 	100	,	0.20	,	8.60	),
            new Stoff("Polyesterharz, ungesättigt, Formt., glasfaserv., Wärmed. PUR-Sch."	,	"Lagerungsdichte 5-10%", 	null	,	1.10	,	5.30),
            new Stoff("Polyesterharz, ungesättigt, Formteile, glasfaserverst., lose gest."	,	"Lagerungsdichte 5-25%", 	null	,	1.10	,	5.30	),
            new Stoff("Polyesterharz, ungesättigt, Formteile, glasfaserverstärkt, dicht gestapelt"	,	null, 	90	,	0.90	,	5.30	),
            new Stoff("Polyesterharz, ungesättigt, Formteile, glasfaserverstärkt, mit Wärmed. PUR-Sch."	,	null, 	5	,	1.10	,	5.30	),
            new Stoff("Polyethylen-Behälter oder Formteile (gestapelt oder geschüttet)"	,	"Lagerungsdichte 10-90%", 	null	,	0.80	,	12.20	),
            new Stoff("Polyethylen-Fertigteile"	,	null, 	94	,	0.80	,	12.20	),
            new Stoff("Polyethylen-Späne in Bunkern"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Polyethylen-Späne in Bunkern"	,	null, 	40	,	0.80	,	12.20	),
            new Stoff("Polyolefine, Kfz-Radhausverkleidungen aus Polypropylen-Copolymere in Pappkart."	,	null, 	30	,	1.10	,	10.70	),
            new Stoff("Polyolefine, Polyethylen-Behälter oder Formteile (gestapelt oder geschüttet)"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Polyolefine, Polyethylen-Folien auf Rollen gewickelt"	,	null, 	30	,	1.10	,	12.20	),
            new Stoff("Polyolefine, Polyethylen-Granulat in einzelnen Säcken"	,	null, 	0	,	0.80	,	12.20	),
            new Stoff("Polyolefine, Polypropylen-Formteile in Pappkartons"	,	null, 	15	,	0.80	,	12.60	),
            new Stoff("Polyolefine, Polypropylen-Granulat in Säcken auf Holzpaletten"	,	null, 	80	,	1.30	,	9.60	),
            new Stoff("Polyolefine, Polypropylen-Granulat in Säcken, dicht gestapelt"	,	null, 	0	,	1.20	,	12.80	),
            new Stoff("Polyolefine, Polypropylen-Rohre (DIN 4102 - B2)"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Polystyrol u. Styrolcopolymerisate, Acrylnitril-Butadien-Styrol-Formt. Pappkar."	,	null, 	10	,	0.90	,	9.90	),
            new Stoff("Polystyrol u. Styrolcopolymerisate, PS-Hartschaum (DIN 4102-B1, 20 kg/m3)"	,	null, 	100	,	0.40	,	11.00	),
            new Stoff("Polystyrol u. Styrolcopolymerisate, PS-Hartschaum (DIN 4102-B3, 20 kg/m3)"	,	null, 	100	,	0.90	,	11.00	),
            new Stoff("Polystyrol u. Styrrolcopolymerisate, Formt. dünnw., ungesch. Polystyrol Blechb."	,	null, 	10	,	2.10	,	11.00	),
            new Stoff("Polyurethan, PUR-Hartschaum (DIN 4102-B1, ¸ 36 kg/m3)"	,	null, 	100	,	0.20	,	6.70	),
            new Stoff("Polyurethan, PUR-Hartschaum (DIN 4102-B2, ¸ 36 kg/m3)"	,	null, 	100	,	0.30	,	6.70	),
            new Stoff("Polyurethan, PUR-Weichschaum (DIN 4102-B3, ¸ 30 kg/m3) in Drahtkörben"	,	null, 	90	,	1.20	,	6.40	),
            new Stoff("Polyurethan, PUR-Weichschaum (DIN 4102-B3, ¸ 50 kg/m3) in Verb. mit Holzkonstr."	,	null, 	50	,	1.40	,	5.30	),
            new Stoff("Polyvinylchlorid, PVC-hart Formteile in Drahtkörben"	,	null, 	30	,	0.40	,	5.00	),
            new Stoff("Polyvinylchlorid, PVC-hart Formteile in Pappkartons"	,	"Lagerungsdichte 31-90%", 	null	,	0.40	,	5.00	),
            new Stoff("Polyvinylchlorid, PVC-hart Rohre auf Holzpaletten horizontal gelagert"	,	null, 	10	,	0.40	,	5.00	),
            new Stoff("Polyvinylchlorid, PVC-hart Rohre horizontal gelagert"	,	null, 	10	,	0.20	,	5.00	),
            new Stoff("Polyvinylchlorid, PVC-hart Rohrstücke"	,	null, 	10	,	0.40	,	5.00	),
            new Stoff("Polyvinylchlorid, PVC-weich Formteile in Drahtkörben"	,	null, 	10	,	0.70	,	5.00	),
            new Stoff("PVC HART Bodenbelag"	,	null, 	30	,	0.40	,	5.00	),
            new Stoff("PVC Weich Bodenbelag"	,	null, 	10	,	0.70	,	5.00	),
            new Stoff("Regenerat"	,	null, 	10	,	4.80	,	12.20	),
            new Stoff("Regenerat"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Rohrdämmung aus PUR-Weichschaum"	,	null, 	90	,	1.20	,	6.40	),
            new Stoff("Säcke aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Schachteln aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Schäferkästen aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Schaumbelag (PUR-Weichschaum)"	,	null, 	90	,	1.20	,	6.40	),
            new Stoff("Silikon-Dichtungsmittel"	,	null, 	0	,	0.20	,	8.90	),
            new Stoff("Sockelleisten aus PVC-hart"	,	null, 	90	,	0.40	,	5.00	),
            new Stoff("Sortierkästen aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Spüleinsätze"	,	null, 	0	,	0.80	,	12.80	),
            new Stoff("Spülkasten aus PVC"	,	null, 	90	,	0.40	,	5.00	),
            new Stoff("Tüten aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Wannen aus Polyethylen"	,	null, 	10	,	0.80	,	12.20	),
            new Stoff("Werkzeuge aus Poylpropylen"	,	null, 	15	,	0.80	,	12.60	)
            );
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Liste der Stoffe Klasse 5: Kohleartige Stoffe
     */
    List<Stoff> stoffeKohleartigeStoffe = Arrays.<Stoff>asList(
            new Stoff("Braunkohlebriketts, lose geschüttet oder gestapelt"	,	null, 	60	,	0.30	,	5.80	),
            new Stoff("Brechkoks, in Verbindung mit Holz (Holzbauteile ¸ 35 %), lose geschüttet"	,	null, 	60	,	0.20	,	6.90	),
            new Stoff("Brechkoks, lose geschüttet"	,	null, 	60	,	0.20	,	8.10	)
            );
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Liste der Stoffe Klasse 6: Organische Verbindungen, flüssig
     */
    List<Stoff> stoffeOrganischeVerbindungenFlüssig = Arrays.<Stoff>asList(
            new Stoff("Acryl-Lacke"	,	null, 	0	,	0.80	,	7.60	),
            new Stoff("Benzin"	,	null, 	100	,	0.70	,	11.90	),
            new Stoff("Chlorbenzol"	,	null, 	100	,	0.50	,	11.20	),
            new Stoff("Cyclohexan"	,	null, 	100	,	0.60	,	8.90	),
            new Stoff("Dieselkraftstoff"	,	null, 	100	,	0.70	,	11.70	),
            new Stoff("Dimethylformamid"	,	null, 	100	,	1.80	,	6.10	),
            new Stoff("Epoxide-Lasur"	,	null, 	0	,	0.80	,	7.60	),
            new Stoff("Farben (Acryl/Epoxid)"	,	null, 	0	,	0.80	,	7.80	),
            new Stoff("Flüssiggas"	,	null, 	100	,	0.20	,	4.60	),
            new Stoff("Flüssiggas"	,	null, 	100	,	1.30	,	13.30	),
            new Stoff("Glycol"	,	null, 	100	,	1.90	,	4.60	),
            new Stoff("Heizöl EL"	,	null, 	100	,	0.70	,	11.70	),
            new Stoff("Heizöl S"	,	null, 	100	,	0.70	,	11.70	),
            new Stoff("Holzschutzbeize"	,	null, 	0	,	0.80	,	7.00	),
            new Stoff("Holzschutzimprägnierung"	,	null, 	0	,	0.80	,	7.00	),
            new Stoff("Hydrauliköl HLP 36"	,	null, 	100	,	0.60	,	9.80	),
            new Stoff("Hydrauliköl W 92"	,	null, 	100	,	0.40	,	9.80	),
            new Stoff("Isopropanol"	,	null, 	100	,	1.10	,	7.50	),
            new Stoff("Leim"	,	null, 	100	,	0.80	,	8.10	),
            new Stoff("Methanol"	,	null, 	100	,	1.00	,	5.40	),
            new Stoff("Nitroverdünnung"	,	null, 	100	,	1.00	,	7.50	),
            new Stoff("Silicon-Transformatorenflüssigkeit"	,	null, 	100	,	0.20	,	8.90	),
            new Stoff("Terpentin"	,	null, 	100	,	0.60	,	11.50	),
            new Stoff("Terpentin-Lösungsmittel"	,	null, 	100	,	0.60	,	11.50	),
            new Stoff("Xylol"	,	null, 	100	,	0.60	,	11.10	)
            );
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Liste der Stoffe Klasse 7: Organische Verbindungen, fest
     */
    List<Stoff> stoffeOrganischeVerbindungenFest = Arrays.<Stoff>asList(
            new Stoff("Bitumen, Blöcke"	,	null, 	100	,	0.60	,	9.80	),
            new Stoff("Bitumen, Dachbahn mit Rohfilzeinlage"	,	null, 	60	,	0.50	,	8.00	),
            new Stoff("Bitumen, Klebemasse"	,	null, 	60	,	0.50	,	8.00	),
            new Stoff("Fußmatten aus Gummi"	,	null, 	100	,	0.60	,	9.80	),
            new Stoff("Gummi, Dichtungsbänder"	,	null, 	20	,	0.80	,	5.80	),
            new Stoff("Gummi, Fahrzeugreifen aus Kautschuk auf Holzpaletten"	,	null, 	10	,	0.60	,	8.70	),
            new Stoff("Gummi, Fahrzeugreifen aus Kautschuk, lose gelagert"	,	null, 	10	,	0.40	,	12.20	),
            new Stoff("Gummi, Fördergurte geschichtet"	,	null, 	100	,	0.20	,	12.20	),
            new Stoff("Gummirollen"		,	null, 	10	,	0.40	,	12.20	),
            new Stoff("Gummischlauch"	,	null, 	10	,	0.40	,	12.20	),
            new Stoff("Scheibenwischer, etc."	,	null, 	10	,	0.40	,	12.20	)

            );
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Liste der Stoffe Klasse 8: Lebensmittel
     */
    List<Stoff> stoffeLebensmittel = Arrays.<Stoff>asList(
            new Stoff("Aal	", null, null,	0.50	,	3.27	),
            new Stoff("Ananas	", null, null,	1.00	,	0.64	),
            new Stoff("Äpfel	", null, null,	1.00	,	0.63	),
            new Stoff("Aprikosen	", null, null,	1.00	,	0.50	),
            new Stoff("Artischocken	", null, null,	1.00	,	0.26	),
            new Stoff("Auberginen	", null, null,	1.00	,	0.20	),
            new Stoff("Austern	", null, null,	0.50	,	0.77	),
            new Stoff("Austernpilze	", null, null,	1.00	,	0.13	),
            new Stoff("Avocados	", null, null,	1.00	,	2.57	),
            new Stoff("Baguette	", null, null,	1.00	,	3.02	),
            new Stoff("Bananen	", null, null,	1.00	,	1.09	),
            new Stoff("Barsch	", null, null,	1.00	,	0.94	),
            new Stoff("Bergkäse	", null, null,	1.00	,	4.49	),
            new Stoff("Bierschinken	", null, null,	0.50	,	1.97	),
            new Stoff("Birkenpilze	", null, null,	1.00	,	0.21	),
            new Stoff("Birnen	", null, null,	1.00	,	0.64	),
            new Stoff("Blumenkohl	", null, null,	1.00	,	0.26	),
            new Stoff("Blätterteig	", null, null,	1.00	,	4.36	),
            new Stoff("Bohnen, weiß	", null, null,	1.00	,	2.77	),
            new Stoff("Bratwurst	", null, null,	0.50	,	3.47	),
            new Stoff("Broccoli	", null, null,	1.00	,	0.30	),
            new Stoff("Brombeeren	", null, null,	1.00	,	0.51	),
            new Stoff("Brunnenkresse	", null, null,	1.00	,	0.21	),
            new Stoff("Butter	", null, null,	0.20	,	8.77	),
            new Stoff("Buttermilch	", null, null,	1.00	,	0.41	),
            new Stoff("Butterpilze	", null, null,	1.00	,	0.14	),
            new Stoff("Butterschmalz	", null, null,	1.00	,	10.43	),
            new Stoff("Champignons	", null, null,	1.00	,	0.24	),
            new Stoff("Chicoree	", null, null,	1.00	,	0.19	),
            new Stoff("Chinakohl	", null, null,	1.00	,	0.14	),
            new Stoff("Cola	", null, null,	1.00	,	0.50	),
            new Stoff("Diät-Vollbier	", null, null,	1.00	,	0.38	),
            new Stoff("Eier	", null, null,	1.00	,	1.81	),
            new Stoff("Eisbergsalat	", null, null,	1.00	,	0.15	),
            new Stoff("Endivien	", null, null,	1.00	,	0.16	),
            new Stoff("Ente	", null, null,	0.50	,	2.64	),
            new Stoff("Erbsen	", null, null,	1.00	,	3.13	),
            new Stoff("Erdbeeren	", null, null,	1.00	,	0.37	),
            new Stoff("Erdnüsse	", null, null,	1.00	,	6.63	),
            new Stoff("Erdnussöl	", null, null,	1.00	,	10.41	),
            new Stoff("Feigen	", null, null,	1.00	,	0.70	),
            new Stoff("Feldsalat	", null, null,	1.00	,	0.16	),
            new Stoff("Fenchel	", null, null,	1.00	,	0.28	),
            new Stoff("Flunder	", null, null,	0.50	,	0.84	),
            new Stoff("Forelle	", null, null,	0.50	,	1.19	),
            new Stoff("Frankfurter Würstchen	", null, null,	0.50	,	3.16	),
            new Stoff("Frischkäse (60%)	", null, null,	1.00	,	2.92	),
            new Stoff("Frischkäse (20%)	", null, null,	1.00	,	1.56	),
            new Stoff("Fruchsaftgetränke	", null, null,	1.00	,	0.57	),
            new Stoff("Gans	", null, null,	0.50	,	3.98	),
            new Stoff("Garnelen	", null, null,	0.50	,	1.01	),
            new Stoff("Geflügelwurst	", null, null,	0.50	,	1.26	),
            new Stoff("Gelbwurst	", null, null,	0.50	,	3.27	),
            new Stoff("Grapefruit	", null, null,	1.00	,	0.52	),
            new Stoff("Gurken	", null, null,	1.00	,	0.14	),
            new Stoff("Hafer	", null, null,	1.00	,	3.92	),
            new Stoff("Hammel (Muskelfleisch)	", null, null,	0.50	,	1.36	),
            new Stoff("Hammel (Brustfleisch)	", null, null,	0.50	,	4.43	),
            new Stoff("Hammel (Filet)	", null, null,	0.50	,	1.30	),
            new Stoff("Hammel (Keule)	", null, null,	0.50	,	2.72	),
            new Stoff("Hammel (Kotelett)	", null, null,	0.50	,	4.05	),
            new Stoff("Hammel (Lende)	", null, null,	0.50	,	2.26	),
            new Stoff("Hammel (Schnitzel)	", null, null,	0.50	,	1.52	),
            new Stoff("Hase	", null, null,	0.50	,	1.31	),
            new Stoff("Hecht	", null, null,	0.50	,	0.95	),
            new Stoff("Hefeteig	", null, null,	1.00	,	3.52	),
            new Stoff("Heidelbeeren	", null, null,	1.00	,	0.43	),
            new Stoff("Heilbutt	", null, null,	0.50	,	1.12	),
            new Stoff("Hering	", null, null,	0.50	,	0.27	),
            new Stoff("Himbeeren	", null, null,	1.00	,	0.38	),
            new Stoff("Hirsch	", null, null,	0.50	,	1.30	),
            new Stoff("Holunderbeeren	", null, null,	1.00	,	0.63	),
            new Stoff("Honig	", null, null,	1.00	,	3.80	),
            new Stoff("Honigmelone	", null, null,	1.00	,	0.63	),
            new Stoff("Huhn	", null, null,	0.50	,	2.99	),
            new Stoff("Hummer	", null, null,	0.50	,	0.94	),
            new Stoff("Joghurt	", null, null,	1.00	,	0.71	),
            new Stoff("Johannisbeere	", null, null,	1.00	,	0.38	),
            new Stoff("Kabeljau	", null, null,	0.50	,	0.88	),
            new Stoff("Kalbfleisch (Muskelfleisch)	", null, null,	0.50	,	1.10	),
            new Stoff("Kalbfleisch (Brust)	", null, null,	0.50	,	1.52	),
            new Stoff("Kalbfleisch (Filet)	", null, null,	0.50	,	1.10	),
            new Stoff("Kalbfleisch (Haxe)	", null, null,	0.50	,	1.14	),
            new Stoff("Kalbfleisch (Keule)	", null, null,	0.50	,	1.13	),
            new Stoff("Kalbfleisch (Kotelett)	", null, null,	0.50	,	1.30	),
            new Stoff("Kalbfleisch (Schnitzel)	", null, null,	0.50	,	1.15	),
            new Stoff("Kalbfleisch (Bries)	", null, null,	0.50	,	1.15	),
            new Stoff("Karpfen	", null, null,	0.50	,	1.34	),
            new Stoff("Kartoffeln	", null, null,	1.00	,	0.81	),
            new Stoff("Kefir	", null, null,	1.00	,	0.71	),
            new Stoff("Kirschen	", null, null,	1.00	,	0.73	),
            new Stoff("Kiwi	", null, null,	1.00	,	0.58	),
            new Stoff("Knoblauch	", null, null,	1.00	,	1.62	),
            new Stoff("Knollensellerie	", null, null,	1.00	,	0.21	),
            new Stoff("Knäckebrot	", null, null,	1.00	,	3.70	),
            new Stoff("Kohlrabi	", null, null,	1.00	,	0.28	),
            new Stoff("Kopfsalat	", null, null,	1.00	,	0.14	),
            new Stoff("Kürbisse	", null, null,	1.00	,	0.30	),
            new Stoff("Lachs	", null, null,	0.50	,	2.35	),
            new Stoff("Lauch	", null, null,	1.00	,	0.29	),
            new Stoff("Leberkäse	", null, null,	0.50	,	3.45	),
            new Stoff("Leberpastete	", null, null,	0.50	,	3.65	),
            new Stoff("Leberwurst	", null, null,	0.50	,	3.79	),
            new Stoff("Linsen	", null, null,	1.00	,	3.14	),
            new Stoff("Margarine	", null, null,	0.20	,	8.40	),
            new Stoff("Mais	", null, null,	1.00	,	3.86	),
            new Stoff("Makrele	", null, null,	0.50	,	2.09	),
            new Stoff("Madarinen	", null, null,	1.00	,	0.53	),
            new Stoff("Mandeln	", null, null,	1.00	,	6.71	),
            new Stoff("Mangos	", null, null,	1.00	,	0.69	),
            new Stoff("Mangold	", null, null,	1.00	,	0.16	),
            new Stoff("Mascarpone	", null, null,	1.00	,	5.35	),
            new Stoff("Mayonaise	", null, null,	1.00	,	5.70	),
            new Stoff("Meerettich	", null, null,	1.00	,	0.73	),
            new Stoff("Mehrkornbrot	", null, null,	1.00	,	2.51	),
            new Stoff("Melonen	", null, null,	1.00	,	0.29	),
            new Stoff("Mettwurst	", null, null,	0.50	,	4.54	),
            new Stoff("Miesmuscheln	", null, null,	0.50	,	0.59	),
            new Stoff("Milch (3,5%)	", null, null,	1.00	,	0.74	),
            new Stoff("Milch (1,5%)	", null, null,	1.00	,	0.55	),
            new Stoff("Mirabellen	", null, null,	1.00	,	0.78	),
            new Stoff("Morcheln	", null, null,	1.00	,	0.17	),
            new Stoff("Mozarella	", null, null,	1.00	,	2.97	),
            new Stoff("Möhren	", null, null,	1.00	,	0.31	),
            new Stoff("Nudeln	", null, null,	1.00	,	4.19	),
            new Stoff("Oliven	", null, null,	1.00	,	1.55	),
            new Stoff("Olivelöl	", null, null,	1.00	,	10.43	),
            new Stoff("Orangen	", null, null,	1.00	,	0.42	),
            new Stoff("Paprika	", null, null,	1.00	,	0.23	),
            new Stoff("Pfiferlinge	", null, null,	1.00	,	0.17	),
            new Stoff("Pfirsiche	", null, null,	1.00	,	0.50	),
            new Stoff("Pflaumen	", null, null,	1.00	,	0.57	),
            new Stoff("Pinienkerne	", null, null,	1.00	,	7.84	),
            new Stoff("Pizzateig	", null, null,	1.00	,	3.00	),
            new Stoff("Pommes Frites	", null, null,	1.00	,	3.37	),
            new Stoff("Preiselbeeren	", null, null,	1.00	,	0.41	),
            new Stoff("Quitten	", null, null,	1.00	,	0.44	),
            new Stoff("Radiccio	", null, null,	1.00	,	0.15	),
            new Stoff("Radieschen	", null, null,	1.00	,	0.16	),
            new Stoff("Reh (Schlegel)	", null, null,	0.50	,	1.13	),
            new Stoff("Reh (Rücken)	", null, null,	0.50	,	1.42	),
            new Stoff("Reis	", null, null,	1.00	,	4.04	),
            new Stoff("Rettich	", null, null,	1.00	,	0.16	),
            new Stoff("Rindfleisch (Muskelfleisch)	", null, null,	0.50	,	1.19	),
            new Stoff("Rindfleisch (Filet)	", null, null,	0.50	,	1.41	),
            new Stoff("Rindfleichsch (Keule)	", null, null,	0.50	,	1.72	),
            new Stoff("Rindfleisch (Lende)	", null, null,	0.50	,	1.51	),
            new Stoff("Rindfleisch (Hackfleisch)	", null, null,	0.50	,	2.51	),
            new Stoff("Roggen	", null, null,	1.00	,	3.73	),
            new Stoff("Roggenbrot	", null, null,	1.00	,	2.55	),
            new Stoff("Roggenmischbrot	", null, null,	1.00	,	2.47	),
            new Stoff("Rosenkohl	", null, null,	1.00	,	0.42	),
            new Stoff("Rotbarsch	", null, null,	0.50	,	1.22	),
            new Stoff("Rote Bete	", null, null,	1.00	,	0.48	),
            new Stoff("Rotkohl	", null, null,	1.00	,	0.24	),
            new Stoff("Ruccola	", null, null,	1.00	,	0.28	),
            new Stoff("Sahne sauer (10%)	", null, null,	1.00	,	1.36	),
            new Stoff("Sahne süß (30%)	", null, null,	1.00	,	3.59	),
            new Stoff("Salami	", null, null,	0.50	,	4.31	),
            new Stoff("Sanddornbeeren	", null, null,	1.00	,	1.04	),
            new Stoff("Sardinen	", null, null,	1.00	,	1.37	),
            new Stoff("Sauerkraut	", null, null,	1.00	,	0.20	),
            new Stoff("Schichtkäse (10%)	", null, null,	1.00	,	1.02	),
            new Stoff("Schinken (ohne Fett)	", null, null,	0.50	,	1.69	),
            new Stoff("Schinken gekocht	", null, null,	0.50	,	2.24	),
            new Stoff("Schinken geräuchert	", null, null,	1.00	,	4.45	),
            new Stoff("Schnittlauch	", null, null,	1.00	,	0.31	),
            new Stoff("Scholle	", null, null,	1.00	,	1.00	),
            new Stoff("Schwarzwurzel	", null, null,	1.00	,	0.19	),
            new Stoff("Schweinefleisch (Muskelfleisch)	", null, null,	0.50	,	1.22	),
            new Stoff("Schweiefleisch (Bauch)	", null, null,	0.50	,	3.04	),
            new Stoff("Schweinefleisch (Schulter)	", null, null,	0.50	,	3.15	),
            new Stoff("Schweinefleisch (Eisbein)	", null, null,	0.50	,	2.16	),
            new Stoff("Schweinefleisch (Filet)	", null, null,	0.50	,	1.21	),
            new Stoff("Schweinefleisch (Schlegel)	", null, null,	0.50	,	3.19	),
            new Stoff("Schweinefleisch (Kotelett)	", null, null,	0.50	,	1.74	),
            new Stoff("Schweinefleisch (Schnitzel)	", null, null,	0.50	,	1.23	),
            new Stoff("Schweineschmalz	", null, null,	0.20	,	10.44	),
            new Stoff("Sekt	", null, null,	1.00	,	0.97	),
            new Stoff("Senf	", null, null,	1.00	,	1.19	),
            new Stoff("Sojabohnen	", null, null,	1.00	,	3.94	),
            new Stoff("Sojafleisch	", null, null,	1.00	,	2.90	),
            new Stoff("Sojamehl	", null, null,	1.00	,	4.20	),
            new Stoff("Sojaöl	", null, null,	1.00	,	10.46	),
            new Stoff("Sonneblumenöl	", null, null,	1.00	,	10.44	),
            new Stoff("Spagetti	", null, null,	1.00	,	4.21	),
            new Stoff("Spargel	", null, null,	1.00	,	0.21	),
            new Stoff("Speck	", null, null,	0.50	,	7.22	),
            new Stoff("Speisequark (40%)	", null, null,	1.00	,	1.86	),
            new Stoff("Speseiquark (mager)	", null, null,	1.00	,	0.84	),
            new Stoff("Spinat	", null, null,	1.00	,	0.17	),
            new Stoff("Stachelbeeren	", null, null,	1.00	,	0.43	),
            new Stoff("Steinpilze	", null, null,	1.00	,	0.31	),
            new Stoff("Tafelwein	", null, null,	1.00	,	0.76	),
            new Stoff("Thunfisch	", null, null,	0.50	,	2.63	),
            new Stoff("Tintenfisch	", null, null,	0.50	,	0.85	),
            new Stoff("Tomaten	", null, null,	1.00	,	0.20	),
            new Stoff("Truthahn	", null, null,	0.50	,	2.47	),
            new Stoff("Trüffel	", null, null,	1.00	,	0.81	),
            new Stoff("Vollkornbrot	", null, null,	1.00	,	2.69	),
            new Stoff("Vollmilchschokolade	", null, null,	1.00	,	6.12	),
            new Stoff("Walnüsse	", null, null,	1.00	,	7.75	),
            new Stoff("Wassermelonen	", null, null,	1.00	,	0.43	),
            new Stoff("Weintrauben	", null, null,	1.00	,	0.79	),
            new Stoff("Weizen	", null, null,	1.00	,	3.85	),
            new Stoff("Weizenkeimöl	", null, null,	1.00	,	10.47	),
            new Stoff("Weizenmischbrot	", null, null,	1.00	,	2.62	),
            new Stoff("Weizentoastbrot	", null, null,	1.00	,	3.05	),
            new Stoff("Weizenvolbier	", null, null,	1.00	,	0.53	),
            new Stoff("Weißbrot	", null, null,	1.00	,	2.74	),
            new Stoff("Weißkohl	", null, null,	1.00	,	0.28	),
            new Stoff("Weißwurst	", null, null,	0.50	,	3.34	),
            new Stoff("Whisky	", null, null,	1.00	,	2.86	),
            new Stoff("Wiener Würstchen	", null, null,	0.50	,	3.44	),
            new Stoff("Wirsing	", null, null,	1.00	,	0.29	),
            new Stoff("Zander	", null, null,	0.50	,	0.97	),
            new Stoff("Zitronen	", null, null,	1.00	,	0.42	),
            new Stoff("Zucchini	", null, null,	1.00	,	0.22	),
            new Stoff("Zucker	", null, null,	0.40	,	4.65	),
            new Stoff("Zwieback	", null, null,	1.00	,	4.28	),
            new Stoff("Zwiebeln	", null, null,	1.00	,	0.33	)
            );
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Liste der Stoffe Klasse 9: Kabelisolierungen
     */
    List<Stoff> stoffeKabelisolierungen = Arrays.<Stoff>asList(
            new Stoff("Elektrokabel"	,	null, 	50	,	0.50	,	5.00	),
            new Stoff("Kabel mit PVC-Isolierung als Kabelbündel auf Kabelrosten"	,	"Lagerungsdichte 30-90%", 	null	,	0.50	,	5.00	)
            );

//----------------------------------------------------------------------------------------------------------------------
    /**
     * Liste der Stoffe Klasse 9: Kabelisolierungen
     */
    List<Stoff> stoffeSonstigeStoffe = Arrays.<Stoff>asList(
            new Stoff("Abdichtungsbahnen aus Bitumen s. unter Bitumen"	,	null, 	0	,	0.00	,	0.00	),
            new Stoff("Abdichtungsbahnen aus Ethylencopolymerisat-Bitumen (ECB, d= 2mm, 1.9 kg/m²)"	,	null, 	0	,	0.60	,	11.20	),
            new Stoff("Abdichtungsbahnen aus Ethylen-Propylen-Terpolymer-Kautschuk (EPDM)"	,	null, 	0	,	0.60	,	12.20	),
            new Stoff("Abdichtungsbahnen aus Ethylen-Vinylacetat (E-VAC)"	,	null, 	0	,	0.60	,	12.20	),
            new Stoff("Abdichtungsbahnen aus Hochpolymere Bahn (1.4 - 2.4 kg/m²)"	,	null, 	0	,	0.60	,	6.20	),
            new Stoff("Abdichtungsbahnen aus Isobuthylen-Isopren-Rubber (Buthylkautschuk, IIR)"	,	null, 	0	,	0.60	,	12.20	),
            new Stoff("Abdichtungsbahnen aus Nitril-Kautschuk (NBR)"	,	null, 	0	,	0.60	,	12.20	),
            new Stoff("Abdichtungsbahnen aus Polychloropren-Kautschuk (CR)"	,	null, 	0	,	0.60	,	12.20	),
            new Stoff("Abdichtungsbahnen aus Polyethylen (PE-Dampfsperre, 0.2 kg/m²)"	,	null, 	0	,	0.60	,	12.20	),
            new Stoff("Abdichtungsbahnen aus Polyethylen, chloriert (PE-C)"	,	null, 	0	,	0.60	,	12.20	),
            new Stoff("Abdichtungsbahnen aus Polyethylen, chorsulfoniert (CSM)"	,	null, 	0	,	0.60	,	12.20	),
            new Stoff("Abdichtungsbahnen aus Polyisobuthylen (PIB)"	,	null, 	0	,	0.60	,	12.80	),
            new Stoff("Abdichtungsbahnen aus Polyvinylchlorid (PVC, 1.5 mm, 1.6 kg m²)"	,	null, 	0	,	0.50	,	5.60	),
            new Stoff("Abdichtungsbahnen aus Polyvinylchlorid (PVC, 1.5 mm, 2.0 kg/m²)"	,	null, 	0	,	0.50	,	8.30	),
            new Stoff("ABS-Formteile in Pappkartons	"	,	null, 	0	,	0.90	,	9.90	),
            new Stoff("Aceton	"	,	null, 	100	,	0.90	,	7.90	),
            new Stoff("Acetylen (13600 kcal/Nm3)	"	,	null, 	100	,	0.90	,	13.30	),
            new Stoff("Acryl-Butadien-Styrol (ABS)	"	,	null, 	100	,	0.90	,	9.80	),
            new Stoff("Alkohol	"	,	null, 	1	,	1.00	,	4.50	),
            new Stoff("Altpapier, zu Ballen gepreßt	"	,	null, 	90	,	0.20	,	4.20	),
            new Stoff("Ammoniak	"	,	null, 	100	,	0.60	,	3.90	),
            new Stoff("Ammonsulfat-Salpeter	"	,	null, 	100	,	0.60	,	0.60	),
            new Stoff("Antrazitkohle	"	,	null, 	80	,	0.60	,	9.90	),
            new Stoff("Arbeitsschuhe mit Oberleder und Polyerethan-Sohlen, in Kartons verpackt	"	,	null, 	100	,	0.90	,	5.60	),
            new Stoff("Bambusrohr	"	,	null, 	100	,	0.60	,	4.60	),
            new Stoff("Bekleidung	"	,	null, 	1	,	0.70	,	4.30	),
            new Stoff("Benzien	"	,	null, 	1	,	0.70	,	11.90	),
            new Stoff("Benzin, Flug-	"	,	null, 	100	,	0.20	,	11.80	),
            new Stoff("Benzin, Marken-	"	,	null, 	100	,	0.20	,	11.80	),
            new Stoff("Benzin, Renn-	"	,	null, 	100	,	0.20	,	6.40	),
            new Stoff("Benzin, Super-	"	,	null, 	100	,	0.20	,	11.90	),
            new Stoff("Benzol	"	,	null, 	100	,	0.20	,	11.10	),
            new Stoff("Bitumen, Dachpappe, besandet (2 kg/m²)	"	,	null, 	100	,	0.40	,	4.60	),
            new Stoff("Bitumen, Dachpappe, unbesandet (2.5 kg/m²)	"	,	null, 	100	,	0.50	,	5.80	),
            new Stoff("Bitumen, Verklebung, streifenweise (0.5 kg/m²)	"	,	null, 	100	,	0.50	,	11.70	),
            new Stoff("Bitumen, Verklebung, vollflächig (2.5 kg/m²)	"	,	null, 	100	,	0.50	,	11.70	),
            new Stoff("Brennholz	"	,	null, 	50	,	1.00	,	4.80	),
            new Stoff("Bücher auf Holzregalen	"	,	null, 	50	,	0.20	,	4.20	),
            new Stoff("Büroflächen	"	,	null, 	1	,	1.00	,	0.12	),
            new Stoff("Butan	"	,	null, 	100	,	0.20	,	13.90	),
            new Stoff("Cellulose-Fasern	"	,	null, 	100	,	0.20	,	4.60	),
            new Stoff("Dachbahn (Rohfilz)	"	,	null, 	60	,	0.50	,	8.00	),
            new Stoff("Dichtungsbänder	"	,	null, 	20	,	0.80	,	5.80	),
            new Stoff("Epoxidharz (EP)	"	,	null, 	100	,	1.30	,	11.80	),
            new Stoff("Epozidharz, glasfaserverstärkt (GF-EP)	"	,	null, 	100	,	1.30	,	11.80	),
            new Stoff("Erdöl	"	,	null, 	100	,	1.30	,	12.00	),
            new Stoff("Ethan	"	,	null, 	100	,	1.30	,	13.30	),
            new Stoff("Ethanol	"	,	null, 	100	,	1.30	,	7.40	),
            new Stoff("Ether	"	,	null, 	100	,	1.30	,	9.40	),
            new Stoff("Ethylen	"	,	null, 	100	,	1.30	,	13.20	),
            new Stoff("Ethylen-Copolymerisat-Bitumen (ECB)	"	,	null, 	100	,	1.30	,	11.20	),
            new Stoff("Fasern, auf Cellulosebasis	"	,	null, 	100	,	1.30	,	4.60	),
            new Stoff("Fasern, aus pflanzlichen Produkten (Baumwolle, Flachs)	"	,	null, 	100	,	1.30	,	4.60	),
            new Stoff("Fasern, aus tierischen Fasern (Wolle, Seide)	"	,	null, 	100	,	1.30	,	5.80	),
            new Stoff("Fette (pflanzliche und tierische)	"	,	null, 	100	,	1.30	,	11.00	),
            new Stoff("Fettkohle	"	,	null, 	80	,	0.60	,	9.90	),
            new Stoff("Filmmaterial	"	,	null, 	0	,	0.50	,	7.90	),
            new Stoff("Fleisch	"	,	null, 	100	,	0.50	,	11.50	),
            new Stoff("Fleisch und Wurstwaren	"	,	null, 	100	,	0.30	,	11.50	),
            new Stoff("Fördergurte aus Gummi, geschichtet	"	,	null, 	100	,	0.20	,	12.20	),
            new Stoff("Furnier	"	,	null, 	80	,	1.00	,	4.80	),
            new Stoff("Gasförmige Stoffe	"	,	null, 	1	,	1.30	,	13.20	),
            new Stoff("Gaskohle	"	,	null, 	80	,	0.60	,	9.90	),
            new Stoff("Gasöl	"	,	null, 	100	,	0.60	,	11.60	),
            new Stoff("Gebäck	"	,	null, 	100	,	0.60	,	4.60	),
            new Stoff("Getreide	"	,	null, 	100	,	0.60	,	4.60	),
            new Stoff("Gichtgas	"	,	null, 	100	,	0.60	,	1.10	),
            new Stoff("Glycerin	"	,	null, 	100	,	0.60	,	5.20	),
            new Stoff("Gummi, hart	"	,	null, 	100	,	1.30	,	9.30	),
            new Stoff("Gummi, Kleinteile	"	,	null, 	80	,	0.20	,	12.20	),
            new Stoff("Gummi, Kleinteile	"	,	null, 	100	,	0.50	,	12.20	),
            new Stoff("Gummi, Kleinteile	"	,	null, 	100	,	0.20	,	12.20	),
            new Stoff("Hanf-Seile	"	,	null, 	0	,	0.80	,	7.50	),
            new Stoff("Harnstoff	"	,	null, 	100	,	0.20	,	2.30	),
            new Stoff("Harnstoff-Formaldehydharz (UF)	"	,	null, 	100	,	0.20	,	5.80	),
            new Stoff("Harnstoff-Harze	"	,	null, 	100	,	0.20	,	5.80	),
            new Stoff("Heptan, n-	"	,	null, 	100	,	0.50	,	11.60	),
            new Stoff("Heu	"	,	null, 	100	,	0.50	,	4.60	),
            new Stoff("Hexan	"	,	null, 	100	,	0.50	,	11.60	),
            new Stoff("Holz, frisch	"	,	null, 	100	,	0.50	,	2.30	),
            new Stoff("Holz, lufttrocken	"	,	null, 	100	,	0.50	,	4.30	),
            new Stoff("Holzbauteile	"	,	null, 	1	,	0.20	,	8.10	),
            new Stoff("Holzfaserplatten, hart (DIN 68750)	"	,	null, 	100	,	0.50	,	4.60	),
            new Stoff("Holzfaserplatten, porös (DIN 68750)	"	,	null, 	100	,	0.50	,	4.10	),
            new Stoff("Holzkohle	"	,	null, 	100	,	0.50	,	8.50	),
            new Stoff("Holzpaletten	"	,	null, 	1	,	0.50	,	4.80	),
            new Stoff("Holzspanplatten B2 DIN 4102	"	,	null, 	99	,	0.20	,	4.80	),
            new Stoff("Holzwolle-Leichtbauplatten (DIN 1101)	"	,	null, 	100	,	0.70	,	1.70	),
            new Stoff("Hornmehl	"	,	null, 	60	,	0.20	,	5.20	),
            new Stoff("Hülsenfrüchte	"	,	null, 	1	,	0.60	,	4.60	),
            new Stoff("Isopropylalkohol	"	,	null, 	100	,	1.20	,	7.50	),
            new Stoff("Kalkammon-Salpeter	"	,	null, 	100	,	1.20	,	0.10	),
            new Stoff("Kalkammonsalpeter in Säcken aus Polyester, dicht gestapelt, auf Holzpaletten	"	,	null, 	0	,	0.20	,	0.60	),
            new Stoff("Karton, gestrichen oder ungestrichen, zu Ballen gepreßt	"	,	null, 	90	,	0.20	,	4.20	),
            new Stoff("Karton, gestrichten oder ungestrichen, geschnitten auf Paletten	"	,	null, 	100	,	0.20	,	4.20	),
            new Stoff("Kartonagen, Wellpappe (200 Kg/m3)	"	,	null, 	90	,	0.80	,	4.20	),
            new Stoff("Kautschuk (natürlich oder künstlich)	"	,	null, 	100	,	1.20	,	12.20	),
            new Stoff("Kfz-Kunstst. teile	"	,	null, 	60	,	0.40	,	8.40	),
            new Stoff("Klebstoff	"	,	null, 	1	,	0.60	,	11.50	),
            new Stoff("Kleinmöbel Holz	"	,	null, 	15	,	1.20	,	4.80	),
            new Stoff("Kleinmöbel Holz II	"	,	null, 	15	,	1.20	,	4.80	),
            new Stoff("Kohlenmonoxid (CO), (3020 kcal/Nm3)	"	,	null, 	100	,	0.80	,	2.90	),
            new Stoff("Kunstkautschuk (Baypren)	"	,	null, 	100	,	0.60	,	12.20	),
            new Stoff("Kunstkautschuk (EPDM) mit Machons = Rohgummiformlinge	"	,	null, 	100	,	0.60	,	12.20	),
            new Stoff("Lacke u. Farben	"	,	null, 	1	,	0.80	,	8.10	),
            new Stoff("Laubholz	"	,	null, 	100	,	0.60	,	4.80	),
            new Stoff("Leder	"	,	null, 	100	,	0.90	,	9.00	),
            new Stoff("Leder, lose gelagert (Dichte 5 - 15)	"	,	null, 	5	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 10)	"	,	null, 	10	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 11)	"	,	null, 	11	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 12)	"	,	null, 	12	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 13)	"	,	null, 	13	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 14)	"	,	null, 	14	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 15)	"	,	null, 	15	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 5)	"	,	null, 	5	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 6)	"	,	null, 	6	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 7)	"	,	null, 	7	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 8)	"	,	null, 	8	,	1.20	,	5.30	),
            new Stoff("Leder, lose gelagert, (Dichte 9)	"	,	null, 	9	,	1.20	,	5.30	),
            new Stoff("Lederkoffer	"	,	null, 	5	,	1.20	,	7.00	),
            new Stoff("Leutchgas (4000 kcal/Nm3)	"	,	null, 	100	,	0.60	,	4.60	),
            new Stoff("Linoleum	"	,	null, 	100	,	0.60	,	5.80	),
            new Stoff("Lösungsmittel	"	,	null, 	1	,	0.60	,	11.50	),
            new Stoff("Magariene	"	,	null, 	1	,	0.20	,	9.00	),
            new Stoff("Magerkohle	"	,	null, 	80	,	0.60	,	9.90	),
            new Stoff("Magnesium	"	,	null, 	80	,	0.60	,	7.50	),
            new Stoff("Mehl	"	,	null, 	80	,	0.60	,	4.60	),
            new Stoff("Mehl	"	,	null, 	100	,	1.00	,	9.00	),
            new Stoff("Melamin-Formaldehydharz (MF)	"	,	null, 	80	,	0.60	,	5.90	),
            new Stoff("Methan	"	,	null, 	100	,	0.60	,	13.90	),
            new Stoff("Milchpulver	"	,	null, 	80	,	0.05	,	4.60	),
            new Stoff("Nadelholz	"	,	null, 	80	,	0.05	,	5.20	),
            new Stoff("Nahrungsmittel	"	,	null, 	100	,	0.60	,	8.00	),
            new Stoff("Octan	"	,	null, 	100	,	0.05	,	12.80	),
            new Stoff("Öle	"	,	null, 	1	,	0.50	,	11.50	),
            new Stoff("Ölhaltige Betriebsm.	"	,	null, 	1	,	0.60	,	9.00	),
            new Stoff("Paletten aus Holz	"	,	null, 	1	,	0.80	,	4.80	),
            new Stoff("Papier, großformatig geschnitten, auf Rollen eng gewickelt, stehend oder liegend	"	,	null, 	75	,	0.20	,	3.80	),
            new Stoff("Parafin	"	,	null, 	75	,	0.20	,	12.80	),
            new Stoff("Pechkohle	"	,	null, 	75	,	0.20	,	6.20	),
            new Stoff("Pentan	"	,	null, 	100	,	0.20	,	12.50	),
            new Stoff("Petroleum	"	,	null, 	100	,	0.20	,	11.40	),
            new Stoff("Phenol	"	,	null, 	100	,	0.20	,	9.30	),
            new Stoff("Phenol - Formaldehydharz (PF)	"	,	null, 	100	,	0.20	,	3.70	),
            new Stoff("Phenol - Harz	"	,	null, 	100	,	0.20	,	7.00	),
            new Stoff("Phosphor	"	,	null, 	100	,	0.20	,	7.00	),
            new Stoff("PKW Sicherheitszuschlag (pro Fahrzeug)	"	,	null, 	100	,	1.00	,	10.00	),
            new Stoff("Ploystyrol	"	,	null, 	100	,	2.50	,	11.00	),
            new Stoff("Polyacrylnitril zu Ballen verpreßt, Fasern nicht modifiziert	"	,	null, 	0	,	0.80	,	8.20	),
            new Stoff("Polyacrylsäure - Butylester	"	,	null, 	100	,	0.20	,	8.10	),
            new Stoff("Polyamid (PA)	"	,	null, 	100	,	0.20	,	8.20	),
            new Stoff("Polycarbonat (PC)	"	,	null, 	100	,	0.20	,	8.10	),
            new Stoff("Polyester, Garne, Schläuche mit Machons / Innengummierung	"	,	null, 	100	,	0.50	,	9.90	),
            new Stoff("Polyester, mit 30% Glasfaserverstärkung (GFK)	"	,	null, 	100	,	0.20	,	5.20	),
            new Stoff("Polyester, ohne Glasfaserverstärkung	"	,	null, 	100	,	0.20	,	7.50	),
            new Stoff("Polyesterharz, ungesättigt, lose gestappelte Profilst.Glasf.	"	,	null, 	25	,	0.70	,	5.30	),
            new Stoff("Polyester-Polybutylenterephtalat (PBTP)	"	,	null, 	30	,	0.20	,	11.10	),
            new Stoff("Polyester-Polyethylenterephthalat (PETP)	"	,	null, 	30	,	0.20	,	11.10	),
            new Stoff("Polyester-Türen	"	,	null, 	100	,	0.70	,	5.30	),
            new Stoff("Polyethersulfon (PESU)	"	,	null, 	25	,	0.70	,	4.70	),
            new Stoff("Polyethylen-Folie	"	,	null, 	25	,	1.00	,	12.20	),
            new Stoff("Polyethylen-Formteile (leere Bierkästen) gestapelt	"	,	null, 	0	,	0.50	,	12.20	),
            new Stoff("Polyethylen-Granulat in einzelnen Säcken	"	,	null, 	0	,	0.80	,	12.20	),
            new Stoff("Polyformaldehyd	"	,	null, 	25	,	0.50	,	4.60	),
            new Stoff("Polyolefine, (Lupolen, LDPE, HDPE)	"	,	null, 	25	,	0.50	,	12.80	),
            new Stoff("Polyoxymethylen (POM)	"	,	null, 	25	,	0.50	,	4.70	),
            new Stoff("Polypropylen	"	,	null, 	13	,	0.80	,	12.80	),
            new Stoff("Polysulfon (PSU)	"	,	null, 	100	,	0.80	,	10.00	),
            new Stoff("Polytetraflourethylen (PTFE)	"	,	null, 	100	,	0.80	,	1.20	),
            new Stoff("Polyurethan, PUR-Dichtungsmasse, 2-Komponenten	"	,	null, 	100	,	0.30	,	6.40	),
            new Stoff("Polyvinylacetat	"	,	null, 	100	,	0.30	,	5.80	),
            new Stoff("Polyvinylchlorid PVC-weich	"	,	null, 	90	,	0.40	,	8.30	),
            new Stoff("Polyvinylpropionat	"	,	null, 	90	,	0.40	,	7.00	),
            new Stoff("Poyisobutylen (PIB)	"	,	null, 	25	,	0.50	,	12.80	),
            new Stoff("Poymethylmethacrylat (PMMA)	"	,	null, 	25	,	0.50	,	7.20	),
            new Stoff("Propan	"	,	null, 	100	,	0.40	,	12.80	),
            new Stoff("Reet-Vorhang	"	,	null, 	0	,	1.00	,	4.80	),
            new Stoff("Resopal	"	,	null, 	80	,	0.40	,	5.00	),
            new Stoff("Roggenmehl	"	,	null, 	60	,	1.00	,	4.60	),
            new Stoff("Rohbraunkohle	"	,	null, 	100	,	0.40	,	3.50	),
            new Stoff("Rohgummi, Kunstkautschuk (EPDM)	"	,	null, 	100	,	0.60	,	12.20	),
            new Stoff("Sandwichwand (PUR-Kern, 5 kg/m²)	"	,	null, 	100	,	0.30	,	6.70	),
            new Stoff("Schmierfett in offener Wanne (Blechbehälter)	"	,	null, 	100	,	0.50	,	11.50	),
            new Stoff("Schmieröl	"	,	null, 	100	,	0.80	,	13.30	),
            new Stoff("Schmierstoffe	"	,	null, 	100	,	0.80	,	13.30	),
            new Stoff("Schuhe	"	,	null, 	1	,	0.90	,	9.00	),
            new Stoff("Schwefel	"	,	null, 	100	,	0.80	,	2.90	),
            new Stoff("Sicherheitszuschlag	"	,	null, 	0	,	1.00	,	10.00	),
            new Stoff("Speiseöle	"	,	null, 	1	,	0.80	,	13.30	),
            new Stoff("Spiritus	"	,	null, 	100	,	0.20	,	6.90	),
            new Stoff("Stadtgas	"	,	null, 	100	,	0.20	,	4.60	),
            new Stoff("Stearin	"	,	null, 	100	,	0.20	,	11.00	),
            new Stoff("Steinkohlenkoks	"	,	null, 	100	,	0.20	,	8.10	),
            new Stoff("Styrol-Copolymere (Luran (SAN), Terluran (ABS), ASA)	"	,	null, 	100	,	0.20	,	10.60	),
            new Stoff("Textilabfall in Ballen, Mischgewebe	"	,	null, 	0	,	0.80	,	8.00	),
            new Stoff("Textilien	"	,	null, 	80	,	0.80	,	8.00	),
            new Stoff("Toluol	"	,	null, 	100	,	0.80	,	11.00	),
            new Stoff("Ton- u. Datenträgerkassetten, nicht spezifiziert, lose gelagert	"	,	null, 	80	,	1.60	,	6.00	),
            new Stoff("Ton- u. Datenträgerkassetten, Polycarbonat-Gehäuse und Polyester-Band, im Karton	"	,	null, 	100	,	0.20	,	6.00	),
            new Stoff("Ton- u. Datenträgerkassetten, Polycarbonat-Gehäuse und Polyester-Band, lose gel.	"	,	null, 	80	,	0.60	,	6.00	),
            new Stoff("Torf	"	,	null, 	100	,	0.80	,	4.00	),
            new Stoff("Treibgas	"	,	null, 	1	,	1.30	,	13.30	),
            new Stoff("Treibgas (Dosen)	"	,	null, 	1	,	1.30	,	13.30	),
            new Stoff("Treibgas (in Dosen)	"	,	null, 	1	,	1.30	,	13.30	),
            new Stoff("Verkabelung	"	,	null, 	0	,	1.00	,	1.00	),
            new Stoff("Vulkanisiermittel (z. B. Schwefel, Beschleuniger, Füllstoffe)	"	,	null, 	100	,	0.50	,	4.60	),
            new Stoff("Waschpulver	"	,	null, 	50	,	1.00	,	8.20	),
            new Stoff("Wassergas	"	,	null, 	100	,	0.50	,	2.90	),
            new Stoff("Wasserstoff (2580 kcal/Nm3)	"	,	null, 	100	,	0.50	,	33.10	),
            new Stoff("Wellpappe (Karton, 200 kg/m3)	"	,	null, 	100	,	0.80	,	4.20	),
            new Stoff("Zechenkohle	"	,	null, 	100	,	0.40	,	8.40	),
            new Stoff("Zechenkohle in Säcken	"	,	null, 	100	,	0.40	,	12.00	)
            );
//----------------------------------------------------------------------------------------------------------------------


    public void initialize(URL url, ResourceBundle resourceBundle) {

//----------------------------------------------------------------------------------------------------------------------
        /**
         * "SetUp" der TreeTableView und der Spalten
         */

        //TreeTableView
        TreeTableColumnStoff.setCellValueFactory(new TreeItemPropertyValueFactory<Stoff, String>("nameStoff"));
        TreeTableColumnBeschreibung.setCellValueFactory(new TreeItemPropertyValueFactory<Stoff, String>("beschreibungStoff"));
        TreeTableColumnLagerungsdichte.setCellValueFactory(new TreeItemPropertyValueFactory<Stoff, Integer>("lagerungsdichteStoff"));
        TreeTableColumnHeizwert.setCellValueFactory(new TreeItemPropertyValueFactory<Stoff, Double>("heizwertStoff"));
        TreeTableColumnAbbrandfaktor.setCellValueFactory(new TreeItemPropertyValueFactory<Stoff, Double>("abbrandfaktorStoff"));


        TreeItem<Stoff> root = new TreeItem<Stoff>(new Stoff("Stoff", null,null, null, null));
        TreeTableViewMaterialbibliothek.setRoot(root);
        root.setExpanded(true);
        TreeTableViewMaterialbibliothek.setShowRoot(false);
//----------------------------------------------------------------------------------------------------------------------
        /**
         * Die Listen mit den Stoffdaten werden in die TreeView eingespielt
         */

        stoffe1Ebene.stream().forEach((stoff -> {
            root.getChildren().add(new TreeItem<Stoff>(stoff));
        }));

        //Index 0 entsprichte "Papier"
        stoffeHolz.stream().forEach(stoff -> {
            TreeItem<Stoff> itemHolz = root.getChildren().get(0);
            itemHolz.getChildren().add(new TreeItem<>(stoff));
        });

        //Index 1 entspricht "Papier"
        stoffePapier.stream().forEach(stoff -> {
            TreeItem<Stoff> itemPapier = root.getChildren().get(1);
            itemPapier.getChildren().add(new TreeItem<>(stoff));
        });

        //Index 2 entspricht "Textilien"
        stoffeTextilien.stream().forEach(stoff -> {
            TreeItem<Stoff> itemTextilien = root.getChildren().get(2);
            itemTextilien.getChildren().add(new TreeItem<>(stoff));
        });

        //Index 3 entspricht "Kunststoffe"
        stoffeKunststoffe.stream().forEach(stoff -> {
            TreeItem<Stoff> itemKunststoffe = root.getChildren().get(3);
            itemKunststoffe.getChildren().add(new TreeItem<>(stoff));
        });

        //Index 4 entspricht "Kohleartige Stoffe"
        stoffeKohleartigeStoffe.stream().forEach(stoff -> {
            TreeItem<Stoff> itemKohleartigeStoffe = root.getChildren().get(4);
            itemKohleartigeStoffe.getChildren().add(new TreeItem<>(stoff));
        });

        //Index 5 entspricht "Organische Verbindungen, flüssig"
        stoffeOrganischeVerbindungenFlüssig.stream().forEach(stoff -> {
            TreeItem<Stoff> itemOrganischeVerbindungenFlüssig = root.getChildren().get(5);
            itemOrganischeVerbindungenFlüssig.getChildren().add(new TreeItem<>(stoff));
        });

        //Index 6 entspricht "Organische Verbindungen, fest"
        stoffeOrganischeVerbindungenFest.stream().forEach(stoff -> {
            TreeItem<Stoff> itemOrganischeVerbindungenFest = root.getChildren().get(6);
            itemOrganischeVerbindungenFest.getChildren().add(new TreeItem<>(stoff));
        });

        //Index 7 entspricht "Lebensmittel"
        stoffeLebensmittel.stream().forEach(stoff -> {
            TreeItem<Stoff> itemLebensmittel = root.getChildren().get(7);
            itemLebensmittel.getChildren().add(new TreeItem<>(stoff));
        });

        //Index 8 entspricht "Kabelisolierungen"
        stoffeKabelisolierungen.stream().forEach(stoff -> {
            TreeItem<Stoff> itemKabelisolierungen = root.getChildren().get(8);
            itemKabelisolierungen.getChildren().add(new TreeItem<>(stoff));
        });

        //Index 9 entspricht "Sonstige Stoffe"
        stoffeSonstigeStoffe.stream().forEach(stoff -> {
            TreeItem<Stoff> itemSonstigeStoffe = root.getChildren().get(9);
            itemSonstigeStoffe.getChildren().add(new TreeItem<>(stoff));
        });



//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
    }

}