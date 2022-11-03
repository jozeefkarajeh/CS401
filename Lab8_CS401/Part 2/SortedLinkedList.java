package lab8;

public class SortedLinkedList<T> extends LinkedList<Employee>  {
	
	 @Override
	 public void add(Employee element){//spceial add method adds elements in a sorted way

		 LLNode<Employee> newNode = new LLNode<>(element);//initiate a node

	            //dealing with special cases
	            //when inserted element is smaller than head element
	     if (head == null || head.info.compareTo(element) > 0) {
	                newNode.setLink(head);
	                head = newNode;
	            }

	     else {
	            LLNode<Employee> current = head;

	            //searching the position for sorted insert
	            while (current.getLink()!=null && current.getLink().info.compareTo(element) < 0) {
	            		current = current.getLink();
	                } 

	            newNode.setLink(current.getLink());
	            current.setLink(newNode);
	            } 

	    }
}