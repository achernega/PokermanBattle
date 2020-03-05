
public abstract class DungeonCharacter
{
	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin, damageMax;

	public DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	{
		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
	}//end constructor

	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			this.hitPoints += hitPoints;
			//System.out.println("Remaining Hit Points: " + hitPoints);
		}
	}//end addHitPoints method

	public void subtractHitPoints(int hitPoints)
	{
		if (hitPoints <0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints >0)
		{
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(getName() + " hit " +
								" for <" + hitPoints + "> points damage."
								+ "\n" + getName() + " now has "
								+ getHitPoints() + " hit points remaining.\n");
		}//end else if

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");


	}//end method

    public boolean isAlive()
	{
	  return (hitPoints > 0);
	}//end isAlive method

	public void attack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= chanceToHit;

		if (canAttack)
		{
			damage = (int)(Math.random() * (damageMax - damageMin + 1))
						+ damageMin ;
			opponent.subtractHitPoints(damage);
			System.out.println();
		}//end if can attack
		else
		{
			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!\n");
		}//end else

	}//end attack method
	
	public String getName()
	{
		return name;
	}//end getName

	public int getHitPoints()
	{
		return hitPoints;
	}//end getHitPoints

	public int getAttackSpeed()
	{
		return attackSpeed;
	}//end getAttackSpeed
	
	public double getChanceToHit()
	{
		return chanceToHit;
	}

	public void setChanceToHit(double chanceToHit)
	{
		this.chanceToHit = chanceToHit;
	}

	public int getDamageMin()
	{
		return damageMin;
	}

	public void setDamageMin(int damageMin)
	{
		this.damageMin = damageMin;
	}

	public int getDamageMax()
	{
		return damageMax;
	}

	public void setDamageMax(int damageMax)
	{
		this.damageMax = damageMax;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setHitPoints(int hitPoints)
	{
		this.hitPoints = hitPoints;
	}

	public void setAttackSpeed(int attackSpeed)
	{
		this.attackSpeed = attackSpeed;
	}

}//end class Character