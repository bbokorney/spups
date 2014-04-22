package model.rules.developer;

import model.GameModel;
import model.board.Board;
import model.board.Location;
import model.palacefestival.PalaceCardComponent;
import model.player.Developer;
import model.player.JavaPlayer;
import model.rules.tiles.Visitor;
import model.tiles.*;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class DeveloperPassThroughRule {
    private boolean tileTypeOk;
    private Location location;
    private Board board;
    private Collection<JavaPlayer> players;
    private JavaPlayer currentPlayer;

    public DeveloperPassThroughRule(Location location, Board board, Collection<JavaPlayer> players, JavaPlayer currentPlayer ) {
        this.location = location;
        this.board = board;
        this.players = players;
        this.currentPlayer = currentPlayer;
    }

    public boolean allowed() {
        // check to see if there are any Developers on this location
        boolean devOnSpaceOk;
        JavaPlayer playerWithDev = null;
        Developer devOnSpace = null;
        for(JavaPlayer player : players) {
            for(Developer dev : player.getDevelopers()) {
                if(dev.getLocation().equals(location)) {
                    playerWithDev = player;
                    devOnSpace = dev;
                }
            }
        }

        if(devOnSpace != null) {
            if(playerWithDev.equals(currentPlayer)) {
                devOnSpaceOk = true;
            }
            else {
                devOnSpaceOk = false;
            }
        }
        else {
            devOnSpaceOk = true;
        }

        TileComponent component = board.getTopTileComponent(location);
        if(component == null) {
            return false;
        }
        component.accept(new PassThroughVisitor());

        return devOnSpaceOk && tileTypeOk;
    }

    private class PassThroughVisitor implements Visitor {

        public void visit(VillageTileComponent component) {
            tileTypeOk = true;
        }

        public void visit(RiceTileComponent component) {
            tileTypeOk = true;
        }

        public void visit(PalaceTileComponent component) {
            tileTypeOk = false;
        }

        public void visit(IrrigationTileComponent component) {
            tileTypeOk = false;
        }
    }
}
