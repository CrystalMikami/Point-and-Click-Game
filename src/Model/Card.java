package Model;

// Represents a card
public class Card {

    private int value; // Range from 1 to 13
    private int suit; // Range from 1 to 4; 1 is club, 2 is diamond
                      //                  ; 3 is heart, 4 is spades

    // MODIFIES: this
    // EFFECTS: sets up a card that has a value and a suit
    public Card (int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    // EFFECTS: returns a card's value
    public int getValue() {
        return value;
    }

    // EFFECTS: returns a card's suit
    public int getSuit() {
        return suit;
    }
}
