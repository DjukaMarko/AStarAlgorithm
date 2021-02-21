package astar;


import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class AStarAlgorithm {
	
	Map<Node, Boolean> visited = new HashMap<>();
	Map<Node, Integer> gScore = new HashMap<>();
	
	
	public int manhattanDistance(Node source, Node destination) {
		return Math.abs(source.getX_arr() - destination.getX_arr()) + Math.abs(source.getY_arr() - destination.getY_arr());
	}
	
	
	public List<Node> getAdjacentNodes(Node[][] list, Node curr) {
		List<Node> adjacent = new ArrayList<>();
		int x = curr.getX_arr();
		int y = curr.getY_arr();
	
		if(x >= 0 && x < list[0].length && y >= 0 && y < list.length) {
			if(y -1 >= 0 && y - 1 < list.length && y+1 >= 0 && y+1 < list.length) {
				adjacent.add(list[y-1][x]);
				adjacent.add(list[y+1][x]);
			}
			if(x - 1 >= 0 && x - 1 < list[0].length && x+ 1 >= 0 && x + 1 < list[0].length) {
				adjacent.add(list[y][x-1]);
				adjacent.add(list[y][x+1]);
			}
		}
	

		return adjacent;
	}
	
	public Node mainAlgorithm(Node[][] arr) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Node source = null;
		Node destination = null;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				gScore.put(arr[i][j], Integer.MAX_VALUE);
				visited.put(arr[i][j], false);
				if (arr[i][j].getColor() == Color.RED) {
					source = arr[i][j];
				} else if(arr[i][j].getColor() == Color.BLUE) {
					destination = arr[i][j];
				}
			}
		}
		gScore.replace(source, Integer.MAX_VALUE, 0);
		pq.add(source);
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(curr.getColor() == Color.GRAY) continue;
			curr.setColor(Color.GREEN);
			visited.replace(curr, false, true);
			
			if(curr.equals(destination))  {
				System.out.println("found the destination");
				findShortestPath(curr, source);
				break;
			}
			for(Node a: getAdjacentNodes(arr, curr)) {
				if(pq.contains(a)) continue;
				int gOld = gScore.get(a);
				int parentDist = gScore.get(curr);
				int gCurrent = 10 + parentDist;
				if(gOld > gCurrent) {
					gScore.replace(a, gOld, gCurrent);
				}
				int f = gScore.get(a) + manhattanDistance(a, destination);
				
				a.setF(f);
				if(!visited.get(a))  {
					a.setParent(curr);
					if(a.getColor() != Color.GRAY) a.setColor(Color.ORANGE);
					pq.add(a);
				}

			}
			
			
		}
		return destination;
		
	}


	private void findShortestPath(Node curr, Node source) {
		// TODO Auto-generated method stub
		while(!curr.getParent().equals(source)) {
			curr.setColor(Color.CYAN);
			curr = curr.getParent();
		}
		curr.setColor(Color.CYAN);
		
	}

}
