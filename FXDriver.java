import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXDriver extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Create an instance of FXMainPane and set it to root
        FXMainPane root = new FXMainPane();

        // Set the scene to hold root with a specified width and height
        stage.setScene(new Scene(root, 800, 600));

        // Set stage title
        stage.setTitle("Hello World GUI");

        // Display the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}