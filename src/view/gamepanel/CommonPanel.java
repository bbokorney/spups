package view.gamepanel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import view.JavaImageLoader;
import model.GameModel;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class CommonPanel extends JPanel {
	Image p2;
	Image p4;
	Image p6;
	Image p8;
	Image p10;
	Image irrigation;
	Image threetile;
	
	public CommonPanel() {
		
	    p2 = JavaImageLoader.getImage("/Users/maumau/spups/resources/Palace2.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    p4 = JavaImageLoader.getImage("/Users/maumau/spups/resources/Palace4.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    p6 = JavaImageLoader.getImage("/Users/maumau/spups/resources/Palace6.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    p8 = JavaImageLoader.getImage("/Users/maumau/spups/resources/Palace8.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    p10 = JavaImageLoader.getImage("/Users/maumau/spups/resources/Palace10.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    threetile = JavaImageLoader.getImage("/Users/maumau/spups/resources/Threetile.png").getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	    irrigation = JavaImageLoader.getImage("/Users/maumau/spups/resources/Irrigation.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	}

	protected void paintComponent(Graphics g) {
        g.drawImage(p2, 0, 160, null);
        g.drawImage(p4, 50, 160, null);
        g.drawImage(p6, 100, 160, null);
        g.drawImage(p8, 150, 160, null);
        g.drawImage(p10, 200, 160, null);
        g.drawImage(irrigation, 160, 20, null);
        g.drawImage(threetile, 0, 20, null);
    }

	public void refreshView(GameModel model) {
		// TODO Auto-generated method stub
		
	}
}
