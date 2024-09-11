package pack_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		PlaingCard aceHearts = new PlaingCard("Hearts", "Ace"); 
		PlaingCard kingClubs = new PlaingCard("clubs", "King"); 
		PlaingCard queenSpades = new PlaingCard("Spades", "Queen"); 
		
		List<PlaingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
		
		cards.forEach(s -> System.out.println(s+" "+s.hashCode()));
		
		Set<PlaingCard> deck = new HashSet<>();
		for(PlaingCard c : deck) {
			if(!deck.add(c)) {
				System.out.println("Found a Duplicate for " + c);
			}
		}
		System.out.print(deck);
	}
}
