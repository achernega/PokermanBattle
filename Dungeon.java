import java.util.Scanner;

public class Dungeon
{
    public static void main(String[] args)
	{
		Hero theHero;
		Monster theMonster;
		do
		{
		    theHero = chooseHero();
		    theMonster = spawnMonster();
			battle(theHero, theMonster);

		} while (playAgain());
    }//end main method

    public static Hero chooseHero() {
		int choice;
		HeroFactory hf = new HeroFactory();
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
		choice = kb.nextInt();

		switch(choice)
		{
			case 1: return hf.createHero("Warrior");

			case 2: return hf.createHero("Sorceress");

			case 3: return hf.createHero("Thief");

			default: System.out.println("invalid choice, returning Thief");
				return new Thief();
		}
	}
    
    public static Monster spawnMonster()
    {
    	MonsterFactory mf = new MonsterFactory();
		int choice = (int)(Math.random() * 3) + 1;
		
		switch(choice)
		{
			case 1: return mf.createMonster("Ogre");

			case 2: return mf.createMonster("Gremlin");

			case 3: return mf.createMonster("Skeleton");

			default: System.out.println("invalid choice, returning Skeleton");
				return mf.createMonster("Skeleton");
		}
	}
    
	public static boolean playAgain()
	{
		char again;
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Play again (y/n)?");
		again = kb.next().charAt(0);

		return (again == 'Y' || again == 'y');
	}//end playAgain method


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster)
	{
		char pause = 'p';
		System.out.println(theHero.getName() + " battles "
				+ theMonster.getName()
				+ "\n---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			Scanner kb = new Scanner(System.in);
			pause = kb.next().charAt(0);

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");
	}//end battle method
}//end Dungeon class