import java.util.ArrayList;

public class PlayerList {
	ArrayList<Player> playerList=new ArrayList<Player>();

	public void addPlayer(Player newPlayer){
		this.playerList.add(newPlayer);
	}
	
	public Player nextPlayer(Player curPlayer){
		Player next;
		int curIndex = playerList.indexOf(curPlayer);
		if(curIndex<playerList.size()){
			next=playerList.get(0);
		}
		else {
			next=playerList.get(curIndex+1);
		}
		return next;
	}
}
