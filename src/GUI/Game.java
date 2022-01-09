package GUI;

import Model.Board;
import Model.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private CardLayout cardLayout;
    private JPanel cards;
    private JPanel gamePanel;
    private JButton[][] cardButtons;
    private Board board;
    private int difficulty = 0;
    private int hGap;
    private int vGap;
    private int cardWidth = 0;
    private int cardHeight = 0;
    private int cardPairsRemaining = 0;
    private int cardOneColumn = -1;
    private int cardOneRow = -1;
    private int cardTwoColumn = -1;
    private int cardTwoRow = -1;

    public Game(JPanel gamePanel, JPanel cards, CardLayout cardLayout) {
        this.gamePanel = gamePanel;
        this.cards = cards;
        this.cardLayout = cardLayout;
        board = new Board(difficulty, cardWidth, cardHeight);
        board.addCards();
    }

    // EFFECTS: resets board and adds cards to the board depending on difficulty
    public void fillBoard() {
        board.refreshBoard(difficulty, cardWidth, cardHeight);
        board.addCards();

        // Going through the COLUMNS
        for (int i = 0; i < board.getWidth(); i++) {
            // Going through the ROWS
            for (int j = 0; j < board.getHeight(); j++) {
                JButton cardButton = new JButton();
                cardButtons[i][j] = cardButton;
                cardButton.setIcon(board.getCardAtPos(i, j).getCardImage());
                cardButton.setBounds(hGap * (1 + i) + (i * cardWidth), vGap * (1 + j) + (j * cardHeight), cardWidth, cardHeight);
                cardButton.putClientProperty("column", i);
                cardButton.putClientProperty("row", j);

                cardButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        flipCard((int) cardButton.getClientProperty("column"), (int) cardButton.getClientProperty("row"));
                        if (cardOneColumn == -1) {
                            cardOneColumn = (int) cardButton.getClientProperty("column");
                            cardOneRow = (int) cardButton.getClientProperty("row");
                        } else if (cardTwoColumn == -1) {
                            cardTwoColumn = (int) cardButton.getClientProperty("column");
                            cardTwoRow = (int) cardButton.getClientProperty("row");
                            matchedCards(cardOneColumn, cardOneRow, cardTwoColumn, cardTwoRow);
                        }
                    }
                });

                gamePanel.add(cardButton);
            }
        }
        gamePanel.revalidate();
        gamePanel.repaint();

    }

    // EFFECTS: removes the cards from the game
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
    }

    // EFFECTS: Sets difficulty, card width and height, board placement
    //          depending on the difficulty
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
// gaps = (board.getWidth() + 1) * hgap
// buttons = board.getWidth() * cardwidth
// gap + button = Frame width
// Adjust values later
        switch (difficulty) {
            case 0:
                cardButtons = new JButton[4][2];
                this.cardPairsRemaining = 4;
                hGap = 192;
                vGap = 25;
                cardWidth = 160;
                cardHeight = 300;
                break;
            case 1:
                cardButtons = new JButton[8][4];
                this.cardPairsRemaining = 16;
                hGap = 104;
                vGap = 15;
                cardWidth = 83;
                cardHeight = 150;
                break;
            case 2:
                cardButtons = new JButton[14][5];
                this.cardPairsRemaining = 35;
                hGap = 50;
                vGap = 37;
                cardWidth = 60;
                cardHeight = 90;
                break;
            default:
        }
    }

    // EFFECTS: sets card's flipState and appearance
    public void flipCard(int column, int row) {
        Card selectedCard = board.getCardAtPos(column, row);

        if (selectedCard.getFlipped() == 0) {
            selectedCard.setFlipped(1);
        } else {
            selectedCard.setFlipped(0);
        }
        cardButtons[column][row].setIcon(selectedCard.getCardImage());
    }

    // EFFECTS: check if the chosen 2 cards are matched
    //          if matched, the chosen 2 cards will remain flipped and then disabled
    //          o/w the chosen 2 cards get flipped back
    public void matchedCards(int column1, int row1, int column2, int row2) {
        if ((board.getCardAtPos(column1, row1).getValue() == board.getCardAtPos(column2, row2).getValue()) && (board.getCardAtPos(column1, row1).getSuit() == board.getCardAtPos(column2, row2).getSuit())) {
            cardButtons[column1][row1].setEnabled(false);
            cardButtons[column2][row2].setEnabled(false);
            this.cardPairsRemaining--;
            if (this.cardPairsRemaining == 0) {
                refreshGame();
                cardLayout.show(cards, "menu"); // TODO: This should be results screen
            }
        } else {
            flipCard(column1, row1);
            flipCard(column2, row2);
        }

        cardOneColumn = -1;
        cardOneRow = -1;
        cardTwoColumn = -1;
        cardTwoRow = -1;
    }
}