
public class CalcEven<T> implements IPredicate<Integer>{
	@Override
	public boolean accept(Integer element) {
		return element % 2 == 0;
	}
	
	
}
