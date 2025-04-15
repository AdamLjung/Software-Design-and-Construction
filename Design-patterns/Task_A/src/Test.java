

import java.text.MessageFormat;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		final ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(2);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(7);
		arrayList.add(9);
		arrayList.add(10);
		arrayList.add(1);

		Enumerable<Integer> evenNumbs = new NumbConcStrat(arrayList);
		
		evenNumbs = evenNumbs.where(new CalcEven());
		
		//Reseta iteratorn
		Enumerable<Integer> oddNumbs = new NumbConcStrat(arrayList);
		
		oddNumbs = oddNumbs.where(new CalcOdd());
		
		evenNumbs.forEach(new PrintAction<>());
		
		oddNumbs.forEach(new PrintAction<>());
	}

}
