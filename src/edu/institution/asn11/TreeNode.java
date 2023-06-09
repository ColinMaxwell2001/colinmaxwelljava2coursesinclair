/* Colin Maxwell
 * Java II
 * Binary Search Tree
 * 4/18/2021
 */
package edu.institution.asn11;

public class TreeNode<E> {
	
	protected E element;
	protected TreeNode<E> left;
	protected TreeNode<E> right;
	
	public TreeNode(E e) {
		element = e;
	}
	
	public String toString() {
		return element.toString();
	}

}
