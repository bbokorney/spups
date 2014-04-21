package view.gamepanel;

import java.awt.Color;
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
		BoardPanel.drawHex(g, width, height, Color.yellow);
		BoardPanel.drawHouses(g, width, height, Color.black);
		
	}

	@Override
	public void visit(RiceTileComponent component) {
		BoardPanel.drawHex(g, width, height, new Color(30, 128, 2));
		BoardPanel.drawRiceLines(g, width, height, -14, 26);
		BoardPanel.drawRiceLines(g, width, height, -7, 34);
		BoardPanel.drawRiceLines(g, width, height, 0, 40);
		BoardPanel.drawRiceLines(g, width, height, 7, 34);
		BoardPanel.drawRiceLines(g, width, height, 14, 26);
	}

	@Override
	public void visit(PalaceTileComponent component) {
		BoardPanel.drawHex(g, width, height, new Color(128, 109, 41));
		BoardPanel.drawPalace(g, width, height, Color.black, component.getLevel());
	}

	@Override
	public void visit(IrrigationTileComponent component) {
//		System.out.println(width + " " + height);
		BoardPanel.drawHex(g, width, height, new Color(8, 128, 255));
		BoardPanel.drawIrrigationWave(g, width, height, -8);
		BoardPanel.drawIrrigationWave(g, width, height, 8);
		
	}
}
