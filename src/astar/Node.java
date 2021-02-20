package astar;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Node extends Rectangle2D implements Shape, Comparable<Node> {
	
	double width;
	double height;
	double x;
	double y;
	int x_d;
	int y_d;
	Node parent;
	int x_arr;
	int y_arr;
	Color color;
	int h;
	int g;
	int f;
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setScores(int f, int g, int h) {
		this.f = f;
		this.g = g;
		this.h = h;
	}
	
	public void setF(int f) {
		this.f = f;
	}
	public int getF() {
		return f;
	}
	public int setG(int g) {
		this.g = g;
		return g;
	}
	
	public int getG() {
		return g;
	}
	
	public int getH() {
		return h;
	}
	
	public void setH(int h) {
		this.h = h;
	}
	
	public void setX_arr(int x_arr) {
		this.x_arr = x_arr;
	}
	
	public void setY_arr(int y_arr) {
		this.y_arr = y_arr;
	}
	
	public int getX_arr() {
		return x_arr;
	}
	
	public int getY_arr() {
		return y_arr;
	}

	
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	

	public double getHeight() {
		return height;
	} 
	
	public double getWidth() {
		return width;
	}
	
	public double getX() {
		return x;
	}
	
	public int getMX() {
		return x_d;
	}
	public int getMY() {
		return y_d;
	}
	
	
	public double getY() {
		return y;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Node(double x, double y, double width, double height) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.x_d = (int) x;
		this.y_d = (int) y;
		this.g = Integer.MAX_VALUE;
	}
	
	public Node(double x, double y, int h) {
		this.x = x;
		this.y = y;
		setH(h);
	}

	@Override
	public void setRect(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		this.x_d = (int) x;
		this.y_d = (int) y;
		this.width = w;
		this.height = h;
		
	}
	

	@Override
	public int outcode(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rectangle2D createIntersection(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Node obj1 = (Node) obj;
		if(this.x_arr == obj1.x_arr && this.y_arr == obj1.y_arr) {
			return true;
		}
		return false;
	}


	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.getF(), o.getF());
	}
	
	


}
