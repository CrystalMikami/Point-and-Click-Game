package Model;

import java.util.ArrayList;
import java.util.Random;

// Represents the full deck of cards available
public class Deck {
    private ArrayList<Card> cardList = new ArrayList<>();

    // Initializes a full deck
    public Deck() {
        for(int i = 1; i <= 13; i++) {
            for(int j = 1; j <= 4; j++) {
                Card currCard = new Card(i, j);
                cardList.add(currCard);
            }
        }
    }

    // Draws a card from the available deck, the chosen card
    // is removed from the deck
    public Card drawCard() {
        Random rand = new Random();
        int card = rand.nextInt(cardList.size());
        return cardList.remove(card);
    }

    // Refreshes the deck
    public void refreshDeck() {
        cardList.clear();
        for(int i = 1; i <= 13; i++) {
            for(int j = 1; j <= 4; j++) {
                Card currCard = new Card(i, j);
                cardList.add(currCard);
            }
        }
    }
}
