package pack_3;

public class LPAStudent extends Student{

	private double percenteComplete; 
	
	public LPAStudent() {
		percenteComplete = random.nextDouble(0, 100.001);
		
	}
	
	@Override 
	public String toString() {
		return "%s %8.1f%%".formatted(super.toString(), percenteComplete);
	}

	public double getPercenteComplete() {
		return percenteComplete;
	}
}
