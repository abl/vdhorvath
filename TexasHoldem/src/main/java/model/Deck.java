package model;

import java.util.Stack;
import java.util.Collections;

public class Deck {
  private Stack<Card> deck;
  private Stack<Card> discards;

  public Deck() {
    deck = new Stack<>();
    discards = new Stack<>();
    
    for (Suit suit : Suit.values()) {
      for (Value value : Value.values()) {
        discards.push(new Card(suit, value));
      }
    }
    shuffleDiscards();
  }

  public int getDeckSize() {
    return deck.size();
  }

  public int getDiscardSize() {
    return discards.size();
  }

  public Card drawCard() {
    if (getDeckSize() == 0) {
      shuffleDiscards();
    }

    return deck.pop();
  }

  public void discardCard(Card card) {
    discards.push(card);
  }

  public Card peekDiscard() {
    // We might want this to show the top of the discard pile

    return discards.peek();
  }

  private void shuffleDiscards() {
    deck.addAll(discards);
    Collections.shuffle(deck);
  }
}



