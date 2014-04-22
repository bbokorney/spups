package view.palacefestival;

import java.awt.Image;

import view.JavaImageLoader;

import java.util.List;

import model.palacefestival.PalaceCard;
import model.palacefestival.PalaceCardComponent;

public class PalaceCardImageLoader {
	public PalaceCardImageLoader() {
		
	}

	public static Image getDeckImage() {
		Image returnImage = JavaImageLoader.getImage("resources/carddeck.png");
		return returnImage.getScaledInstance(50, 70, Image.SCALE_SMOOTH);
		
	}
	
	public static Image getImage(PalaceCard card){
		List<PalaceCardComponent> components = card.getComponents();
		String s = "";
		for(PalaceCardComponent component : components)
			s += component.name();
		Image returnImage = JavaImageLoader.getImage("resources/" + s.toLowerCase() + "card.png");
		return returnImage.getScaledInstance(50, 70, Image.SCALE_SMOOTH);
	}
}
