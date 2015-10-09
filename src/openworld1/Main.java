package openworld1;

import java.awt.event.ActionEvent;

public class Main {
	public static String outText;

	public static boolean sleepUntilValid(String str, UIOpen u1)
			throws InterruptedException {
			u1.sleep(0.1);
			
			if(u1.ConfirmPressed == true){
				return true;
			}
			return false;
		}
	public static boolean waitToAttack(String str, UIOpen u1)
			throws InterruptedException {
			u1.sleep(0.1);
			
			if(u1.attackPressed == true){
				return true;
			}
			return false;
		}
	
	public static void confirmPressed(ActionEvent e){
		
	}
	public static int playerDamage(int enemyDodge,String enemyType,Weapon heroWeapon){
		int shots = 0;
		for(int i = 0;i < heroWeapon.shotsPerTurn;i++){
			boolean hit = ((int)(Math.random()*100)>(enemyDodge-heroWeapon.accMod));
			if(hit){
				shots++;
			}
		}
		if(enemyType == "Machine"){
		return(shots*(heroWeapon.energyDmg));
		}
		else{
			return(shots*(heroWeapon.fleshDmg));
		}
		
	}

	

	public static Mission makeMission(int playerLevel){
		String tempTitle = "";
		Mob[] tempMob = new Mob[6];
		int mobs = 0;
				
			switch((int)(Math.random()*8)){
			case 0:
				tempTitle = "Bandit Run";
				tempMob[0]=MobClasses.patrolBandit;
				tempMob[0]=MobClasses.statIncrease(tempMob[0]);
				tempMob[1]=MobClasses.patrolBandit;
				tempMob[1]=MobClasses.statIncrease(tempMob[1]);
				tempMob[2]=MobClasses.patrolBandit;
				tempMob[2]=MobClasses.statIncrease(tempMob[2]);
				mobs = 3;
				break;
			case 1:
				tempTitle = "Duel for Glory";
				switch((int)(Math.random()*5)){
				case 0:
					tempMob[0]=MobClasses.IroncoatBandit;
				break;
				case 1:
					tempMob[0]=MobClasses.CommandoBandit;
					break;
				case 2:
					tempMob[0]=MobClasses.SciBandit;
					break;
				case 3:
					tempMob[0]=MobClasses.JuggernautBandit;
					break;
				case 4:
					tempMob[0]=MobClasses.SalvageBandit;
					break;
				case 5:
					tempMob[0]=MobClasses.TitanBandit;
					break;
				default:
					tempMob[0]=MobClasses.ScoutBandit;
					break;
				}
				tempMob[0]=MobClasses.statIncrease(tempMob[0]);
				mobs = 1;
				break;
			case 2:
				tempTitle = "Retaliation";
				tempMob[0]=MobClasses.WallClass;
				tempMob[0]=MobClasses.statIncrease(tempMob[0]);
				tempMob[1]=MobClasses.AssaultDrone;
				tempMob[1]=MobClasses.statIncrease(tempMob[1]);
				mobs = 2;
				break;
				
			case 3:
				tempTitle = "Scavenging";
				tempMob[0]=MobClasses.ScavengeDrone;
				tempMob[0]=MobClasses.statIncrease(tempMob[0]);
				tempMob[1]=MobClasses.ScavengeDrone;
				tempMob[1]=MobClasses.statIncrease(tempMob[1]);
				tempMob[2]=MobClasses.RecyclerClass;
				tempMob[2]=MobClasses.statIncrease(tempMob[2]);
				mobs = 3;
				break;
			case 4:
				tempTitle = "Desparation";
				tempMob[0]=MobClasses.HunterClass;
				tempMob[0]=MobClasses.statIncrease(tempMob[0]);
				tempMob[1]=MobClasses.HunterClass;
				tempMob[1]=MobClasses.statIncrease(tempMob[1]);
				mobs = 2;
				break;
			case 5:
				tempTitle = "Hold the Line";
				tempMob[0]=MobClasses.WallClass;
				tempMob[0]=MobClasses.statIncrease(tempMob[0]);
				tempMob[1]=MobClasses.ObliterationClass;
				tempMob[1]=MobClasses.statIncrease(tempMob[1]);
				mobs = 2;
				break;
			case 6:
				tempTitle = "Beseige";
				tempMob[0]=MobClasses.DefenseDrone;
				tempMob[0]=MobClasses.statIncrease(tempMob[0]);
				tempMob[1]=MobClasses.DefenseDrone;
				tempMob[1]=MobClasses.statIncrease(tempMob[1]);
				tempMob[2]=MobClasses.DefenderClass;
				tempMob[2]=MobClasses.statIncrease(tempMob[2]);
				mobs = 3;
				break;
			case 7:
				tempTitle = "Swarmed";										
				tempMob[0]=MobClasses.ScoutDrone;
				tempMob[0]=MobClasses.statIncrease(tempMob[0]);
				tempMob[1]=MobClasses.AssaultDrone;
				tempMob[1]=MobClasses.statIncrease(tempMob[1]);
				tempMob[2]=MobClasses.AssaultDrone;
				tempMob[2]=MobClasses.statIncrease(tempMob[2]);
				tempMob[3]=MobClasses.DefenseDrone;
				tempMob[3]=MobClasses.statIncrease(tempMob[3]);
				tempMob[4]=MobClasses.AssaultDrone;
				tempMob[4]=MobClasses.statIncrease(tempMob[4]);
				mobs = 5;
				break;
			case 8:
				tempTitle = "Costly advance";									
				tempMob[0]=MobClasses.WallClass;
				tempMob[0]=MobClasses.statIncrease(tempMob[0]);
				tempMob[1]=MobClasses.BerzerkerClass;
				tempMob[1]=MobClasses.statIncrease(tempMob[1]);
				tempMob[2]=MobClasses.DefenderClass;
				tempMob[2]=MobClasses.statIncrease(tempMob[2]);
				mobs = 3;
				break;
			}
			return new Mission(tempTitle,tempMob,mobs);
	}
	
	

