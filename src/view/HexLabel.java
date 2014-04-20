package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Polygon;

public class HexLabel extends JLabel {
	int xx[]; 
	int yy[];

	public HexLabel(String s, int[] xx, int[] yy, int width, int height) { 
		super(s); 
		this.xx = xx; 
		this.yy = yy;
		this.setFont(new Font("Lucida Grande", 0, 14));
		this.setPreferredSize(new Dimension(width, height));
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setVerticalAlignment(SwingConstants.BOTTOM);
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		for(int i = 0; i < xx.length; ++i) {
			g.setColor(Color.BLACK);
			Polygon polygon = JavaImageLoader.makeHex(xx[i], yy[i]);
			g.drawPolygon(polygon);
			g.setColor(Color.RED);
			g.fillPolygon(polygon);
		}
	}

}
