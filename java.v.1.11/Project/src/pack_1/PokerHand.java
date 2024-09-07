package pack_1;

import java.util.ArrayList;
import java.util.List;

public class PokerHand {
	private List<Card> hand; 
	private List<Card> keepers; 
	private List<Card> discards;
	
	private Ranking score = Ranking.NONE; 
	
	private int playerNo;

	public PokerHand(List<Card> hand, int playerNo) {
		hand.sort(Card.sortRankReversedSuit());
		this.hand = hand;
		this.playerNo = playerNo;
		keepers = new ArrayList<>(hand.size());
		discards = new ArrayList<>(hand.size());
		
	}

	@Override
	public String toString() {
		return "%d. %-16s Rank: %d %-40s %s".formatted(playerNo, score, score.ordinal(), hand, 
				(discards.size() >0)?"Discrads: "+discards:"");
		
	} 
	
	
	
}
