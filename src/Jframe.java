import javax.swing.JFrame;

public class Jframe extends JFrame {

	
	
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Jframe() {
		setSize(624, 441);
		setResizable(true);
		setTitle("A* Visualization Algorithm");
		Jpanel jp = new Jpanel();
		jp.setFocusable(true);
		add(jp);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Jframe();
	}

}
