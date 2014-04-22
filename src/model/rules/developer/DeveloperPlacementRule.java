package model.rules.developer;

import model.board.Board;
import model.board.Location;
import model.palacefestival.PalaceCardComponent;
import model.player.Developer;
import model.rules.tiles.Visitor;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

import java.util.Collection;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class DeveloperPlacementRule {
    private boolean allowed;
    private Location location;
    private Board board;
    private Collection<Developer> developers;
    private Developer developer;

    public DeveloperPlacementRule(Location location, Board board, Collection<Developer> developers, Developer developer) {
        allowed = false;
        this.location = location;
        this.board = board;
        this.developers = developers;
        this.developer = developer;
    }



    public boolean allowed() {
        // is this space on the board?
        if(!board.areLocationsOnBoard(location)) {
            return false;
        }
        // is there a developer there?
        for(Developer dev : developers) {
            if(dev.getLocation().equals(location)) {
                if(developers != null && dev.equals(developer)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        if(board.getSpace(location).getTopTileComponent() != null) {
            board.getSpace(location).getTopTileComponent().accept(new PlacementVisitor());
            return allowed;
        }
        return false;
    }

    private class PlacementVisitor implements Visitor {

        public void visit(VillageTileComponent component) {
            allowed = true;
        }

        public void visit(RiceTileComponent component) {
            allowed = true;
        }

        public void visit(PalaceTileComponent component) {
            allowed = false;
        }

        public void visit(IrrigationTileComponent component) {
            allowed = false;
        }
    }
}
