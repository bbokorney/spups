package view.gamepanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.TileLabel;
import model.GameModel;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class CommonPanel extends JPanel {
	JLabel[] palace = new JLabel[5];
	JLabel p4;
	JLabel p6;
	JLabel p8;
	JLabel p10;
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
//		JLabel twotile = TileLabel.newTwoHexLabel("threetile", offWidth, offHeight);

		this.add(irrigation);
		this.add(threetile);
		
		stack = TileLabel.newJLabel("3", "/Users/maumau/spups/resources/card.png", 70, 90);
		card = TileLabel.newJLabel("3", "/Users/maumau/spups/resources/card.png", 70, 90);
		this.add(stack);
		this.add(card);
	}


	public void refreshView(GameModel model) {
		// TODO Auto-generated method stub
		
	}
}
