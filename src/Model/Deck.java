package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Represents the full deck of cards available
public class Deck {
    private ArrayList<Card> cardList = new ArrayList<>();
    private ImageIcon[][] img = {   {new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg")},
                                {new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg")},
                                {new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg")},
                                {new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg"), new ImageIcon("Images/myCat.jpg")}};

    // Initializes a full deck
    public Deck(int width, int height) {
        for(int i = 1; i <= 13; i++) {
            for(int j = 1; j <= 4; j++) {
                Card currCard = new Card(i, j, width, height, img[width][height]);
                cardList.add(currCard);
            }
        }
    }

    public List<Card> getCardList() {
        return cardList;
    }

    // Draws a card from the available deck, the chosen card
    // is removed from the deck
    public Card drawCard() {
        Random rand = new Random();
        int drawnCardPos = rand.nextInt(cardList.size());
        return cardList.remove(drawnCardPos);
    }

    // Refreshes the deck
    public void refreshDeck(int width, int height) {
        cardList.clear();
        for(int i = 1; i <= 13; i++) {
            for(int j = 1; j <= 4; j++) {
                Card currCard = new Card(i, j, width, height, img[width][height]);
                cardList.add(currCard);
            }
        }
    }
}
