package Model;

import javax.swing.*;

// Represents a card
public class Card {

    private int value; // Range from 1 to 13
    private int suit; // Range from 1 to 4; 1 is club, 2 is diamond
                      //                  ; 3 is heart, 4 is spades
    private int flipped; // flipped = 1
    private ImageIcon img;
    private int width;
    private int height;

    // MODIFIES: this
    // EFFECTS: sets up a card that has a value and a suit
    public Card(int value, int suit, int width, int height, ImageIcon img) {
        this.value = value;
        this.suit = suit;
        this.flipped = 0;
        this.img = img;
        this.width = width;
        this.height = height;
    }

    // MODIFIES: this
    // EFFECTS: sets the flipped state to flippedState
    public void setFlipped(int flippedState) {
        this.flipped = flippedState;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // EFFECTS: returns a card's value
    public int getValue() {
        return value;
    }

    // EFFECTS: returns a card's suit
    public int getSuit() {
        return suit;
    }

    // EFFECTS: Returns if the card is flipped or not
    public int getFlipped() {
        return flipped;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ImageIcon getImg() {
        return img;
    }
}
