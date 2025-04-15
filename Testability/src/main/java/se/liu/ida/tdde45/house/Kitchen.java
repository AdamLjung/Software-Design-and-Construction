package se.liu.ida.tdde45.house;

public class Kitchen {
	private final Stove stove;
	private final Fridge fridge;
	private final Workbench workbench;
	
	public Kitchen(Fridge fr, Stove stove, Workbench wb) {
		this.fridge = fr;
		this.stove = stove;
		this.workbench = wb;
	}
	
	public Stove getStove() {
		return stove;
	}
	
	public Fridge getFridge() {
		return fridge;
	}

	public Workbench getWorkbench() {
		return workbench;
	}
}
