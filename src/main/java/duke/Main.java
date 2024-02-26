package duke;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {
    /**
     * The Duke object to be used in the application.
     */
    private Duke duke = new Duke();

    /**
     * Starts the application.
     *
     * @param stage a Stage object representing the primary stage for the application
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            stage.setTitle("Yarr: The Pirate Task Manager");
            stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/images/YarrIcon.png")));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
