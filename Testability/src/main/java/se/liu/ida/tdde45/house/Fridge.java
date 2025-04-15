package se.liu.ida.tdde45.house;

import se.liu.ida.tdde45.food.ingredients.raw.RawEgg;
import se.liu.ida.tdde45.food.ingredients.raw.RawPotato;
import se.liu.ida.tdde45.food.ingredients.raw.Yoghurt;
import se.liu.ida.tdde45.singletons.FridgeStocker;
import se.liu.ida.tdde45.singletons.UninitializedSingletonException;

@SuppressWarnings("serial")
public class Fridge {
	private boolean stocked = false;
	private FridgeStocker fs;
	
	public Fridge(FridgeStocker fridgeStocker) throws UninitializedSingletonException{
		this.fs = fridgeStocker;
		fs.stock(this);
	}
	
	public RawEgg getEgg() throws UnstockedException {
		if(!stocked)
			throw new UnstockedException();
		
		return new RawEgg();
	}
	
	public Yoghurt getYoghurt() throws UnstockedException {
		if(!stocked)
			throw new UnstockedException();

		return new Yoghurt();
	}
	
	public RawPotato getPotato() throws UnstockedException {
		if(!stocked)
			throw new UnstockedException();

		return new RawPotato();
	}

	public void stock() {
		stocked = true;
		
	}

	public static class UnstockedException extends Exception {
		public UnstockedException() {
			super("Fridge has not been stocked!");
		}
	}
}
