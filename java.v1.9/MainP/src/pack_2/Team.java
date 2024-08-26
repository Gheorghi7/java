package pack_2;

import java.util.ArrayList;
import java.util.List;
record Affiliation(String name, String type, String countryCode) {
	@Override
	public String toString() {
		return name+ "(" +type+" in "+ countryCode+")" ;
	}
};



public class Team <T extends Player, S>{

		private String teamName; 
		private S affiliation;
		private List<T> teamMembers = new ArrayList<>();
		
		private int totalWins = 0; 
		private int totalLosses = 0;
		private int totalTies = 0;
		
		
		public Team(String teamName, S affiliation) {
			this.teamName = teamName;
			this.affiliation = affiliation;
		}
		public Team(String teamName) {
			this.teamName = teamName;
		} 
		public void addTeamMember(T player) {
			if(!teamMembers.contains(player)) {
				teamMembers.add(player);
			}
		}
		public void listTeamMembers() {
			
			System.out.print(teamName+" Roster:");
			System.out.println((affiliation == null)?"":"AFILIATION: "+ affiliation);
			for(T t: teamMembers) {
				System.out.println(t.name());
			}
			
		}
		public int ranking() {
			return (totalLosses*2) + totalTies+1;
		}
		
		public String setScore(int ourScore, int theirScore) {
			String message = "lost to";
			if (ourScore>theirScore) {
				totalWins++; 
				message = "beat";
				return message;
			}else if(ourScore==theirScore) {
				totalTies++; 
				message = "tied"; 
			}else {
				totalLosses++;
			}
				return message;
		}
		@Override
		public String toString() {
			return "Team [teamName=" + teamName + ", teamMembers=" + teamMembers + "]";
		}
		
		
		
}
