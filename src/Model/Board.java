package Model;

// Represents the board
public class Board {
    public int difficulty; // 1 = easy, 2 = medium, 3 = hard
    private Card[][] board;
    private Deck deck;

    // Initializes board size
    public Board(int difficulty) {
        deck = new Deck();
        if (difficulty == 1) {
            board = new Card[2][4]; // 8 Cards
        } else if (difficulty == 2) {
            board = new Card[4][8]; // 32 Cards
        } else {
            board = new Card[6][12]; // 72 Cards
        }
    }

    // Add cards to the board
    public void addCards() {
        // Rows of board
        for (int i = 0; i < board.length; i++) {
            // Columns of board
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = deck.drawCard();
            }
        }
    }

    // Resets boards for new game
    public void refreshBoard(int difficulty) {
        deck.refreshDeck();
        if (difficulty == 1) {
            board = new Card[2][4]; // 8 Cards
        } else if (difficulty == 2) {
            board = new Card[4][8]; // 32 Cards
        } else {
            board = new Card[6][12]; // 72 Cards
        }
    }
}
