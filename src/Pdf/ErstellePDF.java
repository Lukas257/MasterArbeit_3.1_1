package Pdf;

import MainWindow.MainWindowController;
import javafx.fxml.Initializable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ErstellePDF implements Initializable {

    MainWindowController mainWindowController;

   public ErstellePDF(MainWindowController mainWindowController) {
       this.mainWindowController = mainWindowController;
    }

    /**
     * erstellt die PDF-Datei mit den Projektinformationen (Seite 1)
     * @throws IOException
     */

    public void erstellePdf() throws IOException {


        // Create a document and add a page to it
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage( page );

        // Create a new font object selecting one of the PDF base fonts
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont text = PDType1Font.HELVETICA;

        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream contentStream = new PDPageContentStream(document, page);


// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"

//-----------------------------------------Überschrift-Anfang

        contentStream.beginText();
        contentStream.setFont( font, 16 );
        contentStream.moveTextPositionByAmount( 50, 750 );
        contentStream.drawString( "Brandschutznachweis nach DIN 18230" );
        contentStream.endText();

//-----------------------------------------Überschrift-Ende

//-----------------------------------------Imnformationen-Anfang

        contentStream.beginText();
        contentStream.setFont( text, 8 );
        contentStream.moveTextPositionByAmount( 50, 740 );
        contentStream.drawString( "Masterarbeit, Lukas Schumacher" );
        contentStream.endText();

//-----------------------------------------Informationen-Ende

//------------------------------------------------------Anfang Projekt-Informationen
        contentStream.beginText();
        contentStream.setFont( font, 14 );
        contentStream.moveTextPositionByAmount( 50, 700 );
        contentStream.drawString( "Projektbezeichnung: ");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( font, 14 );
        contentStream.moveTextPositionByAmount( 192, 700 );
        contentStream.drawString( mainWindowController.getProjektbezeichnung());
        contentStream.endText();

        // Name, Firma, Straße, PLZ/Ort, Tel.:, E-Mail:
        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 50, 680 );
        contentStream.drawString( "Projektnummer: ");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 192, 680 );
        contentStream.drawString( mainWindowController.getProjektnummer());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 50, 660 );
        contentStream.drawString( "Datum: ");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 192, 660 );
        contentStream.drawString( mainWindowController.getDatum() );
        contentStream.endText();

//------------------------------------------------------Ende Projekt-Informationen

//------------------------------------------------------Anfang Bauherr-Informationen
        contentStream.beginText();
        contentStream.setFont( font, 14 );
        contentStream.moveTextPositionByAmount( 50, 600 );
        contentStream.drawString( "Bauherr" );
        contentStream.endText();

        // Name, Firma, Straße, PLZ/Ort, Tel.:, E-Mail:
        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 50, 580 );
        contentStream.drawString( "Name:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 105, 580 );
        contentStream.drawString( mainWindowController.getBauherrName());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 50, 560 );
        contentStream.drawString( "Firma:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 105, 560 );
        contentStream.drawString( mainWindowController.getBauherrFirma() );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 50, 540 );
        contentStream.drawString( "Straße:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 105, 540 );
        contentStream.drawString( mainWindowController.getBauherrStraße() );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 50, 520 );
        contentStream.drawString( "PLZ/Ort:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 105, 520 );
        contentStream.drawString( mainWindowController.getBauherrOrt() );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 50, 500 );
        contentStream.drawString( "Tel.:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 105, 500 );
        contentStream.drawString(mainWindowController.getBauherrTelefon());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 50, 480 );
        contentStream.drawString( "E-Mail:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 105, 480 );
        contentStream.drawString(mainWindowController.getBauherrEmail());
        contentStream.endText();
//------------------------------------------------------Ende Bauherr-Informationen

//------------------------------------------------------Anfang Brandschutz-Informationen
        contentStream.beginText();
        contentStream.setFont( font, 14 );
        contentStream.moveTextPositionByAmount( 330, 600 );
        contentStream.drawString( "Brandschutz" );
        contentStream.endText();

        // Name, Firma, Straße, PLZ/Ort, Tel.:, E-Mail:
        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 330, 580 );
        contentStream.drawString( "Name:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 385, 580 );
        contentStream.drawString( mainWindowController.getBrandschutzName() );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 330, 560 );
        contentStream.drawString( "Firma:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 385, 560 );
        contentStream.drawString( mainWindowController.getBrandschutzFirma() );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 330, 540 );
        contentStream.drawString( "Straße:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 385, 540 );
        contentStream.drawString( mainWindowController.getBrandschutzStraße() );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 330, 520 );
        contentStream.drawString( "PLZ/Ort:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 385, 520 );
        contentStream.drawString(mainWindowController.getBrandschutzOrt());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 330, 500 );
        contentStream.drawString( "Tel.:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 385, 500 );
        contentStream.drawString( mainWindowController.getBrandschutzTelefon() );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 330, 480 );
        contentStream.drawString( "E-Mail:" );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( text, 12 );
        contentStream.moveTextPositionByAmount( 385, 480 );
        contentStream.drawString( mainWindowController.getBrandschutzEmail() );
        contentStream.endText();

//------------------------------------------------------Ende Brandschutz-Informationen

//------------------------------------------------------Ende Text


        contentStream.close();
        document.save("C:\\Users\\Lukas\\IdeaProjects\\MasterArbeit 3.0\\Projektinformationen.pdf");
        document.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
