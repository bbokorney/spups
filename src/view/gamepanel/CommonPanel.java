package view.gamepanel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.TileLabel;
import model.GameModel;
import model.palacefestival.PalaceFestival;
import model.sharedresources.SharedResourceType;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class CommonPanel extends JPanel {
	JLabel[] palace = new JLabel[5];
	JLabel irrigation;
	JLabel threetile;
	JLabel stack;
	JLabel card;
	
	public CommonPanel() {
		int offHeight = 70;
		int offWidth = 70;
		for(int x = 2; x <= 10; x += 2) {
			palace[x/2-1] = TileLabel.newHexLabel(x + "palace", offWidth, offHeight, new PalaceTileComponent(x));
			this.add(palace[x/2-1]);
		}
		
		irrigation = TileLabel.newHexLabel("irrigation", offWidth, offHeight, new IrrigationTileComponent());
		threetile = TileLabel.newThreeHexLabel("threetile", offWidth+20, offHeight+30);
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


	public void refreshView(GameModel model, PalaceFestival festival) {
		palace[0].setText(""+model.getCount(SharedResourceType.PALACELEVELTWO));
		palace[1].setText(""+model.getCount(SharedResourceType.PALACELEVELFOUR));
		palace[2].setText(""+model.getCount(SharedResourceType.PALACELEVELSIX));
		palace[3].setText(""+model.getCount(SharedResourceType.PALACELEVELEIGHT));
		palace[4].setText(""+model.getCount(SharedResourceType.PALACELEVELTEN));
		irrigation.setText(""+model.getCount(SharedResourceType.IRRIGATION));
		threetile.setText(""+model.getCount(SharedResourceType.THREE));
		stack.setText(""+festival.getDeckSize());
		
		// TODO put picture of festival card
		//card.setText(""+festival.peekAtFestivalCard());
		repaint();
	}
}
