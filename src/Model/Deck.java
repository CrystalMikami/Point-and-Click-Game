package Model;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cardList;

    public Deck() {
        for(int i = 1; i <= 13; i++) {
            for(int j = 1; j <= 4; j++) {
                Card currCard = new Card(i, j);
                cardList.add(currCard);
            }
        }
    }

    public Card drawCard() {
        Random rand = new Random();
        int card = rand.nextInt(cardList.size());
        return cardList.remove(card);
    }

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
