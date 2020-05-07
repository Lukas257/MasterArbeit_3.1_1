//package Pdf;
//
//
//import Ergebnis.ErgebnisController;
//import MainWindow.MainWindowController;
//import TreeView.TreeViewController;
//import com.sun.glass.ui.Application;
//import javafx.fxml.Initializable;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDFont;
//import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
//import org.apache.pdfbox.pdmodel.font.PDType1CFont;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.SQLOutput;
//import java.util.ResourceBundle;
//
//
//public class ErstellePDFBBA1 implements Initializable {
//
//    TreeViewController treeViewController;
//
//    public ErstellePDFBBA1(TreeViewController treeViewController) {
//        this.treeViewController = treeViewController;
//    }
//
//
//    /**
//     * erstellt die PDF-Datei aus den Eingaben des Nutzers und den Berechnungen
//     * @throws IOException
//     */
//    public void erstellePdfBBA1() throws IOException {
//
//        // Create a document and add a page to it
//        PDDocument documentBBA1 = new PDDocument();
//        PDPage page = new PDPage();
//        documentBBA1.addPage( page );
//
//// Create a new font object selecting one of the PDF base fonts
//        PDFont font = PDType1Font.HELVETICA_BOLD;
//        PDFont text = PDType1Font.HELVETICA;
//
//// Start a new content stream which will "hold" the to be created content
//        PDPageContentStream contentStream = new PDPageContentStream(documentBBA1, page);
//
//
//// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
//
////-----------------------------------------Überschrift-Anfang: Name BBA
//
//        contentStream.beginText();
//        contentStream.setFont( font, 14 );
//        contentStream.moveTextPositionByAmount( 50, 750 );
//        contentStream.drawString( "Brandbekämpfungsabschnitt 1: " + treeViewController.bba1.getNameBBA());
//        contentStream.endText();
//
////-----------------------------------------Überschrift-Ende: Namme BBA
//
////------------------------------------------------------Anfang Projekt-Informationen
//        contentStream.beginText();
//        contentStream.setFont( font, 14 );
//        contentStream.moveTextPositionByAmount( 50, 700 );
//        contentStream.drawString( "Projektbezeichnung: ");
//        contentStream.endText();
//
//
//
//        contentStream.beginText();
//        contentStream.setFont( text, 12 );
//        contentStream.moveTextPositionByAmount( 192, 700 );
//        contentStream.drawString("Test");
//        contentStream.endText();
//
//
////------------------------------------------------------Ende Text
//
//        contentStream.close();
//        documentBBA1.save("C:\\Users\\Lukas\\IdeaProjects\\MasterArbeit 3.0\\BBA1.pdf");
//        documentBBA1.close();
//
//
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }
//
//}
