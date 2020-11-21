package model;

import java.io.File;

public class FileObject
{
    private final String fileName;
    private final String fileExtension;
    private final double fileSize;
    private final File file;

    public FileObject(File file) {
        this.file = file;

        this.fileName = file.getName();
        this.fileExtension = getFileName(file);
        this.fileSize = (file.length() / 1024);
    }

    public String getFileName(File file) {
        String fileExtension="";
        String fileName=file.getName();

        if(fileName.contains(".") && fileName.lastIndexOf(".")!= 0) {
            fileExtension=fileName.substring(fileName.lastIndexOf(".")+1);
        }

        return fileExtension;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public double getFileSize() {
        return fileSize;
    }

    public File getFile() {
        return file;
    }
}
