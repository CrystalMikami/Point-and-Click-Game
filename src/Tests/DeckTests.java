package Tests;

import Model.Card;
import Model.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeckTests {
    private Deck testDeckOne;
    private Deck testDeckTwo;

    @BeforeEach
    public void setup() {
        testDeckOne = new Deck();
        testDeckTwo = new Deck();
    }

    // Deck must not be null
    public boolean cardRemoved(Deck tests) {
        return !tests.getCardList().contains(tests.getDrawnCard());
    }

    @Test
    public void testDrawCardOne() {
        testDeckOne.drawCard();
        assertTrue(cardRemoved(testDeckOne));

    }

    @Test
    public void testDrawCardTwo() {
        testDeckTwo.drawCard();
        assertTrue(cardRemoved(testDeckTwo));
    }

    @Test
    public void testRefreshDeckOne() {
        testDeckOne.refreshDeck();
    }
}
