import java.util.ArrayList;
import java.util.Scanner;

public class Round {
	

	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		String ans;
		Player curPlayer;
		Kitty kit=new Kitty();
		ArrayList<Player> players=new ArrayList<Player>();
		
		System.out.println("What is the name of the next player?");
		while(!(ans=scanner.nextLine()).isEmpty()){
			System.out.println("What is the name of the next player?");
			curPlayer=new Player(ans);
			players.add(curPlayer);
		}



		curPlayer=players.get(0);
		
		
		while(!(curPlayer.gameTotal>99 && curPlayer.isFinal==true)){
			
			
		do {
			curPlayer=players.get(0);
			players.remove(curPlayer);
			int die1= Die.roll();
			int die2= Die.roll();
			int roll= die1+die2;
			
			
			System.out.println(curPlayer.id+" rolled: " + die1 + " and " + die2);
			if(roll==2){
				curPlayer.gameTotal=0;
				curPlayer.loseChips(4);
				kit.addChips(4);
				System.out.println("SKUNK");
				break;
			} 
			else if(roll==3){
				curPlayer.loseChips(2);
				kit.addChips(2);
				System.out.println("SKUNK");
				break;
			}
			else if(die1==1||die2==1){
				curPlayer.loseChips(1);
				kit.addChips(1);
				System.out.println("SKUNK");
				break;
			} 
			else {
				curPlayer.updateCurScore(die1+die2);
				playerStats(curPlayer);
				System.out.println("Do you want to continue rolling?");
				ans=scanner.nextLine();
			}
		}while (ans.equals("Y")||ans.equals("y"));

		curPlayer.updateGameTotal();
		if(curPlayer.gameTotal>99){
			curPlayer.isFinal=true;
		}
		players.add(curPlayer);
		turnSummary(curPlayer, kit);
		
		
		}
		
		//find and reward winner
		Player winner=curPlayer;
		for(int i=0;i<players.size();i++){
			curPlayer=players.get(i);
			System.out.println(curPlayer.id+" has "+curPlayer.gameTotal);
			if(winner.gameTotal<curPlayer.gameTotal){
				winner=curPlayer;
			}	
		}
		System.out.println("The winner of this round is: "+winner.id);
		players.remove(winner);
		winner.chips=winner.chips+kit.chips;
		kit.clearKitty();
		players.add(winner);
		
		//get info about chip counts and clear round values
		for(int i=0;i<players.size();i++){
			curPlayer=players.get(i);
			curPlayer.clearRound();
			System.out.println(curPlayer.id+" has "+curPlayer.chips+" chips");
		}
		
		
	}
	
	
	public static void playerStats(Player curPlayer){
		System.out.println("Turn score: "+curPlayer.curTurn);
		System.out.println("Total score: "+curPlayer.curTotal);
		System.out.println("Total game score: "+curPlayer.gameTotal);
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
	
	

}
