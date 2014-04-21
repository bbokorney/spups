package model.potentialactions;

import model.GameModel;
import model.JavaGameModel;
import model.palacefestival.Card;
import model.palacefestival.PalaceCard;
import model.palacefestival.PalaceCardComponent;
import model.palacefestival.PalaceFestival;
import view.GameFrame;

import javax.swing.*;
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


        String message;// = (threeSpacePA.rotateClockwise().getMessage());
//        stuff.printThreeSpace(threeSpacePA, "Rotate: " + message);
//        threeSpacePA.rotateClockwise();
//        stuff.printThreeSpace(threeSpacePA, "Rotate:");
//        threeSpacePA.rotateClockwise();
//        stuff.printThreeSpace(threeSpacePA, "Rotate:");
//        threeSpacePA.rotateClockwise();
//        stuff.printThreeSpace(threeSpacePA, "Rotate:");
//        threeSpacePA.rotateClockwise();
//        stuff.printThreeSpace(threeSpacePA, "Rotate:");
//        threeSpacePA.rotateClockwise();
//        stuff.printThreeSpace(threeSpacePA, "Rotate:");
//
//        message = threeSpacePA.moveNorth().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move North 1 : " + message);
//        message = threeSpacePA.moveNorth().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move North 2 : " + message);
//        message = threeSpacePA.moveNorth().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move North 3 : " + message);
//        message = threeSpacePA.moveNorth().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move North 4 : " + message);
//        message = threeSpacePA.moveNorth().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move North 5 : " + message);
//        message = threeSpacePA.moveNorth().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move North 6 : " + message);
//        message = threeSpacePA.moveNorth().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move North 7 : " + message);
//        message = threeSpacePA.moveNorth().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move North 8 : " + message);
//        message = threeSpacePA.moveNorth().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move North 9 : " + message);


//        message = threeSpacePA.moveNorthwest().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move Northwest 1 : " + message);
//        message = threeSpacePA.moveNorthwest().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move Northwest 2 : " + message);
//        message = threeSpacePA.moveNorthwest().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move Northwest 3 : " + message);
//        message = threeSpacePA.moveNorthwest().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move Northwest 4 : " + message);
//        message = threeSpacePA.moveNorthwest().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move Northwest 5 : " + message);

//        message = threeSpacePA.moveSoutheast().getMessage();
//        stuff.printThreeSpace(threeSpacePA, "Move Southeast 5 : " + message);
//
//        game.getBoard().getSpace(threeSpacePA.getCenterLocation()).accept(new VillageTileComponent(new Tile(1)));
//
//
//
//        threeSpacePA.moveSouth();
//        stuff.printThreeSpace(threeSpacePA, "Move South:");
//
//        threeSpacePA.moveNortheast();
//        stuff.printThreeSpace(threeSpacePA, "Move Northeast:");
//
//        threeSpacePA.moveSoutheast();
//        stuff.printThreeSpace(threeSpacePA, "Move Southeast:");
//
//        threeSpacePA.moveNorthwest();
//        stuff.printThreeSpace(threeSpacePA, "Move Northwest:");
//
//        threeSpacePA.moveSouthwest();
//        stuff.printThreeSpace(threeSpacePA, "Move Southwest:");


//        PotentialJavaTwoSpaceTile twoSpacePA = new PotentialJavaTwoSpaceTile(game, festival);
//        stuff.printTwoSpace(twoSpacePA, "New PotentialJavaTwoSpaceTile:");

//        twoSpacePA.rotateClockwise();
//        stuff.printTwoSpace(twoSpacePA, "Rotate:");
//        twoSpacePA.rotateClockwise();
//        stuff.printTwoSpace(twoSpacePA, "Rotate:");
//        twoSpacePA.rotateClockwise();
//        stuff.printTwoSpace(twoSpacePA, "Rotate:");
//        twoSpacePA.rotateClockwise();
//        stuff.printTwoSpace(twoSpacePA, "Rotate:");
//        twoSpacePA.rotateClockwise();
//        stuff.printTwoSpace(twoSpacePA, "Rotate:");
//        twoSpacePA.rotateClockwise();
//        stuff.printTwoSpace(twoSpacePA, "Rotate:");
//
//        twoSpacePA.moveNorth();
//        stuff.printTwoSpace(twoSpacePA, "Move North:");
//
//        twoSpacePA.moveSouth();
//        stuff.printTwoSpace(twoSpacePA, "Move South:");
//
//        twoSpacePA.moveNortheast();
//        stuff.printTwoSpace(twoSpacePA, "Move Northeast:");
//
//        twoSpacePA.moveSoutheast();
//        stuff.printTwoSpace(twoSpacePA, "Move Southeast:");
//
//        twoSpacePA.moveNorthwest();
//        stuff.printTwoSpace(twoSpacePA, "Move Northwest:");
//
//        twoSpacePA.moveSouthwest();
//        stuff.printTwoSpace(twoSpacePA, "Move Southwest:");
////
        PotentialPlaceRiceTile riceSpacePA = new PotentialPlaceRiceTile (game, festival);
        stuff.printOneSpace(riceSpacePA, "New PotentialJavaOneSpaceTile:");

