package pack_1;

public class BookingAgent {
	public static void main(String[] args) {
		int rows = 10; 
		int totalSeats = 100; 
		Theatre rodgersNYC = new Theatre("Richard Rodgers", rows, totalSeats);
		rodgersNYC.printSeatMap();
		bookSeat(rodgersNYC, 'A', 3);
		bookSeat(rodgersNYC, 'A', 7);
		bookSeat(rodgersNYC, 4, 'B', 3, 10);
		bookSeat(rodgersNYC, 6, 'B','C', 3, 10);
		
	}
	
	private static void bookSeat( Theatre theatre, char rows, int seatNo) {
		String seat = theatre.reserveSeat(rows, seatNo); 
		if(seat != null) {
			System.out.println("Congratulations! Your reserved seat is " + seat);
			theatre.printSeatMap();
		}else {
			System.out.println("Sorry! Unable to reserve " + rows + seatNo );
		}
	
		
	}
	private static void bookSeat(Theatre theatre, int tickets, char minRow, int minSeat, int maxSeat) {
		bookSeat(theatre, tickets, minRow, minRow, minSeat, maxSeat);
	}
	
	private static void bookSeat(Theatre theatre, int tickets, char minRow, char maxRow, int minSeat, int maxSeat) {
		var seat = theatre.reserveSeat(tickets, minRow, maxRow, minSeat, maxSeat);
		if(seat != null) {
			System.out.println("Congratulations! Your reversed seat are " + seat);
			theatre.printSeatMap();
		}else {
			System.out.println("Sorry!! No matching contiguous seats in rows "+ minRow+ " - "+ maxRow);
		}
		
	}
}
