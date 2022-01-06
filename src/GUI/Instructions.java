package GUI;

import javax.swing.*;

import java.awt.*;

import static GUI.Main.FRAME_HEIGHT;
import static GUI.Main.FRAME_WIDTH;

public class Instructions {

    // Constants
    private final int SOUND_BUTTON_WIDTH = 50;
    private final int SOUND_BUTTON_HEIGHT = 50;
    private final int MARGIN = FRAME_WIDTH / 8;
    private final int BUTTON_MARGIN = 25;
    private final int BUTTON_WIDTH = ((FRAME_WIDTH - 2 * MARGIN) - (2 * BUTTON_MARGIN)) / 3; // (Space available - # horizontal gaps between buttons) / number of buttons
    private final int BUTTON_HEIGHT = (FRAME_HEIGHT / 6) - (2 * BUTTON_MARGIN); // (Space available - vertical gap)

    Font titleFont = new Font("Times New Roman", Font.BOLD, 50);
    Font contentFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font buttonsFont = new Font("Times New Roman", Font.BOLD, 25);

    //Panels
    JPanel img;
    JPanel text;
    JPanel buttons;
    JPanel title;

    //Buttons
    JButton back;
    JButton menu;
    JButton next;
    JButton sound;

    public Instructions() {
        // Buttons
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        back.setFont(buttonsFont);

        menu = new JButton("Menu");
        menu.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        menu.setFont(buttonsFont);

        next = new JButton("Next");
        next.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        next.setFont(buttonsFont);

        sound = new JButton();
        sound.setIcon(new ImageIcon("Images/myCat.JPG"));
        sound.setBounds(25, 25, SOUND_BUTTON_WIDTH, SOUND_BUTTON_HEIGHT);

        // Title
        JLabel titleLabel = new JLabel("Instructions");
        titleLabel.setFont(titleFont);

        title = new JPanel(new GridBagLayout());
        title.add(titleLabel);
        title.setVisible(true);
        title.setBounds(MARGIN, 0, FRAME_WIDTH - 2 * MARGIN, FRAME_HEIGHT / 6);

        // Content Image
        ImageIcon picIcon = new ImageIcon("Images/myCat.jpg");
        JLabel pic = new JLabel(picIcon);

        img = new JPanel(new FlowLayout(FlowLayout.LEFT, 0,0));
        img.add(pic);
        img.setVisible(true);
        img.setBounds(MARGIN, FRAME_HEIGHT / 6, FRAME_WIDTH - 2 * MARGIN, 7 * FRAME_HEIGHT / 12);

        // Content Text
        JLabel instructionsText = new JLabel("Teach me how to play this game senpai <3");
        instructionsText.setFont(contentFont);
        instructionsText.setForeground(new Color(230, 230, 230));
        instructionsText.setBackground(new Color(0,0,0, 200));

        text = new JPanel(new FlowLayout(FlowLayout.LEFT, BUTTON_MARGIN,BUTTON_MARGIN / 2));
        text.add(instructionsText);
        text.setVisible(true);
        text.setBackground(new Color(0,0,0, 200));
        text.setBounds(MARGIN, 9 * FRAME_HEIGHT / 12, FRAME_WIDTH - 2 * MARGIN, FRAME_HEIGHT / 12);

        // Buttons
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 0, BUTTON_MARGIN);

        buttons = new JPanel();
        buttons.setVisible(true);
        buttons.setLayout(layout);
        buttons.add(back);
        buttons.add(Box.createHorizontalStrut(BUTTON_MARGIN));
        buttons.add(menu);
        buttons.add(Box.createHorizontalStrut(BUTTON_MARGIN));
        buttons.add(next);
        buttons.setBounds(MARGIN, 5 * FRAME_HEIGHT / 6, FRAME_WIDTH - 2 * MARGIN, FRAME_HEIGHT / 6);

        // View proportions, colour coded
        //title.setBackground(Color.red);
        //img.setBackground(Color.yellow);
        //text.setBackground(Color.green);
        //buttons.setBackground(Color.cyan);
    }

    //Add elements to screen
    public void addJElements(JFrame frame) {
        frame.add(sound);
        frame.add(img);
        frame.add(text);
        frame.add(buttons);
        frame.add(title);
    }

    //Remove elements from screen
    public void removeJElements(JFrame frame) {
        frame.remove(sound);
        frame.remove(img);
        frame.remove(text);
        frame.remove(buttons);
        frame.remove(title);
    }
}
