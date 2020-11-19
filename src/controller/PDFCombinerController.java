package controller;

import dev.shaankhan.javafx.Controller;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import model.FileObject;
import model.PDFCombiner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public class PDFCombinerController extends Controller<PDFCombiner>
{
    @FXML
    private TableView<FileObject> fileTv;

    public ObservableList<FileObject> getAllFiles() {
        return model.getFileObservableList();
    }

    private FileObject getSelectedFileObject() {
        return fileTv.getSelectionModel().getSelectedItem();
    }

    public void removeFile(ActionEvent actionEvent) {
        model.removeFile(getSelectedFileObject());
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
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
        //Adds file to list
        List<File> files = event.getDragboard().getFiles();
        model.addFile(new FileObject(files.get(0)));
    }

    @FXML
    public void convertFiles(ActionEvent actionEvent) {
        model.convertFiles();
    }
}
