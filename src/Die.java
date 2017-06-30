
public class Die {
	private static int val;
	
	public static int roll() // note how this changes Die's state, but doesn't return anything
	{
		val=((int) (Math.random() * 6 + 1));
		return val;
	}

	
}
