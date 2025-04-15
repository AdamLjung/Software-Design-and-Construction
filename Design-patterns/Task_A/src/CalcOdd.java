
public class CalcOdd<T> implements IPredicate<Integer>{
	
	@Override
	public boolean accept(Integer element) {
		return element % 2 == 1;
	}
	
	
}
