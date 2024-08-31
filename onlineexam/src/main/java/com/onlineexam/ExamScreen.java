package com.onlineexam;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class ExamScreen {

    private Scene examScene;
    private Label questionLabel, timerLabel;
    private RadioButton option1, option2, option3;
    private ToggleGroup optionsGroup;
    private Button nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private Timeline timeline;
    private List<Question> questions;
    private OnlineExaminationSystem mainApp;

    public ExamScreen(OnlineExaminationSystem mainApp) {
        this.mainApp = mainApp;
        initializeQuestions();
        createExamScreen();
    }

    private void createExamScreen() {
        questionLabel = new Label();
        option1 = new RadioButton();
        option2 = new RadioButton();
        option3 = new RadioButton();
        optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        nextButton = new Button("Next");

        nextButton.setOnAction(e -> {
            checkAnswer();
            if (currentQuestionIndex < questions.size() - 1) {
                currentQuestionIndex++;
                displayQuestion(currentQuestionIndex);
            } else {
                timeline.stop();
                mainApp.switchToResultScreen();
            }
        });

        timerLabel = new Label("Time left: 60 seconds");
        timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            int timeLeft = Integer.parseInt(timerLabel.getText().replaceAll("\\D", "")) - 1;
            timerLabel.setText("Time left: " + timeLeft + " seconds");

            if (timeLeft <= 0) {
                timeline.stop();
                mainApp.switchToResultScreen();
            }
        }));
        timeline.setCycleCount(120);

        VBox examLayout = new VBox(10);
        examLayout.getChildren().addAll(timerLabel, questionLabel, option1, option2, option3, nextButton);
        examLayout.setStyle("-fx-background-color: linear-gradient(to top right, #FFD500, #FF95FC);");
        examLayout.setAlignment(Pos.CENTER);
        examScene = new Scene(examLayout, 1500, 1000);
    }

    private void initializeQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("What is 2 + 2?", "3", "4", "5", "4"));
        questions.add(new Question("What is the capital of France?", "Berlin", "London", "Paris", "Paris"));
        questions.add(new Question("What is the square root of 16?", "3", "4", "5", "4"));
        questions.add(new Question("Who was the first President of India?", "Dr. Rajendra Prasad", "Dr. S. Radhakrishnan", "Jawaharlal Nehru", "Indira Gandhi"));
        questions.add(new Question("Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Venus"));
        questions.add(new Question("What is the capital of Australia?", "Sydney", "Melbourne", "Canberra", "Brisbane"));
        questions.add(new Question("Who wrote the national anthem of India?", "Bankim Chandra Chatterjee", "Rabindranath Tagore", "Sarojini Naidu", "Subhas Chandra Bose"));
        questions.add(new Question("Which is the smallest continent by land area?", "Africa", "Europe", "Australia", "South America"));
        questions.add(new Question("Which Indian state has the longest coastline?", "Gujarat", "Tamil Nadu", "Maharashtra", "Andhra Pradesh"));
        questions.add(new Question("Who is known as the Father of the Nation in India?", "Jawaharlal Nehru", "Subhas Chandra Bose", "Mahatma Gandhi", "Bhagat Singh"));
    }

    public void startExam() {
        currentQuestionIndex = 0;
        score = 0;
        displayQuestion(currentQuestionIndex);
        timeline.playFromStart();
    }

    private void displayQuestion(int index) {
        Question q = questions.get(index);
        questionLabel.setText(q.getQuestionText());
        option1.setText(q.getOption1());
        option2.setText(q.getOption2());
        option3.setText(q.getOption3());
        optionsGroup.selectToggle(null); // Clear previous selection
    }

    private void checkAnswer() {
        Question q = questions.get(currentQuestionIndex);
        RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
        if (selectedOption != null && selectedOption.getText().equals(q.getCorrectAnswer())) {
            score++;
        }
    }

    public int getScore() {
        return score;
    }

    public Scene getScene() {
        return examScene;
    }
}
