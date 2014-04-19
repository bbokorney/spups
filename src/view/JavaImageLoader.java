package view;

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
			System.out.println(source);
			returnImage = ImageIO.read(new File(source));
		} catch(IOException e){
			System.out.println("Image couldn't be loaded.");
		}
		return returnImage;
	}
}
