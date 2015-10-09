package openworld1;

public class Weapons {
	//Hit boxes represent the tiles around the point of impact that take damage.
	//First segment represents the first row, second segment represents second row, and so on....
	
//constructor for weapon: energyDamage,fleshDamage,shock,accMod,shotsPerTurn,energyPerTurn(in this order)
	public static Weapon vibroRepeater = new Weapon("vibroRepeater",17,8,1,0,2,5);
	public static Weapon vibroCannon = new Weapon("vibroCannon",81,36,1,6,1,9);
	public static Weapon vibroMG = new Weapon("vibroMG",5,3,1,-15,16,17);
	public static Weapon vibroShotgun = new Weapon("vibroShotgun","energy",66,24,0,-5,1,8,0,false,false);
	public static Weapon militaryRevolver = new Weapon("militaryRevolver",18,38,0,-2,1,6,false);
	public static Weapon militaryMG = new Weapon("militaryMG",2,4,0,-20,20,100,false);
	public static Weapon militaryShotgun = new Weapon("militaryShotgun",29,52,0,0,1,10,false);
	public static Weapon militaryRocketLauncher = new Weapon("militaryBazooka",33,68,0,-10,1,6,false);
	public static Weapon pioneerLaserGatling = new Weapon("pioneerGatling",2,1,0,-35,50,70,false);
	public static Weapon pioneerSmelterCannon = new Weapon("pioneerSmelterCannon","bullet",55,70,0,0,1,45,6,false,false);
	public static Weapon pioneerOrbLauncher = new Weapon("pioneerOrbLauncher",58,29,4,-15,1,50,false);
	public static Weapon pioneerGiantLaser = new Weapon("pioneerGiantLaser","energy",8,5,0,-10,15,35,0,true,false);
	public static Weapon pioneerRailSniper = new Weapon("pioneerSniper","bullet",54,74,0,25,1,75,4,false,false);
	public static Weapon pioneerToasterBlaster = new Weapon("pioneerToaster","pancake",16,86,0,0,1,100,2,false,true);
	public static Weapon brokenWeapon = new Weapon("brokenWeapon","bullet",0,0,0,0,0,0,0,false,false);
	public static Weapon SatanGun = new Weapon("SatanGun","bullet",666,666,1,66,75,1,1,false,false);
	
	public static Weapon generateLoot(){
		Weapon w = Weapons.vibroRepeater;
		int random = (int)(Math.random()*13);
		switch(random){
		case 0:
			w = Weapons.vibroCannon;
			break;
		case 1:
			w = Weapons.vibroMG;
			break;
		case 2:
			w = Weapons.vibroRepeater;
			break;
		case 3:
			w = Weapons.vibroShotgun;
			break;
		case 4:
			w = Weapons.militaryRocketLauncher;
			break;
		case 5:
			w = Weapons.militaryMG;
			break;
		case 6:
			w = Weapons.militaryRevolver;
			break;
		case 7:
			w = Weapons.militaryShotgun;
			break;
		case 8:
			w = Weapons.pioneerLaserGatling;
			break;
		case 9:
			w = Weapons.pioneerSmelterCannon;
			break;
		case 10:
			w = Weapons.pioneerOrbLauncher;
			break;
		case 11:
			w = Weapons.pioneerGiantLaser;
			break;
		case 12:
			w = Weapons.pioneerRailSniper;
			break;
		case 13:
			w = Weapons.pioneerToasterBlaster;
			break;
			default:
				w = Weapons.brokenWeapon;
		}
		return w;
	}
}
