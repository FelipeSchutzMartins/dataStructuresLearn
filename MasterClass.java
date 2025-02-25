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
	
	private void remove(Integer value) {
		if (!this.root) {
			return false;
		}
		
		Node currentNode = this.root;
		Node parentNode = null;
		
		while (currentNode) {
			if (value < currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.left
			} else if (value > currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.right
			} else if (value == currentNode.value) {

				if (currentNode.right === null) {
				  if (parentNode === null) {
					this.root = currentNode.left;
				  } else {
					if (currentNode.value < parentNode.value) {
					  parentNode.left = currentNode.left;

					} else if (currentNode.value > parentNode.value) {
					  parentNode.right = currentNode.left;
					}
				  }

				} else if (currentNode.right.left === null) {
				  currentNode.right.left = currentNode.left;
				  if (parentNode === null) {
					this.root = currentNode.right;
				  } else {
					if (currentNode.value < parentNode.value) {
					  parentNode.left = currentNode.right;

					} else if (currentNode.value > parentNode.value) {
					  parentNode.right = currentNode.right;
					}
				  }

				} else {
				  let leftmost = currentNode.right.left;
				  let leftmostParent = currentNode.right;
				  while (leftmost.left !== null) {
					leftmostParent = leftmost;
					leftmost = leftmost.left;
				  }

				  leftmostParent.left = leftmost.right;
				  leftmost.left = currentNode.left;
				  leftmost.right = currentNode.right;

				  if (parentNode === null) {
					this.root = leftmost;
				  } else {
					if (currentNode.value < parentNode.value) {
					  parentNode.left = leftmost;
					} else if (currentNode.value > parentNode.value) {
					  parentNode.right = leftmost;
					}
				  }
				}
			}
		}
	}
}