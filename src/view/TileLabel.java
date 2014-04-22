package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.gamepanel.TileVisitor;
import model.tiles.RiceTileComponent;
import model.tiles.TileComponent;
import model.tiles.VillageTileComponent;


@SuppressWarnings("serial")
public class TileLabel extends JLabel {
//	BoardPanel board;
	TileComponent[] tiles;
	int xx[]; 
	int yy[];

	public TileLabel(String s, int[] xx, int[] yy, int width, int height, TileComponent[] tiles) { 
		super(s); 
		this.xx = xx; 
		this.tiles = tiles;
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
//			Polygon polygon = JavaImageLoader.makeHex(xx[i], yy[i]);
//			TileVisitor visitor = new TileVisitor(g, xx[i], yy[i], null, null);
//			tiles[i].accept(visitor);
//			g.drawPolygon(polygon);
//			g.setColor(Color.RED);
//			g.fillPolygon(polygon);
		}
	}


	public static JLabel newThreeHexLabel(String value, int width, int height) {
		TileLabel label= new TileLabel(value, new int[] {35, 87, 87}, new int[] {62, 92, 32}, width, height, new TileComponent[] {
				new VillageTileComponent(), new RiceTileComponent(), new RiceTileComponent()});
		setLabelStuff(label, width, height);
		return label;
	}


	public static JLabel newTwoHexLabel(String value, int width, int height) {
		TileLabel label= new TileLabel(value, new int[] {35, 35}, new int[] {35, 95}, width, height, new TileComponent[] {
				new VillageTileComponent(), new RiceTileComponent()});
		setLabelStuff(label, width, height);
		return label;
	}


	public static JLabel newJLabel(String value, String src, int width, int height){
		JLabel label= new JLabel(value);
		label.setIcon(new ImageIcon(src));
//		label.setVerticalAlignment(JLabel.NORTH);
		setLabelStuff(label, width, height);
		return label;
	}

	public static JLabel newHexLabel(String value, int width, int height, TileComponent tile){
		TileLabel label= new TileLabel(value, new int[] {35}, new int[] {35}, width, height, new TileComponent[] {tile});
		setLabelStuff(label, width, height);
		return label;
	}
	
	private static void setLabelStuff(JLabel label, int width, int height) {
		label.setFont(new Font("Lucida Grande", 0, 14));
		label.setPreferredSize(new Dimension(width, height));
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
	}

	
}
