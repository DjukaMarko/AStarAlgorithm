package astar;

import javax.swing.JFrame;

public class Jframe extends JFrame {

	
	
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Jframe() {
		setSize(1015, 1040);
		setTitle("A* Visualization Algorithm");
		Jpanel jp = new Jpanel();
		jp.setFocusable(true);
		add(jp);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Jframe();
	}

}
