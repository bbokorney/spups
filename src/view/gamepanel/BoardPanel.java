package view.gamepanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

import model.board.Board;
import model.board.HexLocation;
import model.board.LocationType;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.TileComponent;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel {
	public static double hexScaling = 2.0/3;
	//private Graphics2D g2d;
	HexLocation[] locations;
	Board board;
	public BoardPanel() {
		this.setVisible(true);
	}
	
	private int[] getBoardOrigin(HexLocation[] locations) { 
		int width = 0; 
		int height = 0; 
		for(int x = 0; x < locations.length; ++x) { 
			if(width > locations[x].getDistanceFromOrigin()[0])
				width = locations[x].getDistanceFromOrigin()[0];
			if(height > locations[x].getDistanceFromOrigin()[1])
				height = locations[x].getDistanceFromOrigin()[1];
		}
		return new int[] {width*-1, height*-1};
	}
	
	protected void paintComponent(Graphics g) {
		if(board != null) {
			int[] origin = getBoardOrigin(locations);
	
			for(HexLocation location : locations) { 
				int[] distance = location.getDistanceFromOrigin();
				
				if(distance[0] == 0 && distance[1] == 0) 
					board.getSpace(location).accept(new VillageTileComponent());
				if(distance[0] == 0 && distance[1] == 60) 
					board.getSpace(location).accept(new IrrigationTileComponent());
				if(distance[0] == 0 && distance[1] == 120) 
					board.getSpace(location).accept(new RiceTileComponent());
				if(distance[0] == 0 && distance[1] == 180) 
					board.getSpace(location).accept(new PalaceTileComponent(2));
				
				int width = distance[0]+origin[0]+50;
				int height = distance[1]+origin[1]+40;
	
		    	LocationType type = board.getLocationType(location);
		    	Color color = Color.white;
		    	if(type == LocationType.Highlands)
		    		color = Color.red;
		    	if(type == LocationType.Lowlands)
		    		color = Color.green;
				
				drawHex(g, width, height, color);
				TileComponent tile = board.getSpace(location).getTopTileComponent();
				TileVisitor visitor = new TileVisitor(g, width, height);
				if(tile != null) 
					board.getSpace(location).getTopTileComponent().accept(visitor);
			}
		}
    }
	
	public static void drawHouses(Graphics g, int i, int j, Color color) {
		int[] xHouse = {-4, -4, -7, 0, 7, 4, 4};
		int[] yHouse = {4, 0, 0, -9, 0, 0, 4};
		int[] xx = {-12, 0, 12, 0};
		int[] yy = {0, -12, 0, 12};
		for(int x = 0; x < xx.length; ++x) {
			Polygon house = new Polygon();
			for(int y = 0; y < xHouse.length; ++y) {
				int width = i+xx[x]+xHouse[y];
				int height = j+yy[x]+yHouse[y];
	            house.addPoint((int)(width*(hexScaling)), (int)(height*(hexScaling)));
			}
			((Graphics2D) g).setColor(color);
			g.fillPolygon(house);
		}
	}

	public static void drawPalace(Graphics g, int i, int j, Color color, int palaceValue) {
		int houseDimension = 18; 
		int roofWidth = 25; 
		int roofHeight = 26;
		
		int[] xHouse = {-houseDimension, -houseDimension, -roofWidth, 0, roofWidth, houseDimension, houseDimension};
		int[] yHouse = {houseDimension, 0, 0, -roofHeight, 0, 0, houseDimension};
			Polygon house = new Polygon();
			for(int y = 0; y < xHouse.length; ++y) {
				int width = i+xHouse[y];
				int height = j+yHouse[y];
	            house.addPoint((int)(width*(hexScaling)), (int)(height*(hexScaling)));
			}
			((Graphics2D) g).setColor(Color.YELLOW);
			g.fillPolygon(house);
	        g.fillArc((int)(i*(hexScaling)), (int)(j*(hexScaling)), 20, 200, 0, 30);
	        g.setColor(Color.black);
	        g.setFont(new Font("default", Font.BOLD, 20));
	        if(palaceValue > 9)
	        	i -= 12;
	        g.drawString(palaceValue+"", (int)(i*(hexScaling))-6, (int)(j*(hexScaling))+6);
	}

	public enum TileType {
		Rice, Village, Palace, Irrigation, Highlands;
	}
	
	public static void drawHex(Graphics g, int posWidth, int posHeight, Color color) {
        Polygon tile = new Polygon();
        for (int x = 0; x < 6; x++) {
        	int height = (int) (posHeight + hexSideLength()*Math.sin(x*2*Math.PI/6));
        	int width = (int) (posWidth + hexSideLength()*Math.cos(x*2*Math.PI/6));
            tile.addPoint((int)(width*(hexScaling)), (int)(height*(hexScaling)));
        }
        
        g.setColor(color);
    	g.fillPolygon(tile);
    	
        ((Graphics2D) g).setColor(Color.black);
        ((Graphics2D) g).setStroke(new BasicStroke(2));
        g.drawPolygon(tile);
    }
	
	private static int hexSideLength() { 
		return (int) (30*Math.sin(Math.PI/2) / Math.sin(Math.PI/3));
	}

	
	public void refreshView(Board board) {	
		this.board = board;	
		locations = board.getAllLocations().toArray(new HexLocation[0]);
		// TODO Auto-generated method stub
		repaint();
	}
	
	public static void drawIrrigationWave(Graphics g, int width, int height, int yOffset) {
	    g.setColor(Color.blue);
		int lastX = (int)(width*BoardPanel.hexScaling)-12; 
		int lastY = (int)(height*BoardPanel.hexScaling)-yOffset;
	    for(int i = -1; i < 8; i++) {
	        int pixelX = lastX + 3;
	        int pixelY = lastY + (int) (Math.sin(Math.PI/3*i)*5);
			g.drawLine(lastX, lastY, pixelX, pixelY);
			lastX = pixelX; 
			lastY = pixelY;
	    }
	}
	
	public static void drawRiceLines(Graphics g, int width, int height, int yOffset, int length) {
	    g.setColor(new Color(20, 84, 1));
		int startX = (int)(width*BoardPanel.hexScaling)-(length/2); 
		int startY = (int)(height*BoardPanel.hexScaling)-yOffset;
		g.drawLine(startX, startY, startX+length, startY);
	}
	
}
