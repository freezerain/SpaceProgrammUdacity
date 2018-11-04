
public class U1 extends Rocket {

	public U1(){
		weight = 10000;
		cost = 100;
		maxWeight = 18000;
		launchChance = 0.05;
		landChance = 0.01;
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
