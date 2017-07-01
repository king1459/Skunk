import java.util.Scanner;

public class SkunkApp {
	public static void main(String[] args){
		Game.startGame();
	}
	
	public static String getNewPlayers(){
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		String ans = null;
		
		System.out.println("What is the name of the next player?");
		ans=scanner.nextLine();
		return ans;
	}
	
	public static boolean contRoll(){
		boolean cont = false;
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		String ans = null;
		
		System.out.println("Do you want to continue rolling?");
		ans=scanner.nextLine();
		ans=ans.toLowerCase();
		if(ans.equals("y")||ans.equals("yes")){
			cont=true;
		}
		return cont;
	}
	
	public static void printRoll(Player curPlayer, int die1, int die2){
		System.out.println(curPlayer.id+" rolled: " + die1 + " and " + die2);
	}
	
	public static void printSkunk(){
		System.out.println("SKUNK");
	}
	
	public static void printTotals(Player curPlayer){
		System.out.println(curPlayer.id+" has "+curPlayer.gameTotal);
	}
	
	public static void printChips(Player curPlayer){
		System.out.println(curPlayer.id+" has "+curPlayer.chips+" chips");
	}
	
	public static void printWinner(Player winner){
		System.out.println("-------------------------------");
		System.out.println("The winner of this round is: "+winner.id);
		System.out.println("-------------------------------");
	}
	
	public static void playerStats(Player curPlayer){
		System.out.println("Turn score: "+curPlayer.curTurn);
		System.out.println("Total score: "+curPlayer.curTotal);
	}
	
	public static void turnSummary(Player curPlayer, Kitty kit){
		System.out.println("--Turn summary--");
		System.out.println("Current player: "+curPlayer.id);
		System.out.println("Current score: "+curPlayer.gameTotal);
		System.out.println("Number of chips: "+curPlayer.chips);
		System.out.println("Chips in the Kitty: "+kit.chips);
		System.out.println("-------------------------------");
		System.out.println();
	}
	
	public static void tooFewPlayers(){
		System.out.println("You must have at least 2 players");
		System.exit(0);
	}
}