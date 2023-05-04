import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMainPane extends VBox {
    private Button btnHello;
    private Button btnHowdy;
    private Button btnChinese;
    private Button btnClear;
    private Button btnExit;
    private Button btnOtherLanguage; // new button added
    private Label lblFeedback;
    private TextField txtField;
    private HBox hbox1;
    private HBox hbox2;
    private DataManager dataManager;

    public FXMainPane() {
        // Instantiate the buttons
        btnHello = new Button("Hello");
        btnHowdy = new Button("Howdy");
        btnChinese = new Button("Chinese");
        btnClear = new Button("Clear");
        btnExit = new Button("Exit");
        btnOtherLanguage = new Button("Bonjour"); // new button added

        // Instantiate the label and textfield
        lblFeedback = new Label("Feedback:");
        txtField = new TextField();

        // Instantiate the DataManager instance
        dataManager = new DataManager();

        // Instantiate the HBoxes and add the components to them
        hbox1 = new HBox();
        hbox1.getChildren().addAll(btnHello, btnHowdy, btnChinese, btnClear, btnExit, btnOtherLanguage); // new button added
        hbox1.setSpacing(10);
        hbox1.setAlignment(Pos.CENTER);

        hbox2 = new HBox();
        hbox2.getChildren().addAll(lblFeedback, txtField);
        hbox2.setSpacing(10);
        hbox2.setAlignment(Pos.CENTER);

        // Set padding and spacing for the VBox
        setPadding(new Insets(10));
        setSpacing(10);
        setAlignment(Pos.CENTER);

        // Add the HBoxes to the VBox
        getChildren().addAll(hbox1, hbox2);

        // Set margins for each button
        Insets inset = new Insets(10);
        HBox.setMargin(btnHello, inset);
        HBox.setMargin(btnHowdy, inset);
        HBox.setMargin(btnChinese, inset);
        HBox.setMargin(btnClear, inset);
        HBox.setMargin(btnExit, inset);
        HBox.setMargin(btnOtherLanguage, inset);

        // Set button actions
        btnHello.setOnAction(new ButtonHandler());
        btnHowdy.setOnAction(new ButtonHandler());
        btnChinese.setOnAction(new ButtonHandler());
        btnClear.setOnAction(new ButtonHandler());
        btnExit.setOnAction(new ButtonHandler());
        btnOtherLanguage.setOnAction(new ButtonHandler()); // new button added
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getTarget() == btnHello) {
                String response = dataManager.getHello();
                txtField.setText(response);
            } else if (event.getTarget() == btnHowdy) {
                String response = dataManager.getHowdy();
                txtField.setText(response);
            } else if (event.getTarget() == btnChinese) {
                String response = dataManager.getChinese();
                txtField.setText(response);
            } else if (event.getTarget() == btnClear) {
                txtField.setText("");
            } else if (event.getTarget() == btnExit) {
                Platform.exit();
                System.exit(0);
        }
    }
}
}