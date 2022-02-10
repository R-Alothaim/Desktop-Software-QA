package com.qaisr;

import com.qaisr.ui.LoginFrame;

/**
 * Main entry point for the Quiz Desktop Application.
 *
 * @author ralot
 */
public class QuizApplication {

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        Thread uiThread = new Thread(loginFrame::run);
        uiThread.start();
    }
}
