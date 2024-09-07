package pack_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pack_1.Card.Suit;

public class Main {
	
	
public static void main(String... args) {
	
	
	
	Card[] cardArray = new Card[13]; 
	
	Card aceOfHeart =  Card.getFaceCard(Card.Suit.HEART, 'A'); 
	Arrays.fill(cardArray, aceOfHeart);
	
	Card.printDeck(Arrays.asList(cardArray), "Ace of Card", 1);
	
	
	List<Card>  cards = new ArrayList<>(52);
	Collections.fill(cards, aceOfHeart); 
	System.out.println(cards);
	System.out.println("card.size() = "+ cards.size());
	
	
	List<Card> acesOfHeart = Collections.nCopies(13, aceOfHeart); 
	Card.printDeck(acesOfHeart, "Aces of Hearts", 1);
	 
	
	Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
	List<Card> kingsOfClub = Collections.nCopies(13, kingOfClubs); 
	Card.printDeck(kingsOfClub, "Kings of Clubs", 1);
	
	
	Collections.addAll(cards, cardArray);
	Collections.addAll(cards, cardArray);
	Card.printDeck(cards, "Cards collection with Aces added", 2);
	
	Collections.copy(cards, kingsOfClub );
	Card.printDeck(cards, "Cards collection with Kings added", 2);
	
	cards = List.copyOf(kingsOfClub); 
	Card.printDeck(cards, "Cards collection with Kings added", 2);
	
	List<Card> deck = Card.getStandartDeck();
	Card.printDeck(deck);
	
	Collections.shuffle(deck);
	Card.printDeck(deck, "Shuffle deck", 4);
	
	Collections.reverse(deck);
	Card.printDeck(deck, "Reversed deck of Cards", 4);
	
	var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
	Collections.sort(deck, sortingAlgorithm);
	Card.printDeck(deck, "Standart deck sorted by rank", 13);
	
	Collections.reverse(deck);
	Card.printDeck(deck, "Sorted by rank suit reversed", 13);
	
	List<Card> kings = new ArrayList<>(deck.subList(4, 8));
	Card.printDeck(kings, "Kings in deck", 1);
	
	List<Card> tens = new ArrayList<>(deck.subList(16, 20));
	Card.printDeck(tens, "Kings in deck", 1);
	System.out.println("---------------------------");
	int subListIndex = Collections.indexOfSubList(deck, tens); 
	System.out.println("sublist index of tens " + subListIndex);
	
	System.out.println("---------------------------");
	boolean disJoint = Collections.disjoint(kings, tens);
	System.out.println("disjoint " + disJoint);
//	System.out.println("---------------------------");
	
	Collections.reverse(deck);
	Card.printDeck(deck);
	deck.sort(sortingAlgorithm);
	Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10); 
	int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm); 
	System.out.println("foundIndex " + foundIndex);
	System.out.println("foundIndex " + deck);
	System.out.println("foundIndex " + deck.indexOf(tenOfHearts));
	System.out.println(deck.get(foundIndex));
//	System.out.println("---------------------------");
	
	Card tenOfClub = Card.getNumericCard(Card.Suit.CLUB, 10); 
	Collections.replaceAll(deck,tenOfHearts , tenOfClub);
	Card.printDeck(deck.subList(32, 36), "Tens row", 1);
	
	Collections.replaceAll(deck, tenOfClub ,tenOfHearts );
	Card.printDeck(deck.subList(32, 36), "Tens row", 1);
	
	if(Collections.replaceAll(deck,  tenOfClub ,tenOfHearts)) {
		System.out.println("Tens of Hearts replaces with tens of clubs");
	}else {
		System.out.println("No tens of hearts found in the list");
		}
	
	System.out.println("ten of Clubs cards = " + Collections.frequency(deck, tenOfClub));
	System.out.println("ten of Hearts cards = " + Collections.frequency(deck, tenOfHearts));
	System.out.println("Card max " + Collections.max(deck, sortingAlgorithm));
	System.out.println("Card min " + Collections.min(deck, sortingAlgorithm));

	
	var sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
	deck.sort(sortBySuit);
	Card.printDeck(deck, "Sorted by suit", 4);
	
	
	List<Card> copied = new ArrayList<>(deck.subList(0, 13));
	
	Collections.rotate(copied, 2);
	System.out.println("UnRotaed: "+ deck.subList(0, 13));
	System.out.println("Rotaed: "+ 2+ ": "+ copied);
	
	copied = new ArrayList<>(deck.subList(0, 13));
	
	Collections.rotate(copied, -2);
	System.out.println("UnRotaed: "+ deck.subList(0, 13));
	System.out.println("Rotaed: "+ -2+ ": "+ copied);
	
	copied = new ArrayList<>(deck.subList(0, 13)); 
	for(int i = 0; i<copied.size()/2;i++) {
		Collections.swap(copied, i, copied.size()-1-i);
	}
	System.out.println("Manual swap: "+copied);
	
	copied = new ArrayList<>(deck.subList(0, 13)); 
	Collections.reverse(copied);
	System.out.println("Using reverse method: "+ copied);
	
}
	
	
}
 