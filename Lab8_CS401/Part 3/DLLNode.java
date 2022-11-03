package lab8;

public class DLLNode<T> {

	private T info;
	DLLNode<T> forward, back;	// link to the forward and back nodes
	
	// Constructor
	public DLLNode(T info) {
		this.info = info; forward = null; back = null;
	}
	public DLLNode() {
		this(null);
	}
	
	public void setInfo(T info) {	this.info = info;	}
	public T getInfo() {	return this.info;	}
	
	public void setForward(DLLNode<T> node) {	this.forward = node;	}
	public void setBack(DLLNode<T> node) {	this.back = node;	}
	
	public DLLNode<T> getForward(){	return this.forward;	}
	public DLLNode<T> getBack(){	return this.back;	}
	
}