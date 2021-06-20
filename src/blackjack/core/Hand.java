package blackjack.core;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards = new ArrayList<Card>();
	boolean bust = false;
	int[] values;
	int finalValue;
	boolean finished = false;

	public ArrayList<Card> getCards() {
		return cards;
	}

	public int getCardAmount() {
		return cards.size();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public int[] calculateValue() {
		if (hasBlackjack()) {
			int[] temp = { 21 };
			return temp;
		}
		int aceCount = 0;
		for (Card c : cards) {
			if (c.getValue() == Value.ACE) {
				aceCount += 1;
			}
		}
		boolean hasAce = aceCount > 0;
		if (hasAce) {
			values = new int[2];
		} else {
			values = new int[1];
		}
		boolean aceCounted = false;
		if (hasAce) {
			for (Card c : cards) {
				if (c.getNumericalValue() == -1) {
					if (!aceCounted) {
						values[1] += 11;
						aceCounted = true;
					} else {
						values[1] += 1;
					}
				} else {
					values[1] += c.getNumericalValue();
				}
			}
		}
		for (Card c : cards) {
			if (c.getNumericalValue() == -1) {
				values[0] += 1;
			} else {
				values[0] += c.getNumericalValue();
			}
		}
		if (values.length == 2 && values[1] > 21) {
			int[] singleValues = { values[0] };
			values = singleValues;
		}
		return values;
	}

	public boolean checkBust() {
		if (values.length == 1) {
			if (values[0] > 21) {
				bust = true;
			}
		} else {
			if (values[0] > 21 && values[1] > 21) {
				bust = true;
			}
		}
		return bust;
	}

	public boolean hasBlackjack() {
		if (cards.size() == 2) {
			if ((cards.get(0).getValue() == Value.ACE && cards.get(1).getNumericalValue() == 10)
					|| (cards.get(0).getNumericalValue() == 10 && cards.get(1).getValue() == Value.ACE)) {
				finished = true;
				int[] bjv = { 21 };
				values = bjv;
				return true;
			}
		}
		return false;
	}
}
