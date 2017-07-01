import java.util.ArrayList;

public class Game {
	public static void startGame(){
		String name;
		Player curPlayer;
		ArrayList<Player> players=new ArrayList<Player>();
		
		
		//create player list, should be done in Game when going through again
		do{
			name=SkunkApp.getNewPlayers();
			if(name.isEmpty()){
				break;
			}
			curPlayer=new Player(name);
			players.add(curPlayer);
		}while(!(name.isEmpty()));
		
		if(players.size()<2){
			SkunkApp.tooFewPlayers();
		}
		
		Round.startRound(players);
	}
}
