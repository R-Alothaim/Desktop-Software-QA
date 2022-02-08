package com.qaisr.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import com.qaisr.model.Question;
import com.qaisr.service.QuizService;

/**
 * Displays a single question with four answer buttons, lifelines, and
 * navigation controls.
 */
public class QuizPanel extends JPanel {

    JLabel My;
    JLabel Q,
            hintLabel;
    JLabel c;
    JButton option1,
            option2,
            option3,
            option4,
            option5,
            option6;

    String correct_answer,
            hint;
    static int xxxx = 0;

    static boolean next = false;
    static int score = 0;
    static boolean xxx = false;
    static TimerDisplay cc = new TimerDisplay();
    public static int res = 1;

    QuizPanel(Question obj, JFrame window) {

        Q = new JLabel(obj.question);
        hintLabel = new JLabel("Hint");
        option1 = new JButton(obj.op1);
        option2 = new JButton(obj.op2);
        option3 = new JButton(obj.op3);
        option4 = new JButton(obj.op4);
        option5 = new JButton("Previous");
        option6 = new JButton("Next");
        correct_answer = obj.correctAnswer;
        hint = obj.hint;
        JButton hintBTN = new JButton(new ImageIcon(getClass().getResource("hint.png")));
        JButton half = new JButton(new ImageIcon(getClass().getResource("fifty-fifty.png")));
        String i = "" + xxxx;
        My = new JLabel(".");
        c = new JLabel(i);
        switch (res) {
            case 1 -> {
                setBounds(10, 170, 1920, 1200);
                Q.setBounds(220, 20, 1500, 80);
                option1.setBounds(400, 155, 1200, 50);
                option2.setBounds(400, 250, 1200, 50);
                option3.setBounds(400, 345, 1200, 50);
                option4.setBounds(400, 445, 1200, 50);
                hintBTN.setBounds(500, 50, 280, 80);
                half.setBounds(1300, 60, 280, 70);
                hintLabel.setBounds(800, 50, 480, 80);
            }
            case 2 -> {
                setBounds(10, 170, 1485, 550);
                Q.setBounds(220, 20, 1000, 80);
                option1.setBounds(220, 155, 1000, 50);
                option2.setBounds(220, 250, 1000, 50);
                option3.setBounds(220, 345, 1000, 50);
                option4.setBounds(220, 445, 1000, 50);
                hintBTN.setBounds(200, 50, 280, 80);
                half.setBounds(1000, 60, 280, 70);
                hintLabel.setBounds(500, 50, 480, 80);

            }
        }
        JPanel pan = new JPanel();
        pan.setLayout(null);
        pan.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        pan.setBackground(Color.BLACK);
        window.setContentPane(pan);
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        setBorder(BorderFactory.createLineBorder(Color.lightGray));
        pan.add(this);
        add(My);
        add(Q);
        add(option1);
        add(option2);
        add(option3);
        add(option4);
        add(option5);
        add(option6);
        add(c);
        c.setBounds(50, 1, 200, 100);
        c.setForeground(Color.WHITE);
        c.setBackground(Color.black);
        c.setFont(new Font("SansSerif", Font.BOLD, 30));

        Q.setFont(new Font("SansSerif", Font.BOLD, 15));
        My.setBounds(1200, 470, 311, 100);
        Q.setHorizontalAlignment(JLabel.CENTER);
        My.setHorizontalAlignment(JLabel.CENTER);
        My.setFont(new Font("SansSerif", Font.BOLD, 10));
        My.setForeground(Color.GRAY);

        Q.setBorder(new BevelBorder(WIDTH, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
        Q.setBackground(Color.black);
        Q.setBackground(new Color(255, 255, 255));
        Q.setForeground(Color.WHITE);

        option5.setBounds(90, 150, 80, 50);
        option6.setBounds(5, 150, 80, 50);

        option1.setBorder(new BevelBorder(WIDTH, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
        option2.setBorder(new BevelBorder(WIDTH, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
        option3.setBorder(new BevelBorder(WIDTH, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
        option4.setBorder(new BevelBorder(WIDTH, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));

        pan.add(half);
        pan.add(hintBTN);
        pan.add(hintLabel);

        hintBTN.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

        half.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

        hintLabel.setHorizontalAlignment(JLabel.CENTER);
        hintLabel.setForeground(Color.white);
        hintLabel.setBorder(new LineBorder(Color.white, 2, true));

        hintBTN.addActionListener((ActionEvent e) -> {
            hintLabel.setText(hint);
        });
        option5.addActionListener((ActionEvent e) -> {
            if (QuizService.Counter >= 1) {
                QuizService.Counter = QuizService.Counter - 2;
            }
            if (QuizService.i >= 1) {
                QuizService.i = QuizService.i - 2;

            }
            if (xxxx >= 1) {
                xxxx = xxxx - 2;
                next = true;
            }

        });
        option6.addActionListener((ActionEvent e) -> {

            next = true;

        });

        half.addActionListener((ActionEvent e) -> {
            if (!option1.getText().equals(correct_answer)) {
                option1.setEnabled(false);
                option1.setBackground(Color.red);
            } else if (!option2.getText().equals(correct_answer)) {
                option2.setEnabled(false);
                option2.setBackground(Color.red);
            }
            if (!option3.getText().equals(correct_answer)) {
                option3.setEnabled(false);
                option3.setBackground(Color.red);
            } else if (!option4.getText().equals(correct_answer)) {
                option4.setEnabled(false);
                option4.setBackground(Color.red);
            }
        });

        window.setVisible(true);
    }

    void getAnswer(int time) throws InterruptedException {
        option1.addActionListener((ActionEvent e) -> {
            if (option1.getText().equals(correct_answer)) {
                option1.setBackground(Color.green);
                score++;
            } else {
                xxx = false;

                option1.setBackground(Color.red);
                if (option2.getText().equals(correct_answer)) {
                    option2.setBackground(Color.green);
                } else if (option3.getText().equals(correct_answer)) {
                    option3.setBackground(Color.green);
                } else {
                    option4.setBackground(Color.green);
                }

            }
            next = true;

        });

        option2.addActionListener((ActionEvent e) -> {
            if (option2.getText().equals(correct_answer)) {
                option2.setBackground(Color.green);
                score++;
            } else {
                xxx = false;

                option2.setBackground(Color.red);
                if (option1.getText().equals(correct_answer)) {
                    option1.setBackground(Color.green);
                } else if (option3.getText().equals(correct_answer)) {
                    option3.setBackground(Color.green);
                } else {
                    option4.setBackground(Color.green);
                }

            }
            next = true;
        });

        option3.addActionListener((ActionEvent e) -> {
            if (option3.getText().equals(correct_answer)) {
                option3.setBackground(Color.green);
                score++;
            } else {
                xxx = false;

                option3.setBackground(Color.red);
                if (option2.getText().equals(correct_answer)) {
                    option2.setBackground(Color.green);
                } else if (option1.getText().equals(correct_answer)) {
                    option1.setBackground(Color.green);
                } else {
                    option4.setBackground(Color.green);
                }

            }
            next = true;

        });

        option4.addActionListener((ActionEvent e) -> {
            if (option4.getText().equals(correct_answer)) {
                option4.setBackground(Color.green);

                score++;

            } else {
                xxx = false;
                option4.setBackground(Color.red);
                if (option2.getText().equals(correct_answer)) {
                    option2.setBackground(Color.green);
                } else if (option3.getText().equals(correct_answer)) {
                    option3.setBackground(Color.green);
                } else {
                    option1.setBackground(Color.green);
                }

            }
            next = true;
        });

        while (next == false) {

            cc.Ms++;
            Thread.sleep(1);
            if (cc.Ms == 999) {
                cc.S++;
                cc.Ms = 0;
            }
            if (cc.S == 59) {
                cc.M++;
                cc.S = 0;
            }

        }
        xxxx++;
        next = false;
        if (xxx == false) {
            Thread.sleep(1000);
            xxx = true;
        } else {
            Thread.sleep(250);
        }

    }

    int getScore() {
        return score;
    }

    TimerDisplay getTime() {
        return cc;
    }

    void Reset() {

        cc.M = 0;
        cc.Ms = 0;
        cc.S = 0;
        xxxx = 0;
        score = 0;

    }

}
