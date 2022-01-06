package GUI;

import javax.swing.*;
import java.awt.*;

import static GUI.Main.FRAME_HEIGHT;
import static GUI.Main.FRAME_WIDTH;

public class Menu {

    // game title
    private JLabel title;
    Font titleFont = new Font("Times New Roman", Font.BOLD, 80);
    private static final int MENU_TITLE_WIDTH = 500;
    private static final int MENU_TEXT_HEIGHT = 200;

    // buttons below title: play, instructions
    private JButton playButton;
    private JButton instructionsButton;
    Font buttonsFont = new Font("Times New Roman", Font.PLAIN, 35);

    // panel to hold the above buttons in an organized layout
    private JPanel buttonsPanel;

    // sound button
    private JButton soundButton;
    private ImageIcon soundIcon;
    private final int SOUND_BUTTON_WIDTH = 50;
    private final int SOUND_BUTTON_HEIGHT = SOUND_BUTTON_WIDTH;

    // referencing line
    JPanel linePanel;

    public Menu() {
        title = new JLabel("Matching Card Game");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(titleFont);
        title.setOpaque(true);
        title.setBounds(FRAME_WIDTH / 6 + 50, 60, MENU_TITLE_WIDTH * 2, MENU_TEXT_HEIGHT);

        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(FRAME_WIDTH / 3 + 60, FRAME_HEIGHT / 3 + 10, 400, 400);
        buttonsPanel.setLayout(new GridLayout(2, 1, 30, 30));
//        buttonsPanel.setBackground(Color.RED);

        playButton = new JButton("Play");
        playButton.setFont(buttonsFont);

        instructionsButton = new JButton("Instructions");
        instructionsButton.setFont(buttonsFont);

        soundButton = new JButton();
        soundIcon = new ImageIcon("Images/myCat.jpg");
        soundButton.setIcon(soundIcon);
        soundButton.setBounds(50, 50, SOUND_BUTTON_WIDTH, SOUND_BUTTON_HEIGHT);

//        linePanel = new JPanel();
//        linePanel.setVisible(true);
//        linePanel.setBounds(FRAME_WIDTH/2,0,3,FRAME_HEIGHT);
//        linePanel.setBackground(Color.red);
    }

    public void addJElements(JFrame frame) {
        frame.add(title);
        frame.add(buttonsPanel);
        buttonsPanel.add(playButton);
        buttonsPanel.add(instructionsButton);
        frame.add(soundButton);
//        frame.add(linePanel);
    }

    public void removeJElements (JFrame frame) {
        frame.remove(title);
        frame.remove(buttonsPanel);
        buttonsPanel.remove(playButton);
        buttonsPanel.remove(instructionsButton);
        frame.remove(soundButton);
    }
}
