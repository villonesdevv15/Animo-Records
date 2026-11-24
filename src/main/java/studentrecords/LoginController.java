package studentrecords;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    // the admin account, hardcoded
    // the students make their own account in the create account page (saved in accounts.csv)
    private static final String adminUsername = "admin";
    private static final String adminPassword = "tagalogmasarap";

    // the dashboard checks this to know if the one logged in is the admin or a student
    public static boolean isAdmin = false;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;
    @FXML private Button loginButton;

    @FXML
    private void handleLogin() throws Exception {
        String user = usernameField.getText().trim();
        String pass = passwordField.getText();

        // check if the fields are empty
        if (user.isEmpty() || pass.isEmpty()) {
            errorLabel.setText("Please enter your username and password.");
            return;
        }

        // check if it is the admin or a student account
        boolean adminLogin = user.equals(adminUsername) && pass.equals(adminPassword);
        boolean studentLogin = AccountStorage.checkLogin(user, pass);

        if (!adminLogin && !studentLogin) {
            errorLabel.setText("Incorrect USERNAME or PASSWORD!!!");
            passwordField.clear();
            return;
        }

        // remember who logged in
        isAdmin = adminLogin;

        // If login is correct proceed to the dashboard
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setResizable(true);
        stage.centerOnScreen();
    }

    // create an account hyperlink then proceeds to the createAccount.fxml page
    @FXML
    private void handleCreateAccount() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.centerOnScreen();
    }
}
