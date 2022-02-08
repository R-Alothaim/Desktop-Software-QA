package com.qaisr.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

import static com.qaisr.ui.QuizPanel.xxxx;

/**
 * Panel that displays the final score and offers restart / exit options.
 */
public class ScorePanel extends JPanel {

    JButton playAgain,
            exit,
            e;

    JLabel scoreLabel, My;

    static boolean again = false;

    ScorePanel(JFrame window, int score, int nbrQ) {

        setSize(window.getSize().width, window.getSize().height);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        window.setContentPane(this);

        playAgain = new JButton("Restart");
        playAgain.setBackground(new Color(255, 255, 255));
        playAgain.setBounds(800, 350, 300, 100);
        add(playAgain);

        e = new JButton(new ImageIcon(getClass().getResource("R.png")));
        e.setBounds(800, 100, 300, 80);

        add(e);
        exit = new JButton("Exit");
        exit.setBackground(new Color(255, 255, 255));
        exit.setBounds(800, 550, 300, 100);

        add(exit);

        scoreLabel = new JLabel("You Got : " + score + "/" + nbrQ);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        scoreLabel.setForeground(Color.white);
        scoreLabel.setBorder(new LineBorder(Color.white, 2, true));
        scoreLabel.setBounds(650, 200, 600, 100);
        add(scoreLabel);

        window.setVisible(true);
    }

    void choose() {

        playAgain.addActionListener((ActionEvent e) -> {
            xxxx = 0;
            again = true;
        });

        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        while (!again) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
                // ignored
            }
        }

        again = false;
    }
}
