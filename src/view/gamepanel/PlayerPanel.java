package view.gamepanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import view.TileLabel;
import model.GameModel;
import model.player.JavaPlayer;
import model.player.JavaPlayerResourceType;
import model.player.Player;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;
import model.turn.Turn;

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
	JLabel extratokens;
	JLabel user;
	JTextArea name;
	JTextArea AP;
	JTextArea fame;
	public PlayerPanel() {
		name = new JTextArea();
		name.setPreferredSize(new Dimension(70, 30));
		name.setBackground(Color.red);
		fame = new JTextArea();
		fame.setPreferredSize(new Dimension(70, 30));
		fame.setBackground(Color.red);
		AP = new JTextArea();
		AP.setPreferredSize(new Dimension(70, 30));
		AP.setBackground(Color.red);
//		this.setLayout(null);
		

		int offHeight = 70;
		int offWidth = 70;
//		twotile = new JLabel("", JavaImageLoader.getImage("/Users/maumau/spups/resources/Palace2.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		twotile = newJLabel("3", "/Users/maumau/spups/resources/twotile.png", offWidth, offHeight);
		developer = newJLabel("3", "/Users/maumau/spups/resources/developer.png", offWidth, offHeight);
		rice = newJLabel("3", "/Users/maumau/spups/resources/rice.png", offWidth, offHeight);
		village = newJLabel("3", "/Users/maumau/spups/resources/village.png", offWidth, offHeight);
		extratokens = newJLabel("3", "/Users/maumau/spups/resources/AP.png", offWidth, offHeight);
		card = newJLabel("3", "/Users/maumau/spups/resources/card.png", 80, offHeight+30);
		user = newJLabel("", "/Users/maumau/spups/resources/user.png", 80, offHeight);
		

		rice = TileLabel.newHexLabel("rice", offWidth, offHeight, new RiceTileComponent());
		village = TileLabel.newHexLabel("village", offWidth, offHeight, new VillageTileComponent());
		twotile = TileLabel.newTwoHexLabel("twotile", offWidth, offHeight+30);
		
		add(name);
		add(fame);
		add(AP);
		
		add(developer);
		add(rice);
		add(village);
		add(twotile);
		add(extratokens);
		add(card);
//		add(user);
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

	public void refreshView(GameModel model, Turn turn, JavaPlayer javaPlayer, int cardSize) {
		twotile.setText(""+javaPlayer.getCount(JavaPlayerResourceType.TWO));
		rice.setText(""+javaPlayer.getCount(JavaPlayerResourceType.RICE));
		village.setText(""+javaPlayer.getCount(JavaPlayerResourceType.VILLAGE));
		extratokens.setText(""+javaPlayer.getCount(JavaPlayerResourceType.EXTRAACTIONTOKEN));
		developer.setText(""+javaPlayer.getCount(JavaPlayerResourceType.DEVELOPER));
		card.setText(""+cardSize);
		name.setText(javaPlayer.getName());
		fame.setText("FAME: "+javaPlayer.getScore());
		if(model.getCurrentJavaPlayer() == javaPlayer) {
//			System.out.println("TURN " + turn);
			String s = turn == null ? "turn" : turn.getActionPoints() + "";
			AP.setText("AP:" + s);
		} else { 
			AP.setText("");
		}
	}
}
