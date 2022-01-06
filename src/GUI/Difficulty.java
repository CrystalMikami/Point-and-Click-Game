package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.Main.FRAME_HEIGHT;
import static GUI.Main.FRAME_WIDTH;

/**
 * NOTE: If you would like to see what this looks like,
 * just add the line of code below to the runGUI() method
 * <p>
 * diff.addJElements(myFrame);
 * <p>
 * in the Main class in the GUI package.
 * <p>
 * Make sure that the only GUI-screen active is this one.
 * O/W they will overlap with other GUI-screens (like Menu
 * or Instructions)
 **/

// Represents the Difficulty GUI-screen, where the user chooses difficulty
public class Difficulty implements ActionListener {

    private final int DIFF_TEXT_WIDTH = 500;
    private final int DIFF_TEXT_HEIGHT = 64;
    private final int DIFF_TEXT_Y_POS = 100;
    private final int DIFF_BUTTON_WIDTH = 350;
    private final int DIFF_BUTTON_HEIGHT = DIFF_BUTTON_WIDTH/4;
    private final int IMAGE_WIDTH = 350;
    private final int IMAGE_HEIGHT = IMAGE_WIDTH;
    private final int IMAGE_Y_POS = 205;

    // These may be used as global variables
    private final int MENU_BUTTON_WIDTH = 300;
    private final int MENU_BUTTON_HEIGHT = MENU_BUTTON_WIDTH/4;
    private final int SOUND_BUTTON_WIDTH = 50;
    private final int SOUND_BUTTON_HEIGHT = SOUND_BUTTON_WIDTH;

    JLabel chooseDiffText;

    ImageIcon easyIcon;
    JLabel imageContainerEasy;

    ImageIcon mediumIcon;
    JLabel imageContainerMedium;

    ImageIcon hardIcon;
    JLabel imageContainerHard;

    JButton easyButton;
    JButton mediumButton;
    JButton hardButton;

    JButton menuButton;

    ImageIcon soundIcon;
    JButton soundButton;

    JPanel vLinePanel;
    JPanel hLinePanel;

    // EFFECTS: initializes all the Java swing elements for the difficulty screen
    public Difficulty() {
        chooseDiffText = new JLabel("Choose your difficulty");
        chooseDiffText.setHorizontalAlignment(SwingConstants.CENTER);
        chooseDiffText.setFont(new Font("Times New Roman", Font.BOLD, 42));
        chooseDiffText.setBackground(Color.cyan);
        chooseDiffText.setOpaque(true);
        chooseDiffText.setBounds(FRAME_WIDTH / 2 - DIFF_TEXT_WIDTH / 2, DIFF_TEXT_Y_POS, DIFF_TEXT_WIDTH, DIFF_TEXT_HEIGHT);

        easyIcon = new ImageIcon("Images/myCat.JPG");
        imageContainerEasy = new JLabel(easyIcon);
        imageContainerEasy.setVisible(true);
        imageContainerEasy.setBounds(FRAME_WIDTH / 4 - IMAGE_WIDTH / 2, IMAGE_Y_POS, IMAGE_WIDTH, IMAGE_HEIGHT);

        mediumIcon = new ImageIcon("Images/myCat.JPG");
        imageContainerMedium = new JLabel(mediumIcon);
        imageContainerMedium.setVisible(true);
        imageContainerMedium.setBounds(FRAME_WIDTH / 2 - IMAGE_WIDTH / 2, IMAGE_Y_POS, IMAGE_WIDTH, IMAGE_HEIGHT);

        hardIcon = new ImageIcon("Images/myCat.JPG");
        imageContainerHard = new JLabel(hardIcon);
        imageContainerHard.setVisible(true);
        imageContainerHard.setBounds((3 * FRAME_WIDTH / 4) - IMAGE_WIDTH / 2, IMAGE_Y_POS, IMAGE_WIDTH, IMAGE_HEIGHT);

        easyButton = new JButton("Easy");
        easyButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        easyButton.setBounds(FRAME_WIDTH / 4 - DIFF_BUTTON_WIDTH / 2, 2 * FRAME_HEIGHT / 3, DIFF_BUTTON_WIDTH, DIFF_BUTTON_HEIGHT);

        mediumButton = new JButton("Medium");
        mediumButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        mediumButton.setBounds(FRAME_WIDTH / 2 - DIFF_BUTTON_WIDTH / 2, 2 * FRAME_HEIGHT / 3, DIFF_BUTTON_WIDTH, DIFF_BUTTON_HEIGHT);

        hardButton = new JButton("Hard");
        hardButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        hardButton.setBounds((3 * FRAME_WIDTH / 4) - DIFF_BUTTON_WIDTH / 2, 2 * FRAME_HEIGHT / 3, DIFF_BUTTON_WIDTH, DIFF_BUTTON_HEIGHT);

        menuButton = new JButton("Back to Menu");
        menuButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        menuButton.setBounds(FRAME_WIDTH / 2 - MENU_BUTTON_WIDTH / 2, 5 * FRAME_HEIGHT / 6, MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);

        soundButton = new JButton();
        soundIcon = new ImageIcon("Images/myCat.JPG");
        soundButton.setIcon(soundIcon);
        soundButton.setBounds(50, 50, SOUND_BUTTON_WIDTH, SOUND_BUTTON_HEIGHT);

        // The JPanels' below are reference-lines for eyeballing!
        // These lines will be deleted after this phase!
        vLinePanel = new JPanel();
        vLinePanel.setVisible(true);
        vLinePanel.setBounds(FRAME_WIDTH / 2, 0, 3, FRAME_HEIGHT);
        vLinePanel.setBackground(Color.red);

        hLinePanel = new JPanel();
        hLinePanel.setVisible(true);
        hLinePanel.setBounds(0, FRAME_HEIGHT / 2, FRAME_WIDTH, 3);
        hLinePanel.setBackground(Color.red);
    }

    // MODIFIES: frame
    // EFFECTS: adding the Java swing elements defined in the constructor to frame
    public void addJElements(JFrame frame) {
        frame.add(chooseDiffText);
        frame.add(imageContainerEasy);
        frame.add(imageContainerMedium);
        frame.add(imageContainerHard);
        frame.add(easyButton);
        frame.add(mediumButton);
        frame.add(hardButton);
        frame.add(menuButton);
        frame.add(soundButton);
        frame.add(vLinePanel);
        frame.add(hLinePanel);
    }

    // MODIFIES: frame
    // EFFECTS: removing the Java swing elements defined in the constructor from frame
    public void removeJElements(JFrame frame) {
        frame.remove(chooseDiffText);
        frame.remove(imageContainerEasy);
        frame.remove(imageContainerMedium);
        frame.remove(imageContainerHard);
        frame.remove(easyButton);
        frame.remove(mediumButton);
        frame.remove(hardButton);
        frame.remove(menuButton);
        frame.remove(soundButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
