package pack_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Card> deck = Card.getStandartDeck();
		Collections.shuffle(deck);
		boolean game = true;
		Scanner scanner = new Scanner(System.in);
		
		Card.printDeck(deck);
		
		Player player_1 = new Player();
		Player player_2 = new Player();
		Player player_3 = new Player();
		
		player_1.cardOnHand(deck);
		player_1.cardDistribution(deck);
		player_2.cardOnHand(deck);
		player_3.cardOnHand(deck);
		
		Card[] p1 = player_1.getPickUpCard();
		Card[] p2 = player_2.getPickUpCard();
		Card[] p3 = player_3.getPickUpCard();
		
		Card[] d = player_1.getCardDistribution();
		
		System.out.println(Arrays.toString(p1));
		System.out.println(Arrays.toString(p2));
		System.out.println(Arrays.toString(p3));
		System.out.print("first is 3: ");
		int n = scanner.nextInt();
		for (int i=0; i<= n-1; i++) {
			System.out.print(d[i]+" ");
			
		}
		System.out.println();
		
	}
}
class Player implements PlayerInterface {
	
	private Random randomCard = new Random();
	private Card[] pickUpCard;
	private Card[] cardDistr;
	
	
	
	@Override
	public void cardOnHand(List<Card> deck) {
		// TODO Auto-generated method stub
		this.pickUpCard = new Card[]{deck.get(randomCard.nextInt(0, 52)),deck.get(randomCard.nextInt(0, 52))};
		
	}
	
	public Card[] getPickUpCard() {
		return pickUpCard;
	}
	@Override
	public void cardDistribution(List<Card> deck) {
		this.cardDistr = new Card[]{deck.get(randomCard.nextInt(0, 52)),
									deck.get(randomCard.nextInt(0, 52)), 
									deck.get(randomCard.nextInt(0, 52)),
									deck.get(randomCard.nextInt(0, 52)),
									deck.get(randomCard.nextInt(0, 52))};
		
	}
	public Card[] getCardDistribution() {
		return this.cardDistr;
	}
	
	}

