package pack_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class PokerGame {
	private final List<Card> deck = Card.getStandartDeck(); 
	private int playerCount; 
	private int cardsInHand; 
	private List<PokerHand> pokerHands; 
	private List<Card> remainingCards;
	
	
	public PokerGame(int playerCount, int cardsInHand) {
		super();
		this.playerCount = playerCount;
		this.cardsInHand = cardsInHand;
		pokerHands = new ArrayList<>(cardsInHand);
	}
	
	
	public void startPlay() {
		
		Collections.shuffle(deck);
		Card.printDeck(deck);
		int randomMidle = new Random().nextInt(15, 35);
		
		Collections.rotate(deck, randomMidle);
		Card.printDeck(deck);
		
		deal(); 
		
		System.out.println("--------------------------------"); 
		Consumer<PokerHand> checkHand = PokerHand::evalHand;
		pokerHands.forEach(checkHand.andThen(System.out::println));
		
		
		int cardDealt = playerCount * cardsInHand; 
		int cardRemaining = deck.size() - cardDealt; 
		remainingCards = new ArrayList<>(cardRemaining);
		remainingCards = new ArrayList<>(Collections.nCopies(cardRemaining, null));
		remainingCards.replaceAll(c -> deck.get(cardDealt + remainingCards.indexOf(c)));
		Card.printDeck(remainingCards, "Remaining cards", 2);
		
	}
	
	private void deal() {
		
		Card[][] hands = new Card[playerCount][cardsInHand]; 
		for (int deckIndex = 0, i=0; i<cardsInHand; i++ ) {
			for(int j =0; j< playerCount; j++) {
				hands[j][i] = deck.get(deckIndex++); 
				
			}
			
			}
		int playerNo = 1; 
		for(Card[] hand: hands) {
			pokerHands.add(new PokerHand(Arrays.asList(hand), playerNo++));
			
		}
	}
	
}
