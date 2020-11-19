package controller;

import dev.shaankhan.javafx.Controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.PDFCombiner;


public class PDFCombinerController extends Controller<PDFCombiner>
{
    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    public final PDFCombiner getPDFCombiner() {
        return model;
    }
}
