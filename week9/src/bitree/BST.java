package bitree;

public class BST<E extends Comparable<? super E>> {
	
	private Node<E> root;
	int nodecount;
	public Node<E> parentL;
	public Node<E> parentR;
	E temp;//remove를 위해 추가하였습니다.
	
	BST() {
		root = null;
		nodecount = 0;
		parentL = null;
		parentR = null;
	}
	
	public void insert(E e) {
		root = inserthelp(root, e);
		nodecount++;
	}
	
	private Node<E> inserthelp(Node<E> rt, E e) {
		if (rt == null) {
			return new Node<E>(e);
		}
		if (rt.getElement().compareTo(e) > 0) {
			rt.setLeft(inserthelp(rt.getLeft(), e));
		}
		else {
			rt.setRight(inserthelp(rt.getRight(), e));
		}
		return rt;
	}
	
	private StringBuffer out;
	public String toString() {
		out = new StringBuffer();
		printhelp(root);
		return out.toString();
	}
	
	private void printhelp(Node<E> rt) {
		if (rt == null) {
			return;
		}
		printhelp(rt.getLeft());
		out.append(rt.getElement() + " " );
		printhelp(rt.getRight());
	}

	public Node<E> find(E e) {
		return findhelp(root, e);
	}
	
	private Node<E> findhelp(Node<E> rt, E e) {
		if (rt == null) {
			return null;
		}
		if (rt.getElement().compareTo(e) == 0) {
			return rt;
		}
		else if (rt.getElement().compareTo(e) > 0) {
			parentL = rt; // 값을 찾기 직전 노드를 parent로 저장 
			return findhelp(rt.getLeft(), e); 
		}
		else {
			parentR = rt; // 값을 찾기 직전 노드를 parent로 저장 
			return findhelp(rt.getRight(), e);
		}
	}
	
	public void remove(E e) {
		nodecount--;
		removehelp(find(e), e);//find(e)에서 찾은 노드를 input합니다.
	}
	
	private E removehelp(Node<E> rt, E e) {
		if (find(e) != null) {
			if(rt.getLeft() == null && rt.getRight() == null) {//Leaf Node인 경우 
				if (parentL != null) {parentL.setLeft(null);}
				else {parentR.setRight(null);}
			}
			else if (rt.getLeft() == null) { //오른쪽 child만 있는 경우 
				parentR.setRight(rt.getRight());//rt의 parent 다음 값을 rt 다음 값으로 지정 
			}
			else if (rt.getRight() == null) {//왼쪽 child만 있는 경우 
				parentL.setLeft(rt.getLeft());//rt의 parent 다음 값을 rt 다음 값으로 지정 
			}
			else {
				temp = findmin(rt.getRight()).getElement();
				removehelp(findmin(rt.getRight()),findmin(rt.getRight()).getElement());
				rt.setElement(temp);
			}//오른쪽 서브트리 중 가장 작은 값을 rt에 저장하고 해당 노드 삭제 
		}
		else {
			return null;
		}
		return null;
	}
	
	private Node<E> findmin(Node<E> rt) {
	    if (rt.getLeft() == null) {
	        return rt;
	    } else if (rt.getLeft() != null) {
	        findmin(rt.getLeft());
	    }
	    return null;
	}//서브 트리 중 최소값 리턴 

	
}
