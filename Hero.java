import java.util.Scanner;

public abstract class Hero extends DungeonCharacter
{
	protected double chanceToBlock;
	protected int numTurns;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
  }

  public void readName()
  {
	  Scanner sc = new Scanner(System.in);
		System.out.print("Enter character name: ");
		name = sc.next();
  }//end readName method

  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(name + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = attackSpeed/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices

}//end Hero class