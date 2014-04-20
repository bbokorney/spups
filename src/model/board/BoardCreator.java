package model.board;

/**
 * Created by Sachit on 4/19/2014.
 */

import model.board.*;
import model.tiles.IrrigationTileComponent;
import model.tiles.Tile;

import java.util.ArrayList;
import java.util.List;

/**The purpose of this class is to create our board. It is a very specific
 * class, created without almost any reusability in mind. It is simply an
 * easier way to delegate board creation to another class from the model
 * so that all of the code doesn't end up somewhere else.
 */
public class BoardCreator {
    public static JavaBoard createBoard() {
        JavaBoard board = new JavaBoard();

        List<Directions> directions = new ArrayList<Directions>();
        Location loc = new HexLocation(directions);
        Space space = new JavaSpace();
        board.placeSpace(loc, space);  // the origin
        directions.add(Directions.NORTH);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        space.accept(new IrrigationTileComponent(new Tile()));
        board.placeSpace(loc, space);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        space.accept(new IrrigationTileComponent(new Tile()));
        board.placeSpace(loc, space);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        space.accept(new IrrigationTileComponent(new Tile()));
        board.placeSpace(loc, space);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.NORTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.SOUTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTH);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.NORTH);
        directions.add(Directions.SOUTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.NORTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.NORTH);
        directions.add(Directions.SOUTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTHEAST);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTH);
        directions.add(Directions.SOUTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTH);
        directions.add(Directions.SOUTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHWEST);
        directions.add(Directions.NORTHEAST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToLowlands(loc);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTH);
        directions.add(Directions.SOUTHWEST);
        directions.add(Directions.NORTH);
        directions.add(Directions.NORTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTH);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHEAST);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);
        directions.add(Directions.SOUTHWEST);
        loc = new HexLocation(new ArrayList<Directions>(directions));
        space = new JavaSpace();
        board.placeSpace(loc, space);
        board.addToHighlands(loc);

        return board;
    }
}