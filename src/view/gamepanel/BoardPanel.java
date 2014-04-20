package view.gamepanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.util.Arrays;

import javax.swing.JPanel;

import view.JavaImageLoader;
import model.board.Board;
import model.board.HexLocation;
import model.board.JavaBoard;
import model.board.Location;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel {
	private Image boardBackground;
	//private Graphics2D g2d;
	public BoardPanel(Board board) {
		board = new JavaBoard();
		boardBackground = JavaImageLoader.getImage("/Users/maumau/spups/resources/BoardBackground.jpg").getScaledInstance(510, 660, Image.SCALE_SMOOTH);
		this.setVisible(true);
		
		HexLocation[] locations = board.getAllLocations().toArray(new HexLocation[0]);
		System.out.println(locations.length);
		for(int x = 0; x < locations.length; ++x) { 
			System.out.println(Arrays.toString(locations[x].getDistanceFromOrigin()));
		}

	} 
	
	protected void paintComponent(Graphics g) {
//        g.drawImage(boardBackground, 0, 0, null);
//		System.out.println(hexSideLength());
		int wStart = 100; 
		int hStart = 100;
		for(int x = 0; x < 10; ++x) { 
			if(x % 2 == 0)
				hStart += 30;
			else
				hStart -= 30;
			for(int y = 0; y < 10; ++y) { 
				drawHex(g, wStart+(x*52), hStart+(y*60));
			}
		}
//		drawHex(g, 100, 100);
//		drawHex(g, 150, 130);
//		drawHex(g, 100, 160);
    }
	
	public void drawHex(Graphics g, int posWidth, int posHeight) {
        Polygon tile = new Polygon();
        for (int x = 0; x < 6; x++) {
        	int height = (int) (posHeight + hexSideLength()*Math.sin(x*2*Math.PI/6));
        	int width = (int) (posWidth + hexSideLength()*Math.cos(x*2*Math.PI/6));
            tile.addPoint(width, height);
        }
//        g.fillPolygon(tile);
        g.drawPolygon(tile);
    }
	
	public int hexSideLength() { 
		return (int) (30*Math.sin(Math.PI/2) / Math.sin(Math.PI/3));
	}

	
	public void refreshView(Board board) {
		// TODO Auto-generated method stub
		repaint();
	}
	
}
