package controller.history;

import controller.Controller;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;

import java.util.Stack;
import java.util.Stack;

/**
 * Created by Baker on 4/14/2014.
 */
public class TimeTraveler {
	Stack<Stack<Pair>> undoneActions;
	Stack<Pair> doneActions;
	Stack<Stack<Pair>> actions;
	GameModel model;
	Controller controller;
	History history;

	public TimeTraveler(Controller controller, History history, Stack<Stack<Pair>> undoneActions, Stack<Stack<Pair>> actions, GameModel model) {
		this.history = history;
		this.controller = controller;
		this.undoneActions = undoneActions;
		doneActions = new Stack<Pair>();
		this.actions = actions;
		this.model = model;
	}

	public boolean hasNext() {
		return (!undoneActions.isEmpty());
	}

	public void next() {
		Stack<Pair> latestTurn = undoneActions.peek();
		Pair<ActionResult, Action> pair = latestTurn.pop();
		doneActions.add(pair);
		pair.getSecond().doAction();
		controller.refreshGameView();

		if(latestTurn.size() < 1) {
			undoneActions.pop();
		}
		history.addAction(pair);
	}

	public void back() {
		if(!doneActions.isEmpty()) {
			history.rewindAction();
			doneActions.pop();
		}
	}
}
