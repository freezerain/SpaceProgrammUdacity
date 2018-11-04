
public class U2 extends Rocket {

	public U2(){
		weight = 18000;
		cost = 120;
		maxWeight = 29000;
		launchChance = 0.04;
		landChance = 0.08;
	}
	@Override
	public boolean launch() {
		return Math.random() > ((((double)weight) / ((double)maxWeight)) * launchChance);
	}
	
	@Override
	public boolean land() {
		return Math.random() > ((((double)weight) / ((double)maxWeight)) * landChance);
	}

}
