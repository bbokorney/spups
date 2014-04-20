package view;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JavaImageLoader {
	public JavaImageLoader() {
		
	}
	
	public static BufferedImage getImage(String source){
		BufferedImage returnImage = null;
		try{
//			System.out.println(source);
			returnImage = ImageIO.read(new File(source));
		} catch(IOException e){
			System.out.println("Image couldn't be loaded.");
		}
		return returnImage;
	}
	public static Polygon makeHex(int posWidth, int posHeight) {
        Polygon tile = new Polygon();
        for (int x = 0; x < 6; x++) {
        	int height = (int) (posHeight + hexSideLength()*Math.sin(x*2*Math.PI/6));
        	int width = (int) (posWidth + hexSideLength()*Math.cos(x*2*Math.PI/6));
            tile.addPoint((int)(width*(2.0/3)), (int)(height*(2.0/3)));
        }
        return tile;
//        g.fillPolygon(tile);
//        g.drawPolygon(tile);
    }

	public static int hexSideLength() { 
		return (int) (30*Math.sin(Math.PI/2) / Math.sin(Math.PI/3));
	}
}