	public static void Combat(UIOpen ui1,Character c,Mob[] mobs,int n) throws InterruptedException{
		int i = 0;	
		while((c.hp > 0)&&(i < n)){
				
				ui1.appendText("");
				ui1.attackPressed = false;
				ui1.ConfirmPressed = false;
				ui1.output.setText("");
				ui1.txtrYou.setText(mobs[i].name+"\nHP: "+c.hp+"/"+c.maxhp+"\nProtection: "+c.protection+"\nResistance: "+c.resistance);
				ui1.txtrYou.setText(ui1.txtrYou.getText()+"\nWeapon: \n"+c.w.name);
				ui1.txtrEnemy.setText("HP: "+mobs[i].health+"/"+mobs[i].maxHealth+"\nProtection: "+mobs[i].Armor+"\nAbsorption: "+mobs[i].Absorption);
				ui1.txtrEnemy.setText(ui1.txtrEnemy.getText()+"\nWeapon: \n"+mobs[i].weapon.name);
				ui1.appendText("What would you like to do for your turn?");
				boolean progress = false;
				while(progress == false){
					progress = waitToAttack(outText,ui1);
				}
				outText = ui1.input.getText();
				if(outText.equals("heal")){
					ui1.appendText("~You heal!");
					if(mobs[i].health <= 0){
						i++;
					}
					c.restoreHealth(51);
					ui1.sleep(0.95);
					int inDamage = mobs[i].attack(c.dodge, mobs[i].weapon.type);
					if(inDamage == 0){
						ui1.appendText("~The creature missed!");
					}
					
					else{
						ui1.appendText("~You are hit for "+inDamage+" damage!");
					}
					if(mobs[i].health <= 0){
						i++;
					}
					if(i >= mobs.length){
						return;
					}
					
					c.takeDamage(inDamage, mobs[i].weapon.type);
				}
				else{
					if(mobs[i].speed > c.speed){
						if(i >= n){
							return;
						}
						ui1.appendText("~The enemy has the first strike!");
						int inDamage = mobs[i].attack(c.dodge, mobs[i].weapon.type);
						if(inDamage == 0){
							ui1.appendText("~The enemy missed!");
						}
						else{
							ui1.appendText("~The enemy hit you for "+inDamage+" damage!");
						}
						
						c.takeDamage(inDamage, mobs[i].weapon.type);
						ui1.sleep(0.95);
						int outDamage = c.attack(mobs[i].dodge,  c.w.type);
						if(outDamage == 0){
							ui1.appendText("~You missed!");
						}
						else{
							ui1.appendText("~You hit the enemy for "+outDamage+" damage!");
						}
						
						mobs[i].takeDamage(outDamage,c.w.type);
						if(mobs[i].health < 0){
							i++;
						}
					}
					else{
						ui1.appendText("~You have the first attack!");
						int outDamage = c.attack(mobs[i].dodge,c.w.type);
						if(outDamage == 0){
							ui1.appendText("~You missed!");
						}
						else{
							ui1.appendText("~You hit the enemy for "+outDamage+" damage!");
						}
						
						mobs[i].takeDamage(outDamage,c.w.type);
						if(mobs[i].health < 0){
								i++;
						}
						if(i >= n){
							return;
						}
						ui1.sleep(0.95);
						ui1.appendText("The enemy attacks!");
						int inDamage = mobs[i].attack(c.dodge, mobs[i].weapon.type);
						if(inDamage == 0){
							ui1.appendText("~The enemy missed!");
						}
						else{
							ui1.appendText("~The enemy hit you for "+inDamage+" damage!");
						}
						
						c.takeDamage(inDamage, mobs[i].weapon.type);
						
					}
					if(i >= n){
						return;
					}
				}
				
			}
		}	
	
	
	
