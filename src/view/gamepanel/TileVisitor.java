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
	}

	@Override
	public void visit(PalaceTileComponent component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IrrigationTileComponent component) {
		BoardPanel.drawHex(g, width, height, new Color(8, 128, 255));
		drawWave();
		
	}
//	private void drawWave(int yPos, int xPos, int colour, int length, int amplitude, int alpha) {
	private void drawWave() {
//	    int pixelY, pixelX;
////
//		int lastX = width; 
//		int lastY = height;
//	    for(int i = 0; i < 100; i++) {
//	        pixelX = lastX + i;
//	        pixelY = (int) (Math.sin(Math.PI/10*i));
//				g.drawLine(lastX, lastY, pixelX, pixelY);
//			lastX = pixelX; 
//			lastY = pixelY;
//	    }
	}
}
