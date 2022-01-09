package Tests;

import Model.Card;
import Model.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTests {
    private Deck testDeckOne;
    private Deck testDeckTwo;
    @BeforeEach
    public void setup() {
        testDeckOne = new Deck(0, 0);
        testDeckTwo = new Deck(0, 0);
    }

    @Test
    public void testDrawCardOne() {
        assertFalse(testDeckOne.getCardList().contains(testDeckOne.drawCard()));
    }

    @Test
    public void testDrawCardTwo() {
        assertFalse(testDeckTwo.getCardList().contains(testDeckTwo.drawCard()));
    }

    @Test
    public void testRefreshDeckOne() {
        testDeckOne.refreshDeck(0, 0);
        testDeckTwo.drawCard();
        testDeckTwo.drawCard();
        testDeckTwo.refreshDeck(0, 0);
        assertEquals(testDeckOne.getCardList().size(), testDeckTwo.getCardList().size());
    }
}
