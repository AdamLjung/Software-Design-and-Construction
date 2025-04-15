package se.liu.ida.tdde45.house;

public class House {
	final private Kitchen kitchen;
	final private Bedroom bedroom;
	
	
	public House(Bedroom bedroom, Kitchen kitch) {
		this.bedroom = bedroom;
		this.kitchen = kitch;
	}
	
	public Kitchen getKitchen() {
		return kitchen;
	}
	
	public Bedroom getBedroom() {
		return bedroom;
	}
}
