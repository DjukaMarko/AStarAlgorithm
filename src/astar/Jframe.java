package astar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Jframe extends JFrame {

	
	
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Jframe() {
		setSize(624, 441);
		setResizable(false);
		setTitle("A* Visualization Algorithm");
		Jpanel jp = new Jpanel();
		jp.setFocusable(true);
		JButton b = new JButton("Start");
		add(jp);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AStarAlgorithm a = new AStarAlgorithm();
				a.mainAlgorithm(jp.getArr());
			}
		});
		add(b);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Jframe();
	}

}
