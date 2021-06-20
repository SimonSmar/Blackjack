package blackjack.core;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards = new ArrayList<Card>();
	boolean bust = false;
	int[] values;
	int finalValue;
	boolean finished = false;
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public int[] calculateValue() {
		if(hasBlackjack()) {
			int[] temp = {21};
			return temp;
		}
		//System.out.println("[Calculating Hand Value]");
		int aceCount = 0;
		//Calculate possible hand values
		//We know only 1 Ace can be worth 11, otherwise 11+11 = 22 which is bust
		//I really stuggled with getting my head around how to calculate this not gonna lie
		for(Card c: cards) {
			if(c.getValue() == Value.ACE) {
				aceCount += 1;
			}
		}
		boolean hasAce = aceCount > 0;
		//System.out.println("[Ace count: " + aceCount + "]");
		if(hasAce) {
			values = new int[2];
			//System.out.println("[2 Possible values...]");
		} else {
			//System.out.println("[1 Possible value...]");
			values = new int[1];
		}
		//Create an array of possible values
		//Calculate value with one Ace as 11
		boolean aceCounted = false;
		if(hasAce) {
			//System.out.println("[Calculating Ace hand value]");
			for(Card c: cards) {
				if(c.getNumericalValue() == -1) {
					if(!aceCounted) {
						//System.out.println("[Adding ace with 11]");
						values[1] += 11;
						aceCounted = true;
					} else {
						//System.out.println("[Adding ace with value 1]");
						values[1] += 1;
					}
				} else {
				values[1] += c.getNumericalValue();
				//System.out.println("[Adding card with value " + c.getNumericalValue() + "]");
				}
			}
		}
			//Calculate value with all Aces as 1
		//System.out.println("[Calculating lower hand value]");
				for(Card c: cards) {
					if(c.getNumericalValue() == -1) {
						//System.out.println("[Added Ace value 1]");
						values[0] += 1;
					} else {
						//System.out.println("[Adding card with value " + c.getNumericalValue() + "]");
						values[0] += c.getNumericalValue();
					}
				}
				if (values.length == 2 && values[1]>21) {
					int[] singleValues = { values[0] };
					values = singleValues;
				}
				return values;
			}

	public boolean checkBust() {
		if (values.length == 1){
			if(values[0]>21) {
				bust = true;
			}
		} else {
			if(values[0]>21 && values[1]>21) {
				bust = true;
			}
		}
		return bust;
	}
	
	public boolean hasBlackjack() {
		if(cards.size() == 2) {
			if((cards.get(0).getValue() == Value.ACE && cards.get(1).getNumericalValue() == 10) ||
					(cards.get(0).getNumericalValue() == 10 && cards.get(1).getValue() == Value.ACE)) {
				finished = true;
				return true;
			}
		}
		return false;
	}
}
