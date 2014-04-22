package view.palacefestival;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import model.palacefestival.Card;
import model.palacefestival.PalaceCard;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import view.JavaImageLoader;


@SuppressWarnings("serial")
public class CurrentPlayerHandPanel extends JPanel {
	BufferedImage cards; 
	int cardPerLine = 7;
	
	public CurrentPlayerHandPanel() {
		cards = new BufferedImage(500, 300, BufferedImage.TYPE_INT_ARGB);
	}

	
	
	@SuppressWarnings("rawtypes")
	public void refreshView(List<Card> cardsOfCurrentPlayer, List<Integer> cardsSelected) {
		Graphics2D g2d = cards.createGraphics();
		for(int x = 0; x < cardsOfCurrentPlayer.size(); ++x) { 
			Image card = PalaceCardImageLoader.getImage((PalaceCard) cardsOfCurrentPlayer.get(x));
			g2d.drawImage(card, (x%cardPerLine)*50, (x/cardPerLine)*70, null);
		}

		g2d.dispose();
		// TODO put picture of festival card
		//card.setText(""+festival.peekAtFestivalCard());
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(cards, 0, 0, null);
	}
}
