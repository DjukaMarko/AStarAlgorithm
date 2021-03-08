package astar;
import javax.swing.JFrame;

public class Jframe extends JFrame {

	
	
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Jframe() {
		setSize(767, 790);
		setTitle("A* Visualization Algorithm");
		Jpanel jp = new Jpanel();
		jp.setFocusable(true);
		add(jp);
		setResizable(false);
		setVisible(true);

		this.revalidate();
		this.repaint();
	}

	public static void main(String[] args) {
		new Jframe();
		
	}

}
