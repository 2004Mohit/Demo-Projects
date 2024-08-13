package com.onlineexam;

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

public class SignupPage {

    private Stage primaryStage;
    private Scene signupScene;
    private FlowPane signupFlow;

    public void getSignupPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene getSignupScene() {
        return signupScene;
    }

    public void setSignupPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setSignupScene(Scene signupScene) {
        this.signupScene = signupScene;
    }

    public VBox createSignuPage(Runnable signUpBackHandler) {

        //Header
        Label headLabel = new Label("Online Examination Form");
        headLabel.setTextFill(Color.BLUE);
        headLabel.setFont(Font.font("Algerian", FontWeight.BOLD, 50));
        
        HBox Header = new HBox(headLabel);
        Header.setPrefHeight(150);
        Header.setAlignment(Pos.CENTER);
        Header.setStyle("-fx-background-color:#cacfd2");

        //firstName
        Label firstName = new Label("Enter firstName");
        firstName.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField firstNameField = new TextField();
        firstNameField.setStyle("-fx-background-radius:2em; -fx-min-height:30; -fx-min-width:270;");
        firstNameField.setFocusTraversable(false);
        firstNameField.setPromptText("Enter firstName");

        //lastName
        Label lastName = new Label("Enter lastName");
        lastName.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField lastNameField = new TextField();
        lastNameField.setStyle("-fx-background-radius:2em; -fx-min-height:30; -fx-min-width:270;");
        lastNameField.setFocusTraversable(false);
        lastNameField.setPromptText("Enter lastName");

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

        TextField passField = new TextField();
        passField.setStyle("-fx-background-radius:2em; -fx-min-height:30; -fx-min-width:270;");
        passField.setFocusTraversable(false);
        passField.setPromptText("Enter Password");

        //hasAccount
        Label hasAccount = new Label("Already have Account ?");
        hasAccount.setFont(Font.font(null, FontWeight.BOLD, 20));
        
        Button loginButton = new Button("Login");
        loginButton.setFont(Font.font(null, FontWeight.BOLD, 20));
        loginButton.setStyle("-fx-background-radius:2em;");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                signUpBackHandler.run();
            }
        });

        // Vbox for FirstName, LastName, UserName & Password
        VBox firstNameBox = new VBox(10, firstName, firstNameField);
        firstNameBox.setMaxSize(300, 30);

        VBox lastNameBox = new VBox(10, lastName, lastNameField);
        lastNameBox.setMaxSize(300, 30);

        VBox userNameBox = new VBox(10, userName, userNameField);
        userNameBox.setMaxSize(300, 30);

        VBox passwordBox = new VBox(10, password, passField);
        passwordBox.setMaxSize(300, 30);

        //Hbox for Login Button
        VBox loginBox = new VBox(10, hasAccount, loginButton);
        loginBox.setAlignment(Pos.CENTER);

        //signup Button
        Button signupButton = new Button("Signup");
        signupButton.setFont(Font.font(null, FontWeight.BOLD, 20));
        signupButton.setStyle("-fx-background-radius:2em;");
        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                signUpBackHandler.run();
            }
        });

        //signup VBox
        VBox signupBox = new VBox(40, firstNameBox, lastNameBox, userNameBox , passwordBox, signupButton, loginBox);
        signupBox.setAlignment(Pos.CENTER);
        signupBox.setStyle("-fx-alignment: TOP_CENTER ; -fx-padding : 30; -fx-background-color:#95a5a6; -fx-background-radius:2em;");

        //FlowPane
        signupFlow = new FlowPane(signupBox);
        signupFlow.setStyle("-fx-background-color : #f0b27a");
        signupFlow.setPrefSize(1000, 900);
        signupFlow.setAlignment(Pos.CENTER);

        VBox vb = new VBox(Header, signupFlow);

        return vb;
    }


}
