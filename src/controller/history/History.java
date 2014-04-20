package controller.history;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Baker on 4/14/2014.
 */
public class History {
	Queue<Queue<Pair>> actions;
	Queue<Queue<Pair>> undoneActions;
	GameModel model;

	public History(GameModel model) {
		actions = new LinkedList<Queue<Pair>>();
		undoneActions = new LinkedList<Queue<Pair>>();
		actions.add(new LinkedList<Pair>());
		undoneActions.add(new LinkedList<Pair>());
	}

	public void addAction(Pair action) {
		Queue<Pair> latestTurn = actions.peek();
		latestTurn.add(action);
	}

	public void addEndTurn(Pair action) {
		Queue<Pair> latestTurn = actions.peek();
		latestTurn.add(action);
		actions.add(new LinkedList<Pair>());
	}

	public TimeTraveler rewindToBeginning() {
		while(!actions.isEmpty()) {
			Queue<Pair> reconstructedTurn = new LinkedList<Pair>();
			Queue<Pair> turn = actions.poll();
			while(!turn.isEmpty()) {
				reconstructedTurn.add(turn.poll());
			}
			undoneActions.add(reconstructedTurn);
		}
		redoActions();
		return new TimeTraveler(this, undoneActions, actions, model);
	}

	public TimeTraveler rewindTurns(int turns) {
		for(int i = 0; i < turns; i++) {
			undoneActions.add(actions.remove());
		}
		redoActions();
		return new TimeTraveler(this, undoneActions, actions, model);
	}

	public TimeTraveler rewindAction() {
		Queue<Pair> latestTurn = actions.peek();
		if(latestTurn.size() <= 1) {

		}
	}

	public TimeTraveler rewindActions() {

	}

	public void deleteTurns(int turns) {
		for(int i = 0; i < turns; i++) {
			actions.remove();
		}
		redoActions();
	}

	public void deleteLastAction() {
		actions.peek().remove();
		redoActions();
	}

	private void redoActions() {
		model.resetGame();
		for(Queue<Pair> t : actions) {
			for(Pair<ActionResult, Action> a : t) {
				a.getSecond().doAction(model);
			}
		}
	}
}
