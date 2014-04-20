package view.gamepanel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.player.JavaPlayer;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {
	JLabel twotile;
	JLabel developer;
	JLabel rice;
	JLabel village;
	JLabel card;
	JLabel AP;
	JLabel user;
	public PlayerPanel() {
//		this.setLayout(null);
//		twotile = new JLabel("", JavaImageLoader.getImage("/Users/maumau/spups/resources/Palace2.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		twotile = newJLabel("3", "/Users/maumau/spups/resources/twotile.png", 40, 90);
		developer = newJLabel("3", "/Users/maumau/spups/resources/developer.png", 40, 90);
		rice = newJLabel("3", "/Users/maumau/spups/resources/rice.png", 40, 90);
		village = newJLabel("3", "/Users/maumau/spups/resources/village.png", 40, 90);
		AP = newJLabel("3", "/Users/maumau/spups/resources/AP.png", 40, 90);
		card = newJLabel("3", "/Users/maumau/spups/resources/card.png", 80, 90);
		user = newJLabel("", "/Users/maumau/spups/resources/user.png", 80, 90);
		add(twotile);
		add(developer);
		add(rice);
		add(village);
		add(AP);
		add(card);
		add(user);
		
	}

	private JLabel newJLabel(String value, String src, int width, int height){
		JLabel label= new JLabel(value);
		label.setIcon(new ImageIcon(src));
		label.setFont(new Font("Lucida Grande", 0, 14));
		label.setPreferredSize(new Dimension(width, height));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		return label;
	}
	
	public void refreshView(JavaPlayer player) {
		// TODO Auto-generated method stub
		
	}
}
