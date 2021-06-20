package blackjack.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
	public Hand hand = new Hand();

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public String displayHand() {
		String playerHand = "";
		List<Card> cards = hand.getCards();
		for (Card c : cards) {
			playerHand += c.toString();
		}
		return playerHand;
	}

	public void clearHand() {
		hand = new Hand();
	}
}
