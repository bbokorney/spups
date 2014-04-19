package model;

/**
 * Created by Sachit on 4/19/2014.
 */

import model.board.*;

import java.util.ArrayList;
import java.util.List;

/**The purpose of this class is to create our board. It is a very specific
 * class, created without almost any reusability in mind. It is simply an
 * easier way to delegate board creation to another class from the model
 * so that all of the code doesn't end up somewhere else.
 */
public class BoardCreator {
    private JavaBoard board;

    public JavaBoard createBoard() {
        board = new JavaBoard();

        //First add all the lowlands/highlands starting with the one
        //directly north of the origin
        List<Directions> directions = new ArrayList<Directions>();
        for (int i = 0; i < 9; i++)
            directions.add(Directions.NORTH);
        Location loc = new HexLocation(directions);
        Space space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);

        //TODO: add the irrigation tiles

        //TODO: add rest of board
        return board;
    }
}
