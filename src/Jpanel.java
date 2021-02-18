import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Jpanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Node> arr = null;
	private static ArrayList<Node> fillarr = null;
	private static ArrayList<Node> startFinishArr = null;
	private final int RECT_SIZE = 15;
	private final int RECT_NUM = 500;
	private final int NUM_START_FINISH = 2;
	
	public Jpanel() {
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				addElements(e);
				
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				for(Node r: arr) {
					if(r.contains(e.getPoint())) {
						
						if(!fillarr.contains(r) && !startFinishArr.contains(r)) {
							fillarr.add(r);
						}
				
					}
				}
				repaint();
			}
		});
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if(key == 32) {
					fillarr.clear();
					startFinishArr.clear();
				}
				repaint();
				
			}
		});
		setSize(640, 480);
		
		arr = new ArrayList<>(RECT_NUM);
		fillarr = new ArrayList<>(RECT_NUM);
		startFinishArr = new ArrayList<>(NUM_START_FINISH);
		
		for(int y = 0; y < RECT_NUM/10; y++) {
			
			for(int x = 0; x < RECT_NUM/10; x++) {
				
				Node rect = new Node(x*RECT_SIZE, y*RECT_SIZE, RECT_SIZE, RECT_SIZE);
				arr.add(rect);
				
			}
		}
		
	}
	
	public void addElements(MouseEvent e) {
		for(Node r: arr) {
			if(r.contains(e.getPoint())) {
				
				if(e.getButton() == MouseEvent.BUTTON1) {
					if(fillarr.contains(r)) {
						fillarr.remove(r);
					} else {
						if(!startFinishArr.contains(r)) {
							fillarr.add(r);
						}
					}
				}
				
				if(e.getButton() == MouseEvent.BUTTON3) {
					if(startFinishArr.contains(r)) {
						startFinishArr.remove(r);
					} else {
						if(!fillarr.contains(r) && startFinishArr.size() < 2) {
							startFinishArr.add(r);
						}
					}
					
				}
			}
		}
        repaint();
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.RED);
        for(Node cell: startFinishArr) {
        	g2d.fill(cell);
            cell.setColor(Color.RED);
        }
        
        g2d.setColor(Color.BLUE);
        if(startFinishArr.size() == 2) {
        	g2d.fill(startFinishArr.get(1));
        	startFinishArr.get(1).setColor(Color.BLUE);
        }
        
        g2d.setColor(Color.GRAY);
        for (Node cell : fillarr) {
            g2d.fill(cell);
            cell.setColor(Color.GRAY);
            
        }
        
        g2d.setColor(Color.BLACK);
        for (Node cell : arr) {
            g2d.draw(cell);
            g2d.setColor(Color.BLACK);
        }
        
	}
}
