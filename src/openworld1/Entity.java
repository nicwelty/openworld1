package openworld1;
 

//The entity is an interface that will control all moving objects, primarily Bandits, the Hero, and Machines.
public interface Entity {
	public int attack(int dodge, String i);  //The entity will attack, dealing damage.
	public void takeDamage(int inDamage,String dpsType); //This function damages an entity, taking, and negating, damage. If HP = 0; entity will despawn
	public void restoreHealth(int value); //The entity will restore Health, but his health cannot exceed max Health.
		
}