//        message = riceSpacePA.moveNorth().getMessage();
//        stuff.printOneSpace(riceSpacePA, "Move North: " + message);
//
//
//        game.getBoard().getSpace(riceSpacePA.getLocation()).accept(new RiceTileComponent(new Tile(1)));
//
        message = riceSpacePA.moveSouth().getMessage();
        stuff.printOneSpace(riceSpacePA, "Move South 1  : " + message);
        message =  riceSpacePA.moveSouth().getMessage();
        stuff.printOneSpace(riceSpacePA, "Move South 2  : " + message);
        message =  riceSpacePA.moveSouth().getMessage();
        stuff.printOneSpace(riceSpacePA, "Move South 3  : " + message);
        message = riceSpacePA.moveSouth().getMessage();
        stuff.printOneSpace(riceSpacePA, "Move South 4  : " + message);
        message = riceSpacePA.moveSouth().getMessage();
        stuff.printOneSpace(riceSpacePA, "Move South 5  : " + message);
        message =  riceSpacePA.moveSouth().getMessage();
        stuff.printOneSpace(riceSpacePA, "Move South 6  : " + message);
        message = riceSpacePA.moveSouth().getMessage();
        stuff.printOneSpace(riceSpacePA, "Move South 7  : " + message);
        message = riceSpacePA.moveSouth().getMessage();
        stuff.printOneSpace(riceSpacePA, "Move South 8  : " + message);
        message = riceSpacePA.moveSouth().getMessage();
        stuff.printOneSpace(riceSpacePA, "Move South 9  : " + message);
        message = riceSpacePA.moveSouth().getMessage();
        stuff.printOneSpace(riceSpacePA, "Move South 10 : " + message);
//        game.getBoard().getSpace(riceSpacePA.getLocation()).accept(new RiceTileComponent(new Tile(1)));
//
//        riceSpacePA.moveNortheast();
//        stuff.printOneSpace(riceSpacePA, "Move Northeast:");
//
//        game.getBoard().getSpace(riceSpacePA.getLocation()).accept(new RiceTileComponent(new Tile(1)));
//
//        riceSpacePA.moveSoutheast();
//        stuff.printOneSpace(riceSpacePA, "Move Southeast:");
//
//        game.getBoard().getSpace(riceSpacePA.getLocation()).accept(new RiceTileComponent(new Tile(1)));
//
//        riceSpacePA.moveNorthwest();
//        stuff.printOneSpace(riceSpacePA, "Move Northwest:");
//
//        riceSpacePA.moveSouthwest();
//        stuff.printOneSpace(riceSpacePA, "Move Southwest:");



    }
    public void printThreeSpace(PotentialJavaThreeSpaceTile threeSpacePA, String startMessage) {
        System.out.println( startMessage);
        System.out.println("\t Other 1  " + threeSpacePA.getOtherLocation(0).getDistanceFromOrigin()[0] + ", " + threeSpacePA.getOtherLocation(0).getDistanceFromOrigin()[1]);
        System.out.println("\t Center   " + threeSpacePA.getCenterLocation().getDistanceFromOrigin()[0] + ", " + threeSpacePA.getCenterLocation().getDistanceFromOrigin()[1]);
        System.out.println("\t Other 2  " + threeSpacePA.getOtherLocation(1).getDistanceFromOrigin()[0] + ", " + threeSpacePA.getOtherLocation(1).getDistanceFromOrigin()[1]);
    }

    public void printTwoSpace(PotentialJavaTwoSpaceTile twoSpacePA, String startMessage) {
        System.out.println( startMessage);
        System.out.println("\t Rice     " + twoSpacePA.getOtherLocation().getDistanceFromOrigin()[0] + ", " + twoSpacePA.getOtherLocation().getDistanceFromOrigin()[1]);
        System.out.println("\t Village  " + twoSpacePA.getCenterLocation().getDistanceFromOrigin()[0] + ", " + twoSpacePA.getCenterLocation().getDistanceFromOrigin()[1]);
    }

    public void printOneSpace(PotentialOneSpaceMovement oneSpacePA, String startMessage) {
        System.out.println( startMessage);
        System.out.println("\t Space    " + oneSpacePA.getLocation().getDistanceFromOrigin()[0] +", " + oneSpacePA.getLocation().getDistanceFromOrigin()[1]);
    }
}
