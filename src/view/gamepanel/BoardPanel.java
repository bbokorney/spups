package view.gamepanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JPanel;

import view.JavaImageLoader;
import model.board.Board;
import model.board.HexLocation;
import model.board.JavaBoard;
import model.board.Location;
import model.board.LocationType;
import model.board.Space;
import model.tiles.Tile;
import model.tiles.TileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel {
	private static double hexScaling = 2.0/3;
	private Image boardBackground;
	//private Graphics2D g2d;
	HexLocation[] locations;
	Board board;
	public BoardPanel(Board board) {
		this.board = board;
//		boardBackground = JavaImageLoader.getImage("/Users/maumau/spups/resources/BoardBackground.jpg").getScaledInstance(510, 660, Image.SCALE_SMOOTH);
		this.setVisible(true);
		
		locations = board.getAllLocations().toArray(new HexLocation[0]);
//		HexLocation[] locations = new HexLocation[]{};
		
		System.out.println(locations.length);
		int[] origin = getBoardOrigin(locations);
		System.out.println(Arrays.toString(origin));
		for(int x = 0; x < locations.length; ++x) { 
//			System.out.println(Arrays.toString(locations[x].getDistanceFromOrigin()));
		}

	} 
	
	private int[] getBoardOrigin(HexLocation[] locations) { 
		int width = 0; 
		int height = 0; 
		for(int x = 0; x < locations.length; ++x) { 
			if(width > locations[x].getDistanceFromOrigin()[0])
				width = locations[x].getDistanceFromOrigin()[0];
			if(height > locations[x].getDistanceFromOrigin()[1])
				height = locations[x].getDistanceFromOrigin()[1];
//			System.out.println(Arrays.toString(locations[x].getDistanceFromOrigin()));
			
		}
		return new int[] {width*-1, height*-1};
	}
	
	protected void paintComponent(Graphics g) {
		int[] origin = getBoardOrigin(locations);

		for(HexLocation location : locations) { 
			int[] distance = location.getDistanceFromOrigin();
			int width = distance[0]+origin[0]+50;
			int height = distance[1]+origin[1]+40;

	    	LocationType type = board.getLocationType(location);
	    	Color color = Color.white;
	    	if(type == LocationType.Highlands)
	    		color = Color.red;
	    	if(type == LocationType.Lowlands)
	    		color = Color.green;
			
			drawHex(g, width, height, color);
			TileVisitor visitor = new TileVisitor(g, width, height);
			board.getSpace(location).getTopTileComponent().accept(visitor);
		}
		System.out.println("Size " + locations.length);
    }
	
	public static void drawHouses(Graphics g, int i, int j) {
		int[] xHouse = {-4, -4, -7, 0, 7, 4, 4};
		int[] yHouse = {4, 0, 0, -6, 0, 0, 4};
		int[] xx = {-12, 0, 12, 0};
		int[] yy = {0, -12, 0, 12};
		for(int x = 0; x < xx.length; ++x) {
			Polygon house = new Polygon();
			for(int y = 0; y < xHouse.length; ++y) {
				int width = i+xx[x]+xHouse[y];
				int height = j+yy[x]+yHouse[y];
	            house.addPoint((int)(width*(hexScaling)), (int)(height*(hexScaling)));
			}
			((Graphics2D) g).setColor(Color.magenta);
			g.fillPolygon(house);
		}
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
		// TODO Auto-generated method stub
		repaint();
	}
	
}
