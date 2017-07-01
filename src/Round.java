import java.util.ArrayList;

public class Round {
	

	public static void startRound(ArrayList<Player> players){
		Player curPlayer;
		Kitty kit=new Kitty();

		Turn.startTurn(players, kit);
		
		
		//find and reward winner
		Player winner=players.get(0);
		for(int i=0;i<players.size();i++){
			curPlayer=players.get(i);
			SkunkApp.printTotals(curPlayer);
			if(winner.gameTotal<curPlayer.gameTotal){
				winner=curPlayer;
			}	
		}
		
		SkunkApp.printWinner(winner);
		winner.chips=winner.chips+kit.chips;
		kit.clearKitty();
		
		//get info about chip counts and clear round values
		for(int i=0;i<players.size();i++){
			curPlayer=players.get(i);
			curPlayer.clearRound();
			SkunkApp.printChips(curPlayer);
		}
		
		

		}

	
	

	
	

}
