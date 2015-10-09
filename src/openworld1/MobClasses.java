package openworld1;

public class MobClasses {
	//Basic bandits, not very good. Usually come in large numbers:
	public static Mob patrolBandit = new Mob("Patrol Bandit",360,Weapons.brokenWeapon,15,2,2,0,"Human");
	public static Mob ScoutBandit = new Mob("Bandit Scout",220,Weapons.brokenWeapon,22,7,1,0,"Human");
	public static Mob IroncoatBandit = new Mob("Bandit Ironcoat",695,Weapons.brokenWeapon,0,1,8,0,"Human");
	public static Mob SalvageBandit = new Mob("Bandit Scrapper",695,Weapons.pioneerSmelterCannon,0,1,8,0,"Human");
	//Elite Bandits, much more powerful, and they fight alone:
	public static Mob CommandoBandit = new Mob("Bandit Commando",450,Weapons.militaryRocketLauncher,15,2,2,0,"Human");
	public static Mob JuggernautBandit = new Mob("Bandit Juggernaut",850,Weapons.brokenWeapon,0,0,14,8,"Human");
	public static Mob TitanBandit = new Mob("Bandit Titan",415,Weapons.pioneerGiantLaser,10,3,6,6,"Human");
	public static Mob SciBandit = new Mob("Bandit Techie",450,Weapons.brokenWeapon,14,5,4,22,"Human");
	//Basic drones:
	
	public static Mob ScoutDrone = new Mob("Scout Drone",150,Weapons.vibroRepeater,33,10,1,3,"Machine");
	public static Mob AssaultDrone = new Mob("Assault Drone",200,Weapons.brokenWeapon,20,8,2,3,"Machine");
	public static Mob DefenseDrone = new Mob("Defense Drone",425,Weapons.brokenWeapon,8,5,5,5,"Machine");
	public static Mob ScavengeDrone = new Mob("Scavenger",165,Weapons.brokenWeapon,30,8,3,2,"Machine");
	public static Mob PatrolDrone = new Mob("Patrol Drone",220,Weapons.brokenWeapon,18,4,7,7,"Machine");

    //More specialized machines:
	public static Mob WallClass = new Mob("Wall-Class Mech",700,Weapons.brokenWeapon,0,3,8,6,"Machine");
	public static Mob HunterClass = new Mob("Hunter Mech",450,Weapons.brokenWeapon,10,5,2,4,"Machine");
	public static Mob RecyclerClass = new Mob("Mech Recycler",425,Weapons.pioneerSmelterCannon,8,5,6,6,"Machine");
	public static Mob DefenderClass = new Mob("Defense Mech",620,Weapons.brokenWeapon,3,4,5,8,"Machine");
	public static Mob BerzerkerClass = new Mob("Assault Mech",400,Weapons.brokenWeapon,17,6,5,4,"Machine");
	public static Mob ObliterationClass = new Mob("Obliterator",350,Weapons.pioneerOrbLauncher,15,4,4,5,"Machine");
	
	public static Mob statIncrease(Mob oldMob){
		oldMob.Absorption += (Math.random()*(oldMob.Absorption/2));
		oldMob.Armor += (Math.random()*(oldMob.Armor/2));
		oldMob.maxHealth += (Math.random()*(oldMob.maxHealth/3));
		oldMob.dodge += (Math.random()*(oldMob.dodge/4));
		oldMob.health = oldMob.maxHealth;
		if(oldMob.weapon.name.equals("brokenWeapon")){
			switch((int)(Math.random()*13)){
			case 0:
				oldMob.weapon = Weapons.militaryRevolver;
				break;
			case 1:
				oldMob.weapon = Weapons.militaryMG;
				break;
			case 2:
				oldMob.weapon = Weapons.militaryShotgun;
				break;
			case 3:
				oldMob.weapon = Weapons.militaryRocketLauncher;
				break;
			case 4:
				oldMob.weapon = Weapons.vibroRepeater;
				break;
			case 5:
				oldMob.weapon = Weapons.vibroMG;
				break;
			case 6:
				oldMob.weapon = Weapons.vibroShotgun;
				break;
			case 7:
				oldMob.weapon = Weapons.vibroCannon;
				break;
			case 8:
				oldMob.weapon = Weapons.pioneerGiantLaser;
				break;
			case 9:
				oldMob.weapon = Weapons.pioneerLaserGatling;
				break;
			case 10:
				oldMob.weapon = Weapons.pioneerRailSniper;
				break;
			case 11:
				oldMob.weapon = Weapons.pioneerSmelterCannon;
				break;
			case 12:
				oldMob.weapon = Weapons.pioneerOrbLauncher;
				break;
			default:
				oldMob.weapon = Weapons.brokenWeapon;
				break;
			}
		}
		return oldMob;
		
	}
}
