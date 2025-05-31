import java.util.*;

public class Graph {
	
	int numberOfNodes;
	Map<Integer, List<Integer>> adjacentList = new HashMap<>();
	
	public void addVertex(int node)  {
		if (adjacentList.get(node) != null) return;
		adjacentList.put(node, new ArrayList<>());
	}

	public void addEdge(int node, int relatedTo) {
		List<Integer> newRelationship = adjacentList.get(node);
		if (adjacentList.get(node).contains(relatedTo)) return;

		newRelationship.add(relatedTo);
		if (adjacentList.get(relatedTo) != null) addEdge(relatedTo, node);
		
		adjacentList.put(node, newRelationship);
	}
	
	public void showConnections() {
		for (Integer key : adjacentList.keySet()) {
			String connections = "";
			
			for (Integer connection : adjacentList.get(key)) {
				connections += connection + " ";
			}

			System.out.println(key + "-->" + connections);
		}
	}
	
	public static void main(String[] args) {
		Graph myGraph = new Graph();
		myGraph.addVertex(0);
		myGraph.addVertex(1);
		myGraph.addVertex(2);
		myGraph.addVertex(3);
		myGraph.addVertex(4);
		myGraph.addVertex(5);
		myGraph.addVertex(6);
		myGraph.addEdge(3, 1); 
		myGraph.addEdge(3, 4); 
		myGraph.addEdge(4, 2); 
		myGraph.addEdge(4, 5); 
		myGraph.addEdge(1, 2); 
		myGraph.addEdge(1, 0); 
		myGraph.addEdge(0, 2); 
		myGraph.addEdge(6, 5);
		
		myGraph.showConnections();
	}
}