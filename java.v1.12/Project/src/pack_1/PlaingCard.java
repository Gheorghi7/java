package pack_1;

import java.util.Objects;

public class PlaingCard {
	
	private String suit; 
	private String face; 
	private int internalHash;
	
	
	public PlaingCard(String suit, String face) {
		this.suit = suit;
		this.face = face;
		this.internalHash = (suit.equals("Hearts")?11:12);
	}


	@Override
	public String toString() {
		return face + " of "+ suit;
	}



	@Override
	public int hashCode() {
		return internalHash;
	}


	@Override
	public boolean equals(Object obj) {
		System.out.print("--> Cheking a Playing Card equality");
		return true;
	} 
	
	
	
	
}
