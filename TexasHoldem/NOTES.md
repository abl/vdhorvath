# Overview

Texas hold 'em is a variant of poker. Similar to poker, a single deck of 52 cards is used.

Each player (1-N players) gets exactly two cards; five community cards are dealt in counts of 3,1,1.
Players are scored based on the best possible poker hand that can be constructed from any five total
cards among their two cards and the five community cards. There is no discrimination between the
player's own cards and the community cards; if the best-scoring hand at the table is composed of the
five community cards the round is an N-way tie.

## Assumptions

 * A single server should be able to host any number of simultaneous games with independent decks.
 * Decks are reshuffled automatically when a card is requested from an empty deck.
 * No more than 8 players per table (so it's always possible to deal using a single deck).

## Models

### Card

Has to have a suit and a value.

### Deck

A collection of between 0 and 52 cards. Strongly ordered; cards should only come off the "top" of
the deck.

Should also have a "discard" pile; attempts to pull from an empty "deck" should shuffle discard
into the deck seamlessly.

Should initialize with a full set of 52 cards in order in discard; the first draw from the deck will
therefore automatically shuffle and deal.

### Hand

An unordered collection of 2 (player) or 3-5 (community) cards. Ordered with random access.

Must be possible to combine a player and community hand for scoring.

## Controllers

`TBD`

## Views

`TBD`

# Scoring

Hand scoring follows standard poker rules. Lowercase letters are variable; `aa___` would be two
cards of value `a` and three cards NOT of value `a`. Valid card values, from lowest to highest, are
`234567890JQKA` (or 0-12); suits are `SCDH` (or 0-3).

Assume hands are ordered such that for a hand `abcde`, `a` is the highest-valued card; `aabbc` would
be ordered such that `a` is the highest-valued pair, `b` is the lower-valued pair, and `c` is the
next-highest-available single card.

 1. Royal Flush - `AKQJ0` in the same suit. All royal flushes are equal.
 2. Straight Flush - `abcde` in the same suit describing a sequence. Note that the sequence wraps!
    Ties broken by the value of `e` - so `A5432` is the lowest and `AKQJ0` is the highest (although
    this would be a royal flush instead.)
 3. Four of a Kind - `aaaab`; ties broken by the value of `a` and then the value of `b`.
 4. Full House - `aaabb`; ties broken by the value of `a` and then the value of `b`.
 5. Flush - `abcde` in a single suit (S/C/D/H). Ties broken by individual card values; `A6432` beats
    `K0987` but `A6432` loses to `A0789`.
 6. Straight - `abcde` of multiple suits describing a sequence. Ties broken by the value of `e`.
 7. Three of a Kind - `aaabc`; ties broken by the value of `a`, then `b`, then `c`.
 8. Two Pair - `aabbc`; ties broken by the value of `a`, then `b`, then `c`.
 9. One Pair - `aabcd`; ties broken by the value of `a`, then `b`, then `c`, then `d`.
 10. Highest Card - `abcde`; ties broken by the value of `a`, ..., then `e`.

