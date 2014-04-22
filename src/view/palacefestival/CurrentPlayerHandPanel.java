package view.palacefestival;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import model.palacefestival.Card;
import model.palacefestival.PalaceCard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.image.BufferedImage;


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
        g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.cyan);
		for(int x = 0; x < cardsOfCurrentPlayer.size(); ++x) { 
			Image card = PalaceCardImageLoader.getImage((PalaceCard) cardsOfCurrentPlayer.get(x));
			int width = (x%cardPerLine)*50;
			int height = (x/cardPerLine)*70+1;
			g2d.drawImage(card, width, height, null);
		}

		for(Integer i : cardsSelected) { 
			int width = (i%cardPerLine)*50;
			int height = (i/cardPerLine)*70+1;
			g2d.drawPolygon(new Polygon(new int[] {width, width+50, width+50, width}, new int[] {height, height, height+70, height+70}, 4)); 
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
