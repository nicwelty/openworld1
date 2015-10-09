package openworld1;

public class Mob implements Entity{
	String name;	
	int health;
	int maxHealth;
	Weapon weapon;
	int dodge;
	int speed;
	int Armor;
	int Absorption;
	String type;

	/*
	 * This constructor builds a mob using the following parameters:
	 * Health
	 * MaxHealth
	 * Weapon
	 * Dodge
	 * protection
	 * resistance
	 * This can be used to build either machines or bandits...
	 */
	public Mob(String name,int hp,Weapon weapon, int dodge,int speed, int armor, int absorb,String type) {
		this.health = hp;
		this.maxHealth = hp;
		this.weapon = weapon;
		this.dodge = dodge;
		this.speed = speed;
		this.Armor = armor;
		this.Absorption = absorb;
		this.type = type;
		this.name = name;
	}
	/*
	 * Returns the damage of an entity, depending on ShotsPerTurn, damage, and the DODGE of a hero
	 * @see openworld1.Entity#attack()
	 */
	public int attack(int dodge, String type){
		int shots = 0;
		boolean hit;
		if(weapon.laser == true){
			hit = ((int)(Math.random()*100)>(dodge-weapon.accMod));
			shots = weapon.shotsPerTurn;
		}
		else{
			for(int i = 0;i < weapon.shotsPerTurn;i++){
				hit = ((int)(Math.random()*100)>(dodge-weapon.accMod));
				if(hit){
					shots++;
				}
			}
		}
		if(type.equals("Machine")){
			return(shots*(weapon.energyDmg));
		}
		return(shots*(weapon.fleshDmg));
		
	}
	public void takeDamage(int inDamage,String dpsType){
		if(inDamage <= 0){
			return;
		}
		if(dpsType.equals("Machine"))
			health -= inDamage-Absorption;
		else
			health -= inDamage - Armor;
	}
	public void restoreHealth(int value){
		health += value;
		if(health >= maxHealth){
			health = maxHealth;
		}
	}
	

}
