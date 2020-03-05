import java.util.Scanner;

public class Dungeon
{
    public static void main(String[] args)
	{
		do
		{
			GameSetup game = new GameSetup();
			game.battle();
		} while (playAgain());
    }//end main method

	public static boolean playAgain()
	{
		char again;
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Play again (y/n)?");
		again = kb.next().charAt(0);

		return (again == 'Y' || again == 'y');
	}//end playAgain method
	
}//end Dungeon class