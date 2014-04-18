package view.gamepanel;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import view.JavaImageLoader;
import model.board.Board;

/**
 * Created by Baker on 4/14/2014.
 */
public class BoardPanel extends JFrame {
	private BufferedImage board;
	private Graphics2D g2d;
	public BoardPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT*2/3));
        this.setVisible(true);
		BufferedImage board = JavaImageLoader.getImage("resources/BoardBackground.jpg");
		g2d.drawImage(board, null, 0, 0);
	}
	
	public void refreshView(Board board2) {
		// TODO Auto-generated method stub
		
	}
	
}
