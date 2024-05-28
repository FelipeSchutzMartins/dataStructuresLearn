public class MasterClass {
	public static void main(String... args) {

	}
}

class Node {
	Integer value;
	Node left;
	Node right;

	public Node (Integer value) {
		this.value = value;
	}
}
class SearchTree {
	Node root;
	public SearchTree(){
		this.root = null;
	}

	public void insert(Integer value) {
		insertIntoNode(root, value);
	}

	public Node lookup(Integer value) {
		return lookup(root, value);
	}

	private Node lookup(Node node, Integer value) {
		if (node == null) return null;

		if (node.value.equals(value)) {
			return node;
		}

		if (node.value > value) {
			return lookup(node.left, value);
		}

		return lookup(node.right, value);
	}

	private void insertIntoNode(Node node, Integer value) {
		if (node.value > value) {
			if (node.left == null) {
				node.left = new Node(value);
				return;
			}
			insertIntoNode(node.left, value);
		}
		if (node.value < value) {
			if (node.right == null) {
				node.right = new Node(value);
				return;
			}
			insertIntoNode(node.right, value);
		}
	}
}