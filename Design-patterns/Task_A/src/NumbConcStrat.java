import java.util.Collection;
import java.util.Iterator;

public class NumbConcStrat<T> implements Enumerable<T> {
	private Iterator<T> iterator;
	
	
	public NumbConcStrat(Collection<T> collection) {
		this.iterator = collection.iterator();
		
	}
	
	@Override
	public Enumerable<T> where(IPredicate<T> predicate) {
		Iterator<T> oldIterator = iterator;
		this.iterator = new Iterator<T>() {

			@Override
			public boolean hasNext() {
				return oldIterator.hasNext();
			}

			@Override
			public T next() {
				T item = oldIterator.hasNext() ? oldIterator.next() : null;
				
				
				while (oldIterator.hasNext() && !predicate.accept(item)) {
					
					item = oldIterator.next();
					
				}
				if(predicate.accept(item)) {
				return item;}else {return null;}
			}
		};
		
		return this;
	}

	@Override
	public Iterator<T> iterator() {
		return iterator;
	}
	@Override
	public void forEach(IAction<T> action) {
		while (iterator.hasNext()) {
			T t = (T) iterator.next();
			//Check if iterator is null
			if(t != null) {
			action.perform(t);
			}
		}
	}
}
