package view.palacefestival;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import model.palacefestival.Card;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.JavaImageLoader;
import view.TileLabel;
import model.GameModel;
import model.palacefestival.PalaceFestival;
import model.sharedresources.SharedResourceType;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;


@SuppressWarnings("serial")
public class CurrentPlayerHandPanel extends JPanel {

	LinkedList<JLabel> cards = new LinkedList<JLabel>();
	JLabel irrigation;
	JLabel threetile;
	JLabel stack;
	JLabel card;
	
	public CurrentPlayerHandPanel() {
		int offHeight = 70;
		int offWidth = 70;
		
//		irrigation = TileLabel.newHexLabel("irrigation", offWidth, offHeight, new IrrigationTileComponent());
//		threetile = TileLabel.newThreeHexLabel("threetile", offWidth+20, offHeight+30);
		this.add(irrigation);
		this.add(threetile);
		//TODO make the text of this go on the right place
		stack = newJLabel("", "/Users/maumau/spups/resources/card.png", 60, 100);
		card = newJLabel(" ", "/Users/maumau/spups/resources/card.png", 60, 100);
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

	@SuppressWarnings("rawtypes")
	public void refreshView(List<Card> cardsOfCurrentPlayer, List<Integer> cardsSelected) {
		BufferedImage img = JavaImageLoader.getImage("/Users/maumau/spups/resources/card.png");
		Graphics2D g2d = img.createGraphics();
		for(int x = 0; x < cardsOfCurrentPlayer.size(); ++x) { 
			g2d.drawImage(img, null, (x%7)*70, (x/7)*70);
			
		}

		// TODO put picture of festival card
		//card.setText(""+festival.peekAtFestivalCard());
		repaint();
	}
}
