


public class BinarySearchTreeClient {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		  tree.add(25);  
	      tree.add(15);  
	      tree.add(50);  
	      tree.add(10);   
	      tree.add(22);   
	      tree.add(35); 
	      tree.add(70); 
	      tree.add(4); 
	      tree.add(12); 
	      tree.add(18); 
	      tree.add(24); 
	      tree.add(31); 
	      tree.add(44); 
	      tree.add(66); 
	      tree.add(90); 
        
        System.out.println("Size determined Reursivly: " + tree.sizeRecursive());
        System.out.println("Size determined Iterativly: " + tree.sizeIterative());
        System.out.println("Minimum: " + tree.min());
        System.out.println("Maximum: " + tree.max());
        
        System.out.print("Tree Depth: ");
        System.out.println(tree.maxDepth(tree.root));
        
        System.out.println("\nInorder traversal: ");
        tree.getIterator(Order.Inorder);
        System.out.print("\n");
        
        System.out.println("\nPreorder traversal: ");
        tree.getIterator(Order.Preorder);
        System.out.print("\n");
        
        System.out.println("\nPostorder traversal: ");
        tree.getIterator(Order.Postorder);
        System.out.print("\n");
      
      
	}

}
