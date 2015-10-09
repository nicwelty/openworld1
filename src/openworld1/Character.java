package openworld1;

public class Character implements Entity {
int hp = 0;
int maxhp = 0;
Weapon w = null;
int protection = 0;
int resistance = 0;
int speed = 00;
int dodge = 0;
String classification = "Human";
/*
 * This builds the character, using these parameters:
 * -HP
 * -Weapon
 * -protection
 * -resistance
 * -speed
 * -dodge
 * -classification
 */
	public Character(int Health,Weapon weapon,int protection,int resistance,int speed,int dodge,String classification) {
		this.maxhp = Health;
		this.hp = maxhp;
		this.protection = protection;
		this.resistance = resistance;
		this.speed = speed;
		this.dodge = dodge;
		this.classification = classification;
		this.w = weapon;
	}
	public int attack(int dodge,String Classification){
		int shots = 0;
		for(int i = 0;i < w.shotsPerTurn;i++){
			boolean hit = ((int)(Math.random()*100)>(dodge-w.accMod));
			if(hit){
				shots++;
			}
		}
		
		if(Classification.equals("Machine")){
			return shots*w.energyDmg;
		}
		else{
			return shots*w.fleshDmg;
		}
		
	}
	public void takeDamage(int inDamage,String dpsType){
		if(inDamage <= 0){
			return;
		}
		if(dpsType.equals("Machine"))
			hp -= (inDamage-resistance);
		else
			hp -= (inDamage-protection);
	}
	public void restoreHealth(int value){
		hp += value;
	}

}
