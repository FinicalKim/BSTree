public class BSTree<T extends Comparable <T>> implements Tree<T>{

	private Node root;
	int theSize = 0;
	
		// adds to the BST
	public void add(T item) {
		
		
		if (root == null) {
			root = new Node (item);
			}
		
		if (item.compareTo(root.data) < 0) 
		{
				//going to the left
			if (root.left == null) 
			{
				root.left = new Node(item);
			}
			else
				root.left.add(item);
		}
			
		else if (item.compareTo(root.data) > 0)
		{
			//going to the right
		if (root.right == null) 
		{
			root.right = new Node(item);
		}
		else
			root.right.add(item);
		}	
	}
	
	public boolean contains(T item) {
		Node cursor = root;
		
		return contains(item, cursor);
	}

	
	public boolean contains(T item, Node p) {
		if (p == null)
			return false;
		if (p.data.equals(item))   
			return true;
		if (item.compareTo(p.data) < 0) 
			return contains(item, p.left);
		if (item.compareTo(p.data) > 0)
			return contains(item, p.right);
		return false;
		
	}
	
	public int size() {
		return (size(root));
	}
		
	private int size(Node p) {
		if (p == null)
			return 0;
		else 
			return (size(p.left) + 1 + size(p.right));
	}
	
	public void inOrderPrint() {
		Node cursor = root;
		
		inOrderPrint(cursor);
	}
        
	public void inOrderPrint(Node p) {
		
		if (p.left != null)
			inOrderPrint(p.left);
		System.out.println(p.data + " ");
		
		if (p.right != null)
			inOrderPrint(p.right);
		return;
			
	}
	
	public String toString() {
		String text = "";
		return toString(root, text);
	
	}
	
	public String toString(Node p, String b) {
		if (p.left != null)
			b = toString(p.left, b);
		b+= p.data + " ";
		
		if (p.right != null)
			b = toString(p.right, b);
		return b;
	
	}
	
		// nested class
	public class Node{
		
			// Data
		public T data = null;
		public Node left = null;
		public Node right = null;
		
		//------- constructors
		public Node(T theData)
		{
			this.data = theData;
			
		}
		
			// Add method
		public void add(T item) {
			
			if (item.compareTo(data) < 0) 
			{
					//going to the left
				if (left == null) 
				{
					left = new Node(item);
				}
				else
					left.add(item);
			}
				
			else if (item.compareTo(data) > 0)
			{
				//going to the right
			if (right == null) 
			{
				right = new Node(item);
			}
			else
				right.add(item);
			}
				
		} // end add method
	}

}
