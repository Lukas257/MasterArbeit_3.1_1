package MainWindow;

import javafx.application.Application;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.print.PrinterJob;
import javafx.scene.Node;


public class PDF {

    /**
     * öffnet den PrintSetup Dialog
     * @param node
     * @param owner
     */
    public void printSetup(Node node, Stage owner)
    {
        // Microsoft Print to PDF als Default Printer festlegen
        Printer myPrinter = null;
        ObservableSet<Printer> printers = Printer.getAllPrinters();
        for(Printer printer : printers){
            if(printer.getName().matches("Microsoft Print to PDF")){
                myPrinter = printer;
            }
        }

        // Create the PrinterJob
        PrinterJob job = PrinterJob.createPrinterJob();

        PageLayout pageLayout
                = myPrinter.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);

        job.getJobSettings().setPageLayout(pageLayout);


        double scaleX
                = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
        double scaleY
                = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
        Scale scale = new Scale(scaleX, scaleY);
        node.getTransforms().add(scale);



        if (job == null)
        {
            return;
        }

        // Show the print setup dialog
        boolean proceed = job.showPrintDialog(owner);

        if (proceed)
        {
            print(job, node);
        }

       node.getTransforms().remove(scale);
    }


    private void print(PrinterJob job, Node node)
    {
        // Print the node
        boolean printed = job.printPage(node);

        if (printed)
        {
            job.endJob();
        }
    }
}

