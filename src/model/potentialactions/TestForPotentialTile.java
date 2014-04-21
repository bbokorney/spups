package model.potentialactions;

import controller.keylistener.KeyListener;
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


        GameFrame frame = new GameFrame(new KeyListener());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



//        //this is rotated clockwise once around the origin once and placed down
//        PotentialJavaThreeSpaceTile threeSpacePA = new PotentialJavaThreeSpaceTile(game, festival);
//        String message = (threeSpacePA.rotateClockwise().getMessage());
//        System.out.println(threeSpacePA.confirmAction().getFirst().getMessage());
//
//        //this is a three space tile moved up one north and placed down
//        PotentialJavaThreeSpaceTile threeSpacePA2 = new PotentialJavaThreeSpaceTile(game, festival);
//        threeSpacePA2.moveNorth();
//        System.out.println(threeSpacePA2.confirmAction().getFirst().getMessage());

//        //this places a village one north of the origin
//        PotentialPlaceVillageTile villageTile1 = new PotentialPlaceVillageTile(game, festival);
//        System.out.println(villageTile1.moveNorth().getMessage());
//        System.out.println(villageTile1.confirmAction().getFirst().getMessage());
//
//        //this places a village on the origin
//        PotentialPlaceVillageTile villageTile2 = new PotentialPlaceVillageTile(game, festival);
//        System.out.println(villageTile2.confirmAction().getFirst().getMessage());

        //attempting to place a palace tile
//        PotentialPlacePalaceTile palaceTile = new PotentialPlacePalaceTile(game, festival, 2);
//        stuff.printOneSpace(palaceTile, "Creating Palace: " + palaceTile.moveNorth().getMessage())
//        ;
//        stuff.printOneSpace(palaceTile, "Creating Palace: " + palaceTile.moveNorth().getMessage());
//        System.out.println(palaceTile.confirmAction().getFirst().getMessage());

                //this is rotated clockwise once around the origin once and placed down
        PotentialJavaTwoSpaceTile twoSpacePA = new PotentialJavaTwoSpaceTile(game, festival);
        String message = (twoSpacePA.rotateClockwise().getMessage());
        twoSpacePA.moveNorthwest();
        twoSpacePA.moveSouthwest();
        twoSpacePA.moveNorthwest();
        twoSpacePA.moveSouthwest();
        twoSpacePA.moveNorthwest();
        message = twoSpacePA.confirmPlacement().getFirst().getMessage();
        stuff.printTwoSpace(twoSpacePA, "Place rotated tile: "+ message);
//
//        System.out.println(palaceTile.confirmAction().getFirst().getMessage());

        //this is a three space tile moved up one north and placed down
        PotentialJavaTwoSpaceTile twoSpacePA2 = new PotentialJavaTwoSpaceTile(game, festival);
        twoSpacePA2.moveNorth();

        twoSpacePA2.moveNorth();
        System.out.println(twoSpacePA2.confirmPlacement().getFirst().getMessage());

//        PotentialPlaceIrrigationTile irrigationPA = new PotentialPlaceIrrigationTile(game, festival);
//        irrigationPA.moveSouth();
//        irrigationPA.confirmAction();

        PotentialPlaceDeveloperOnBoard placeDev = new PotentialPlaceDeveloperOnBoard(game, festival);
        placeDev.moveNorthwest();
        placeDev.moveSouthwest();
        placeDev.moveNorthwest();
        placeDev.moveSouthwest();
        placeDev.moveNorthwest();
        message = placeDev.confirmAction().getFirst().getMessage();
        stuff.printOneSpace(placeDev, "Placing the dev: " + message);


        System.out.println(game.getTurn().getActionPoints());



        frame.refreshGame(game, festival, null, null, null);




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
