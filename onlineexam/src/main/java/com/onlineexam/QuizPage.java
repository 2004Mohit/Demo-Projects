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

public class QuizPage {
    private Stage primaryStage;
    private Scene quizScene;
    private FlowPane quizFlow;

    public void getQuizPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene getQuizScene() {
        return quizScene;
    }

    public void setQuizPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setQuizScene(Scene quizScene) {
        this.quizScene = quizScene;
    }

    public VBox createQuizPage(Runnable quizBackHandler) {
        QuizPage quiz = new QuizPage();

        //Header
        Label headLabel = new Label("Quiz");
        headLabel.setTextFill(Color.BLUE);
        headLabel.setFont(Font.font("Algerian", FontWeight.BOLD, 50));
        
        HBox Header = new HBox(headLabel);
        Header.setPrefHeight(150);
        Header.setAlignment(Pos.CENTER);
        Header.setStyle("-fx-background-color:#cacfd2");

        //Quiz VBox
        VBox quizBox = new VBox();
        quizBox.setAlignment(Pos.CENTER);
        quizBox.setStyle("-fx-alignment: TOP_CENTER ; -fx-padding : 30; -fx-background-color:#95a5a6; -fx-background-radius:2em;");

        //FlowPane
        quizFlow = new FlowPane(quizBox);
        quizFlow.setStyle("-fx-background-color : #f0b27a");
        quizFlow.setPrefSize(1000, 900);
        quizFlow.setAlignment(Pos.CENTER);

        VBox vb = new VBox(Header, quizFlow);

        return vb;
    }

}

/*Remaining Work : Add switch for MCQ */
