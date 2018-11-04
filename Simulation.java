import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Simulation {
	public ArrayList<Item> loadItems(int phase) {
		ArrayList<Item> list = new ArrayList<>();
		try {
			File file = new File(phase > 0 ? "phase-2.txt" : "phase-1.txt");
			Scanner scn = new Scanner(file);
			String[] line;
			int wght;
			String nm;
			while (scn.hasNextLine()) {
				line = scn.nextLine().split("=");
				nm = line[0];
				wght = Integer.parseInt(line[1]);
				list.add(new Item(nm, wght));
			}
			scn.close();
		} catch (Exception exception) {
			System.out.println("Problem reading text file with items");
			System.exit(0);
		}
		return list;
	}

	public ArrayList<Rocket> loadU1(ArrayList<Item> inList) {
		ArrayList<Rocket> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		ArrayList<Item> itemList = (ArrayList<Item>) inList.clone();
		while (itemList.size() > 0) {
			Rocket rocket = new U1();
			if (rocket.land() && rocket.launch()) {
				while (itemList.size() > 0) {
					if (rocket.canCarry(rocket, itemList.get(0))) {
						rocket.carry(rocket, itemList.get(0));
						itemList.remove(0);
					} else {
						list.add(rocket);
						break;
					}
				}
			} else
				list.add(rocket);
		}
		return list;
	}

	public ArrayList<Rocket> loadU2(ArrayList<Item> inList) {
		ArrayList<Rocket> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		ArrayList<Item> itemList = (ArrayList<Item>) inList.clone();
		while (itemList.size() > 0) {
			Rocket rocket = new U2();
			if (rocket.land() && rocket.launch()) {
				while (itemList.size() > 0) {
					if (rocket.canCarry(rocket, itemList.get(0))) {
						rocket.carry(rocket, itemList.get(0));
						itemList.remove(0);
					} else {
						list.add(rocket);
						break;
					}
				}
			} else
				list.add(rocket);
		}
		return list;
	}

	public int runSimulation (int type, int phase) {
		ArrayList<Item> items = loadItems((phase>0)? 1:0);
		ArrayList<Rocket> rockets;
		if (type>0) rockets = loadU1(items);
		else rockets = loadU2(items);
		int totalCost = 0;
		for (Rocket item : rockets) {
			totalCost += item.cost;
		}
		
		return totalCost;
	}

}
