package Model;

import java.util.ArrayList;
import java.util.Random;

// Represents the board
public class Board {
    public int difficulty; // 1 = easy, 2 = medium, 3 = hard
    private Card[][] board;
    private ArrayList<Card> drawnCards = new ArrayList<>();
    private Deck deck;
    public int countRow = 0;
    public int countColumn = 0;

    // Initializes board size
    public Board(int difficulty) {
        deck = new Deck();
        if (difficulty == 1) {
            board = new Card[2][4]; // 8 Cards
            this.difficulty = 1;
            countRow = 2;
            countColumn = 4;
        } else if (difficulty == 2) {
            board = new Card[4][8]; // 32 Cards
            this.difficulty = 2;
            countRow = 4;
            countColumn = 8;
        } else {
            board = new Card[6][12]; // 72 Cards
            this.difficulty = 3;
            countRow = 6;
            countColumn = 12;
        }
    }

    // Add cards to the board
    public void addCards() {
        for (int i = 0; i < (board.length * board[0].length) / 2; i++) {
            Card current = deck.drawCard();
            drawnCards.add(current);
            drawnCards.add(current);
        }

        // Rows of board
        for (int i = 0; i < board.length; i++) {
            // Columns of board
            for (int j = 0; j < board[0].length; j++) {
                Random rand = new Random();
                int drawnCardPos = rand.nextInt(drawnCards.size());
                board[i][j] = drawnCards.remove(drawnCardPos);
            }
        }
    }

    // Resets board for new game
    public void refreshBoard(int difficulty) {
        deck.refreshDeck();
        if (difficulty == 1) {
            board = new Card[2][4]; // 8 Cards
            this.difficulty = 1;
            countRow = 2;
            countColumn = 4;
        } else if (difficulty == 2) {
            board = new Card[4][8]; // 32 Cards
            this.difficulty = 2;
            countRow = 4;
            countColumn = 8;
        } else {
            board = new Card[6][12]; // 72 Cards
            this.difficulty = 3;
            countRow = 6;
            countColumn = 12;
        }
    }

    public Card getCardAtPos(int row, int column) {
        return board[row][column];
    }
}
