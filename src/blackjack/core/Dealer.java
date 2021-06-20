package blackjack.core;

import java.util.List;

public class Dealer extends Player {

	public boolean canHit() {
		int[] handValues = hand.calculateValue();
		if (handValues.length == 1) {
			return handValues[0] < 17;
		} else {
			return handValues[1] < 17;
		}
	}

	public String displayHiddenHand() {
		List<Card> handCards = hand.getCards();
		String hand = "";
		hand += "[??]";
		hand += handCards.get(1).toString();
		return hand;
	}

}
