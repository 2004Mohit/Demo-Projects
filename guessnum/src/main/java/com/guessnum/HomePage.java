package com.guessnum;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomePage extends Application {
    // Variables to hold the number to guess and user's input
    private int guessNum, userNum;
    // Variables to track the number of attempts
    private int Attempts, attempts;
    // TextField for user input
    private TextField numInput;
    // Button for user input check
    private Button check;
    // Label for user Attempts
    private Label Attempt;

    // Alerts for showing messages to the user
    Alert congo = new Alert(AlertType.INFORMATION);
    Alert exceptionAlert = new Alert(AlertType.WARNING);

    // Method to generate a random number between 1 and 100
    public void GuessNum() {
        guessNum = (int)(Math.random() * 100) + 1;
        System.out.println("Number To Guess : " + guessNum);
    }

    // Method to check Guess Number
    public void checkGuesNum() {
        try {

            userNum = Integer.parseInt(numInput.getText().trim());

            // Check if the user's guess is correct, near, or too high/low
            if (userNum == guessNum) {
                congo.setContentText("Congratulations !!\nYou Won");
                congo.showAndWait();
                numInput.clear();
                Restart();
                return;

            } else if ((userNum > (guessNum - 5)) && (userNum < guessNum)) {
                congo.setContentText("Your Guess is near but Low !!");
                congo.showAndWait();
                numInput.clear();
            } else if ((userNum >= 0) && (userNum < guessNum)) {
                congo.setContentText("Your Guess is Too Low !!");
                congo.showAndWait();
                numInput.clear();
            } else if ((userNum < (guessNum + 5)) && (userNum > guessNum)) {
                congo.setContentText("Your Guess is near but High !!");
                congo.showAndWait();
                numInput.clear();
            } else {
                congo.setContentText("Your Guess is Too High !!");
                congo.showAndWait();
                numInput.clear();
            }

            // Decrement the number of attempts and update the label
            attempts--;
            Attempts = attempts;
            Attempt.setText("Remaining Attempts : " + Attempts);

            // Check if the user has run out of attempts
            if ((userNum != guessNum) && (attempts == 0)) {
                check.setDisable(true);
                congo.setContentText("Sorry Dear !!\nYou Lose !");
                congo.showAndWait();
            }

        } catch (NumberFormatException nume) {

            // Show an alert if the user input is not a valid number and for Empty TextField
            exceptionAlert.setHeaderText("Please, Give Valid Input");
            exceptionAlert.setContentText("TextField should NOT be Empty.\n\nOnly Number is Allowed !");
            exceptionAlert.showAndWait();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Load the image for the question mark gif
        Image quesImage = new Image(getClass().getResourceAsStream("/gif/QuesGif.gif"), 750, 1000, true, false);
        ImageView quesImageView = new ImageView(quesImage);
        quesImageView.setFitWidth(300);
        quesImageView.setFitHeight(300);

        // VBox to hold the image view
        VBox quesGifBox = new VBox(quesImageView);
        quesGifBox.setAlignment(Pos.CENTER);
        quesGifBox.setStyle("-fx-background-radius: 1em;");
        quesGifBox.setLayoutX(900);
        quesGifBox.setLayoutY(200);
        quesGifBox.setPrefSize(300, 300);

        // Label for the title of the game
        Label topLabel = new Label("Number Guessing Game");
        topLabel.setFont(Font.font(null, FontWeight.BOLD, 50));
        topLabel.setTextFill(Color.BLACK);

        // HBox to hold the title label
        HBox TopView = new HBox(topLabel);
        TopView.setStyle("-fx-background-radius: 1em; -fx-background-color : #A9A9A9;");
        TopView.setPadding(new Insets(5));

        // Label prompting the user to enter a number
        Label forNum = new Label("Enter Your Number : ");
        forNum.setFont(Font.font(null, FontWeight.BOLD, 30));
        forNum.setTextFill(Color.BLACK);

        // TextField for user input
        numInput = new TextField();
        numInput.setStyle("-fx-background-radius: 1em;");
        numInput.setPromptText("Enter Your Number");

        // Button to check the user's input
        check = new Button("Check");
        check.setFont(Font.font(null, FontWeight.BOLD, 30));
        check.setStyle("-fx-background-radius : 2em");
        check.setDisable(false);

        // Generate the number to guess
        GuessNum();

        // Set the initial number of attempts
        attempts = 3;
        Attempts = attempts;

        // Label to display the remaining attempts
        Attempt = new Label();
        Attempt.setText("Remaining Attempts : " + Attempts);
        Attempt.setFont(Font.font(null, FontWeight.BOLD, 20));
        Attempt.setTextFill(Color.BLACK);

        //check button for Input Number
        check.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                checkGuesNum();
            }
        });

        // Button to restart the game
        Button Restart = new Button("Restart");
        Restart.setFont(Font.font(null, FontWeight.BOLD, 30));
        Restart.setStyle("-fx-background-radius : 2em");
        Restart.setDisable(false);
        Restart.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                // Reset the game state
                GuessNum();
                Restart();
            }
        });

        // VBox to hold the input, check button, restart button, and Remaining Attempts label
        VBox vb = new VBox(20, forNum, numInput, check, Restart, Attempt);
        vb.setAlignment(Pos.CENTER);

        // VBox to hold all the elements
        VBox flowVB = new VBox(10, quesGifBox, TopView, vb);
        flowVB.setPadding(new Insets(100));
        flowVB.setAlignment(Pos.CENTER);

        // FlowPane for the blur Back background
        FlowPane blurBox = new FlowPane();
        blurBox.setOpacity(0.6);
        blurBox.setStyle("-fx-background-color: #eaf0f0; -fx-background-radius : 2em;");
        blurBox.setAlignment(Pos.CENTER);

        // StackPane to layer the background Box Blur and the content
        StackPane stack = new StackPane(blurBox, flowVB);

        // FlowPane to center the StackPane
        FlowPane flow = new FlowPane(stack);
        flow.setStyle("-fx-background-color: linear-gradient(to top right, #FFD500, #FF95FC);");
        flow.setAlignment(Pos.CENTER);

        // Create and set the scene
        Scene sc = new Scene(flow, 1000, 1000);
        stage.setScene(sc);
        stage.setMaximized(true);
        stage.setTitle("Num Guessing Game");
        stage.show();
    }

    //Method To Restart or User Win
    public void Restart() {
        attempts = 3;
        check.setDisable(false);
        Attempt.setText("Remaining Attempts : " + attempts);
    }
}
