package openworld1;

public class Weapon {
	String name;
	String type;
	int id;
	int fire;
	int freeze;
	int shock;
	int poison;
	int fleshDmg;
	int energyDmg;
	int shotsPerTurn;
	int energyPerTurn;
	int bullets;
	int bulletCapacity;
	int accMod;
	boolean laser;
	boolean randomAffectedTiles;

	/**
	 * Builds a weapon using the following parameters:
	 * 
	 * @param energyDamage
	 * @param fleshDamage
	 * @param shock
	 * @param spread
	 * @param range
	 * @param affectedTiles
	 * @param shotsPerTurn
	 * @param energyPerTurn
	 */
	public Weapon(String name,String type,int energyDamage, int fleshDamage, int shock, int accMod, int shotsPerTurn,
			int energyPerTurn,int bulletCapacity, boolean laser, boolean recharge) {
		this.energyDmg = energyDamage;// Damage dealt to machines
		this.fleshDmg = fleshDamage; // Damage dealt to non-machines
		this.shock = shock; // Immobilizes machines
		this.shotsPerTurn = shotsPerTurn; // How many shots are generated in
		this.name = name;
		this.energyPerTurn = energyPerTurn; // How much energy each use consumes
		this.bulletCapacity = bulletCapacity;
		this.accMod = accMod;
		this.laser = laser;
		this.type = type;
	}
	/*
	 * builds energy Weapons
	 */
	public Weapon(String name,int energyDamage, int fleshDamage, int shock, int accMod, int shotsPerTurn,
			int energyPerTurn) {
		this(name,"energy",energyDamage, fleshDamage, shock, accMod,
				shotsPerTurn, energyPerTurn,0, false, false);
	}
	/**
	 * Builds Military Weapons
	 * @param energyDamage
	 * @param fleshDamage
	 * @param shock
	 * @param spread
	 * @param range
	 * @param affectedTiles
	 * @param shotsPerTurn
	 * @param bulletCapacity
	 * @param shotgun
	 */
	public Weapon(String name,int energyDamage,int fleshDamage, int shock, int accMod, int shotsPerTurn,
			int bulletCapacity,boolean sniper) {
		this(name,"bullet",energyDamage, fleshDamage, shock, accMod,
				shotsPerTurn,0, bulletCapacity, false, sniper);
	}
}
