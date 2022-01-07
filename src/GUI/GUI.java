package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class GUI {
    /** Constants **/
    //Global Constants
    public static final int FRAME_WIDTH = 1600;
    public static final int FRAME_HEIGHT = 900;
    private final int SOUND_BUTTON_WIDTH = 50;
    private final int SOUND_BUTTON_HEIGHT = SOUND_BUTTON_WIDTH;
    public static final int SOUND_BUTTON_VGAP = 25;
    public static final int SOUND_BUTTON_HGAP = SOUND_BUTTON_VGAP;

    // Menu Constants
    private static final int MENU_TITLE_WIDTH = 500;
    private static final int MENU_TEXT_HEIGHT = 200;
    private final int MENU_BUTTON_WIDTH = 300;
    private final int MENU_BUTTON_HEIGHT = MENU_BUTTON_WIDTH/4;

    // Difficulty Constants
    private final int DIFF_TEXT_WIDTH = 500;
    private final int DIFF_TEXT_HEIGHT = 64;
    private final int DIFF_TEXT_Y_POS = 100;
    private final int DIFF_BUTTON_WIDTH = 350;
    private final int DIFF_BUTTON_HEIGHT = DIFF_BUTTON_WIDTH/4;
    private final int DIFF_IMAGE_WIDTH = 350;
    private final int DIFF_IMAGE_HEIGHT = DIFF_IMAGE_WIDTH;
    private final int DIFF_IMAGE_Y_POS = 205;

    // Instruction Constants
    private final int INSTRUCTIONS_MARGIN = FRAME_WIDTH / 8;
    private final int INSTRUCTIONS_BUTTON_MARGIN = 25;
    private final int INSTRUCTIONS_BUTTON_WIDTH = ((FRAME_WIDTH - 2 * INSTRUCTIONS_MARGIN) - (2 * INSTRUCTIONS_BUTTON_MARGIN)) / 3; // (Space available - # horizontal gaps between buttons) / number of buttons
    private final int INSTRUCTIONS_BUTTON_HEIGHT = (FRAME_HEIGHT / 6) - (2 * INSTRUCTIONS_BUTTON_MARGIN); // (Space available - vertical gap)

    /** Global Elements **/
    // Sound Button
    private JButton soundButton;
    private int soundMute = 0;
    private ImageIcon soundOn = new ImageIcon("Images/myCat.JPG");
    private ImageIcon soundOff = new ImageIcon("Images/ChillCat.JPG");

    /** Menu **/
    JPanel menuContainer;
    // buttons below title: play, instructions
    private JButton playButton;
    private JButton instructionsButton;
    Font menuButtonsFont = new Font("Times New Roman", Font.PLAIN, 35);

    // panel to hold the above buttons in an organized layout
    private JPanel menuButtonsPanel;

    // game title
    private JLabel menuTitle;
    Font menuTitleFont = new Font("Times New Roman", Font.BOLD, 80);

    /** Difficulty **/
    JPanel diffContainer;

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

    /** Instructions **/
    JPanel instructionsContainer;
    //Instructions Buttons
    JButton back;
    JButton menu;
    JButton next;
    private Map<ImageIcon, String> instructionList = new LinkedHashMap<>();
    private ImageIcon[] instructionImages;
    private String[] instructionText;
    private int instructionPage = 0;

    // Instructions Fonts
    Font instructionsTitleFont = new Font("Times New Roman", Font.BOLD, 50);
    Font contentFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font instructionsButtonsFont = new Font("Times New Roman", Font.BOLD, 25);

    //Instructions Panels
    JPanel img;
    JPanel text;
    JPanel buttons;
    JPanel title;

    public GUI() {
        // JFrame
        JFrame myFrame = new JFrame();
        myFrame.setVisible(true);
        myFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel(cardLayout);

        // Sound Button
        soundButton = new JButton();
        soundButton.setIcon(soundOn);
        soundButton.setBounds(SOUND_BUTTON_HGAP, SOUND_BUTTON_VGAP, SOUND_BUTTON_WIDTH, SOUND_BUTTON_HEIGHT);
        soundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (soundMute == 0) {
                    // Turn sound off
                    soundMute = 1;
                    soundButton.setIcon(soundOff);
                } else {
                    // Turn sound on
                    soundMute = 0;
                    soundButton.setIcon(soundOn);
                }
            }
        });

        /** Menu **/
        menuTitle = new JLabel("Matching Card Game");
        menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
        menuTitle.setFont(menuTitleFont);
        menuTitle.setOpaque(true);
        menuTitle.setBounds(FRAME_WIDTH / 6 + 50, 60, MENU_TITLE_WIDTH * 2, MENU_TEXT_HEIGHT);

        menuButtonsPanel = new JPanel();
        menuButtonsPanel.setBounds(FRAME_WIDTH / 3 + 60, FRAME_HEIGHT / 3 + 10, 400, 400);
        menuButtonsPanel.setLayout(new GridLayout(2, 1, 30, 30));
