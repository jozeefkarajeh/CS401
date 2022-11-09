

import java.util.Comparator;
import java.util.Iterator;

import lab7.LinkedStack;

public class BinarySearchTree<T> implements BSTInterface<T> {

	public BSTNode<T> root;//Reference to the root of our tree
	protected Comparator<T> comp;//used for comparisons 
	
	
	public BinarySearchTree() {//create an empty BST object and uses natural order
		root = null;
		comp = new Comparator<T>() {//creating a new comparator object for T
			public int compare(T element1, T element2) {
				return((Comparable)element1).compareTo(element2);
			}
		};
	}
	public BinarySearchTree(Comparator<T> comp)
	  // Creates an empty BST object
	  //uses Comparator comp for order of elements.
	  // 
	  {
	   root = null;
	   this.comp = comp;
	  }

//----------------------------------------------------
//----------------------------------------------------
	//Observer methods, isFull, isEmpty, min, and max.
	@Override
	public boolean isFull() {
		// always returns false since tree is link-based
		return false;
	}

	@Override
	public boolean isEmpty() {
		// returns true if tree is empty false if not
		return (root == null);
	}

	@Override
	public T min() {
		//checks if tree is empty first
		// if not, returns smallest element in the tree
		if (isEmpty())
			{return null;}
		else {
			BSTNode<T> node = root;
			while (node.getLeft() != null) {
				node = node.getLeft();
			}
			return node.getInfo();
		}
	}

	@Override
	public T max() {
		//checks if tree is empty first
		// if not, returns largest element in the tree
				if (isEmpty())
					{return null;}
				else {
					BSTNode<T> node = root;
					while (node.getRight() != null) {
						node = node.getRight();
					}
					return node.getInfo();
				}
			}

//----------------------------------------------------
//----------------------------------------------------
	//Transformer operations:
	@Override
	public boolean add(T element) {
		// adds an element to the tree while retaining its property 
		root = recAdd(element, root);
		return true;
	}
	
	private BSTNode<T> recAdd(T element, BSTNode<T> node) {//recursive add method
        if (node == null) 
            node = new BSTNode<T>(element);
        
        else if (comp.compare(element, node.getInfo()) <= 0)
            node.setLeft(recAdd(element, node.getLeft()));//add to the left subtree
        
        else 
            node.setRight(recAdd(element, node.getRight())); //add to the right subtree
        
        return node;
    }
	
	@Override
	public T remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

//----------------------------------------------------
//----------------------------------------------------
	//size methods recursive and iterative
	
	@Override
	public int sizeIterative() {
		// returns the number of elements in the tree
		int count = 0;
		if(root != null) {
			LinkedStack<BSTNode<T>> nodeStack = new LinkedStack<BSTNode<T>>();
			BSTNode<T> currNode;
			nodeStack.push(root);
			while (!nodeStack.isEmpty()) {
				currNode = nodeStack.top();
				nodeStack.pop();
				count++;
				if (currNode.getLeft()!= null)
				{nodeStack.push(currNode.getLeft());}
				if (currNode.getRight() != null)
					nodeStack.push(currNode.getRight());
			}
		}
		return count;
	}
	
	@Override
	public int sizeRecursive() {//better to use for well balanced short bushy trees
		// returns the number of elements in the tree
		return recSize(root);}//uses private method recSize
	
	
	private int recSize(BSTNode node) {
		if (node == null) {return 0;}
		
		else {return 1 + recSize(node.getLeft()) + recSize(node.getRight());}
	}
	
//----------------------------------------------------
//----------------------------------------------------
	//Observer operations
	@Override
	public T get(T target) {
		//returns the info of node of the target node, where comp.compare(target, i) == 0;
		//if target is not found, return null
		return recGet(target, root);
	}
	
	//private recursive method to be used in get(T target) method
	private T recGet(T target, BSTNode<T> node) {
		if (node == null) {
			return null;
		} else if(comp.compare(target, node.getInfo()) < 0) {
			return recGet(target, node.getLeft());
		} else if (comp.compare(target,  node.getInfo()) > 0) {
			return recGet(target, node.getRight());
		} else return node.getInfo();
	}

	@Override
	public boolean contains(T target) {
	//returns true if tree contains a node with info i using comp.compare(target, i) ==0; otherwise returns false.
		return recContains(target, root);
	}
	
	private boolean recContains(T target, BSTNode<T> node) {
	//returns true if the subtree rooted at node contains info i
		if(node == null) {
			return false;//returns false if node is not found
			} else if (comp.compare(target,  node.getInfo()) < 0) {
			return recContains(target, node.getLeft());//search left subtree
		} else if (comp.compare(target,  node.getInfo()) > 0) {
			return recContains(target, node.getRight());//search right subtree
		} else {
			return true;//executes when node is found to escape recursive call
		}
	}
//----------------------------------------------------
//----------------------------------------------------
	//Traversal related methods also considered observer operations
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Iterator<T> getIterator(Order order) {
		// creates and returns an iterator providing a traversal of a snapshot
		//with the order indicated in the argument (Preorder, Postorder, Inorder traversal)
		final LinnkedQueue<T> infoQueue = new LinnkedQueue<T>();
			if (order == Order.Preorder){
				preOrder(root, infoQueue);
			} else if (order == Order.Inorder) {
				inOrder(root, infoQueue);
			} else if (order == Order.Postorder) {
				postOrder(root, infoQueue);
			}
			return new Iterator<T>() {
	            public boolean hasNext() {
	                // Returns true if iteration has more elements; otherwise returns false.
	                return !infoQueue.isEmpty();
	            }

	            public T next() {
	                // Returns the next element in the iteration.
	                if (!hasNext()) {
	                    throw new IndexOutOfBoundsException("illegal invocation of next "
	                            + " in BinarySearchTree iterator.\n");
	                }
	                return infoQueue.dequeue();
	            }
	        };
	    }
			
	// Enqueues the elements from the subtree rooted at node into q in inOrder.
    private void inOrder(BSTNode<T> node, LinnkedQueue<T> q){
        if (node != null) {
            inOrder(node.getLeft(), q);
            q.enqueue(node.getInfo());
            System.out.print(node.getInfo()+" ");
            inOrder(node.getRight(), q);
        }
    }

    // Enqueues the elements from the subtree rooted at node into q in preOrder.
    private void preOrder(BSTNode<T> node, LinnkedQueue<T> q) {
        if (node != null) {
            q.enqueue(node.getInfo());
            System.out.print(node.getInfo()+" ");
            preOrder(node.getLeft(), q);
            preOrder(node.getRight(), q);
        }
    }

    // Enqueues the elements from the subtree rooted at node into q in postOrder.
    private void postOrder(BSTNode<T> node, LinnkedQueue<T> q) {
        if (node != null) {
            postOrder(node.getLeft(), q);
            postOrder(node.getRight(), q);
            q.enqueue(node.getInfo());
            System.out.print(node.getInfo()+" ");
        }
    }
//-----------------------------------------------------
//-----------------------------------------------------
    public int maxDepth(BSTNode<T> node){
        if (node == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.getLeft());
            int rDepth = maxDepth(node.getRight());
 
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
}//end of class
