package lab8;

public interface CollectionInterface<E> {

	boolean add(E element);
	//Attemps to add element to this collection.
	//Returns true if successfull, false otherwise
	
	E get(int i);
	//returns an element e from this collection such that e.equals(target).
	//if no such element exists, return null.
	
	boolean contains(E target);
	//returns true if this collection contains an element e such that
	//e.equals(target); otherwise returns false.
	
	E remove(int i);
	//Attempts to remove an element from the collection, such that e.equals(target) and returns true
	//if element is not in the collection, return false
	
	boolean isFull();
	//returns true if collection is fulle, otherwise returns false.
	
	boolean isEmpty();
	//returns true if empty, otherwise returns false.
	
	int size();
	//returns number of elements in this collection
}
