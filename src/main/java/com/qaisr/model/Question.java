package com.qaisr.model;

/**
 * Immutable data-carrier for a single quiz question and its four options.
 */
public class Question {

    public final String question;
    public final String op1;
    public final String op2;
    public final String op3;
    public final String op4;
    public final String correctAnswer;
    public final String hint;

    public Question(String question, String op1, String op2, String op3,
                    String op4, String correctAnswer, String hint) {
        this.question = question;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
    }
}
