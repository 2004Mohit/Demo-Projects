package com.onlineexam;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ResultScreen {

    private Scene resultScene;
    private Label resultLabel;
    private OnlineExaminationSystem mainApp;

    public ResultScreen(OnlineExaminationSystem mainApp) {
        this.mainApp = mainApp;
        createResultScreen();
    }

    private void createResultScreen() {

        resultLabel = new Label();
        Button logoutButton = new Button("Logout");

        logoutButton.setOnAction(e -> mainApp.switchToLoginScreen());

        VBox resultLayout = new VBox(10);
        resultLayout.getChildren().addAll(resultLabel, logoutButton);
        resultLayout.setStyle("-fx-background-color: linear-gradient(to top right, #FFD500, #FF95FC);");
        resultLayout.setAlignment(Pos.CENTER);
        resultScene = new Scene(resultLayout, 1500, 1000);
    }

    public void displayResults(int score) {
        resultLabel.setText("Your score is: " + score + "/" + 10);
    }

    public Scene getScene() {
        return resultScene;
    }
}
