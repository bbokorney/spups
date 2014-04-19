package view.gamepanel;

import java.awt.Graphics;
import java.awt.Image;

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
	public BoardPanel() {
		boardBackground = JavaImageLoader.getImage("/Users/maumau/spups/resources/BoardBackground.jpg").getScaledInstance(510, 660, Image.SCALE_SMOOTH);
		this.setVisible(true);
	} 
	
	protected void paintComponent(Graphics g) {
        g.drawImage(boardBackground, 0, 0, null);
    }
	
	public void refreshView(Board board) {
		// TODO Auto-generated method stub
		repaint();
	}
	
}
