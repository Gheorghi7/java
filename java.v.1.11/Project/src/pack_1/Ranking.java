package pack_1;

public enum Ranking {
	NONE, ONE_PAIR, TWO_PAIR, FULL_HOUSE,THREE_OF_A_KIND, FOUR_OF_A_KIND;
	
	@Override
	public String toString() {
		return this.name().replace('_', ' ');
	}
}
