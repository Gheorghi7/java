package pack_2;
interface Player{
	String name();
};
public class Main {
	record BaseballPlayer(String name, String position) implements Player{}
	record FootballPlayer(String name, String position) implements Player{}
	record ValleybalPLayer(String name, String position) implements Player{}
	public static void main(String... args) { 
		
			var philly = new Affiliation("city", "Philadelphia","US");
		
		
			BaseBallTeam team_1 = new BaseBallTeam("Team_1");
			BaseBallTeam team_2 = new BaseBallTeam("Team_2");
			
			SportTeam team_1_s = new SportTeam("Team_1");
			SportTeam team_2_s = new SportTeam("Team_2");
			
			Team<BaseballPlayer, Affiliation> team_1_t = new Team<>("Team_1");
			Team<BaseballPlayer, Affiliation> team_2_t = new Team<>("Team_2");
			
			
			var harper = new BaseballPlayer("B Harper", "Right Fielder");
			var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
			
			team_1.addTeamMember(marsh);
			team_2.addTeamMember(harper);
	
			team_1.listTeamMembers();
			team_2.listTeamMembers();
			
			SportTeam afc = new SportTeam("Adelade Crows");
			Team<FootballPlayer, String> afc1 = new Team<>("Adelade Crows", "City of Adelayde, South Australia, in UA");
			var tex = new FootballPlayer("Tex Walker", "Center half forward");
			
			
			var canberra = new Team<ValleybalPLayer, Affiliation>("Canberra Heat", philly);
			canberra.addTeamMember(new ValleybalPLayer("B Black", "Opposite"));
			canberra.listTeamMembers();
//			Team<String> adelade = new Team<>("Adelade Storm");
//			adelade.addTeamMember("N Roberts");
//			adelade.listTeamMembers();
			
			
			
			
			afc.addTeamMember(tex);
			afc.listTeamMembers();
			afc1.addTeamMember(tex);
			afc1.listTeamMembers();
			
			scoreRecorder(team_1, 3, team_2, 5);
			scoreRecorder(team_1_s, 3, team_2_s, 5);
			scoreRecorder(team_1_t, 3, team_2_t, 5);
	}
	
	
	public static void scoreRecorder(BaseBallTeam team1, int t1_score, 
									 BaseBallTeam team2, int t2_score) 
	{
		
		String message = team1.setScore(t1_score, t2_score);
		team2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s %n", team1, message, team2);
	}
	
	
	public static void scoreRecorder(SportTeam team1, int t1_score, 
			SportTeam team2, int t2_score) 
	{

		String message = team1.setScore(t1_score, t2_score);
		team2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s %n", team1, message, team2);
	}
	
	
	public static void scoreRecorder(Team team1, int t1_score, 
			Team team2, int t2_score) 
	{

		String message = team1.setScore(t1_score, t2_score);
		team2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s %n", team1, message, team2);
	}
	
}
