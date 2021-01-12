package model;

public class Card implements Comparable<Card> {
  private Suit suit;
  private Value value;

  public Card(Suit suit, Value value) {
    this.suit = suit;
    this.value = value;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public Value getValue() {
    return this.value;
  }

  public int getSortValue() {
    return this.value.getValue();
  }

  public int compareTo(Card c) {
    return this.getValue().compareTo(c.getValue());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Card)) {
      return false;
    }
    Card card = (Card) o;
    return suit == card.suit &&
        value == card.value;
  }

  @Override
  public String toString() {
    return "<"+ value + "/" + suit +">";
  }
}
