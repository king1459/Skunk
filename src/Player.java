
public class Player {

	 String id;
	 int curTurn;
	 int curTotal;
	 int gameTotal;
	 int chips;
	 boolean isFinal;
	

	public Player(String name){
		this.id=name;
		this.chips=50;
		this.curTurn=0;
		this.curTotal=0;
		this.gameTotal=0;
		this.isFinal=false;
	}
	
	public void updateCurScore(int curVal){
		this.curTurn=this.curTurn+curVal;
		this.curTotal=this.curTotal+curVal;
	}
	
	public void updateGameTotal(){
		this.gameTotal=this.curTotal;
		this.curTurn=0;
	}
	
	public void loseChips(int loss){
		this.chips=this.chips-loss;
		this.curTotal=this.gameTotal;
	}
	
	public void clearRound(){
		this.curTurn=0;
		this.curTotal=0;
		this.gameTotal=0;
		this.isFinal=false;
	}
	
}
