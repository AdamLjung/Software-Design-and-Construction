package se.liu.ida.tdde45.singletons;

public class ChargingQueue {
	private static boolean initialized = false;
	
	
	public static void initialize(){
		initialized = true;
	}
	
	public static void enqueue() throws UninitializedSingletonException {
		if(!initialized)
			throw new UninitializedSingletonException(ChargingQueue.class);
		
		BankConnector.withdraw();
	}
}
