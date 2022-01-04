package Main;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public static void main(String[] args) {
        runGUI();
    }

    private static void runGUI() {

        JFrame myFrame = new JFrame();
        myFrame.setVisible(true);
        myFrame.setSize(1600, 900);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton jButton1 = new JButton();
        jButton1.setEnabled(true);
        jButton1.setVisible(true);

        JButton jButton2 = new JButton();
        jButton2.setEnabled(true);
        jButton2.setVisible(true);

        JButton jButton3 = new JButton();
        jButton3.setEnabled(true);
        jButton3.setVisible(true);

        JButton jButton4 = new JButton();
        jButton4.setEnabled(true);
        jButton4.setVisible(true);

        ImageIcon myIcon = new ImageIcon("Images/myCat.jpg");

        JButton jButton = new JButton(myIcon);
        jButton.setEnabled(true);
        jButton.setVisible(true);

        myFrame.add(jButton);
        myFrame.add(jButton1);
        myFrame.add(jButton2);
        myFrame.add(jButton3);
        myFrame.add(jButton4);

        myFrame.setLayout(new GridLayout(2,2,5,5));
    }

}
