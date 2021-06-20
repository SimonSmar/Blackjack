package blackjack.core;

public class Card {

	private Suit suit;
	private Value value;
	private boolean isFace;

	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
		isFace = value == Value.KING || value == Value.QUEEN || value == Value.JACK;
	}

	public Value getValue() {
		return value;
	}

	public int getNumericalValue() {
		if (isFace || value == Value.TEN) {
			return 10;
		}
		switch (value) {
		case ACE:
			return -1;
		case NINE:
			return 9;
		case EIGHT:
			return 8;
		case SEVEN:
			return 7;
		case SIX:
			return 6;
		case FIVE:
			return 5;
		case FOUR:
			return 4;
		case THREE:
			return 3;
		case TWO:
			return 2;
		default:
			return 0;
		}
	}

	public String toString() {
		String s = "[";
		switch (suit) {
		// These symbols don't display correctly in console and I spent about 35min
		// trying to find a solution on how to display them.
		// If you decide to compile and run this, just imagine it displays the correct
		// symbol 😇
		case DIAMONDS:
			s += "D|";
			break;
		case CLUBS:
			s += "C|";
			break;
		case HEARTS:
			s += "H|";
			break;
		case SPADES:
			s += "S|";
			break;
		}
		switch (value) {
		case ACE:
			s += "A";
			break;
		case KING:
			s += "K";
			break;
		case QUEEN:
			s += "Q";
			break;
		case JACK:
			s += "J";
			break;
		case TEN:
			s += "10";
			break;
		case NINE:
			s += "9";
			break;
		case EIGHT:
			s += "8";
			break;
		case SEVEN:
			s += "7";
			break;
		case SIX:
			s += "6";
			break;
		case FIVE:
			s += "5";
			break;
		case FOUR:
			s += "4";
			break;
		case THREE:
			s += "3";
			break;
		case TWO:
			s += "2";
			break;
		}
		s += "]";
		return s;

	}

}