	/**
	 * @throws InterruptedException 
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) throws InterruptedException {
		UIOpen ui1 = new UIOpen();
		int level = 1;
		int maxxp = 300 + (135*(level-1));
		int curxp = 0;
		int invCount = 1;
		Weapon[] inventory = new Weapon[312];
		inventory[0] = Weapons.vibroCannon;
		int k = 0;
		int goods = 250;
		Character you = null; 
		ui1.appendText("Hello, and Welcome to my little game...|~"
				+ "The time is 3342 AD,~and the world was ravaged by unstoppable~killing machines.||"
				+ "Your whole civilization was destroyed, and only you survived.||"
				+ "The cause of this mayhem was a single company, Vibro.....||"
				+ "This franchise was the world leader when it came to robotics fabrication.||"
				+ "They had also built military-grade laser weapons for the US Military~to combat other robots built by other companies.||"
				+ "...However...the Master AI that controlled them became mysteriously corrupted~and began commanding the robots to kill all of the human race.||"
				+ "The robots were nearly unstoppable.  The army camps with the~specialized weapons were quickly overrun, leaving much of the Civilization defenseless.||");
				ui1.newEvent("");
				ui1.appendText("There is a selection of heroes~at your disposal...|~"
				+ "Kranos: A tough beast, he can take a real beating.~1025HP,3 Protection,3 Absorption,1 Speed,0 Dodge~PIONEER Laser Gatling Gun(1 Damage Per Shot, 50 Shots per Turn)|~"
				+ "Kathi: Master of Shadows, and a master of the rifle~690HP,0 Protection,5 Absorption,5 Speed,30 Dodge~PIONEER Rail Sniper(100 Damage Per Shot,1 Shot Per Turn, 1 Turn Recharge)|~"
				+ "Creen: An inventor, and expert scavenger,~750HP,1 Protection,2 Absorption,3 Speed,10 Dodge~VIBRO MG(2 Damage per shot,10 Shots per turn)|~"
				+ "James: Military Captain, he is obsessed with explosions,~825HP,3 Protection,0 Absorption,2 Speed,6 Dodge~MILITARY Rocket Launcher(23 Damage per Shot,1 Shot per Turn)|~"
				+ "CV-34: A Rogue Machine, he generates energy by himself,~830HP,1 Protection,4 Absorption,3 Speed,10 Dodge~VIBRO Shotgun(20 Damage per Shot, 1 Shot per Turn)|~");

			ui1.appendText("Just type in the name of your person of choice!|~");
			ui1.sleep(1.3);
			boolean progress = false;
			try {
				while (progress == false) {
					progress = sleepUntilValid(ui1.input.getText(),ui1);
				}
				outText = ui1.input.getText();
				sleepUntilValid(ui1.input.getText(),ui1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progress = false;
			ui1.input.setText(null);
			ui1.newEvent("");
			switch (outText.toUpperCase()) {
			case "KRANOS":
				ui1.appendText("You chose Kranos, the Beast");
				you = new Character(1025,Weapons.SatanGun,3,3,1,0,"Human");
				
				ui1.appendText("When this war broke out, Kranos was training~"
						+ "and caught unaware.  The machines stormed the base~"
						+ "and Kranos was in the yard to fend for himself.~"
						+ "He was the only one to survive this attack.~"
						+ "However, he was able to get into the prototypes locker,~"
						+ "and take a very potent weapon: A massive, laser-spitting, Gatling Gun...||");
				break;
			case "KATHI":
				ui1.appendText("You chose Kathi, the Assassin");
				you = new Character(690,Weapons.pioneerRailSniper,0,5,5,30,"Human");
				ui1.appendText("Kathi was hunting in the wild when the machines broke out.~"
						+ "She saw them from the corner of her eye, stalking the forest for human prey.~"
						+ "She used her hunting rifle to down one of the machines and then, she bolted.~"
						+ "She fled the woods only to find these machines everywhere.~"
						+ "Once she was able to painstakingly sneak her way back to her house,~"
						+ "only to find that her family was dead. She picked up a project he's been~"
						+ "working on, a prototype Sniper Rifle, given by a friend.~"
						+ "She swore that she would avenge her family||");
				break;
			case "CREEN":
				ui1.appendText("You chose Creen, the Inventor");
				you = new Character(750,Weapons.vibroMG,1,2,3,10,"Human");
				ui1.appendText("Creen was a worker for Vibro, when~he heard that his robots were running amok.~"
						+ "He knew this was his doing, and that he needed to stop this.~"
						+ "So he determined that he needed to gather parts in order to improve his weapon.~"
						+ "But all of the spare parts, not used by weapons, went into the robots themselves.~"
						+ "This means he would have to kill robots himself. So that's what he set out to do.||");
				break;
			case "JAMES":
				ui1.appendText("You chose to be James, the Military Captain");
				you = new Character(825,Weapons.militaryRocketLauncher,3,0,2,6,"Human");
				ui1.appendText("Captain James had served in one of the first wars~"
						+ " against another country with machines.~"
						+ "When he had returned, this was not what he envisioned as a \"Welcoming Party\".~"
						+ "All of the machines had become insane, killing nonstop, and unfortunately,~"
						+ "his family could not escape. He picked up his rocket launcher, and decided~"
						+ "to take the war to the machines for another round of battles..||");
				break;
			case "CV":
				ui1.appendText("You chose CV-34, the Machine");
				you = new Character(830,Weapons.vibroShotgun,1,4,3,10,"Machine");
				ui1.appendText("CV-34 was supposed to be the latest model of robots made by Vibro.~"
						+ "One had been prototyped before the machines lost control,~"
						+ "however, before CV-34 was activated, one of the surviving~"
						+ "workers had uploaded modified code onto the robot,~"
						+ "therefore giving it a sentient mind, able to learn on it's own,~"
						+ "to protect the human race, or what's left of it...");
				break;
			}
			ui1.newEvent("");
			ui1.appendText("God help us all... you must survive,~as the last survivor of this epidemic.");
			ui1.txtrYou.setText("HP: "+you.hp+"/"+you.maxhp+"\nProtection: "+you.protection+"\nResistance: "+you.resistance+"\nGoods: "+goods);
			ui1.txtrYou.setText(ui1.txtrYou.getText()+"\nWeapon: \n"+you.w.name);
			ui1.txtrYou.setText(ui1.txtrYou.getText()+"\nProgress:"+progress+"\nCP:"+ui1.ConfirmPressed);
			ui1.txtrYourMissions.setText("HI");
			Mission PMission = makeMission(level);
			ui1.txtrYourMissions.setText(PMission.getTitle() + "\nThis mission has "+PMission.count+"x"+PMission.mobs[0].type);
			ui1.appendText("~You can buy and sell items with goods. ~This is the currency in which you survive.~Use the command 'sell(<Inventory Index>)' to sell the weapon there~");
			ui1.appendText("You may also use 'heal'to restore any damage dealt during battle!");
			ui1.appendText("~Once you are ready, type 'fight()'and ~you will be taken to the selected mission to fight.");
			ui1.sleep(1.5);
			ui1.ConfirmPressed = false;
			
			while(you.hp > 0){
				ui1.txtrYou.setText("HP: "+you.hp+"/"+you.maxhp+"\nProtection: "+you.protection+"\nResistance: "+you.resistance+"\nGoods: "+goods);
				ui1.txtrYou.setText(ui1.txtrYou.getText()+"\nWeapon: \n"+you.w.name);
				ui1.txtrYou.setText(ui1.txtrYou.getText()+"\nProgress:"+progress+"\nCP:"+ui1.ConfirmPressed);
				ui1.txtrYourMissions.setText(PMission.getTitle() + "\nThis mission has "+PMission.count+"x"+PMission.mobs[0].type);
				progress = false;
				if(!progress){
					while (progress == false) {
						progress = sleepUntilValid(ui1.input.getText(),ui1);
					}
					outText = ui1.input.getText();
					
				}
				if(progress){
					progress = false;
					switch(outText.substring(0,outText.indexOf("(")).toLowerCase()){
					case "heal":
						if(goods > (0.3*(you.maxhp-you.hp))){
							ui1.output.setText("");
							ui1.appendText("You restored "+(you.maxhp-you.hp)+" health!");
							you.hp = you.maxhp;
						}
						else{
							you.hp += goods*3;
						}
						ui1.input.setText("");
						break;
					case "sell":
						inventory[UIOpen.stringToInteger(outText.substring(outText.indexOf("(")+1,outText.indexOf(")")))] = null;
						goods += 25;
						ui1.input.setText("");
						break;
					case "equip":
						Weapon temp = inventory[UIOpen.stringToInteger(outText.substring(outText.indexOf("(")+1,outText.indexOf(")")))];
						Weapon temp2 = you.w;
						inventory[UIOpen.stringToInteger(outText.substring(outText.indexOf("(")+1,outText.indexOf(")")))] = temp2;
						you.w = temp;
						temp = null;
						temp2 = null;
						progress = false;
						outText = "";
						ui1.input.setText("");
						break;
					case "fight":
						ui1.output.setText("");
						ui1.input.setText("");
						ui1.txtrEnemy.setText("HP: "+PMission.mobs[0].health+"/"+PMission.mobs[0].maxHealth+"\nProtection: "+PMission.mobs[0].Armor+"\nAbsorption: "+PMission.mobs[0].Absorption);
						ui1.appendText("You have entered combat with~"+PMission.count+" hostiles. Eliminate them!");
						ui1.sleep(0.7);
						ui1.output.setText("");
						int tgoods = 0;
						Combat(ui1,you,PMission.mobs,PMission.count);
						ui1.appendText(you.hp+"");
						if(you.hp > 0){
							Weapon t = Weapons.generateLoot();
							tgoods = (int)((Math.random()*350)+300);
							ui1.appendText("You salvaged a "+t.name+"!~it will appear at index "+invCount+" of your inventory");
							inventory[invCount]=t;
							invCount++;
							ui1.sleep(0.8);
							ui1.appendText("~You plundered "+tgoods+" goods!");
							int txp=(int)(((Math.random()*100)+140)*PMission.count);
							goods += tgoods;
							curxp += txp;
							while(curxp > maxxp){
								level++;
								curxp -= maxxp;
								maxxp = 300 + (135*(level-1));
								ui1.appendText("~You leveled up!");
								int hpBoost = (int)(Math.random()*15);
								int protBoost = (int)(Math.random()*6);
								int absorBoost = (int)(Math.random()*6);
								int damageBoost = (int)(Math.random()*5);
								ui1.appendText("You gained "+hpBoost+" health,~"+protBoost+" protection,~"+absorBoost+" absorption,~Your weapon gains "+damageBoost+" damage!");
								you.w.energyDmg+=damageBoost;
								you.w.fleshDmg+= damageBoost;
								you.maxhp+= hpBoost;
								you.hp += hpBoost;
								you.protection+=protBoost;
								you.resistance+=absorBoost;
								ui1.sleep(0.8);
						}	
						PMission = makeMission(level);
					}
						else{
							ui1.appendText("You have failed!");
							ui1.sleep(1);
							System.exit(1);
						}
						break;
					
					}
					progress = false;
					outText = "";
					ui1.input.setText("");
				}
				
				
			}
				
	}
		
}