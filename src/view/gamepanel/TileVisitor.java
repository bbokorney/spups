package view.gamepanel;

import java.awt.Color;
import java.awt.Graphics;

import model.board.Board;
import model.board.HexLocation;
import model.board.Location;
import model.rules.tiles.Visitor;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

public class TileVisitor implements Visitor {
	
	Graphics g; 
	int width;
	int height;
	BoardPanel board; 
	HexLocation location; 
	
	public TileVisitor(Graphics g, int width, int height, BoardPanel board, HexLocation location) {
		this.g = g; 
		this.width = width; 
		this.height = height;
		this.board = board;
		this.location = location;
	}

	@Override
	public void visit(VillageTileComponent component) {
		board.drawHex(g, width, height, Color.yellow, location);
		BoardPanel.drawHouses(g, width, height, Color.black);
		
	}

	@Override
	public void visit(RiceTileComponent component) {
		board.drawHex(g, width, height, new Color(30, 128, 2), location);
		BoardPanel.drawRiceLines(g, width, height, -14, 26);
		BoardPanel.drawRiceLines(g, width, height, -7, 34);
		BoardPanel.drawRiceLines(g, width, height, 0, 40);
		BoardPanel.drawRiceLines(g, width, height, 7, 34);
		BoardPanel.drawRiceLines(g, width, height, 14, 26);
	}

	@Override
	public void visit(PalaceTileComponent component) {
		board.drawHex(g, width, height, new Color(128, 109, 41), location);
		BoardPanel.drawPalace(g, width, height, Color.black, component.getLevel());
	}

	@Override
	public void visit(IrrigationTileComponent component) {
//		System.out.println(width + " " + height);
		board.drawHex(g, width, height, new Color(8, 128, 255), location);
		BoardPanel.drawIrrigationWave(g, width, height, -8);
		BoardPanel.drawIrrigationWave(g, width, height, 8);
		
	}
}
