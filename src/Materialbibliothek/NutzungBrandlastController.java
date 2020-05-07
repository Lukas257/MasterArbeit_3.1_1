package Materialbibliothek;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class NutzungBrandlastController implements Initializable {


    @FXML
    private TreeTableView<Nutzung> TreeTableViewNutzungBrandlast;

    @FXML
    private TreeTableColumn<Nutzung, String> TreeTableColumnNutzung;

    @FXML
    private TreeTableColumn<Nutzung, Double> TreeTableColumnBrandlast;

    @FXML
    private TreeTableColumn<Nutzung, Double> TreeTableColumnBrandlast1;

    @FXML
    private TreeTableColumn<Nutzung, Double> TreeTableColumnBrandlast2;

    @FXML
    private TreeTableColumn<Nutzung, Double> TreeTableColumnBrandlast3;

    /**
     * Hier Listen der Nutzung
     * @param url
     * @param resourceBundle
     */

    List<Nutzung> nutzungList = Arrays.<Nutzung>asList(
            //Seite 1
            new Nutzung("Abfüllung von Getränke und Bereitstellung	",	208	,	null	,	null	),
            new Nutzung("Akkumulatorenfabrik (Kommisionierung)	",	45	,	null	,	null	),
            new Nutzung("Akkumulatorenfabrik (Regallager)	",	404	,	null	,	null	),
            new Nutzung("Altpapierverarbeitung (Sortierung, Produktion)	",	115	,	459	,	2285	),
            new Nutzung("Aluminiumverarbeitung	",	21	,	75	,	270	),
            new Nutzung("Arzneimittelfabrik	",	36	,	null	,	null	),
            new Nutzung("Automobilfabrik	",	34	,	47	,	null	),
            new Nutzung("Automobilwerkstatt	",	16	,	67	,	null	),
            new Nutzung("Auto-Türbeschlag-Fertigung / Montage	",	111	,	null	,	null	),
            new Nutzung("Auto-Türbeschläge / Fertigung	",	191	,	null	,	null	),
            new Nutzung("Backwarenfabrik	",	17	,	32	,	null	),
            new Nutzung("Batterie Kommissionierungslager	",	45	,	null	,	null	),
            new Nutzung("Batterie-Regallager	",	404	,	null	,	null	),
            new Nutzung("Baumarkt	",	85	,	138	,	756	),
            new Nutzung("Bekleidungslager Hänge- und Kartonware	",	45	,	null	,	null	),
            new Nutzung("Bettwarenfabrik	",	63	,	null	,	null	),
            new Nutzung("Blechbearbeitung und Pulverbeschichtung	",	39	,	null	,	null	),
            new Nutzung("Blechbearbeitung / Edelstahlküchengeräte	",	33	,	null	,	null	),
            new Nutzung("Blechwarenfabrik	",	27	,	71	,	137	),
            new Nutzung("Blocklager für Blechteile PKW	",	80	,	null	,	null	),
            new Nutzung("Blumen-Abholhalle / Versteigerung	",	82	,	null	,	null	),
            new Nutzung("Bootswerft	",	90	,	null	,	null	),
            new Nutzung("Brauerei	",	13	,	25	,	64	),
            new Nutzung("Buchbinderei	",	28	,	53	,	223	),
            new Nutzung("Bügeleisen-Endmontage	",	69	,	null	,	null	),
            new Nutzung("Bügeleisen-Kunststoffspritzerei	",	53	,	null	,	null	),
            new Nutzung("Bügeleisen-Sohlenfertigung	",	28	,	null	,	null	),
            new Nutzung("Bügeleisen-Werkzeugbau	",	34	,	null	,	null	),
            new Nutzung("Büro	",	66	,	93	,	123	),
            new Nutzung("Bürostühle-Produktion und Bürotischlager	",	153	,	null	,	null	),
            new Nutzung("Coilanlage ohne Holz	",	22	,	null	,	null	),
            new Nutzung("Dachpappenfabrik	",	226	,	265	,	null	),
            new Nutzung("Dämmstofflager	",	210	,	null	,	null	),
            new Nutzung("Diskothek	",	39	,	null	,	null	),
            new Nutzung("Drahtzieherei	",	16	,	61	,	null	),
            new Nutzung("Dreherei-Aluräderbearbeitung	",	45	,	null	,	null	),
            new Nutzung("Dreherei / Fräserei	",	22	,	null	,	null	),
            new Nutzung("Dreherei / Fräserei / schleifen	",	30	,	null	,	null	),
            new Nutzung("Dreherei / Fräserei-Fertigung	",	31	,	null	,	null	),
            new Nutzung("Druckfarbenlager	",	85	,	null	,	null	),
            new Nutzung("Druckerei	",	18	,	74	,	109	),
            new Nutzung("Druckerei / Weiterverarbeitung	",	60	,	null	,	null	),
            new Nutzung("Druckerei / Versandlager	",	269	,	null	,	null	),
            new Nutzung("Druckerei	",	74	,	null	,	null	),
            new Nutzung("Druckerei	",	18	,	null	,	null	),
            new Nutzung("Druckmaschinen Montage	",	17	,	null	,	null	),
            new Nutzung("Elektronikfabrik	",	97	,	500	,	null	),
            new Nutzung("Elektroverteilanlagen (Gerätebau)	",	54	,	null	,	null	),
            new Nutzung("Entfettungsmaschinenbau	",	19	,	null	,	null	),
            new Nutzung("E-Schalter mit Versand	",	111	,	null	,	null	),
            //Seite 2
            new Nutzung("E-Schalter / Kabel / E-Heizer-Fertigung	",	78	,	null	,	null	),
            new Nutzung("Färberei	",	63	,	107	,	117	),
            new Nutzung("Fahrradfabrik	",	9	,	28	,	49	),
            new Nutzung("Farb- und Lackfabrik	",	85	,	314	,	585	),
            new Nutzung("Faßlager für Keramik- und Metallabfälle	",	233	,	null	,	null	),
            new Nutzung("Fensterfabrik - Aluminium	",	29	,	32	,	52	),
            new Nutzung("Fensterfabrik - Holz, Kunststoff	",	92	,	159	,	218	),
            new Nutzung("Fertighausfabrik	",	111	,	186	,	null	),
            new Nutzung("Fertigung-Bäckereimaschinen / Backöfen	",	18	,	null	,	null	),
            new Nutzung("Fertigung / Montage von Verteilerpumpen	",	20	,	null	,	null	),
            new Nutzung("Fertigwarenlager für Auto / Türbeschlage	",	223	,	null	,	null	),
            new Nutzung("Fleischfabrik	",	160	,	null	,	null	),
            new Nutzung("Flugzeugfabrik	",	32	,	94	,	278	),
            new Nutzung("Flugzeuglackierhalle	",	104	,	null	,	null	),
            new Nutzung("Fotomaterialfabrik	",	6	,	31	,	null	),
            new Nutzung("Furnierfabrik	",	63	,	114	,	126	),
            new Nutzung("Getränke-Vollgut-Lager	",	362	,	null	,	null	),
            new Nutzung("Getränke-Kommissionierung	",	96	,	null	,	null	),
            new Nutzung("Getränke-Leergutlager	",	606	,	null	,	null	),
            new Nutzung("Getränke-Abfüllung	",	55	,	null	,	null	),
            new Nutzung("Gießerei	",	32	,	null	,	null	),
            new Nutzung("Glasfabrik	",	42	,	55	,	59	),
            new Nutzung("Großküche	",	125	,	null	,	null	),
            new Nutzung("Grubenlokomotivenbau	",	29	,	null	,	null	),
            new Nutzung("Gummilitzenfertigung	",	45	,	null	,	null	),
            new Nutzung("Gummiwarenfabrik	",	25	,	45	,	null	),
            new Nutzung("Hemden, Bettücher, Hosen, Bademäntel	",	183	,	null	,	null	),
            new Nutzung("Holzverarbeitungsbetrieb	",	60	,	146	,	null	),
            new Nutzung("Humuswerk / Erdverbesserer / Rindenmulch / Klärschlamm	",	214	,	null	,	null	),
            new Nutzung("Isolierglasfertigung	",	35	,	null	,	null	),
            new Nutzung("Isolierglasfertigung	",	39	,	null	,	null	),
            new Nutzung("Kabelbündelfertigung / Airbus	",	145	,	null	,	null	),
            new Nutzung("Kabelfabrik	",	26	,	119	,	241	),
            new Nutzung("Kabelverwertung (PVC, Gummi u. a.)	",	111	,	null	,	null	),
            new Nutzung("Kakaoverarbeitung	",	375	,	null	,	null	),
            new Nutzung("Kantine in Bürogebäuden	",	70	,	85	,	null	),
            new Nutzung("Kartonagen / Prospekte / Regallager	",	1049	,	null	,	null	),
            new Nutzung("Kartonagenfabrik	",	25	,	71	,	null	),
            new Nutzung("Kaufhaus	",	104	,	null	,	null	),
            new Nutzung("Keramischer Betrieb	",	24	,	37	,	56	),
            new Nutzung("Kfz-Aufbauten / Schlosserei	",	171	,	null	,	null	),
            new Nutzung("Kfz-Werkstatt / Ausstellung / Verkauf	",	74	,	null	,	null	),
            new Nutzung("Kinderwindeln-Produktion	",	31	,	null	,	null	),
            new Nutzung("Kleiderfabrik	",	56	,	100	,	null	),
            new Nutzung("Kleiderlager in 4 Ebenen	",	508	,	null	,	null	),
            new Nutzung("Kleiderspedition	",	94	,	null	,	null	),
            new Nutzung("Kleiderspedition	",	230	,	null	,	null	),
            new Nutzung("Kornmissionierung / Alufelgen	",	52	,	null	,	null	),
            new Nutzung("Konservenfabrik / Produktion Gemüse / Obst	",	37	,	null	,	null	),
            new Nutzung("Kommissionierung / Reifen	",	227	,	null	,	null	),
            new Nutzung("Konservenfabrik	",	17	,	37	,	null	),
            new Nutzung("Kosmetikfabrik	",	142	,	null	,	null	),
            new Nutzung("Kühl-Leerguthalle	",	138	,	null	,	null	),
            new Nutzung("Kühlhaus / Gemüse, Fertiggerichte, Butter, Fleisch	",	918	,	null	,	null	),
            new Nutzung("Kühlhaus / Milch, Joghurt, Käse	",	942	,	null	,	null	),
            new Nutzung("Kühlmöbelfabrik	",	23	,	107	,	null	),

            //Seite 3
            new Nutzung("Kühltruhenlager und Kataloge	",	253	,	null	,	null	),
            new Nutzung("Kunststoffaufbereitungsanlage	",	1721	,	null	,	null	),
            new Nutzung("Kunststoffe-Polyester Schalen-Fertigung	",	180	,	null	,	null	),
            new Nutzung("Kunststoff-Fensterfertigung für Campingwagen	",	103	,	null	,	null	),
            new Nutzung("Kunststoffspritzerei	",	66	,	null	,	null	),
            new Nutzung("Kunststoffspritzerei mit Granulatlager	",	598	,	null	,	null	),
            new Nutzung("Kunststoffspritzerei mit Silos	",	565	,	null	,	null	),
            new Nutzung("Kunststoffspritzerei mit Zwischenlager	",	243	,	null	,	null	),
            new Nutzung("Kunststoff-Granulatlager	",	4340	,	null	,	null	),
            new Nutzung("Kunststoffverarbeitung (keine Schaumstoffe)	",	39	,	52	,	180	),
            new Nutzung("Labor -chemisch	",	42	,	200	,	null	),
            new Nutzung("Lackieranlage für Alufelgen Pulver- / Naß	",	17	,	null	,	null	),
            new Nutzung("Lackiergebäude Automobilindustrie	",	27	,	null	,	null	),
            new Nutzung("Lackiererei	",	17	,	25	,	36	),
            new Nutzung("Lackierhalle Airbusrumpfteile	",	33	,	null	,	null	),
            new Nutzung("Lacklager	",	776	,	null	,	null	),
            new Nutzung("Lager / Heizkörper	",	242	,	null	,	null	),
            new Nutzung("Lager / Versand von Verteilerpumpen u. a.	",	67	,	null	,	null	),
            new Nutzung("Lager für Akustikdecken u. a.	",	207	,	null	,	null	),
            new Nutzung("Lager für Aluprofile (Halle mit Holzbinder)	",	64	,	null	,	null	),
            new Nutzung("Lager für Brandschutztüren und - tore	",	32	,	null	,	null	),
            new Nutzung("Lager für Brandschutztüren und - tore	",	107	,	null	,	null	),
            new Nutzung("Lager für Bürostühle	",	512	,	null	,	null	),
            new Nutzung("Lager für Druckerei	",	620	,	null	,	null	),
            new Nutzung("Lager für Edelstahlbleche	",	114	,	null	,	null	),
            new Nutzung("Lager für Edelstahl und Bleche	",	141	,	null	,	null	),
            new Nutzung("Lager für Flaschen und Pappe	",	122	,	null	,	null	),
            new Nutzung("Lager für Floristenbedarf	",	942	,	null	,	null	),
            new Nutzung("Lager für Garten- / Campingmöbel	",	854	,	null	,	null	),
            new Nutzung("Lager für Heizkörper	",	319	,	null	,	null	),
            new Nutzung("Lager für Katalog-Versandware	",	4538	,	null	,	null	),
            new Nutzung("Lager für Kosmetik Kommissionierung	",	101	,	null	,	null	),
            new Nutzung("Lager für Kunststoffgranulate	",	1631	,	null	,	null	),
            new Nutzung("Lager für Kunststoffprofile aus PVC	",	1099	,	null	,	null	),
            new Nutzung("Lager für Mineralölprodukte (nach VbF)	",	2704	,	null	,	null	),
            new Nutzung("Lager für Papier und Zellulose	",	805	,	null	,	null	),
            new Nutzung("Lager für Profilholz-Spanplatten u. a.	",	782	,	null	,	null	),
            new Nutzung("Lager für Profilholz und Lasierung	",	862	,	null	,	null	),
            new Nutzung("Lager für Reifen	",	584	,	null	,	null	),
            new Nutzung("Lager für Reifen	",	1766	,	null	,	null	),
            new Nutzung("Lager für Rohware Holz	",	1021	,	null	,	null	),
            new Nutzung("Lager für Schraubenverbindungen	",	197	,	null	,	null	),
            new Nutzung("Lager für Stahl	",	21	,	null	,	null	),
            new Nutzung("Lager für Stahlfelgen auf Paletten	",	266	,	null	,	null	),
            new Nutzung("Lager für Textilien, Katalogversand	",	205	,	null	,	null	),
            new Nutzung("Lager für Töpfe / Pfannen auf Paletten	",	511	,	null	,	null	),
            new Nutzung("Lager für Zigaretten, Snackartikel	",	883	,	null	,	null	),
            new Nutzung("Lagerhalle Etuis aus Pappe	",	3092	,	null	,	null	),
            new Nutzung("Lager Obstkonserven	",	135	,	null	,	null	),
            new Nutzung("Lebensmittellager	",	277	,	null	,	null	),
            new Nutzung("Lebensmittellager / Frischgemüse	",	276	,	null	,	null	),
            new Nutzung("Lederwarenfabrik (Verarbeitung)	",	45	,	116	,	332	),
            new Nutzung("Leergutlager Getränke	",	1380	,	null	,	null	),
            new Nutzung("Leer- und Vollgutlager Getränke	",	1472	,	null	,	null	),
            new Nutzung("Leichtmetallbetrieb	",	25	,	null	,	null	),
            new Nutzung("LKW-Aufbauten / Werkstatt	",	79	,	null	,	null	),

            //Seite 4
            new Nutzung("LKW Verladehalle und Ersatzteilversand	",	38	,	null	,	null	),
            new Nutzung("Lüftungs- und Ventilatorenbau	",	36	,	null	,	null	),
            new Nutzung("Maschinenbau Krankabinenfertigung	",	45	,	null	,	null	),
            new Nutzung("Maschinenbau mit Fertigteilelager	",	51	,	null	,	null	),
            new Nutzung("Maschinenbau	",	29	,	null	,	null	),
            new Nutzung("Maschinenbau	",	59	,	null	,	null	),
            new Nutzung("Maschinenbau / Rollengänge	",	34	,	null	,	null	),
            new Nutzung("Maschinenfabrik	",	16	,	29	,	59	),
            new Nutzung("Matratzenfabrik	",	36	,	null	,	null	),
            new Nutzung("Matratzenfabrik (Textil und Kunststoff)	",	114	,	null	,	null	),
            new Nutzung("Matratzenfabrik - mit Schaumstoff	",	71	,	114	,	189	),
            new Nutzung("Möbelausstellung	",	51	,	150	,	null	),
            new Nutzung("Möbelfabrik	",	58	,	111	,	264	),
            new Nutzung("Molkerei	",	82	,	96	,	null	),
            new Nutzung("Museum	",	13	,	null	,	null	),
            new Nutzung("Museum EG	",	58	,	null	,	null	),
            new Nutzung("Museum OG	",	24	,	null	,	null	),
            new Nutzung("Näherei	",	32	,	108	,	null	),
            new Nutzung("Papierfabrik	",	17	,	null	,	null	),
            new Nutzung("Parkettfabrik	",	63	,	90	,	null	),
            new Nutzung("Porzellanfabrik (Lager)	",	216	,	null	,	null	),
            new Nutzung("Porzelanschlagstelle	",	54	,	97	,	162	),
            new Nutzung("Reinigung (chemische)	",	56	,	null	,	null	),
            new Nutzung("Restaurant	",	195	,	null	,	null	),
            new Nutzung("Schaumstoffabrik	",	104	,	null	,	null	),
            new Nutzung("Schlachthäuser	",	25	,	59	,	130	),
            new Nutzung("Schokoladenfabrik	",	74	,	131	,	217	),
            new Nutzung("Schuhwarenfabrik	",	92	,	75	,	null	),
            new Nutzung("Seilerei (Lager)	",	1082	,	null	,	null	),
            new Nutzung("Spanplattenfabrik	",	88	,	211	,	null	),
            new Nutzung("Sperrholzfabrik	",	182	,	null	,	null	),
            new Nutzung("Spinnerei	",	112	,	null	,	null	),
            new Nutzung("Spritzgußfabrik - Kunststoff	",	90	,	328	,	735	),
            new Nutzung("Spritzgußfabrik - Metall	",	77	,	null	,	null	),
            new Nutzung("Stahlmöbelfabrik	",	16	,	null	,	null	),
            new Nutzung("Süßwarenfabrik (Lager)	",	234	,	null	,	null	),
            new Nutzung("Tabakwarenfabrik (Lager)	",	166	,	179	,	556	),
            new Nutzung("Teeaufbereitung und Lager	",	481	,	null	,	null	),
            new Nutzung("Teppichfabrik (Teppichboden)	",	31	,	null	,	null	),
            new Nutzung("Textilbetrieb	",	115	,	223	,	null	),
            new Nutzung("Textillager / hängende Ware	",	70	,	null	,	null	),
            new Nutzung("Textillagerpakete auf Paletten	",	468	,	null	,	null	),
            new Nutzung("Tiefkühlhaus / Eiscreme, Pizza, Fleisch	",	946	,	null	,	null	),
            new Nutzung("Tierverwertung	",	88	,	null	,	null	),
            new Nutzung("Türen Massivholzfertigung	",	156	,	null	,	null	),
            new Nutzung("Türfabrik - Aluminium	",	10	,	null	,	null	),
            new Nutzung("Türfabrik - Holz, Kunststoff	",	33	,	147	,	175	),
            new Nutzung("Uhrenfabrik	",	31	,	48	,	null	),
            new Nutzung("Umschlaglager-Spedition	",	274	,	null	,	null	),
            new Nutzung("Umschlaglager für Arzneimittel	",	174	,	null	,	null	),
            new Nutzung("Vakuum-Metalisierung von Kunststoff	",	280	,	null	,	null	),
            new Nutzung("Verpackungsmittel / Lager / Zigarettenindustrie	",	457	,	null	,	null	),
            new Nutzung("Verbandstoffabrik (Regallager)	",	1231	,	null	,	null	),
            new Nutzung("Verzinkerei	",	97	,	null	,	null	),
            new Nutzung("Vulkanisierbetrieb	",	81	,	149	,	233	),
            new Nutzung("Wachsfabrik (Kerzen)	",	78	,	null	,	null	),
            new Nutzung("Wachsfabrik (Kerzen, Lager)	",	1398	,	null	,	null	),
            new Nutzung("Wäschereien	",	29	,	32	,	45	),

            //Seite 5
            new Nutzung("Waggonfabrik	",	14	,	37	,	65	),
            new Nutzung("Warenhaus	",	97	,	356	,	624	),
            new Nutzung("Webereien	",	74	,	112	,	213	),
            new Nutzung("Weinabfüllung	",	21	,	null	,	null	),
            new Nutzung("Werkzeugbau / Feinmechanik	",	115	,	null	,	null	),
            new Nutzung("Werkzeugbau / Montage	",	23	,	null	,	null	),
            new Nutzung("Werkzeugmaschinen-Montage	",	34	,	null	,	null	),
            new Nutzung("Wellpappenfabrik	",	33	,	71	,	224	),
            new Nutzung("Wertstoff- und Abfall-Sortieranlage	",	284	,	null	,	null	),
            new Nutzung("Wertstoff- und Abfall-Sortieranlage	",	716	,	null	,	null	),
            new Nutzung("Wertstoff- und Abfall-Sortieranlage	",	668	,	null	,	null	),
            new Nutzung("Wertstoff- und Abfall-Sortieranlage	",	2531	,	null	,	null	),
            new Nutzung("Wertstoff- und Abfall-Sortieranlage	",	95	,	null	,	null	),
            new Nutzung("Wertstoff- und Abfall-Sortieranlage für Papier / Pappe	",	229	,	null	,	null	),
            new Nutzung("Zellstofflager	",	1545	,	null	,	null	),
            new Nutzung("Zellstoffzwischenlager mit Technik	",	189	,	null	,	null	),
            new Nutzung("Ziegelei	",	19	,	25	,	32	),
            new Nutzung("Zuckerfabrik	",	84	,	null	,	null	)

            );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /**
         * "SetUp" der TreeTableView und der Spalten
         */

        //TreeTableView
        TreeTableColumnNutzung.setCellValueFactory(new TreeItemPropertyValueFactory<Nutzung, String>("nutzung"));
        TreeTableColumnBrandlast1.setCellValueFactory(new TreeItemPropertyValueFactory<Nutzung, Double>("brandlast1"));
        TreeTableColumnBrandlast2.setCellValueFactory(new TreeItemPropertyValueFactory<Nutzung, Double>("brandlast2"));
        TreeTableColumnBrandlast3.setCellValueFactory(new TreeItemPropertyValueFactory<Nutzung, Double>("brandlast3"));


        TreeItem<Nutzung> root = new TreeItem<Nutzung>(new Nutzung("Nutzung", null, null, null));
        TreeTableViewNutzungBrandlast.setRoot(root);
        root.setExpanded(true);
        TreeTableViewNutzungBrandlast.setShowRoot(false);


        /**
         * Die Listen mit den Nutzungen werden in die TreeView eingespielt
         */

        nutzungList.stream().forEach((nutzung -> {
            root.getChildren().add(new TreeItem<Nutzung>(nutzung));
        }));

    }
}
