import java.util.Random;

public class Match {
    private Team higherSeed;
    private Team lowerSeed;

    public Match(Team team1, Team team2){
        if(team1.getRanking()> team2.getRanking()){
            this.lowerSeed = team2;
            this.higherSeed = team1;
        }else{
            this.lowerSeed = team1;
            this.higherSeed = team2;
        }
    }

    public Team playMatch(Runner.BracketType type){
        Random rnd = new Random();
        int difference = this.higherSeed.getRanking() - this.lowerSeed.getRanking();
        if(type == Runner.BracketType.WeightedBracket){
            if(this.higherSeed.getRanking() == 16 && this.lowerSeed.getRanking() ==1){
                difference = 140;
            }else if(this.higherSeed.getRanking() == 15 && this.lowerSeed.getRanking() ==2){
                difference = 17;
            }else if(this.higherSeed.getRanking() == 14 && this.lowerSeed.getRanking() ==3){
                difference = 8;
            }else if(this.higherSeed.getRanking() == 13 && this.lowerSeed.getRanking() ==4){
                difference = 6;
            }else if(this.higherSeed.getRanking() == 12 && this.lowerSeed.getRanking() ==5){
                difference = 5;
            }else if(this.higherSeed.getRanking() == 11 && this.lowerSeed.getRanking() ==6){
                difference =4;
            }else if(this.higherSeed.getRanking() == 10 && this.lowerSeed.getRanking() ==7){
                difference = 3;
            }
            if(difference == 0 || difference == 1){
                difference = 2;
            }
        }else if(type == Runner.BracketType.Random){
            difference = 2;
        }else{
            if(difference !=0){
                return lowerSeed;
            }else{
                difference = 2;
            }

        }
        int num = rnd.nextInt(difference);
        if(num == 0){
            return this.higherSeed;
        }
        return lowerSeed;
    }

    public String printTeams(){
        String str = "";
        str += this.lowerSeed.getName() + " " + this.lowerSeed.getRanking() + " vs " + this.higherSeed.getName()  + " " + this.higherSeed.getRanking();
        return str;
    }

}
