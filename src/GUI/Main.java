package GUI;

import javax.swing.*;

public class Main {

    public static final int FRAME_WIDTH = 1600;
    public static final int FRAME_HEIGHT = 900;
    private static Difficulty diff;
    private static Menu menu;

    public static void main(String[] args) {
        runGUI();
    }

    private static void runGUI() {

        JFrame myFrame = new JFrame();
        myFrame.setVisible(true);
        myFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        myFrame.setLayout(null);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        menu = new Menu();
//        menu.addJElements(myFrame);

//        diff = new Difficulty();
//        diff.addJElements(myFrame);
    }
}
