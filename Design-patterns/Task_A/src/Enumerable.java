

import java.util.Collection;
import java.util.Iterator;

public interface Enumerable<T> extends Iterable<T> {
	  Enumerable<T> where(IPredicate<T> predicate);
	  void forEach(IAction<T> action);
}
