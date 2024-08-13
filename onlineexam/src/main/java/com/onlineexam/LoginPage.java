package com.onlineexam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginPage extends Application {
    private Stage primaryStage;
    private Scene loginScene, signupScene, QuizScene;
    private FlowPane loginFlow;

    public void getLoginPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initLoginScene();
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public void initLoginScene() {

        //Header
        Label headLabel = new Label("Online Examination");
        headLabel.setTextFill(Color.BLUE);
        headLabel.setFont(Font.font("Algerian", FontWeight.BOLD, 60));
        
        HBox Header = new HBox(headLabel);
        Header.setPrefHeight(150);
        Header.setAlignment(Pos.CENTER);
        Header.setStyle("-fx-background-color:#cacfd2");

        //UserName
        Label userName = new Label("Enter UserName");
        userName.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField userNameField = new TextField();
        userNameField.setStyle("-fx-background-radius:2em; -fx-min-height:30; -fx-min-width:270;");
        userNameField.setFocusTraversable(false);
        userNameField.setPromptText("Enter UserName");

        //Password
        Label password = new Label("Enter Password");
        password.setFont(Font.font(null, FontWeight.BOLD, 20));

        PasswordField passField = new PasswordField();
        passField.setStyle("-fx-background-radius:2em; -fx-min-height:30; -fx-min-width:270;");
        passField.setFocusTraversable(false);
        passField.setPromptText("Enter Password");

        //hasNoAccount
        Label hasNoAccount = new Label("Don't have Account ?");
        hasNoAccount.setFont(Font.font(null, FontWeight.BOLD, 20));
        
        Button signupButton = new Button("Signup");
        signupButton.setFont(Font.font(null, FontWeight.BOLD, 20));
        signupButton.setStyle("-fx-background-radius:2em;");
        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                initSignupPage();
            }
        });

        // TextField passwordField = new TextField();
        // passwordField.setStyle("-fx-background-radius:2em; -fx-min-height:30; -fx-min-width:270;");
        // passwordField.setFocusTraversable(false);
        // passwordField.setVisible(false);
        // passwordField.setPromptText("Enter Password");
        // passwordField.textProperty().bindBidirectional(passField.textProperty());

        // Vbox for UserName & Password
        VBox userNameBox = new VBox(10, userName, userNameField);
        userNameBox.setMaxSize(300, 30);

        VBox passwordBox = new VBox(10, password, passField);
        passwordBox.setMaxSize(300, 30);

        //Hbox for Signup Button
        VBox signupBox = new VBox(10, hasNoAccount, signupButton);
        signupBox.setAlignment(Pos.CENTER);

        //Login Button
        Button loginButton = new Button("Login");
        loginButton.setFont(Font.font(null, FontWeight.BOLD, 20));
        loginButton.setStyle("-fx-background-radius:2em;");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                initQuizPage();
            }
        });

        //Login VBox
        VBox loginBox = new VBox(40, userNameBox , passwordBox, loginButton, signupBox);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setStyle("-fx-alignment: TOP_CENTER ; -fx-padding : 30; -fx-background-color:#95a5a6; -fx-background-radius:2em;");

        //FlowPane
        loginFlow = new FlowPane(loginBox);
        loginFlow.setStyle("-fx-background-color : #f0b27a");
        loginFlow.setPrefSize(1000, 900);
        loginFlow.setAlignment(Pos.CENTER);

        VBox vb = new VBox(Header, loginFlow);

        loginScene = new Scene(vb, 1000, 1000);
    }

    public void start(Stage primaryStage) {

        LoginPage login = new LoginPage();

        login.getLoginPage(primaryStage);

        primaryStage.setScene(login.getLoginScene());

        primaryStage.show();
    }

    private void initSignupPage() {
        SignupPage signup = new SignupPage();
        signup.setSignupPage(primaryStage);
        signupScene = new Scene(signup.createSignuPage(this::handleBack), 1000, 1000);
        signup.setSignupScene(signupScene);
        primaryStage.setScene(signupScene);
        primaryStage.show();
    }

    private void initQuizPage() {
        QuizPage Quiz = new QuizPage();
        Quiz.setQuizPage(primaryStage);
        QuizScene = new Scene(Quiz.createQuizPage(this::handleBack), 1000, 1000);
        Quiz.setQuizScene(QuizScene);
        primaryStage.setScene(QuizScene);
        primaryStage.show();
    }

    private void handleBack() {
        primaryStage.setScene(loginScene);
    }
    
}
