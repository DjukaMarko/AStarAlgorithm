package astar;

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
	AStarAlgorithm a = new AStarAlgorithm();
	public static Node[][] arr = null;
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
				for(Node[] r1: arr) {
					for(Node r: r1) {
						if(r.contains(e.getPoint())) {
							
							if(!fillarr.contains(r) && !startFinishArr.contains(r)) {
								fillarr.add(r);
								r.setColor(Color.GRAY);
							}
					
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
					for(Node[] r1: arr) {
						for(Node r: r1) {
							if(r.getColor() != Color.WHITE) {
								r.setColor(Color.WHITE);
							}
						}
					}
				}
				repaint();
				
			}
		});
		setSize(640, 480);
		
		arr = new Node[RECT_NUM/10][RECT_NUM/10];
		fillarr = new ArrayList<>(RECT_NUM);
		startFinishArr = new ArrayList<>(NUM_START_FINISH);
		
		for(int y = 0; y < RECT_NUM/10; y++) {
			
			for(int x = 0; x < RECT_NUM/10; x++) {
				
				Node rect = new Node(x*RECT_SIZE, y*RECT_SIZE, RECT_SIZE, RECT_SIZE);
				arr[y][x] = rect;
				rect.setX_arr(x);
				rect.setY_arr(y);
				rect.setColor(Color.WHITE);
				
			}
		}
		
	}
	
	public void addElements(MouseEvent e) {
		for(Node[] r1: arr) {
			for(Node r: r1) {
				if(r.contains(e.getPoint())) {
					
					if(e.getButton() == MouseEvent.BUTTON1) {
						if(fillarr.contains(r)) {
							fillarr.remove(r);
							r.setColor(Color.WHITE);
						} else {
							if(!startFinishArr.contains(r)) {
								fillarr.add(r);
								r.setColor(Color.GRAY);
							}
						}
					}
					
					if(e.getButton() == MouseEvent.BUTTON3) {
						if(startFinishArr.contains(r)) {
							startFinishArr.remove(r);
							r.setColor(Color.WHITE);
						} else {
							if(!fillarr.contains(r) && startFinishArr.size() < 2) {
								startFinishArr.add(r);
								r.setColor(Color.RED);
							}
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
        for (Node[] cellarr : arr) {
        	for(Node cell: cellarr) {
        		g2d.draw(cell);
        	}
            
        }
	}
}