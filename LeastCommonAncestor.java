package Assignment;

/*
 * Medium 1 
	Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
	According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
	 
Example 1:

	Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
	Output: 6
	Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:

	Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
	Output: 2
	Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:
	Input: root = [2,1], p = 2, q = 1
	Output: 2
 
Constraints:
	The number of nodes in the tree is in the range [2, 105].
	-109 <= Node.val <= 109
	All Node.val are unique.
	p != q
	p and q will exist in the BST.
*/

public class LeastCommonAncestor {
	static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {

//		Enter the Input Values
		Integer[] data = { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 };
		int p = 2;
		int q = 4;

//		Construct the tree
		TreeNode root = new TreeNode(data[0]);
		form(root, 0, data);

//		Finding the least common ancestor
		System.out.println(lca(root, p, q));

	}

//	construct the tree
	private static void form(TreeNode root, int rootIndex, Integer[] data) {
		int n = data.length;

		int leftIndex = 2 * rootIndex + 1;
		if (leftIndex < n && null != data[leftIndex]) {
			root.left = new TreeNode(data[leftIndex]);
			form(root.left, leftIndex, data);
		}

		int rightIndex = 2 * rootIndex + 2;
		if (rightIndex < n && null != data[rightIndex]) {
			root.right = new TreeNode(data[rightIndex]);
			form(root.right, rightIndex, data);
		}
	}

	public static int lca(TreeNode A, int B, int C) {
		if (A == null) {
			return -1;
		}

		TreeNode ans = solve(A, B, C);

		return ans.val;

	}

	public static TreeNode solve(TreeNode A, int B, int C) {
		if (A == null) {
			return null;
		}

		if (A.val == B || A.val == C) {
			return A;
		}

		TreeNode left = solve(A.left, B, C);
		TreeNode right = solve(A.right, B, C);

		if (left != null && right != null) {
			return A;
		}

		if (left != null) {
			return left;
		}

		if (right != null) {
			return right;
		}

		return null;
	}

}
