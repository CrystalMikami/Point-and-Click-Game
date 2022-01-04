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
        testDeckOne = new Deck();
        testDeckTwo = new Deck();
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
        testDeckOne.refreshDeck();
        testDeckTwo.drawCard();
        testDeckTwo.drawCard();
        testDeckTwo.refreshDeck();
        assertEquals(testDeckOne.getCardList().size(), testDeckTwo.getCardList().size());
    }
}
