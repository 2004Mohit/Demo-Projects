package com.onlineexam;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginScreen {

    private Scene loginScene;
    private OnlineExaminationSystem mainApp;
    private TextField usernameInput;
    private PasswordField passwordInput;

    public LoginScreen(OnlineExaminationSystem mainApp) {
        this.mainApp = mainApp;
        createLoginScreen();
    }

    private void createLoginScreen() {
        Label usernameLabel = new Label("Username:");
        usernameInput = new TextField(); //Enter UserName : admin
        Label passwordLabel = new Label("Password:");
        passwordInput = new PasswordField(); //Enter Password : 1234
        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {

            mainApp.switchToExamScreen(); // Switch to exam screen upon successful login
            usernameInput.clear();
            passwordInput.clear();
        });

        VBox loginLayout = new VBox(10);
        loginLayout.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);
        loginLayout.setStyle("-fx-background-color: linear-gradient(to top right, #FFD500, #FF95FC);");
        loginLayout.setPadding(new Insets(100));
        loginLayout.setAlignment(Pos.CENTER);
        loginScene = new Scene(loginLayout, 1500, 1000);
    }

    public Scene getScene() {
        return loginScene;
    }
}
