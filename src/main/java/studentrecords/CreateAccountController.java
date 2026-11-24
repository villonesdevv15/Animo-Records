package studentrecords;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController {

    // these are connected to the fx:id in createAccount.fxml
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmField;
    @FXML private Label errorLabel;
    @FXML private Button createButton;

    @FXML
    private void handleCreate() throws Exception {
        String user = usernameField.getText().trim();
        String pass = passwordField.getText();
        String confirm = confirmField.getText();

        // check if the fields are empty
        if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
            errorLabel.setText("Please fill in all fields.");
            return;
        }

        // comma is not allowed because it is saved on csv file
        if (user.contains(",") || pass.contains(",")) {
            errorLabel.setText("Commas are not allowed.");
            return;
        }

        // the admin username cannot be used by a student
        if (user.equalsIgnoreCase("admin")) {
            errorLabel.setText("That username is already taken.");
            return;
        }

        if (pass.length() < 8) {
            errorLabel.setText("Password must be at least 8 characters.");
            return;
        }

        if (!pass.equals(confirm)) {
            errorLabel.setText("Passwords do not match.");
            passwordField.clear();
            confirmField.clear();
            return;
        }

        // no duplicate usernames
        if (AccountStorage.usernameExists(user)) {
            errorLabel.setText("That username is already taken.");
            return;
        }

        AccountStorage.save(user, pass);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Account created! You can now sign in.");
        alert.setHeaderText(null);
        alert.showAndWait();

        // go back to the login screen
        handleBack();
    }

    @FXML
    private void handleBack() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage) createButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.centerOnScreen();
    }
}
