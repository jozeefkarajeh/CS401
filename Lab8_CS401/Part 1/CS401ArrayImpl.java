package lab8;


public class CS401ArrayImpl<E> implements CollectionInterface<E>{
		//CS401ArrayImpl implements the Collection Interface
	   private int DEFCAP;
	   private E[] elements;
	   private int numElements = 0;
	  
	   @SuppressWarnings("unchecked")
	   public CS401ArrayImpl()
	   {
		   elements = (E[]) new Object[DEFCAP];      
	   }
	   
	   @SuppressWarnings("unchecked")
	   public CS401ArrayImpl(int size)
	   {
	      elements = (E[]) new Object[size];
	     
	      DEFCAP = size;
	   }   
   
	@Override
	public boolean add(E element) {
		if (isFull()) {
			enlarge();
		}
		elements[numElements] = element;
		numElements++;
		return true;
	}
	
	private boolean enlarge()  {
	       E[] larger = (E[]) new Object[DEFCAP*2]; //create new enlarged array
	       
	       for (int i=0; i<numElements; i++ ){//copy elements from old to new
	           larger[i] = elements [i];
	       }
	       
	       elements = larger;//assign variable elements to larger
	       DEFCAP = elements.length;//new capacity = new length
	       
	      System.out.println("List reached full size.  Increasing size...");
	      System.out.println("New size is " + DEFCAP + " elements");

	      return true;
	   }
	
	
	@Override
	public E get(int i) {
		if (i <0 && i >= numElements) {//if element is out of bounds return null.
			return null;
		} 
		return elements[i];//use the array indexing to return elements of interest 
	}


	public boolean contains(E target) { 
		return true;
	}

	public E remove(int i) {//method to remove elements and fill in empty gap
		
		return null;
	}

	@Override
	public boolean isFull() {
		if (numElements == DEFCAP)
			return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (numElements == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		 return numElements;
	}
	
	//print all elements in list
	public void printElements() {
		
		for (int i=0; i<numElements; i++) {
			System.out.println(elements[i]);
		}
	}
	
}
