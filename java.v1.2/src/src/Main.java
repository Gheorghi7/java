record BaseballPlayer(String name, String position) implements Player {
}

record FootballPlayer(String name, String position) implements Player {
}

interface Player {
    String name();
}


public class Main {

    public static void main(String[] args) {
        BaseballTeam philles1 = new BaseballTeam("Philadelphia Phollies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResult(philles1, 3, astros1, 5);

        SportsTeam philles2 = new SportsTeam("Philadelphia Phollies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        scoreResult(philles2, 3, astros2, 5);

        Team<BaseballPlayer> philles = new Team<>("Philadelphia Phollies");
        Team<BaseballPlayer> astros = new Team<>("Houston Astros");
        scoreResult(philles, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        philles.addTeamMember(harper);
        philles.addTeamMember(marsh);
        philles.listTeamMembers();

        SportsTeam afc = new SportsTeam("Adelaide Crows");
        Team<FootballPlayer> afc1 = new Team<>("Adelaide Crows");
        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
        var rory = new FootballPlayer("Rory laird", "Midfield");
        afc.addTeamMember(tex);
        afc1.addTeamMember(rory);
        afc.listTeamMembers();
        afc1.listTeamMembers();
// - - - - - - - - - - - - - - - - - - - - - - -
        Team<String> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember("N Roberts");
        adelaide.listTeamMembers();

        var canberra = new Team<String>("Canberra Heat");
        canberra.addTeamMember("B Black");
        canberra.listTeamMembers();
        scoreResult(canberra, 0, adelaide, 1);

        Team<Integer> melbrourneVB = new Team<>("Melbourbne Vipers");
    }


    public static void scoreResult(BaseballTeam team1, int t1_score, BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1_score, SportsTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(Team team1, int t1_score, Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

}
