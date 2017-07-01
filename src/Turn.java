import java.util.ArrayList;

public class Turn {

	public static void startTurn(ArrayList<Player> players, Kitty kit){
		int index=0, size=players.size();
		Player curPlayer=players.get(index);
		
		while(!(curPlayer.gameTotal>99 && curPlayer.isFinal==true)){
			
			
			boolean cont=false;
			do {
				int die1= Die.roll();
				int die2= Die.roll();
				int roll= die1+die2;
				boolean skunk=isSkunk(die1,die2);
	
				SkunkApp.printRoll(curPlayer, die1, die2);
				if(skunk==true){
					Turn.skunkType(curPlayer, roll,kit);
					break;
				}else{
					curPlayer.updateCurScore(roll);
					SkunkApp.playerStats(curPlayer);
					cont=SkunkApp.contRoll();
				}
				
			}while (cont==true);

		if(curPlayer.gameTotal>99){
			curPlayer.isFinal=true;
		}
		curPlayer.updateGameTotal();
		SkunkApp.turnSummary(curPlayer, kit);
		index=nextIndex(index, size);
		curPlayer=players.get(index);
		}
	}
	
	public static int nextIndex(int index, int size){
		if(index+1==size){
			index=0;
		}else {
			index++;
		}
		
		return index;
	}
	
	public static void skunkType(Player curPlayer, int roll, Kitty kit){
		SkunkApp.printSkunk();
		int chips=0;
		if(roll==2){
			curPlayer.gameTotal=0;
			chips=4;
		}else if(roll==3){
			chips=2;
		}else{
			chips=1;
		}
		curPlayer.loseChips(chips);
		kit.addChips(chips);
		curPlayer.skunkReset();
		
	}
	
	public static boolean isSkunk(int die1, int die2){
		boolean check=false;
		if (die1==1||die2==1)
			check=true;
		return check;
	}
}

