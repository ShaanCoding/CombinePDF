import dev.shaankhan.javafx.ViewLoader;
import javafx.stage.*;
import javafx.application.Application;
import model.PDFCombiner;

public class CombinePDF extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewLoader.showStage(new PDFCombiner(), "/view/pdfcombiner.fxml", "CombinePDF", stage);
    }
}
