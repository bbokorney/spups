package view.gamepanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.HexLabel;
import model.GameModel;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class CardsPanel extends JPanel {
	Graphics g;
	JLabel stack;
	JLabel card;
	
	public CardsPanel() {
		stack = newJLabel("3", "/Users/maumau/spups/resources/card.png", 75, 200);
		card = newJLabel("3", "/Users/maumau/spups/resources/card.png", 75, 200);
		this.add(stack);
		this.add(card);
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
	
	public void refreshView(GameModel model) {
		// TODO Auto-generated method stub
	}
}
