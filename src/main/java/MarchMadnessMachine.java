import jdk.swing.interop.SwingInterOpUtils;

public class MarchMadnessMachine{

    private Runner.BracketType type;
    private String[][] teams = { {"Gonzaga", "iowa", "kansas", "virginia", "creighton", "USC", "Oregon", "Oklahoma", "missouri", "vsu", "drake", "ucsb", "ohio", "Eastern Wash", "grand canyon", "Norfolk State"},
            {"michigan", "alabama", "texas", "FSU", "Colorado", "BYU", "Uconn", "LSU", "St. Bonaventure", "Maryland", "UCLA", "Georgetown", "Unc Georgetown", "Abil Christain", "iona", "texas southern"},
            {"Baylor", "Ohio State", "Arkansas", "Purdue", "Villanova", "Texas Tech", "Florida", "UNC", "Wisconsin", "Virginia tech", "Utah State", "winthrop", "North texas", "Colgate", "Oral Roberts", "Hartford"},
            {"Illinois", "Houston", "West Virginia", "Oklahoma State", "Tennessee", "SDSU", "Clemson", "Loyola Chicago", "Georgia Tech", "Rutgers", "Syracuse", "Oregon State", "Liberty", "Morehead State", "Cleveland State", "Drexel"}};
    private Match[] matches;
    int num;



    public MarchMadnessMachine(Runner.BracketType type){
        this.num = 64;
        this.type = type;
        this.matches = new Match[num/2];
        for(int k = 0; k < 4; k++){
            for(int i = 0, f = 16; i < this.teams[1].length/2; i++, f--){
                Team j = new Team(teams[k][i],i+1);
                Team z = new Team(teams[k][f-1],f);
                Match match = new Match(j,z);
                switch(i+1 % 8){
                    case 1:
                        this.matches[k*8] = match;
                        break;
                    case 2:
                        this.matches[k*8+7] =match;
                        break;
                    case 3:
                        this.matches[k*8+5] =match;
                        break;
                    case 4:
                        this.matches[k*8+3] =match;
                        break;
                    case 5:
                        this.matches[k*8 + 2] =match;
                        break;
                    case 6:
                        this.matches[k*8 + 4] =match;
                        break;
                    case 7:
                        this.matches[k *8 + 6] =match;
                        break;
                    default:
                        this.matches[k *8 +1] =match;
                        break;
                }
            }
            System.out.println();
            System.out.println();
        }
    }
    public void printTeams(){
        for(int i = 0; i < this.matches.length;i++){
            System.out.println(this.matches[i].printTeams());
        }
    }
    public void playRound(){
        Match[] nextRound = new Match[this.matches.length/2];
        for(int i = 0; i < this.matches.length; i+=2){
            if(this.matches.length == 32){
                if(i==0){
                    System.out.println("WEST");
                }else if(i==8){
                    System.out.println("EAST");
                }else if(i==16){
                    System.out.println("SOUTH");
                }else if(i==24){
                    System.out.println("MIDWEST");
                }
            }
            Team one = this.matches[i].playMatch(this.type);
            System.out.println(this.matches[i].printTeams() + ": " + one.getName() + " is the winner!");
            if(this.matches.length != 1){
                Team two = this.matches[i+1].playMatch(this.type);
                System.out.println(this.matches[i+1].printTeams() + ": " + two.getName() + " is the winner!");
                Match nextR= new Match(one,two);
                nextRound[i/2] = nextR;
            }

            // need write out the names of the teams
        }
        this.matches = nextRound;
    }


}
