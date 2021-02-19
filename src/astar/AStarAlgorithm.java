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
		return Math.abs((int) source.getX() - (int) destination.getX()) - Math.abs((int) source.getY() - (int) destination.getY());
		// TODO do that
	}
	
	
	public List<Node> getAdjacentNodes(Node[][] list, Node curr) {
		List<Node> adjacent = new ArrayList<>();
		int x = curr.getX_arr();
		int y = curr.getY_arr();
		if(x > 0 && x < list.length && y > 0 && y < list.length) {
			adjacent.add(list[x-1][y]);
			adjacent.add(list[x+1][y]);
			adjacent.add(list[x][y-1]);
			adjacent.add(list[x][y+1]);
			adjacent.add(list[x-1][y-1]);
			adjacent.add(list[x-1][y+1]);
			adjacent.add(list[x+1][y-1]);
			adjacent.add(list[x+1][y+1]);
		}
		return adjacent;
	}
	
	public Node mainAlgorithm(Node[][] arr) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Node source = new Node(0, 0, 0);
		Node destination = new Node(0, 0 ,0);
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				gScore.put(arr[i][j], arr[i][j].getG());
				visited.put(arr[i][j], false);
				if (arr[i][j].getColor() == Color.RED) {
					source = arr[i][j];
					System.out.println(arr[i][j].getColor());
				} else if(arr[i][j].getColor() == Color.BLUE) {
					destination = arr[i][j];
				}
			}
		}
		source.setScores(0, 0, manhattanDistance(source, destination));
		gScore.replace(source, source.getG(), 0);
		pq.add(source);
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(curr.getColor() == Color.GRAY) continue;
			curr.setColor(Color.ORANGE);
			visited.put(curr, true);
			
			if(curr.equals(destination))  {
				System.out.println("find the destination");
				findShortestPath(curr, source);
				break;
			}
			for(Node a: getAdjacentNodes(arr, curr)) {
				if(a.getParent() == null) a.setParent(curr);
				if(a.getParent().equals(source)) a.setG(10);
				if(pq.contains(a)) continue;
				int gOld = gScore.get(a);
				int gCurrent = 10 + gOld;
				if(gOld > gCurrent) gScore.replace(a, gOld, gCurrent);
				
				int f = gCurrent + manhattanDistance(a, destination);
				a.setF(f);
				if(!visited.get(a))  {
					a.setParent(curr);
					pq.add(a);
				}

			}
			
			
		}
		return destination;
		
	}


	private void findShortestPath(Node curr, Node source) {
		// TODO Auto-generated method stub
		while(!curr.getParent().equals(source)) {
			System.out.println(curr.getX_arr() + ", " + curr.getY_arr());
			curr.setColor(Color.CYAN);
			curr = curr.getParent();
		}
		//System.out.println(curr.getParent().getX_arr() + ", " + curr.getParent().getY_arr());
		
	}

}
