package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PDFCombiner
{
    //private final Thingy thing;
    private final ObservableList<FileObject> fileObservableList;

    public PDFCombiner() {
        this.fileObservableList = FXCollections.observableArrayList();
    }

    public ObservableList<FileObject> getFileObservableList()
    {
        return fileObservableList;
    }

    public void addFile(FileObject file) {
        this.fileObservableList.add(file);
    }

    public void removeFile(FileObject file) {
        fileObservableList.remove(file);
    }

    public void convertFiles() {

    }
}
