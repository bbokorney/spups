package view.gamepanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;

import javax.swing.JPanel;

import view.JavaImageLoader;
import model.board.Board;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel {
	private Image boardBackground;
	//private Graphics2D g2d;
	public BoardPanel(Board board) {
		boardBackground = JavaImageLoader.getImage("/Users/maumau/spups/resources/BoardBackground.jpg").getScaledInstance(510, 660, Image.SCALE_SMOOTH);
		this.setVisible(true);
		

	} 
	
	protected void paintComponent(Graphics g) {
//        g.drawImage(boardBackground, 0, 0, null);
		drawHex(g, 100, 100);
    }
	
	public void drawHex(Graphics g, int posWidth, int posHeight) {
        Polygon tile = new Polygon();
        for (int x = 0; x < 6; x++) {
        	int height = (int) (posHeight + 25*Math.sin(x*2*Math.PI/6));
        	int width = (int) (posWidth + 25*Math.cos(x*2*Math.PI/6));
            tile.addPoint(width, height);
        }         
        g.drawPolygon(tile);
//        g.fillPolygon(tile);
    }

	
	public void refreshView(Board board) {
		// TODO Auto-generated method stub
		repaint();
	}
	
}
