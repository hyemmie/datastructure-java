package bitree;

public class Node<E> {
	/** Member variables */
	private E element;
	private Node<E> left;
	private Node<E> right;

	/** Constructors */
	public Node() 
		{element=null;
		left=right=null;}

	public Node(E it)
		{element = it;
		left=right=null;}

	public Node(E it, Node<E> leftChild, Node<E> rightChild) {
		element = it;
		left = leftChild;
		right = rightChild;
	}

	/** Get and set the element value */
	public E getElement() {return element;}
	public E setElement(E it) {return element = it;}

	/** Get and set the left child */
	public Node<E> getLeft() {return left;}
	public Node<E> setLeft(Node<E> leftChild) 
	{return left = leftChild;}

	/** Get and set the right child */
	public Node<E> getRight() {return right;}
	public Node<E> setRight(Node<E> rightChild) 
	{return right = rightChild;}

	/** @return True if a leaf node, false otherwise */
	public boolean isLeaf()
	{ if (left==null && right==null) {
		return true;
		}
	 else {return false;}
	}
	
}



