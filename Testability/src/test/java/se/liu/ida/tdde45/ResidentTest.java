package se.liu.ida.tdde45;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import se.liu.ida.tdde45.food.ingredients.cooked.CookedIngredientFactory.UnknownIngredientException;
import se.liu.ida.tdde45.house.Fridge.UnstockedException;
import se.liu.ida.tdde45.house.Stove.UnpoweredException;
import se.liu.ida.tdde45.singletons.BankConnector;
import se.liu.ida.tdde45.singletons.ChargingQueue;
import se.liu.ida.tdde45.singletons.CreditCardCharger;
import se.liu.ida.tdde45.singletons.FridgeStocker;
import se.liu.ida.tdde45.singletons.OrderDispatcher;
import se.liu.ida.tdde45.house.House;
import se.liu.ida.tdde45.house.Bed;
import se.liu.ida.tdde45.house.Bedroom;
import se.liu.ida.tdde45.house.Kitchen;
import se.liu.ida.tdde45.house.Dresser;
import se.liu.ida.tdde45.house.Fridge;
import se.liu.ida.tdde45.singletons.UninitializedSingletonException;
import se.liu.ida.tdde45.house.Workbench;
import se.liu.ida.tdde45.house.Stove;
import se.liu.ida.tdde45.singletons.BankConnector.TestBankConnector;
import se.liu.ida.tdde45.TestFridgeStocker;

public class ResidentTest {
	
	
	
	private TestFridgeStocker stocker;
	private Fridge fr;
	private Workbench wb;
	private Stove st;
	private Resident r;
	
	@BeforeMethod
	public void start() throws UninitializedSingletonException{
		
		st = new Stove();
		
		stocker = new TestFridgeStocker();
		
		fr = new Fridge(stocker);
		
		wb = new Workbench();
		
		r = new Resident(fr, st, wb);
		
	}
	
	
	@Test
	public void testMakeBreakfast() throws UnknownIngredientException, UnpoweredException, UnstockedException, UninitializedSingletonException {
		st.turnOn();
		r.makeBreakfast();
		
	}

	@Test
	public void testFilthyStove() throws UnknownIngredientException, UnpoweredException, UnstockedException, UninitializedSingletonException {
		st.setFilthy(true);
		st.turnOn();
		r.makeBreakfast();
		if(r.isSick()) {
			System.out.println("Resident is very sick!");
		}
	}
	@Test
	public void testFilthyStoveNotOn() throws UnknownIngredientException, UnpoweredException, UnstockedException, UninitializedSingletonException {
		st.setFilthy(true);
		st.turnOff();
		try {
		r.makeBreakfast();
		}catch(UnpoweredException e){if(!r.isSick()) {
			System.out.println("Resident is not very sick!");
		}}
		
	}
}
