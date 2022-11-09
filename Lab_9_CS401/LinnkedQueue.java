

import java.util.NoSuchElementException;

public class LinnkedQueue<T> implements QueueInterface<T> {

	protected LLNode<T> front; // reference to the front of this queue
    protected LLNode<T> rear; // reference to the rear of this queue
    protected int numElements = 0; // number of elements in this queue
    
    public LinnkedQueue()
    {
        front = null; rear = null;
    }

    @Override
    public void enqueue(T element) {
        LLNode<T> newNode = new LLNode((T) element);
        if (rear == null)
            front = newNode;
        else
            rear.setLink(newNode);
        rear = newNode;
        numElements++;

    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Dequeue attempted on empty queue.");
        else
        {
            T element;
            element = front.getInfo();
            front = front.getLink();
            if (front == null)
                rear = null;
            numElements--;
            return element;
        }
    }

    @Override
    public boolean isFull() {
        // Returns false – a linked queue is never full.
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (numElements==0);
    }

    @Override
    public int size() {
        //returns size of queue
        return numElements;
    }

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getRear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getAllElements() {
		// TODO Auto-generated method stub
		return null;
	}
}