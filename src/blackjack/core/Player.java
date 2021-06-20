package blackjack.core;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int chips;
	// Leave hand public so I can manipulate it outside, as later a player can have
	// multiple hands when they split.
	public Hand hand = new Hand();
	// List hands = new ArrayList<Hand>();

	public Player(int chips) {
		this.chips = chips;
	}

	public boolean setBet(int amount) {
		if (amount >= chips) {
			chips -= amount;
			return true;
		} else {
			return false;
		}
	}

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

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}

	public void addChips(int chips) {
		this.chips += chips;
	}

	public void removeChips(int chips) {
		this.chips -= chips;
	}
}
