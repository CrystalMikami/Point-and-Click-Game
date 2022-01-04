package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Represents the full deck of cards available
public class Deck {
    private ArrayList<Card> cardList = new ArrayList<>();
    private Card currCard;
    private int drawnCardPos;

    // Initializes a full deck
    public Deck() {
        for(int i = 1; i <= 13; i++) {
            for(int j = 1; j <= 4; j++) {
                currCard = new Card(i, j);
                cardList.add(currCard);
            }
        }
    }

    public List<Card> getCardList() { return cardList; }

    // Draws a card from the available deck, the chosen card
    // is removed from the deck
    public Card drawCard() {
        Random rand = new Random();
        drawnCardPos = rand.nextInt(cardList.size());
        return cardList.remove(drawnCardPos);
    }

    // Refreshes the deck
    public void refreshDeck() {
        cardList.clear();
        for(int i = 1; i <= 13; i++) {
            for(int j = 1; j <= 4; j++) {
                currCard = new Card(i, j);
                cardList.add(currCard);
            }
        }
    }
}
