package MainPack;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;


public class GraphicPlotter extends JFrame{
	
	
	Canvas canvas;
	JPanel panel;
	ArrayList<Line> lines;
	
	class Line
	{
		int x1,y1,x2,y2;

		public Line(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		public int getX1() {
			return x1;
		}

		public int getY1() {
			return y1;
		}

		public int getX2() {
			return x2;
		}

		public int getY2() {
			return y2;
		}
		
	}
	
	public GraphicPlotter()
	{
		this.setSize(500, 500);
		this.setTitle("Calculator function plotter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBackground(Color.BLACK);
		this.lines = lines;
		
		
		panel = new JPanel() {
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				for(Line it:lines)
				{
					g.drawLine(it.getX1(),it.getY1(),it.getX2(),it.getY2());
				}
			}
		};
		
		
		this.setVisible(true);
	}
	
	
	
	
}
