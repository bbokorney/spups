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
        g.drawImage(boardBackground, 0, 0, null);
		int[] origin = getBoardOrigin(locations);
		HashSet set = new HashSet<Integer>();
		int duplicates = 0;

		
		for(int x = 0; x < locations.length; ++x) { 
//			if(x % 2 != 0){
				int[] distance = locations[x].getDistanceFromOrigin();
				if(set.contains(distance[0]*100000 + distance[1])) {
//					System.out.println("DUPLICATES");
//					System.out.println(distance[0] + " " + distance[1]);
					duplicates++;
					drawHex(g, distance[0]+origin[0]+50, distance[1]+origin[1]+40, distance[0] == 0 && distance[1] == 0, locations[x], true);
				}
				else
					drawHex(g, distance[0]+origin[0]+50, distance[1]+origin[1]+40, distance[0] == 0 && distance[1] == 0, locations[x], false);
				set.add(distance[0]*100000 + distance[1]);
//			}
		}
		System.out.println("Size " + locations.length);
		System.out.println("number of duplicates " + duplicates);


        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.orange);
        g2.setStroke(new BasicStroke(20));
    	g2.drawLine(origin[0]+50, origin[1]+40, origin[0]+3+50, origin[1]+3+40);
    	System.out.println(origin[0] + " " + origin[1]);
		
//		drawHex(g, origin[0]+50, -240+origin[1]+40, false, locations[0]);
//		System.out.println(hexSideLength());
//		int wStart = 100; 
//		int hStart = 100;
//		for(int x = 0; x < 10; ++x) { 
//			if(x % 2 == 0)
//				hStart += 30;
//			else
//				hStart -= 30;
//			for(int y = 0; y < 10; ++y) { 
//				drawHex(g, wStart+(x*52), hStart+(y*60));
//			}
//		}
//		drawHex(g, 100, 100);
//		drawHex(g, 150, 130);
//		drawHex(g, 100, 160);
    }
	
	public enum TileType {
		Rice, Village, Palace, Irrigation, Highlands;
	}
	
	public void drawHex(Graphics g, int posWidth, int posHeight, boolean fill, Location location, boolean duplicate) {
        Polygon tile = new Polygon();
        for (int x = 0; x < 6; x++) {
        	int height = (int) (posHeight + hexSideLength()*Math.sin(x*2*Math.PI/6));
        	int width = (int) (posWidth + hexSideLength()*Math.cos(x*2*Math.PI/6));
            tile.addPoint((int)(width*(hexScaling)), (int)(height*(hexScaling)));
        }
        g.drawPolygon(tile);
        g.setColor(Color.white);
        if(fill) 
            g.setColor(Color.black);
        if(duplicate)
            g.setColor(Color.MAGENTA);
    	
    	LocationType type = board.getLocationType(location);
    	if(type == LocationType.Highlands)
    		g.setColor(Color.red);
    	if(type == LocationType.Lowlands)
    		g.setColor(Color.green);
    	g.fillPolygon(tile);
    		
    	
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        g.drawPolygon(tile);
        

//        Graphics2D g2 = (Graphics2D) g;
//        g2.setColor(Color.orange);
//        g2.setStroke(new BasicStroke(20));
//    	g2.drawLine(posWidth[0]+50, origin[1]+40, origin[0]+3+50, origin[1]+3+40);
//    	System.out.println(origin[0] + " " + origin[1]);


    }
	
	public int hexSideLength() { 
		return (int) (30*Math.sin(Math.PI/2) / Math.sin(Math.PI/3));
	}

	
	public void refreshView(Board board) {
		// TODO Auto-generated method stub
		repaint();
	}
	
}
