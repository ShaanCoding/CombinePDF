package controller;

import dev.shaankhan.javafx.Controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import model.PDFCombiner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class PDFCombinerController extends Controller<PDFCombiner> implements Initializable
{
    @FXML
    private ImageView imageView;
    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleDragOver(DragEvent event) {
        if(event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    public final PDFCombiner getPDFCombiner() {
        return model;
    }

    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageView.setImage(img);
    }
}
