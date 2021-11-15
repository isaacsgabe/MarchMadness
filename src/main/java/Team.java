public class Team {
    private String name;
    private int ranking;

    public Team(String name,int ranking){
        this.name = name;
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }

    public String getName() {
        return name;
    }
}

