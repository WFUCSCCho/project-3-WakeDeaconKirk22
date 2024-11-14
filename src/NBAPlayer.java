
/***************************************************************************
 @file: NBAPlayer.java
 @description: This program implements an NBA player that includes members of this class
  that are all attributes in NBAPlayer.txt file dataset. This class contain the following  default, parametrized,
 and copy constructors. Along with a toString , compareTo , and equals.
 @author:  Kennedy Kirk
 @date  Nov 14 ,2024
// hello
 *******************************************************************************/

public class NBAPlayer implements Comparable<NBAPlayer> {

// id,player_name,team_abbreviation,age,player_height,player_weight,college,country,draft_year,
// draft_round,draft_number,gp,pts,reb,ast,net_rating,oreb_pct,dreb_pct,usg_pct,ts_pct,ast_pct,season
   private int id;
    private String name;
    private String team;
    private Double age;

    private double playerHeight;
    private double playerWeight;
    private String collegeName;
    private String countryName;
    private String draftYear;
    private String draftRound;
    private  String draftNumber;
    private String gp;
    private double points;
    private double reb;
    private double ast;
    private double net_rating;
    private double oreb_pct;
    private double dreb_pct;
    private double usg_pct;
    private double tc_pct;
    private double ast_pct;
    private String seasons;


    //default constructor
public NBAPlayer(){ super(); }

//constructor
    public NBAPlayer(int id, String name, String team, double age, double playerHeight, double playerWeight, String collegeName,
                     String countryName, String draftYear, String draftRound, String draftNumber, String gp, double points,
                     double reb, double ast, double net_rating, double oreb_pct, double dreb_pct, double usg_pct, double tc_pct, double ast_pct, String seasons) {

        this.id = id;
    this.name = name;
        this.age = age;
        this.team = team;
        this.playerHeight = playerHeight;
        this.playerWeight = playerWeight;
        this.collegeName = collegeName;
        this.countryName = countryName;
        this.draftYear = draftYear;
        this.draftRound = draftRound;
        this.draftNumber = draftNumber;
        this.gp = gp;
        this.points = points;
        this.reb = reb;
        this.ast = ast;
        this.net_rating = net_rating;
        this.oreb_pct = oreb_pct;
        this.dreb_pct = dreb_pct;
        this.usg_pct = usg_pct;
        this.tc_pct = tc_pct;
        this.ast_pct = ast_pct;
        this.seasons = seasons;


        //abunch of get and set methods
    }
    public String getName() {
        return name;
    }
    public double getAge() {
        return age;
    }
    public String getTeam() {
        return team;

    }
    public double getPlayerHeight() {
        return playerHeight;
    }
    public double getPlayerWeight() {
        return playerWeight;
    }
    public String getCollegeName() {
        return collegeName;
    }
    public String getCountryName() {
        return countryName;
    }
    public String getDraftYear() {
        return draftYear;
    }
    public String getDraftRound() {
        return draftRound;
    }
    public String getDraftNumber() {
        return draftNumber;
    }
    public String getGp() {
        return gp;
    }
    public double getPoints() {
        return points;
    }
    public double getReb() {
        return reb;
    }
    public double getAst() {
        return ast;
    }
    public double getNet_rating() {
        return net_rating;
    }
    public double getOreb_pct() {
        return oreb_pct;
    }
    public double getDreb_pct() {
        return dreb_pct;
    }
    public double getUsg_pct() {
        return usg_pct;
    }
    public double getTc_pct() {
        return tc_pct;
    }
    public double getAst_pct() {
        return ast_pct;
    }
    public String getSeasons() {
        return seasons;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Double age) {
        this.age = age;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public void setPlayerHeight(double playerHeight) {
        this.playerHeight = playerHeight;
    }
    public void setPlayerWeight(double playerWeight) {
        this.playerWeight = playerWeight;

    }
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;

    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public void setDraftYear(String draftYear) {
        this.draftYear = draftYear;

    }
    public void setDraftRound(String draftRound) {
        this.draftRound = draftRound;
    }
    public void setDraftNumber(String draftNumber) {
        this.draftNumber = draftNumber;
    }
    public void setGp(String gp) {
        this.gp = gp;
    }
    public void setPoints(double points) {
        this.points = points;

    }
    public void setReb(double reb) {
        this.reb = reb;
    }
        public void setAst(double ast) {
        this.ast = ast;
        }
        public void setNet_rating(double net_rating) {
        this.net_rating = net_rating;
        }
        public void setOreb_pct(double oreb_pct) {
        this.oreb_pct = oreb_pct;
        }
        public void setDreb_pct(double dreb_pct) {
        this.dreb_pct = dreb_pct;
        }
        public void setUsg_pct(double usg_pct) {
        this.usg_pct = usg_pct;

        }
        public void setTc_pct(double tc_pct) {
        this.tc_pct = tc_pct;

        }
        public void setAst_pct(double ast_pct) {
        this.ast_pct = ast_pct;
        }
        public void setSeasons(String seasons) {
        this.seasons = seasons;
        }

    public void setId(int id) {
        this.id = id;
    }

    //prints out members by a new line
    @Override
    public String toString() {
        String nbaPlayerInfo = "";
        nbaPlayerInfo += "ID:"+ id+ "\n" + "Name: " + name + "\n" + "Age: " + age + "\n" + "Team: " + team + "\n" + "PlayerHeight: "
        + playerHeight +"\n" + "PlayerWeight: " + playerWeight + "\n" + "CollegeName: " + collegeName + "\n"
        + "DraftYear:" +draftYear + "\n" + "DraftRound: " + draftRound + "\n" + "DraftNumber: " + draftNumber +"\n" +
        "Games Played:  "+ gp + "\n" + "Points: " + points + "\n" + "Rebounds: " + reb + "\n" + "Assist: " + ast + "\n"
        + "Net Rating:" + net_rating + "\n" + "Offensive Rebound Rating:" + oreb_pct + "\n"
        + "Defensive Rebound Rating: " + dreb_pct + "\n" + "Usage Rating:" + usg_pct + "\n"
        + "Total Shot percentage: " + tc_pct + "\n" + "Assist Percentage: " + ast_pct + "\n" +
        "Seasons: played " + seasons + "\n";
     return nbaPlayerInfo;
    }

    //comparable interface ssed as a parameter, returns a negative, postive number and a zero if its <,> or =
    public int compareTo(NBAPlayer o ) {

        return Double.compare(getPoints(), o.getPoints());

        }

// a method to determine if objects are equal
    public boolean equals(NBAPlayer player2) {
        return super.equals(player2);
    }
}