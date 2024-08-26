package pack_2;

import java.util.ArrayList;
import java.util.List;




public class SportTeam <T> {

		private String teamName; 
		
		private List<T> teamMembers = new ArrayList<>();
		
		private int totalWins = 0; 
		private int totalLosses = 0;
		private int totalTies = 0;
		
		
		public SportTeam(String teamName) {
			this.teamName = teamName;
		}
		public void addTeamMember(T player) {
			if(!teamMembers.contains(player)) {
				teamMembers.add(player);
			}
		}
		public void listTeamMembers() {
			System.out.println(teamName+" Roster:");
			System.out.println(teamMembers);
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
			return teamName + " ranked: " + ranking();
		}
		
		
}
