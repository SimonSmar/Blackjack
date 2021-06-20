package blackjack.core;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
	Stack<Card> deck = new Stack<Card>();
	Random r = new Random();
	
	public Deck(int decks) {
		for(int i = 1; i<= decks;i++) {
			generateDeck();
		}
	}

	public void generateDeck() {
		//CLUBS
		deck.add(new Card(Suit.CLUBS,Value.ACE));
		deck.add(new Card(Suit.CLUBS,Value.KING));
		deck.add(new Card(Suit.CLUBS,Value.QUEEN));
		deck.add(new Card(Suit.CLUBS,Value.JACK));
		deck.add(new Card(Suit.CLUBS,Value.TEN));
		deck.add(new Card(Suit.CLUBS,Value.NINE));
		deck.add(new Card(Suit.CLUBS,Value.EIGHT));
		deck.add(new Card(Suit.CLUBS,Value.SEVEN));
		deck.add(new Card(Suit.CLUBS,Value.SIX));
		deck.add(new Card(Suit.CLUBS,Value.FIVE));
		deck.add(new Card(Suit.CLUBS,Value.FOUR));
		deck.add(new Card(Suit.CLUBS,Value.THREE));
		deck.add(new Card(Suit.CLUBS,Value.TWO));
		//HEARTS
		deck.add(new Card(Suit.HEARTS,Value.ACE));
		deck.add(new Card(Suit.HEARTS,Value.KING));
		deck.add(new Card(Suit.HEARTS,Value.QUEEN));
		deck.add(new Card(Suit.HEARTS,Value.JACK));
		deck.add(new Card(Suit.HEARTS,Value.TEN));
		deck.add(new Card(Suit.HEARTS,Value.NINE));
		deck.add(new Card(Suit.HEARTS,Value.EIGHT));
		deck.add(new Card(Suit.HEARTS,Value.SEVEN));
		deck.add(new Card(Suit.HEARTS,Value.SIX));
		deck.add(new Card(Suit.HEARTS,Value.FIVE));
		deck.add(new Card(Suit.HEARTS,Value.FOUR));
		deck.add(new Card(Suit.HEARTS,Value.THREE));
		deck.add(new Card(Suit.HEARTS,Value.TWO));
		//SPADES
		deck.add(new Card(Suit.SPADES,Value.ACE));
		deck.add(new Card(Suit.SPADES,Value.KING));
		deck.add(new Card(Suit.SPADES,Value.QUEEN));
		deck.add(new Card(Suit.SPADES,Value.JACK));
		deck.add(new Card(Suit.SPADES,Value.TEN));
		deck.add(new Card(Suit.SPADES,Value.NINE));
		deck.add(new Card(Suit.SPADES,Value.EIGHT));
		deck.add(new Card(Suit.SPADES,Value.SEVEN));
		deck.add(new Card(Suit.SPADES,Value.SIX));
		deck.add(new Card(Suit.SPADES,Value.FIVE));
		deck.add(new Card(Suit.SPADES,Value.FOUR));
		deck.add(new Card(Suit.SPADES,Value.THREE));
		deck.add(new Card(Suit.SPADES,Value.TWO));
		//DIAMONDS
		deck.add(new Card(Suit.SPADES,Value.ACE));
		deck.add(new Card(Suit.DIAMONDS,Value.KING));
		deck.add(new Card(Suit.DIAMONDS,Value.QUEEN));
		deck.add(new Card(Suit.DIAMONDS,Value.JACK));
		deck.add(new Card(Suit.DIAMONDS,Value.TEN));
		deck.add(new Card(Suit.DIAMONDS,Value.NINE));
		deck.add(new Card(Suit.DIAMONDS,Value.EIGHT));
		deck.add(new Card(Suit.DIAMONDS,Value.SEVEN));
		deck.add(new Card(Suit.DIAMONDS,Value.SIX));
		deck.add(new Card(Suit.DIAMONDS,Value.FIVE));
		deck.add(new Card(Suit.DIAMONDS,Value.FOUR));
		deck.add(new Card(Suit.DIAMONDS,Value.THREE));
		deck.add(new Card(Suit.DIAMONDS,Value.TWO));
		
	}
	
	public void shuffle() {
		Collections.shuffle(deck,r);
	}
	
	public Card dealCard() {
		Card c = deck.pop();
		return c;
	}
}
