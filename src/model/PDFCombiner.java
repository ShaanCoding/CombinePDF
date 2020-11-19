package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;

public class PDFCombiner
{
    //private final Thingy thing;
    private final ObservableList<File> fileObservableList;

    public PDFCombiner() {
        this.fileObservableList = FXCollections.observableArrayList();
    }

    public ObservableList<File> getFileObservableList()
    {
        return fileObservableList;
    }

    public void addFile(File file) {
        this.fileObservableList.add(file);
    }
}
