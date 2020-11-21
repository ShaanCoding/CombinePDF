package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;

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

    public void convertFiles(File outputDirectory) {
            Document document = new Document();
            try {
                FileOutputStream fos = new FileOutputStream(outputDirectory);
                PdfWriter writer = PdfWriter.getInstance(document, fos);
                writer.open();
                document.open();

                for(FileObject file : fileObservableList) {
                    Image image = Image.getInstance(file.getFile().getPath());
                    PdfPTable table = new PdfPTable(1);
                    table.addCell(image);
                    document.add(table);
                }

                document.close();
                writer.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
    }
}
