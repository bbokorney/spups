package view.gamepanel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.TileLabel;
import model.player.Player;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

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
		

		int offHeight = 70;
		int offWidth = 70;
//		twotile = new JLabel("", JavaImageLoader.getImage("/Users/maumau/spups/resources/Palace2.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		twotile = newJLabel("3", "/Users/maumau/spups/resources/twotile.png", offWidth, offHeight);
		developer = newJLabel("3", "/Users/maumau/spups/resources/developer.png", offWidth, offHeight);
		rice = newJLabel("3", "/Users/maumau/spups/resources/rice.png", offWidth, offHeight);
		village = newJLabel("3", "/Users/maumau/spups/resources/village.png", offWidth, offHeight);
		AP = newJLabel("3", "/Users/maumau/spups/resources/AP.png", offWidth, offHeight);
		card = newJLabel("3", "/Users/maumau/spups/resources/card.png", 80, offHeight);
		user = newJLabel("", "/Users/maumau/spups/resources/user.png", 80, offHeight);
		

		rice = TileLabel.newHexLabel("rice", offWidth, offHeight, new RiceTileComponent());
		village = TileLabel.newHexLabel("village", offWidth, offHeight, new VillageTileComponent());
		add(twotile);
		add(developer);
		add(rice);
		add(village);
		add(AP);
		add(card);
//		add(user);
		
//		for(int x = 2; x <= 10; x += 2) {
//			palace[x/2-1] = TileLabel.newHexLabel(x + "palace", offWidth, offHeight, new PalaceTileComponent(x));
//			this.add(palace[x/2-1]);
//		}
//		irrigation = TileLabel.newHexLabel("irrigation", offWidth, offHeight, new IrrigationTileComponent());
//		threetile = TileLabel.newThreeHexLabel("threetile", offWidth, offHeight);
//		JLabel twotile = TileLabel.newTwoHexLabel("threetile", offWidth, offHeight);
//
//		this.add(threetile);
//		this.add(irrigation);
//		
//		stack = TileLabel.newJLabel("3", "/Users/maumau/spups/resources/card.png", 70, 90);
//		card = TileLabel.newJLabel("3", "/Users/maumau/spups/resources/card.png", 70, 90);
//		this.add(stack);
//		this.add(card);
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
	
	public void refreshView(Player player) {
		// TODO Auto-generated method stub
		
	}
}
