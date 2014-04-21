package model.potentialactions;

import model.GameModel;
import model.JavaGameModel;
import model.palacefestival.Card;
import model.palacefestival.PalaceCard;
import model.palacefestival.PalaceCardComponent;
import model.palacefestival.PalaceFestival;

import java.util.Stack;

/**
 * Created by idinamenzel on 4/20/14.
 */
public class TestForPotentialTile {

    public static void main(String[] args){

        TestForPotentialTile stuff = new TestForPotentialTile();

        System.out.println( "Stuff");


        Stack<Card> deck = new Stack<Card>();
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.MASK);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.PUPPET);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.MASK,
                    PalaceCardComponent.PUPPET);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM,
                    PalaceCardComponent.MASK);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM,
                    PalaceCardComponent.PUPPET);
            deck.add(card);
        }



        GameModel game = new JavaGameModel(3);
        PalaceFestival festival = new PalaceFestival(null, deck);

        PotentialJavaThreeSpaceTile threeSpacePA = new PotentialJavaThreeSpaceTile(game, festival);
        stuff.printThreeSpace(threeSpacePA, "New PotentialJavaThreeSpaceTile:");

        System.out.println(game.getBoard().areLocationsOnBoard(threeSpacePA.getCenterLocation()));

        threeSpacePA.moveNorth();
        stuff.printThreeSpace(threeSpacePA, "Move North:");

        threeSpacePA.moveSouth();
        stuff.printThreeSpace(threeSpacePA, "Move South:");

        threeSpacePA.moveSouth();
        stuff.printThreeSpace(threeSpacePA, "Move South:");

        threeSpacePA.moveNortheast();
        stuff.printThreeSpace(threeSpacePA, "Move Northeast:");

        threeSpacePA.moveNortheast();
        stuff.printThreeSpace(threeSpacePA, "Move Northeast:");

        threeSpacePA.moveNorthwest();
        stuff.printThreeSpace(threeSpacePA, "Move Northwest:");

        threeSpacePA.moveNorthwest();
        stuff.printThreeSpace(threeSpacePA, "Move Northwest:");






    }
    public void printThreeSpace(PotentialJavaThreeSpaceTile threeSpacePA, String startMessage) {
        System.out.println( startMessage);
        System.out.println("\t Center " + threeSpacePA.getCenterLocation().getDistanceFromOrigin()[0] + ", " + threeSpacePA.getCenterLocation().getDistanceFromOrigin()[1]);
        System.out.println("\t Other 1 " + threeSpacePA.getOtherLocation(0).getDistanceFromOrigin()[0] + ", " + threeSpacePA.getOtherLocation(0).getDistanceFromOrigin()[1]);
        System.out.println("\t Other 2 " + threeSpacePA.getOtherLocation(1).getDistanceFromOrigin()[0] + ", " + threeSpacePA.getOtherLocation(1).getDistanceFromOrigin()[1]);
    }
}
