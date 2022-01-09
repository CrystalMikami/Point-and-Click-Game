package GUI;

import Model.Board;

import javax.swing.*;
import java.awt.*;

public class Game {
    private JPanel gamePanel;
    private CardLayout cardLayout;
    private int difficulty;
    private Board board;
    private JButton[][] cardButtons;
    private int[] hGap = {};
    private int[] vGap = {};
    private FlowLayout layout;

    public Game(JPanel gamePanel, CardLayout cardLayout) {
        this.gamePanel = gamePanel;
        this.cardLayout = cardLayout;
        board = new Board(difficulty);
        board.addCards();
    }

    public void addJElements() {
        // Going through the COLUMNS
        for (int i = 0; i < board.getWidth(); i++) {
            // Going through the ROWS
            for (int j = 0; j < board.getHeight(); j++) {
                JButton cardButton = new JButton();
                cardButtons[i][j] = cardButton;

                /** cardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
                }); **/
            }
        }
    }

    public void removeJElements() {

    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
        layout = new FlowLayout(FlowLayout.LEFT, hGap[difficulty], vGap[difficulty]);
    }
}