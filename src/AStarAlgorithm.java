
public class AStarAlgorithm {
	
	public int manhattanDistance(Node source, Node destination) {
		return Math.abs((int) source.getX() - (int) destination.getX()) - Math.abs((int) source.getY() - (int) destination.getY());
	}
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method studio
		
	}

}
