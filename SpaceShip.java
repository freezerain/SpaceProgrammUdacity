
public interface SpaceShip {
	default boolean launch() {
		return true;
	}
	default boolean land(){
		return true;
	}
	default boolean canCarry(Rocket rocket, Item item){
		return ((rocket.weight + item.weight)<= rocket.maxWeight);
	}
	default void carry(Rocket rocket,Item item){
			rocket.weight = rocket.weight+item.weight;
	}
	
	

}
