package excercse;

class Node {
	public int value;
	public Node left, right;

	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class BinarySearchTree {
	public static boolean contains(Node root, int value) {
		if (null != root) {
			boolean falg = true;
			if (null != root.left) {
				if (value < root.left.value) {
					falg = false;
					if (root.left.value == value)
						return true;
					else
						contains(root.left, value);
				}
				if (falg) {
					if (null != root.right) {
						if (root.right.value == value)
							return true;
						else
							contains(root.right, value);

					}
				}

			} else {
				if (falg) {
					if (null != root.right) {
						if (root.right.value == value)
							return true;
						else
							contains(root.right, value);

					}
				}
			}

		}
		return false;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1, null, null);
		Node n3 = new Node(3, null, null);
		Node n2 = new Node(2, n1, n3);

		System.out.println(contains(n2, 3));
	}
}