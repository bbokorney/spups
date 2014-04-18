package view.gamepanel;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Created by Baker on 4/14/2014.
 */
public class GamePanel extends JPanel {
	private BufferedImage board;
	private Graphics2D g2d;
	public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT*2/3));
        this.setVisible(true);
		BufferedImage board = getImage("resources/BoardBackground.jpg");
		g2d.drawImage(board, null, 0, 0);
	}
	
	private BufferedImage getImage(String source){
		BufferedImage returnImage = null;
		try{
			System.out.println(source);
			returnImage = ImageIO.read(new File(source));
		} catch(IOException e){
			
		}
		return returnImage;
	}
}
