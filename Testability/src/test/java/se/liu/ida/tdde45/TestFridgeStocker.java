package se.liu.ida.tdde45;

import se.liu.ida.tdde45.house.Fridge;
import se.liu.ida.tdde45.singletons.FridgeStocker;
import se.liu.ida.tdde45.singletons.OrderDispatcher;
import se.liu.ida.tdde45.singletons.UninitializedSingletonException;

public class TestFridgeStocker extends FridgeStocker {
	@Override
	public  void initialize() {
		
	}
	@Override
	public void stock(Fridge fridge) throws UninitializedSingletonException {
		fridge.stock();
	}
}
