
import static org.junit.Assert.*;

import model.Card;
import model.Suit;
import model.Value;
import org.junit.Test;


public class CardTest {
  Card KING_OF_SPADES = new Card(Suit.SPADE, Value.KING);
  Card QUEEN_OF_HEARTS = new Card(Suit.HEART, Value.QUEEN);
  Card KING_OF_SPADES_2 = new Card(Suit.SPADE, Value.KING);
  Card NINE_OF_DIAMONDS = new Card(Suit.DIAMOND, Value.NINE);
  Card FOUR_OF_SPADES = new Card(Suit.SPADE, Value.FOUR);
  Card ACE_OF_HEARTS = new Card(Suit.HEART, Value.ACE);
  Card ACE_OF_DIAMONDS = new Card(Suit.DIAMOND, Value.ACE);

  @Test
  public void getSuit() {
    assertEquals(Suit.SPADE, KING_OF_SPADES.getSuit());
  }

  @Test
  public void getValue() {
    assertEquals(Value.QUEEN, QUEEN_OF_HEARTS.getValue());
  }

  @Test
  public void testThatEquivalentCardsAreEqual() {
    assertTrue(KING_OF_SPADES.equals(KING_OF_SPADES));
    assertTrue(KING_OF_SPADES.equals(KING_OF_SPADES_2));
  }

  @Test
  public void testThatCardValuesMatterToEquals() {
    assertFalse(QUEEN_OF_HEARTS.equals(ACE_OF_HEARTS));
  }

  @Test
  public void testThatCardSuitsMatterToEquals() {
    assertFalse(ACE_OF_HEARTS.equals(ACE_OF_DIAMONDS));
  }

  @Test
  public void testCompareTo() {
    assertEquals(-1, QUEEN_OF_HEARTS.compareTo(KING_OF_SPADES));
  }

  @Test
  public void testCompareToIgnoresSuit() {
    assertEquals(0, ACE_OF_DIAMONDS.compareTo(ACE_OF_HEARTS));
  }

  @Test
  public void testHashCode() {
    assertTrue(KING_OF_SPADES.hashCode() != KING_OF_SPADES_2.hashCode());
  }

  @Test
  public void testValuesAscend() {
    assertTrue(KING_OF_SPADES.getSortValue() > FOUR_OF_SPADES.getSortValue());
  }

}