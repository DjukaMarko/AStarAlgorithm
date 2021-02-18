import java.util.ArrayList;
import java.util.List;

public class AStarAlgorithm {
	
	public int manhattanDistance(Node source, Node destination) {
		return Math.abs((int) source.getX() - (int) destination.getX()) - Math.abs((int) source.getY() - (int) destination.getY());
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
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method studio
		
	}

}
