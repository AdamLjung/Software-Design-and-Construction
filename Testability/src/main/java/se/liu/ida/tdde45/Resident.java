package se.liu.ida.tdde45;

import se.liu.ida.tdde45.food.ingredients.cooked.CookedIngredient;
import se.liu.ida.tdde45.food.ingredients.cooked.CookedIngredientFactory.InvalidIngredientException;
import se.liu.ida.tdde45.food.ingredients.cooked.CookedIngredientFactory.UnknownIngredientException;
import se.liu.ida.tdde45.food.ingredients.raw.RawEgg;
import se.liu.ida.tdde45.food.ingredients.raw.RawPotato;
import se.liu.ida.tdde45.food.ingredients.raw.Yoghurt;
import se.liu.ida.tdde45.food.meals.Breakfast;
import se.liu.ida.tdde45.food.meals.Lunch;
import se.liu.ida.tdde45.house.Bed;
import se.liu.ida.tdde45.house.Bedroom;
import se.liu.ida.tdde45.house.Dresser;
import se.liu.ida.tdde45.house.Fridge.UnstockedException;
import se.liu.ida.tdde45.house.House;
import se.liu.ida.tdde45.house.Stove;
import se.liu.ida.tdde45.house.Stove.UnpoweredException;
import se.liu.ida.tdde45.house.Fridge;
import se.liu.ida.tdde45.house.Workbench;
import se.liu.ida.tdde45.house.Kitchen;

public class Resident {
	
	private boolean sick = false;
	private final Fridge fridge;
	private final Stove st;
	private final Workbench wb;
	
	
	public Resident(Fridge fridge, Stove stove, Workbench workbench) {
		this.fridge = fridge;
		this.st = stove;
		this.wb = workbench;
		
	}
	
	protected Breakfast makeBreakfast() throws UnknownIngredientException, UnpoweredException, UnstockedException {
		final RawEgg rawEgg = fridge.getEgg();
		final Yoghurt yoghurt = fridge.getYoghurt();
		final Breakfast breakfast = new Breakfast(st.boil((rawEgg)), yoghurt);
		
		if(st.isFilthy())
			sick = true;
		
		return breakfast;
	}

	protected Lunch makeLunch() throws InvalidIngredientException, UnknownIngredientException, UnpoweredException, UnstockedException {
		final RawEgg rawEgg = fridge.getEgg();
		final RawPotato rawPotato = fridge.getPotato();
		final CookedIngredient boiledPotato = st.boil(rawPotato);
		final Lunch lunch = new Lunch(wb.process(boiledPotato), st.boil(rawEgg)); 
		
		if(st.isFilthy())
			sick = true;
		
		return lunch;
	}
	
	public boolean isSick() {
		return sick;
	}
}
