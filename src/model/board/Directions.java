package model.board;

/** The directions of movement in the game (clockwise).
 * This will be used when creating the list of movements
 * from origin to this HexLocation. Note that this convention
 * (clockwise) will be used throughout path storage in this system. */
public enum Directions {
	UP, UPRIGHT, RIGHTDOWN, DOWN,
	DOWNLEFT, LEFTUP
}