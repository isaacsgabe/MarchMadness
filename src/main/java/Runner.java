import java.util.Locale;
import java.util.Scanner;

public class Runner {

    enum BracketType{
        WeightedBracket, HigherSeed, Random
    }

    public static void main(String[] args) {
        MarchMadnessMachine machine = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want a WeightedBracket, a Random Bracket, Or a higherSeed Bracket");
        String str = scan.nextLine().toLowerCase();
        while(!str.equals("random") && !str.equals("weightedbracket") && !str.equals("higherseed")){
            System.out.println("Bad input. Enter either: Random, WeightedBracket, or Higherseed");
            str = scan.nextLine().toLowerCase();
        }
        if(str.equals("random")){
            machine = new MarchMadnessMachine(BracketType.Random);
        }else if(str.equals("weightedbracket")){
            machine = new MarchMadnessMachine(BracketType.WeightedBracket);
        }else{
            machine = new MarchMadnessMachine(BracketType.HigherSeed);
        }
        System.out.println("PLAYING ROUND OF 64");
        machine.playRound();
        System.out.println();
        System.out.println();
        System.out.println("PLAYING ROUND OF 32");
        machine.playRound();
        System.out.println();
        System.out.println();
        System.out.println("SWEET 16");
        machine.playRound();
        System.out.println();
        System.out.println();
        System.out.println("ELITE 8");
        machine.playRound();
        System.out.println();
        System.out.println();
        System.out.println("FINAL 4");
        machine.playRound();
        System.out.println();
        System.out.println("NATIONAL CHAMPIONSHIP");
        machine.playRound();





    }
}
