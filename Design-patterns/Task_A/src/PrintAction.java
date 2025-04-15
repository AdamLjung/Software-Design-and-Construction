import java.text.MessageFormat;

public class PrintAction<T> implements IAction<Integer>{
	
	@Override
	public void perform(Integer t) {
		if(t % 2 == 0) {
		System.out.println(MessageFormat.format("Even number {0} ", t));
		}else {
			System.out.println(MessageFormat.format("Odd number {0}", t));
		}
	}
}
