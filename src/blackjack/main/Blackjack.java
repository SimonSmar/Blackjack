package blackjack.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import blackjack.core.*;

public class Blackjack {
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		// Initialize
		System.out.println("Welcome to blackjack!");
		System.out.println("Dealer sticks at 17");
		while (true) {
			System.out.println("___________________");
			Deck deck = new Deck(1);
			deck.shuffle();
			Player player = new Player(100);
			Dealer dealer = new Dealer();
			// Start Game

			// Deal card to player and dealer
			player.addCard(deck.dealCard());
			dealer.addCard(deck.dealCard());
			player.addCard(deck.dealCard());
			dealer.addCard(deck.dealCard());
			System.out.println("-Dealer-");
			System.out.println(dealer.displayHiddenHand());
			System.out.println("-Player-");
			System.out.println(player.displayHand());
			int[] playerHandValue = player.hand.calculateValue();
			System.out.println("Your hand value:" + Arrays.toString(playerHandValue));
			boolean playerFinished = false;
			if (player.hand.hasBlackjack()) {
				System.out.println("BLACKJACK!");
				playerFinished = true;
			}
			while (!playerFinished) {
				System.out.println("[H]it or [s]tick?");
				char input = userHitStick();
				if (input == 'H') {
					player.addCard(deck.dealCard());
					System.out.println(player.displayHand());
					playerHandValue = player.hand.calculateValue();
					System.out.println("Your hand value:" + Arrays.toString(playerHandValue));
					if (player.hand.checkBust()) {
						System.out.println("Bust!");
						playerFinished = true;
					}
				} else {
					playerFinished = true;
				}
			}
			int playerFinalValue;
			if (playerHandValue.length == 2) {
				playerFinalValue = playerHandValue[1];
			} else {
				playerFinalValue = playerHandValue[0];
			}
			System.out.println("Final hand value:" + playerFinalValue);
			System.out.println("----Dealers turn-----");
			boolean dealerFinished = false;
			int[] dealerHandValue = dealer.hand.calculateValue();
			System.out.println("Dealer hand value:" + Arrays.toString(dealerHandValue));
			System.out.println(dealer.displayHand());
			if (dealer.hand.hasBlackjack()) {
				System.out.println("Dealer has Blackjack!");
				dealerFinished = true;

			}
			if (!dealer.canHit() && !dealerFinished) {
				System.out.println("Dealer hit Limit");
				dealerFinished = true;
			}
			while (!dealerFinished) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Dealer hits...");
				dealer.addCard(deck.dealCard());
				dealerHandValue = dealer.hand.calculateValue();
				System.out.println(dealer.displayHand());
				System.out.println("Dealer hand value:" + Arrays.toString(dealerHandValue));
				if (dealer.hand.checkBust()) {
					System.out.println("Dealer busts!");
					dealerFinished = true;
				}
				if (!dealer.canHit() && !dealerFinished) {
					System.out.println("Dealer hit Limit");
					dealerFinished = true;
				}
			}
			int dealerFinalValue;
			if (dealerHandValue.length == 2) {
				dealerFinalValue = dealerHandValue[1];
			} else {
				dealerFinalValue = dealerHandValue[0];
			}
			System.out.println("Dealer final hand value:" + dealerFinalValue);
			System.out.println("__________________________");
			/////////// Check who wins
			if (player.hand.hasBlackjack()) {
				if (dealer.hand.hasBlackjack()) {
					System.out.println("Push!");
				} else {
					System.out.println("Player wins!");
				}
			} else {
				if (!player.hand.checkBust()) {
					if (dealer.hand.checkBust()) {
						System.out.println("You win!");
					} else {
						if (playerFinalValue == dealerFinalValue) {
							System.out.println("Push!");
						} else if (playerFinalValue > dealerFinalValue) {
							System.out.println("You win!");
						} else {
							System.out.println("Dealer wins!");
						}
					}
				} else {
					System.out.println("You lose!");
				}
			}
		}
	}

	public static char userHitStick() {
		char userInput = scnr.next().charAt(0);
		userInput = Character.toUpperCase(userInput);
		boolean validVoidInput = userInput == 'H' || userInput == 'S';
		// Validate void input
		while (!validVoidInput) {
			System.out.println("--Invalid answer, try again!--");
			System.out.println("Enter H for 'Hit' and S for 'Stick'");
			userInput = scnr.next().charAt(0);
			userInput = Character.toUpperCase(userInput);
			validVoidInput = userInput == 'H' || userInput == 'S';
		}
		return userInput;
	}

	public static void dealCardsShuffledDeck(int amountOfCards) {
		Deck deck = new Deck(1);
		deck.shuffle();
		for (int i = 0; i < amountOfCards; i++) {
			Card c = deck.dealCard();
			System.out.println(c.toString());
		}
	}

	public static void dealTestHands() {
		dealBlackJack();
		dealAceHand();
		dealLowHand();
		dealBustHand();
		dealBustAceHand();
	}

	public static void dealBlackJack() {
		Hand hand = new Hand();

		Card c1 = new Card(Suit.HEARTS, Value.ACE);
		Card c2 = new Card(Suit.SPADES, Value.KING);
		hand.addCard(c1);
		hand.addCard(c2);
		System.out.println("--------Hand---------");
		ArrayList<Card> handCards = hand.getCards();
		for (Card c : handCards) {
			System.out.print(c.toString());
		}
		System.out.println();
		System.out.println("Value:" + Arrays.toString(hand.calculateValue()));
		System.out.println("Blackjack:" + hand.hasBlackjack());
		System.out.println("Bust:" + hand.checkBust());
		System.out.println("_____________________");
	}

	public static void dealAceHand() {
		Hand hand = new Hand();

		Card c1 = new Card(Suit.HEARTS, Value.ACE);
		Card c2 = new Card(Suit.SPADES, Value.SEVEN);
		hand.addCard(c1);
		hand.addCard(c2);
		System.out.println("-Hand-");
		ArrayList<Card> handCards = hand.getCards();
		for (Card c : handCards) {
			System.out.print(c.toString());
		}
		System.out.println();
		System.out.println("Value:" + Arrays.toString(hand.calculateValue()));
		System.out.println("Blackjack:" + hand.hasBlackjack());
		System.out.println("Bust:" + hand.checkBust());
		System.out.println("_____________________");
	}

	public static void dealLowHand() {
		Hand hand = new Hand();

		Card c1 = new Card(Suit.HEARTS, Value.EIGHT);
		Card c2 = new Card(Suit.SPADES, Value.SEVEN);
		hand.addCard(c1);
		hand.addCard(c2);
		System.out.println("-Hand-");
		ArrayList<Card> handCards = hand.getCards();
		for (Card c : handCards) {
			System.out.print(c.toString());
		}
		System.out.println();
		System.out.println("Value:" + Arrays.toString(hand.calculateValue()));
		System.out.println("Blackjack:" + hand.hasBlackjack());
		System.out.println("Bust:" + hand.checkBust());
		System.out.println("_____________________");
	}

	public static void dealBustHand() {
		Hand hand = new Hand();

		Card c1 = new Card(Suit.HEARTS, Value.EIGHT);
		Card c2 = new Card(Suit.SPADES, Value.SEVEN);
		Card c3 = new Card(Suit.SPADES, Value.SEVEN);
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		System.out.println("-Hand-");
		ArrayList<Card> handCards = hand.getCards();
		for (Card c : handCards) {
			System.out.print(c.toString());
		}
		System.out.println();
		System.out.println("Value:" + Arrays.toString(hand.calculateValue()));
		System.out.println("Blackjack:" + hand.hasBlackjack());
		System.out.println("Bust:" + hand.checkBust());
		System.out.println("_____________________");
	}

	public static void dealBustAceHand() {
		Hand hand = new Hand();

		Card c1 = new Card(Suit.HEARTS, Value.EIGHT);
		Card c2 = new Card(Suit.SPADES, Value.SEVEN);
		Card c3 = new Card(Suit.SPADES, Value.ACE);
		Card c4 = new Card(Suit.SPADES, Value.SEVEN);
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		System.out.println("-Hand-");
		ArrayList<Card> handCards = hand.getCards();
		for (Card c : handCards) {
			System.out.print(c.toString());
		}
		System.out.println();
		System.out.println("Value:" + Arrays.toString(hand.calculateValue()));
		System.out.println("Blackjack:" + hand.hasBlackjack());
		System.out.println("Bust:" + hand.checkBust());
		System.out.println("_____________________");
	}

}
