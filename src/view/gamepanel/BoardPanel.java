package view.gamepanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import view.GameFrame;
import model.GameModel;
import model.actions.ActionResult;
import model.board.Board;
import model.board.HexLocation;
import model.board.Location;
import model.board.LocationType;
import model.player.JavaPlayer;
import model.tiles.TileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel {
	public static double hexScaling = 2.0/3;
	//private Graphics2D g2d;
	private HexLocation[] locations;
	private int[] origin;
	private Board board;
	private GameModel model;
	private Map<Location, TileComponent> potentialComponents;
	private List<Location> highlightedComponents;
	private ActionResult result;
	
	public BoardPanel() {
		this.setVisible(true);
	}
	
	private int[] getBoardOrigin(HexLocation[] locations) { 
		int width = 0; 
		int height = 0; 
		for(int x = 0; x < locations.length; ++x) { 
			if(width > locations[x].getDistanceFromOrigin()[0])
				width = locations[x].getDistanceFromOrigin()[0];
			if(height > locations[x].getDistanceFromOrigin()[1]*-1)
				height = locations[x].getDistanceFromOrigin()[1]*-1;
		}
		return new int[] {width*-1, height*-1};
	}
	
	protected void paintComponent(Graphics g) {
			// BACKGROUND and TILES
			for(HexLocation location : locations) { 
				int[] distance = location.getDistanceFromOrigin();
				
				int width = distance[0]+origin[0]+50;
				int height = distance[1]*-1+origin[1]+40;
	
		    	LocationType type = board.getLocationType(location);
		    	Color color = Color.white;
		    	if(type == LocationType.Highlands)
		    		color = Color.red;
		    	if(type == LocationType.Lowlands)
		    		color = Color.green;
				
				drawHex(g, width, height, color, location);
//				connectLocations(g, location);
				TileComponent tile = board.getSpace(location).getTopTileComponent();
				TileVisitor visitor = new TileVisitor(g, width, height, this, location);
				if(tile != null) 
					board.getSpace(location).getTopTileComponent().accept(visitor);
			}
			
			// ELEVATION
			for(HexLocation location : locations) {
				int[] distance = location.getDistanceFromOrigin();
				int width = distance[0]+origin[0]+50;
				int height = distance[1]*-1+origin[1]+40;
				width = (int)(width*hexScaling)-10;
				height = (int)(height*hexScaling)+18;

		        if(board.getSpace(location).getHeight() != 0) {
					g.setColor(Color.white);
					g.fillOval(width-2, height-12, 13, 13);
					g.setColor(Color.black);
			        g.setFont(new Font("default", Font.PLAIN, 13));
		        	g.drawString(board.getSpace(location).getHeight()+"", width, height);
		        }
			}
			
			// DEVELOPERS
			for(int x = 0; x < model.getJavaPlayers().size(); ++x) {
				HexLocation[] locations = model.getJavaPlayers().toArray(new JavaPlayer[0])[x].getDeveloperLocations().toArray(new HexLocation[0]);
				for(int y = 0; y < locations.length; ++y) {
					int[] distance = locations[y].getDistanceFromOrigin();
					int width = distance[0]+origin[0]+50;
					int height = distance[1]*-1+origin[1]+40;
					drawDeveloper(g, width, height, GameFrame.playerColors[x]);
				}
			}
			
			List<HexLocation> highlights = new LinkedList<HexLocation>();
			if(potentialComponents != null)
				for(HexLocation location : potentialComponents.keySet().toArray(new HexLocation[0]))
					highlights.add(location);
			if(highlightedComponents != null)
				for(HexLocation location : highlightedComponents.toArray(new HexLocation[0]))
					highlights.add(location);
			
			// POTENTIAL COMPONENT
			if(potentialComponents != null) {
				for(HexLocation location : highlights) { 
					TileComponent tile = potentialComponents.get(location);
					int[] distance = location.getDistanceFromOrigin();
					int width = distance[0]+origin[0]+50;
					int height = distance[1]*-1+origin[1]+40;
					if(tile != null) {
						TileVisitor visitor = new TileVisitor(g, width, height, this, location);
						tile.accept(visitor);
					}
					
					Polygon poly = new Polygon();
			        for (int x = 0; x < 6; x++) {
			        	int hheight = (int) (height + hexSideLength()*Math.sin(x*2*Math.PI/6));
			        	int wwidth = (int) (width + hexSideLength()*Math.cos(x*2*Math.PI/6));
			        	poly.addPoint((int)(wwidth*(hexScaling)), (int)(hheight*(hexScaling)));
			        }
			        g.setColor(Color.CYAN);
			        if(result != null) {
			        	if(result.isSuccess()) {
			        		g.setColor(Color.green);
			        	} else { 
			        		g.setColor(Color.red);
			        	}
			        
			        }
			        	
			        ((Graphics2D) g).setStroke(new BasicStroke(4));
			        g.drawPolygon(poly);
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
	        g.setColor(Color.black);
	        g.setFont(new Font("default", Font.BOLD, 20));
	        if(palaceValue > 9)
	        	i -= 12;
	        g.drawString(palaceValue+"", (int)(i*(hexScaling))-6, (int)(j*(hexScaling))+8);
	}

	public enum TileType {
		Rice, Village, Palace, Irrigation, Highlands;
	}
	
	
	/*
	 *   / \ / \
	 *  |   |   |
	 *   \ / \ /
	 */
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
	

	public void drawHex(Graphics g, int posWidth, int posHeight, Color color, HexLocation location) {
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
    	for(int x = 0; x < 6; ++x) {
			int x1 = tile.xpoints[x];
			int x2 = tile.xpoints[(x+1)%6];
			int y1 = tile.ypoints[x];
			int y2 = tile.ypoints[(x+1)%6];
    		boolean draw = true;
    		for(HexLocation neighbor : location.getNeighbors().toArray(new HexLocation[0])) {
    			if(board.getSpace(location) != null && board.getSpace(location).getTopTileComponent() != null 
    					&& board.getSpace(neighbor) != null && board.getSpace(neighbor).getTopTileComponent() != null 
    					&& board.getSpace(location).getTopTileComponent().getParent() == board.getSpace(neighbor).getTopTileComponent().getParent()) {

	    			int[] distance = neighbor.getDistanceFromOrigin();
	    			int width = (int)((distance[0]+origin[0]+50)*hexScaling);
	    			int height = (int)((distance[1]*-1+origin[1]+40)*hexScaling);
	
	    			int threshold = (int)((hexSideLength()+5)*hexScaling);
	    			
		            if(Math.abs(x1-width) < threshold && Math.abs(x2-width) < threshold && Math.abs(y1-height) < threshold && Math.abs(y2-height) < threshold)
		            	draw = false;
    			}
    		}
    		if(draw)
    			g.setColor(Color.black);
    		else
            	g.setColor(new Color(30, 128, 2));
    		g.drawLine(x1, y1, x2, y2);
    			
    	}
    	
    	
//        g.drawPolygon(tile);
    }
	
	public void connectLocations(Graphics g, HexLocation location) {
		board.getSpace(location);
		for(HexLocation neighbor : location.getNeighbors().toArray(new HexLocation[0])) {
			if(board.getSpace(location) != null && board.getSpace(location).getTopTileComponent() != null && 
					board.getSpace(neighbor) != null && board.getSpace(neighbor).getTopTileComponent() != null && 
					board.getSpace(location).getTopTileComponent().getParent() == board.getSpace(neighbor).getTopTileComponent().getParent()) {
				ArrayList<Point> list  = new ArrayList<Point>();
				int[] distance = location.getDistanceFromOrigin();
				int width1 = distance[0]+origin[0]+50;
				int height1 = distance[1]*-1+origin[1]+40;
				distance = neighbor.getDistanceFromOrigin();
				int width2 = distance[0]+origin[0]+50;
				int height2 = distance[1]*-1+origin[1]+40;
		        for (int x = 0; x < 6; x++) {
		        	int height = (int) (height1 + hexSideLength()*Math.sin(x*2*Math.PI/6));
		        	int width = (int) (width1 + hexSideLength()*Math.cos(x*2*Math.PI/6));
		            if(Math.abs(height-height2) < hexSideLength()+5 && Math.abs(width-width2) < hexSideLength()+5)
		            	list.add(new Point((int)(width*(hexScaling)), (int)(height*(hexScaling))));
		        }
		        g.setColor(new Color(30, 128, 2));
		        ((Graphics2D) g).setStroke(new BasicStroke(9));
		        System.out.println(list);
		        g.drawLine(list.get(0).x, list.get(0).y, list.get(1).x, list.get(1).y);
			}
		}
	}
	
	private static int hexSideLength() { 
		return (int) (30*Math.sin(Math.PI/2) / Math.sin(Math.PI/3));
	}

	
	public void refreshView(Board board, GameModel model, Map<Location, TileComponent> potentialComponents, List<Location> highlightedComponents, ActionResult result) {	
		this.board = board;	
		this.model = model;
		this.potentialComponents = potentialComponents; 
		this.highlightedComponents = highlightedComponents;
		this.locations = board.getAllLocations().toArray(new HexLocation[0]);
		this.result = result;
		this.origin = getBoardOrigin(this.locations);

		repaint();
	}
	
	public static void drawDeveloper(Graphics g, int width, int height, Color color) {
		double[] xx = {-0.7, 0.7, 1, -1};
		double[] yy = {-1.5, -1.5, 1.5, 1.5};
        Polygon tile = new Polygon();
        for (int x = 0; x < 4; x++) {
        	int xPoint = (int) (width*hexScaling + xx[x]*7);
        	int yPoint = (int) (height*hexScaling + yy[x]*7);
            tile.addPoint(xPoint, yPoint);
        }
        
        g.setColor(color);
    	g.fillPolygon(tile);
    	
        ((Graphics2D) g).setColor(Color.black);
        ((Graphics2D) g).setStroke(new BasicStroke(2));
        g.drawPolygon(tile);
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
