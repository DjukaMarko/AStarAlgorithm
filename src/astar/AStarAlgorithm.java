package astar;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class AStarAlgorithm {
	
	
	public int manhattanDistance(Node source, Node destination) {
		return Math.abs((int) source.getX() - (int) destination.getX()) - Math.abs((int) source.getY() - (int) destination.getY());
		// TODO do that
	}
	
	
	public List<Node> getAdjacentNodes(Node[][] list, Node curr) {
		List<Node> adjacent = new ArrayList<>();
		int x = curr.getX_arr();
		int y = curr.getY_arr();
		
		adjacent.add(list[x-1][y]);
		adjacent.add(list[x+1][y]);
		adjacent.add(list[x][y-1]);
		adjacent.add(list[x][y+1]);
		return adjacent;
	}
	
	public boolean mainAlgorithm(Node[][] arr) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Node source = new Node(0, 0, 0);
		Node destination = new Node(0, 0 ,0);
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if (arr[i][j].getColor() == Color.RED) {
					source = arr[i][j];
				} else if(arr[i][j].getColor() == Color.BLUE) {
					destination = arr[i][j];
				}
			}
		}
		source.setScores(0, 0, manhattanDistance(source, destination));
		pq.add(source);
		
		while(!pq.isEmpty()) {
			Node curr = pq.peek();
			
			if(curr.equals(destination)) {
				return true;
			}
			
			for(Node a: getAdjacentNodes(arr, curr)) {
				
			}
			
		}
		return false;
		
	}

}
