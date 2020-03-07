class Node {
	public int data;
	public Node next;
}


public class LinkedList {
	public Node first, last, cur;
	
	public LinkedList() {
		first = null;
		last = null;
		cur = first;
	}
	
	public void InsertAtEnd(int x) {
        
		Node newnode;
        newnode = new Node();
        newnode.data = x;
        newnode.next = null;
        if (last == null) {
              first = last = newnode;
              cur = last;
        } else {
              last.next = newnode;
              last = newnode;
              cur = last;
              
       }
	}
	
	public void setData(Node n, int x) {
		if (n == null) {
			return;
		}
		n.data = x;
	}
	
	public int getData(Node n) {
		if (n == null) {
			return -1;
		}
		return n.data;
	}
	
	public void InsertAtFront(int x) { 
		Node newnode;
		newnode = new Node();
		newnode.data = x;
		newnode.next = first;
		first = newnode;
		if (last == null) 
			last = newnode;
		cur = first;
	}
	
}