//        menuButtonsPanel.setBackground(Color.RED);

        playButton = new JButton("Play");
        playButton.setFont(menuButtonsFont);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diffContainer.add(soundButton);
                cardLayout.show(cards, "difficulty");
            }
        });

        instructionsButton = new JButton("Instructions");
        instructionsButton.setFont(menuButtonsFont);
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructionsContainer.add(soundButton);
                cardLayout.show(cards, "instructions");
            }
        });

        menuContainer = new JPanel(null);
        menuContainer.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        menuContainer.add(soundButton);
        menuContainer.add(menuTitle);
        menuContainer.add(menuButtonsPanel);
        menuButtonsPanel.add(playButton);
        menuButtonsPanel.add(instructionsButton);

        cards.add(menuContainer, "menu");

        /** Difficulty **/
        chooseDiffText = new JLabel("Choose your difficulty");
        chooseDiffText.setHorizontalAlignment(SwingConstants.CENTER);
        chooseDiffText.setFont(new Font("Times New Roman", Font.BOLD, 42));
        chooseDiffText.setBackground(Color.cyan);
        chooseDiffText.setOpaque(true);
        chooseDiffText.setBounds(FRAME_WIDTH / 2 - DIFF_TEXT_WIDTH / 2, DIFF_TEXT_Y_POS, DIFF_TEXT_WIDTH, DIFF_TEXT_HEIGHT);

        easyIcon = new ImageIcon("Images/myCat.JPG");
        imageContainerEasy = new JLabel(easyIcon);
        imageContainerEasy.setVisible(true);
        imageContainerEasy.setBounds(FRAME_WIDTH / 4 - DIFF_IMAGE_WIDTH / 2, DIFF_IMAGE_Y_POS, DIFF_IMAGE_WIDTH, DIFF_IMAGE_HEIGHT);

        mediumIcon = new ImageIcon("Images/myCat.JPG");
        imageContainerMedium = new JLabel(mediumIcon);
        imageContainerMedium.setVisible(true);
        imageContainerMedium.setBounds(FRAME_WIDTH / 2 - DIFF_IMAGE_WIDTH / 2, DIFF_IMAGE_Y_POS, DIFF_IMAGE_WIDTH, DIFF_IMAGE_HEIGHT);

        hardIcon = new ImageIcon("Images/myCat.JPG");
        imageContainerHard = new JLabel(hardIcon);
        imageContainerHard.setVisible(true);
        imageContainerHard.setBounds((3 * FRAME_WIDTH / 4) - DIFF_IMAGE_WIDTH / 2, DIFF_IMAGE_Y_POS, DIFF_IMAGE_WIDTH, DIFF_IMAGE_HEIGHT);

        easyButton = new JButton("Easy");
        easyButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        easyButton.setBounds(FRAME_WIDTH / 4 - DIFF_BUTTON_WIDTH / 2, 2 * FRAME_HEIGHT / 3, DIFF_BUTTON_WIDTH, DIFF_BUTTON_HEIGHT);
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mediumButton = new JButton("Medium");
        mediumButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        mediumButton.setBounds(FRAME_WIDTH / 2 - DIFF_BUTTON_WIDTH / 2, 2 * FRAME_HEIGHT / 3, DIFF_BUTTON_WIDTH, DIFF_BUTTON_HEIGHT);
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        hardButton = new JButton("Hard");
        hardButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        hardButton.setBounds((3 * FRAME_WIDTH / 4) - DIFF_BUTTON_WIDTH / 2, 2 * FRAME_HEIGHT / 3, DIFF_BUTTON_WIDTH, DIFF_BUTTON_HEIGHT);
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        menuButton = new JButton("Back to Menu");
        menuButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        menuButton.setBounds(FRAME_WIDTH / 2 - MENU_BUTTON_WIDTH / 2, 5 * FRAME_HEIGHT / 6, MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuContainer.add(soundButton);
                cardLayout.show(cards, "menu");
            }
        });

        diffContainer = new JPanel(null);
        diffContainer.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        diffContainer.setVisible(true);
        diffContainer.add(chooseDiffText);
        diffContainer.add(imageContainerEasy);
        diffContainer.add(imageContainerMedium);
        diffContainer.add(imageContainerHard);
        diffContainer.add(easyButton);
        diffContainer.add(mediumButton);
        diffContainer.add(hardButton);
        diffContainer.add(menuButton);

        cards.add(diffContainer, "difficulty");

        /** Instructions **/
        // Title
        JLabel titleLabel = new JLabel("Instructions");
        titleLabel.setFont(instructionsTitleFont);

        title = new JPanel(new GridBagLayout());
        title.add(titleLabel);
        title.setVisible(true);
        title.setBounds(INSTRUCTIONS_MARGIN, 0, FRAME_WIDTH - 2 * INSTRUCTIONS_MARGIN, FRAME_HEIGHT / 6);

        // Instructions Content
        instructionList.put(new ImageIcon("Images/myCat.jpg"), "Teach me how to play this game senpai <3");
        instructionList.put(new ImageIcon("Images/ChillCat.jpg"), "OwO I AM THE MASTER NOW");

        instructionImages = instructionList.keySet().toArray(new ImageIcon[0]);
        instructionText = instructionList.values().toArray(new String[0]);

        // Content Image
        JLabel pic = new JLabel();
        pic.setIcon(instructionImages[0]);

        img = new JPanel(new FlowLayout(FlowLayout.LEFT, 0,0));
        img.add(pic);
        img.setVisible(true);
        img.setBounds(INSTRUCTIONS_MARGIN, FRAME_HEIGHT / 6, FRAME_WIDTH - 2 * INSTRUCTIONS_MARGIN, 7 * FRAME_HEIGHT / 12);

        // Content Text
        JLabel instructionsText = new JLabel();
        instructionsText.setText(instructionText[0]);
        instructionsText.setFont(contentFont);
        instructionsText.setForeground(new Color(230, 230, 230));
        instructionsText.setBackground(new Color(0,0,0, 200));

        text = new JPanel(new FlowLayout(FlowLayout.LEFT, INSTRUCTIONS_BUTTON_MARGIN,INSTRUCTIONS_BUTTON_MARGIN / 2));
        text.add(instructionsText);
        text.setVisible(true);
        text.setBackground(new Color(0,0,0, 200));
        text.setBounds(INSTRUCTIONS_MARGIN, 9 * FRAME_HEIGHT / 12, FRAME_WIDTH - 2 * INSTRUCTIONS_MARGIN, FRAME_HEIGHT / 12);

        // Buttons
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(INSTRUCTIONS_BUTTON_WIDTH, INSTRUCTIONS_BUTTON_HEIGHT));
        back.setFont(instructionsButtonsFont);
        back.setEnabled(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (instructionPage - 1 <= 0) {
                    back.setEnabled(false);
                }
                pic.setIcon(instructionImages[--instructionPage]);
                instructionsText.setText(instructionText[instructionPage]);
                if (instructionPage < instructionText.length) {
                    next.setEnabled(true);
                }
            }
        });

        menu = new JButton("Menu");
        menu.setPreferredSize(new Dimension(INSTRUCTIONS_BUTTON_WIDTH, INSTRUCTIONS_BUTTON_HEIGHT));
        menu.setFont(instructionsButtonsFont);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuContainer.add(soundButton);
                cardLayout.show(cards, "menu");
                instructionPage = 0;
                pic.setIcon(instructionImages[0]);
                instructionsText.setText(instructionText[0]);
                back.setEnabled(false);
                next.setEnabled(true);
            }
        });

        next = new JButton("Next");
        next.setPreferredSize(new Dimension(INSTRUCTIONS_BUTTON_WIDTH, INSTRUCTIONS_BUTTON_HEIGHT));
        next.setFont(instructionsButtonsFont);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (instructionPage >= instructionText.length - 2) {
                    next.setEnabled(false);
                }
                pic.setIcon(instructionImages[++instructionPage]);
                instructionsText.setText(instructionText[instructionPage]);
                if (instructionPage > 0) {
                    back.setEnabled(true);
                }
            }
        });

        FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 0, INSTRUCTIONS_BUTTON_MARGIN);

        buttons = new JPanel();
        buttons.setVisible(true);
        buttons.setLayout(layout);
        buttons.add(back);
        buttons.add(Box.createHorizontalStrut(INSTRUCTIONS_BUTTON_MARGIN));
        buttons.add(menu);
        buttons.add(Box.createHorizontalStrut(INSTRUCTIONS_BUTTON_MARGIN));
        buttons.add(next);
        buttons.setBounds(INSTRUCTIONS_MARGIN, 5 * FRAME_HEIGHT / 6, FRAME_WIDTH - 2 * INSTRUCTIONS_MARGIN, FRAME_HEIGHT / 6);

        instructionsContainer = new JPanel(null);
        instructionsContainer.setVisible(true);
        instructionsContainer.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        instructionsContainer.add(title);
        instructionsContainer.add(img);
        instructionsContainer.add(text);
        instructionsContainer.add(buttons);

        cards.add(instructionsContainer, "instructions");

        Container pane = myFrame.getContentPane();
        pane.add(cards, BorderLayout.CENTER);

        // View proportions, colour coded
        //title.setBackground(Color.red);
        //img.setBackground(Color.yellow);
        //text.setBackground(Color.green);
        //buttons.setBackground(Color.cyan);
        // end of instructions
    }
}

