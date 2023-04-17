/* Colin Maxwell
 * Java II
 * Binary Search Tree
 * 4/18/2021
 */
package edu.institution.asn11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BST<E extends Comparable<E>> {

	protected TreeNode<E> root;
	protected int size = 0;
	
	//No-args
	public BST() { 
		
	}
	
	public BST(E[] objects) {
		for (int i=0; i<objects.length; i++) {
			insert(objects[i]);
		}
	}
	
	
	/**
	* Traverses the nodes using the breadth-first traversal algorithm and
	* and returns a list of elements in the correct order.
	* @return the elements in the order that reflects a breadth-first traversal.
	*/
	public List<E> breadthFirstTraversal() {
		
		//Checks for null
		if(root == null) return null;
		
        Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
        List<E> list = new ArrayList<E>();
        
        //Add First Element to queue
        queue.add(root);
        while(!queue.isEmpty())
        {        	
    		TreeNode<E> current = (TreeNode<E>)queue.remove();
    		list.add((E)current.element);
    		
        	/*Enqueue left child*/
        	if (current.left != null)
        	{
        		queue.add(current.left);
        	}
        	if(current.right != null) {
        		queue.add(current.right);
        	}
        	
        }//End While()
        
        return list;
	}//End breadthFirstTraversal()
	
	/**
	* Returns the number of edges between the tree's root and its furthest leaf.
	* @return the height.
	*/
	public int getHeight() {
		
		//Checks for null
		if(root == null) return 0;
		
        Queue<TreeNode<E>> heightQueue = new LinkedList<TreeNode<E>>();
		int height = 0;
		//Add root to Queue
		heightQueue.add(root);
		//Add null as first marker
		heightQueue.add(null);
	
		while(!heightQueue.isEmpty())
		{
    		TreeNode<E> current = (TreeNode<E>)heightQueue.remove();
    		
    		// if element == null, reached end of current level, 
    		// increment height by 1, add another null as marker for
    		// another level
    		if(current == null) {
    			// before adding null, check if queue is empty, which indicates
    			// it has traveled all of the levels
    			if(!heightQueue.isEmpty()) {
    				heightQueue.add(null);
    			}
    			height++;
    		} else {
    			//else add the children of current node
    			if(current.left != null) {
    				heightQueue.add(current.left);
    			}
    			
    			if(current.right != null) {
    				heightQueue.add(current.right);
    			}
    		}
		}
		return height - 1;
	}
	
	
	/**
	 * 
	 * Returns the reults of an in-order traversal without the use of recursion.
	 * @return the elements in the order that reflects an in-order traversal
	 */
	public List<E> nonRecursiveInorder() {
		//Checks for null
		if(root == null) return null;
		
		List<E> list2 = new ArrayList<E>();
		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		TreeNode<E> current = root;
		
		while(current != null || stack.size() > 0)
		{
			//Left Subtree
			while (current != null)
			{
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			list2.add((E)current.element);
			
			//Right Subtree
			current = current.right;
		}
		
		
		return list2;
	}
	
	
	
	public boolean search(E e) {
		TreeNode<E> current = root;
		
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean insert(E e) {
		if (root == null) {
			root = createNewNode(e);
		} else {
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else {
					return false;
				}
			}
				
			if (e.compareTo(parent.element) < 0) {
				parent.left = createNewNode(e);
			} else {
				parent.right = createNewNode(e);
			}
		}
		
		size++;
		return true;
	}
	
	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<E>(e);
	}
	
	public void inorder() {
		inorder(root);
	}
	
	protected void inorder(TreeNode<E> root) {
		if (root == null) return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}
	
	public void postorder() {
		postorder(root);
	}
	
	protected void postorder(TreeNode<E> root) {
		if (root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}
	
	public void preorder() {
		preorder(root);
	}
	
	protected void preorder(TreeNode<E> root) {
		if (root == null) return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public int getSize() {
		return size;
	}
	
	public TreeNode<E> getRoot() {
		return root;
	}
	
	public ArrayList<TreeNode<E>> path(E e) {
		ArrayList<TreeNode<E>> list = new ArrayList<>();
		TreeNode<E> current = root;
		
		while (current != null) {
			list.add(current);
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				break;
			}
		}
		
		return list;
	}
	
	public boolean delete(E e) {
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element)> 0) {
				parent = current;
				current = current.right;
			} else {
				break;
			}
		}
		
		if (current == null) {
			return false;
		}
		
		if (current.left == null) {
			if (parent == null) {
				root = current.right;
			} else {
				if (e.compareTo(parent.element) < 0) {
					parent.left = current.right;
				} else {
					parent.right = current.right;
				}
			}
		} else {
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			
			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			
			current.element = rightMost.element;
			
			if (parentOfRightMost.right == rightMost) {
				parentOfRightMost.right = rightMost.left;
			} else {
				parentOfRightMost.left = rightMost.left;
			}
		}
		
		size--;
		return true;
	}// End Delete
	
	public Iterator<E> iterator() {
		return new InorderIterator();
	}
	
	public void clear() {
		root = null;
		size = 0;
	}
	
	
	private class InorderIterator implements Iterator<E> {
		
		private ArrayList<E> list = new ArrayList<>();
		private int current = 0;
		
		public InorderIterator() {
			inorder();
		}
		
		private void inorder() {
			inorder(root);
		}
		
		private void inorder(TreeNode<E> root) {
			if (root == null) return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}
		
		public boolean hasNext() {
			return current < list.size();
		}
		
		public E next() {
			return list.get(current++);
		}
		
		public void remove() {
			delete(list.get(current));
			list.clear();
			inorder();
		}
	} // End Private Class
	
} //End Class
