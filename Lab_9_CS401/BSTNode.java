

public class BSTNode<T> {

    private T info; //node info
    private BSTNode<T> left, right; //link to the left child
  

    //constructor
    public BSTNode(T info){
        this.info = info;
        left = null;
        right = null;}

    public T getInfo() {return info;}
    public void setInfo(T info) {this.info = info;}
    public BSTNode<T> getLeft() {return left;}
    public void setLeft(BSTNode<T> left) {this.left = left;}
    public BSTNode<T> getRight() {return right;}
    public void setRight(BSTNode<T> right) {this.right = right;}
}