package astar;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;


public class AStarAlgorithm {
	
	Map<Node, Boolean> visited = new HashMap<>();
	List<Node> closedList = new ArrayList<>();
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
		List<Node> openList = new ArrayList<>();
		Node source = null;
		Node destination = null;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if (arr[i][j].getColor() == Color.RED) {
					source = arr[i][j];
				} else if(arr[i][j].getColor() == Color.BLUE) {
					destination = arr[i][j];
				}
			}
		}
		closedList.add(source);
		openList.add(source);
		
		while(openList.size() > 0) {
			Collections.sort(openList, new CustomComparator());
			Node curr = openList.remove(0);
			if(curr.getColor() == Color.GRAY) continue;
			if(!closedList.contains(curr)) closedList.add(curr);
			curr.setColor(Color.GREEN);
			
			if(curr.equals(destination))  {
				findShortestPath(curr, source);
				break;
			}
			for(Node a: getAdjacentNodes(arr, curr)) {
				if (closedList.contains(a)) continue;
				if(a.getColor() == Color.GRAY) continue;

				int parentDist = curr.getG();
				int gCurrent = 1 + parentDist;
				if(openList.contains(a)) {

					if(a.getG() > gCurrent) {
						a.setG(gCurrent);
					}
				} else {
					a.setG(gCurrent);
					a.setParent(curr);
					int f = a.getG() + manhattanDistance(a, destination);
					a.setF(f);
					openList.add(a);
					a.setColor(Color.ORANGE);

				}
			}
		}
				
		return destination;
		
	}


	private void findShortestPath(Node curr, Node source) {
		while(!curr.getParent().equals(source)) {
			curr.setColor(Color.CYAN);
			curr = curr.getParent();
		}
		curr.setColor(Color.CYAN);
		
	}

}
