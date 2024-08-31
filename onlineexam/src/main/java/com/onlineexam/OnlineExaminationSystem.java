package com.onlineexam;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OnlineExaminationSystem extends Application {

    private Stage window;
    private Scene loginScene, examScene, resultScene;
    private LoginScreen loginScreen;
    private ExamScreen examScreen;
    private ResultScreen resultScreen;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        // Initialize the screens
        loginScreen = new LoginScreen(this);
        examScreen = new ExamScreen(this);
        resultScreen = new ResultScreen(this);

        // Initialize Scenes
        loginScene = loginScreen.getScene();
        examScene = examScreen.getScene();
        resultScene = resultScreen.getScene();

        // Set initial scene
        window.setScene(loginScene);
        window.setTitle("Online Examination System");
        window.setMaximized(true);
        window.show();
    }

    public void switchToExamScreen() {
        window.setScene(examScene);
        examScreen.startExam();
    }

    public void switchToResultScreen() {
        window.setScene(resultScene);
        resultScreen.displayResults(examScreen.getScore());
    }

    public void switchToLoginScreen() {
        window.setScene(loginScene);
    }
    
}
