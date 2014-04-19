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
    private Developer developer;
    private Location location;
    private Board board;
    private GameModel model;

    public DeveloperPassThroughRule(Developer developer, Location location, Board board, GameModel model) {
        this.developer = developer;
        this.location = location;
        this.board = board;
    }

    public boolean allowed() {
        // check to see if there are any Developers on this location
        boolean devOnSpaceOk;
        Collection<JavaPlayer> players = model.getPlayers();
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
            if(playerWithDev.equals(model.getCurrentJavaPlayer())) {
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
