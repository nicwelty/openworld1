package openworld1;

public class Mission {
String title = "";
Mob[] mobs = new Mob[4];
int count = 0;
	/*
	 * Constructor for the Mission class, which will issue missions that are either fixed or generated.
	 * These missions include:
	 * Title
	 * Mobs
	 */
	public Mission(String title,Mob[] mobs,int count) {
		this.title = title;
		this.mobs = mobs;
		this.count = count;
	}
	
	public String getTitle(){
		return title;
	}
	public Mob[] getMobs(){
		return mobs;
	}

}
