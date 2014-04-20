package view.gamepanel;

import java.awt.Graphics;

import model.rules.tiles.Visitor;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

public class TileVisitor implements Visitor {
	
	Graphics g; 
	int width;
	int height;
	public TileVisitor(Graphics g, int width, int height) {
		this.g = g; 
		this.width = width; 
		this.height = height;
	}

	@Override
	public void visit(VillageTileComponent component) {
		BoardPanel.drawHouses(g, width, height);
	}

	@Override
	public void visit(RiceTileComponent component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PalaceTileComponent component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IrrigationTileComponent component) {
		// TODO Auto-generated method stub
		
	}

}
