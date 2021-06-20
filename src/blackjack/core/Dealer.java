package blackjack.core;

import java.util.List;

public class Dealer {
	public Hand hand = new Hand();

	public boolean canHit() {
		int[] handValues = hand.calculateValue();
		if (handValues.length == 1) {
			return handValues[0] < 17;
		} else {
			return handValues[1] < 17;
		}
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public String displayHiddenHand() {
		List<Card> handCards = hand.getCards();
		String hand = "";
		hand += "[??]";
		hand += handCards.get(1).toString();
		return hand;
	}

	public String displayHand() {
		String dealerHand = "";
		List<Card> cards = hand.getCards();
		for (Card c : cards) {
			dealerHand += c.toString();
		}
		return dealerHand;
	}

}
