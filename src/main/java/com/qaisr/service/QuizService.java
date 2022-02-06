package com.qaisr.service;

import javax.swing.*;
import java.util.Random;

import com.qaisr.model.Question;
import com.qaisr.ui.QuizPanel;
import com.qaisr.ui.ScorePanel;
import com.qaisr.util.AnswerShuffler;

/**
 * Runs the full-length quiz (all questions in sequence).
 */
public class QuizService {

    public static int Counter = 0;
    public static int i = 0;
    public static Object questions;

    private static final AnswerShuffler shuffler = new AnswerShuffler();

    public static void Run() throws InterruptedException {

        JFrame window = new JFrame("241");
        window.setSize(1400, 800);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        String[] Answer = new String[4];

        while (true) {
            int score = 0, x, seconds = 0;
            int time = -1; // sec
            Question[] Question = new Question[287];

            Answer[0] = "Secondary Storage";
            Answer[1] = "RAM";
            Answer[2] = "Cache";
            Answer[3] = "Optical disk";
            shuffler.shuffle();
            Question[i] = new Question("Expansion of Main Memory that provides nonvolatile capacity :", Answer[shuffler.a], Answer[shuffler.b], Answer[shuffler.c], Answer[shuffler.d], Answer[0], Answer[0]);

            while (Counter != Question.length && seconds > time) {
                Random rand = new Random();
                QuizPanel quiz = new QuizPanel(Question[Counter], window);
                quiz.getAnswer(time);
                x = quiz.getTime().M;
                seconds = quiz.getTime().S;
                score = quiz.getScore();
                if (Counter == Question.length - 1 || (seconds == time)) {

                }
                Counter++;
            }

            int CounterQ = Question.length;
            ScorePanel scorePanel = new ScorePanel(window, score, CounterQ);
            scorePanel.choose();
        }
    }
}
