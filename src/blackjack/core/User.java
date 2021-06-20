package blackjack.core;

public class User extends Player {
	private int chips;

	public User() {
		chips = 100;
	}

	public User(int chips) {
		this.chips = chips;
	}

	public boolean setBet(int amount) {
		if (amount <= chips) {
			chips -= amount;
			return true;
		} else {
			System.out.println("Not enough chips!");
			return false;
		}
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
