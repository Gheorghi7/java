package pack_1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventureGame {
	private static final String GAME_LOCATIONS = """
			road,at the end of the road, W: hill, E:well house,S:valley,N:forest
			hill,on top of hill with a view in all directions,N:forest, E:road
			well house,inside a well house for a small spring,W:road,N:lake,S:stream
			valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
			forest,at the edge of a thick dark forest,S:road,E:lake
			lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
			stream,near a stream with a rocky bed,W:valley, N:well house

			""";
	
	private enum Compass {
		E, N, S, W;
		private static final String[] direction = {"East", "North", "South", "West"};
		
		public String getString() {
			return direction[this.ordinal()];
		}
	}
	
	private record Location(String descriprion, Map<Compass, String> nextPlace) {}
	private String lastPlace;
	private Map<String, Location> adventureMap = new HashMap<>();
	public AdventureGame() {
		this(null);
	}
	public AdventureGame(String customLocations) {
			loadLocation(GAME_LOCATIONS);
			if(customLocations != null) {
				loadLocation(customLocations);
				
			}
	}
	
	private void loadLocation(String data) {
		for(String s: data.split("\\R")) {
			String[] parts = s.split(",", 3);
			Arrays.asList(parts).replaceAll(String::trim);
			Map<Compass,String> nextPlaces = loadDirections(parts[2]);
			Location location = new Location(parts[1], nextPlaces);
			adventureMap.put(parts[0], location);
		}
//		adventureMap.forEach((k, v) -> System.out.printf("%s:%s%n", k, v));
		
	}
	
	private Map<Compass, String> loadDirections(String nextPlaces){
		Map<Compass, String> direction = new HashMap<>();
		List<String> nextSteps = Arrays.asList(nextPlaces.split(","));
		nextSteps.replaceAll(String::trim);
		for(String nextPlace: nextSteps) {
			String[] splits = nextPlace.split(":");
			Compass compass = Compass.valueOf(splits[0].trim());
			String destination = splits[1].trim();
			direction.put(compass, destination);
		}
		return direction;
		
	}
	
	private void visit(Location location) {
		System.out.println("*** You`re standing %s ***%n".formatted(location.descriprion));
		location.nextPlace.forEach((k, v)-> {System.out.println("\t• A %s to the %s (%S) %n".formatted(v, k.getString(), k ));});
		System.out.println("Select your compass (Q to quit) >> ");
	}
	
	public void move (String direction) {
		var nextPlaces = adventureMap.get(lastPlace).nextPlace;
		String nextPlace = null; 
		if("ENSW".contains(direction)) {
			nextPlace = nextPlaces.get(Compass.valueOf(direction));
			if(nextPlace != null) {
				play(nextPlace);
			}
		}else {
			System.out.println("!! Invalid direction, try again!!");
		}
	
		
	}
	public void play(String location) {
		if (adventureMap.containsKey(location)) {
			Location next = adventureMap.get(location); 
			lastPlace = location; 
			visit(next);
			
		}else {
			System.out.println(location + "is a invalid location");
		}
		
	}
	
	
}
