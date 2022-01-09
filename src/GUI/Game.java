package GUI;

import Model.Board;

import javax.swing.*;
import java.awt.*;

public class Game {
    private JPanel gamePanel;
    private int difficulty = 0;
    private Board board;
    private JButton[][] cardButtons;
    private int hGap;
    private int vGap;
    private int cardWidth = 0;
    private int cardHeight = 0;

    public Game(JPanel gamePanel) {
        this.gamePanel = gamePanel;
        board = new Board(difficulty, cardWidth, cardHeight);
        board.addCards();
    }

    public void fillBoard() {
        board.refreshBoard(difficulty, cardWidth, cardHeight);
        board.addCards();

        // Going through the COLUMNS
        for (int i = 0; i < board.getWidth(); i++) {
            // Going through the ROWS
            for (int j = 0; j < board.getHeight(); j++) {
                JButton cardButton = new JButton();
                cardButtons[i][j] = cardButton;
                cardButton.setIcon(board.getCardAtPos(i, j).getImg());
                cardButton.setBounds(hGap * (1 + i) + (i * cardWidth), vGap * (1 + j) + (j * cardHeight), cardWidth, cardHeight);
                gamePanel.add(cardButton);

                /** cardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
                }); **/
            }
        }
        gamePanel.revalidate();
        gamePanel.repaint();

    }

    public void refreshGame() {
        // Going through the COLUMNS
        for (int i = 0; i < board.getWidth(); i++) {
            // Going through the ROWS
            for (int j = 0; j < board.getHeight(); j++) {
                JButton cardButton = cardButtons[i][j];
                gamePanel.remove(cardButton);
            }
        }
        gamePanel.revalidate();
        gamePanel.repaint();
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
// gaps = (board.getWidth() + 1) * hgap
// buttons = board.getWidth() * cardwidth
// gap + button = Frame width
// Adjust values later
        switch (difficulty) {
            case 0:
                cardButtons = new JButton[4][2];
                hGap = 192;
                vGap = 25;
                cardWidth = 160;
                cardHeight = 300;
                break;
            case 1:
                cardButtons = new JButton[8][4];
                hGap = 104;
                vGap = 15;
                cardWidth = 83;
                cardHeight = 150;
                break;
            case 2:
                cardButtons = new JButton[14][5];
                hGap = 50;
                vGap = 37;
                cardWidth = 60;
                cardHeight = 90;
                break;
            default:
        }
    }
}