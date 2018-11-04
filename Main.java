
public class Main {

	public static void main(String[] args) {
		Simulation sim = new Simulation();
		int costU1=0, costU2=0;
		for (int i=0; i<10; i++) {
			costU1 += sim.runSimulation(0, 0);
			costU1 += sim.runSimulation(0, 1);
			costU2 += sim.runSimulation(1, 0);
			costU2 += sim.runSimulation(1, 1);
		}
		costU1 /= 20;
		costU2 /= 20;
		System.out.println("Average fly cost for U1 rocket is: " + costU1);
		System.out.println("Average fly cost for U2 rocket is: " + costU2);

	}

}
