package controller.history;

import controller.Controller;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;

import java.util.Iterator;
import java.util.Stack;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Baker on 4/14/2014.
 */
public class History {
	Stack<Stack<Pair>> actions;
	Stack<Stack<Pair>> undoneActions;
	GameModel model;
	Controller controller;

	public History(Controller controller, GameModel model) {
		this.controller = controller;
		this.model = model;

		actions = new Stack<Stack<Pair>>();
		undoneActions = new Stack<Stack<Pair>>();
		actions.add(new Stack<Pair>());
		undoneActions.add(new Stack<Pair>());
	}

	public void addAction(Pair action) {
		if(actions.size() == 0) actions.add(new Stack<Pair>());
		Stack<Pair> latestTurn = actions.peek();
		latestTurn.add(action);
	}

	public void addEndTurn(Pair action) {
		Stack<Pair> latestTurn = actions.peek();
		latestTurn.add(action);
		actions.add(new Stack<Pair>());
	}

	public TimeTraveler rewindToBeginning() {
		while(!actions.isEmpty()) {
			Stack<Pair> reconstructedTurn = new Stack<Pair>();
			Stack<Pair> turn = actions.pop();
			while(!turn.isEmpty()) {
				reconstructedTurn.add(turn.pop());
			}
			if(undoneActions.peek().size() == 0) undoneActions.pop();
			if(reconstructedTurn.size() != 0) undoneActions.add(reconstructedTurn);
		}
		redoActions();
		return new TimeTraveler(controller, this, undoneActions, actions, model);
	}

	public TimeTraveler rewindTurns(int turns) {
		for(int i = 0; i < turns; i++) {
			Stack<Pair> reconstructedTurn = new Stack<Pair>();
			Stack<Pair> turn = actions.pop();
			while(!turn.isEmpty()) {
				reconstructedTurn.add(turn.pop());
			}
			undoneActions.add(reconstructedTurn);
			if(actions.isEmpty()) {
				actions.add(new Stack<Pair>());
				break;
			}
		}
		redoActions();
		return new TimeTraveler(controller, this, undoneActions, actions, model);
	}

	public TimeTraveler rewindAction() {
		Stack<Pair> latestTurn = actions.peek();
		if(latestTurn.size() <= 0) {
			actions.pop();
			if(actions.isEmpty()) {
				actions.add(new Stack<Pair>());
			}
			undoneActions.add(new Stack<Pair>());
		}
		if(!latestTurn.isEmpty()) undoneActions.peek().add(latestTurn.pop());
		redoActions();
		return new TimeTraveler(controller, this, undoneActions, actions, model);
	}

	public TimeTraveler rewindActions(int actionCount) {
		for(int i = 0; i < actionCount; i++) {
			rewindAction();
		}
		return new TimeTraveler(controller, this, undoneActions, actions, model);
	}

	public void deleteTurns(int turns) {
		for(int i = 0; i < turns; i++) {
			actions.pop();
		}
		redoActions();
	}

	public void deleteLastAction() {
		actions.peek().pop();
		redoActions();
	}

	private void redoActions() {
		model.resetStates();
		for(Stack<Pair> t : actions) {
			for(Pair<ActionResult, Action> a : t) {
				a.getSecond().doAction();
			}
		}
		controller.refreshGameView();
	}
}
