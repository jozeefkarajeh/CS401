

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>{

    protected LLNode<T> top; // reference top node of stack stack
    
    public LinkedStack() {
        top = null;
    }

    public void push(Object element) {
        //pushes element to stack 
        LLNode<T> newNode = new LLNode((T)element);
        newNode.setLink(top);
        top = newNode;
    }

    public void pop()
    // Throws NullPointerException if this stack is empty,
    // otherwise removes top element from this stack.
    {
        if (isEmpty())
            throw new NullPointerException("Pop attempted on an empty stack.");
        else
            top = top.getLink();
    }

    public T top()
    // Throws NullPointerException stack is empty,
    // otherwise returns top element of this stack.
    {
        if (isEmpty())
            throw new NullPointerException("Top attempted on an empty stack.");
        else
            return top.getInfo();
    }

    public boolean isEmpty()
    // checks if stack is empty
    {
        return (top == null);
    }

    public boolean isFull()
    // Returns false – since a linked list can add nodes anytime.
    {
        return false;
    }

}