package controller.history;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Baker on 4/14/2014.
 */
public class TimeTraveler {
	Queue<Queue<Pair>> undoneActions;
	Queue<Pair> doneActions;
	Queue<Queue<Pair>> actions;
	GameModel model;
	History history;

	public TimeTraveler(History history, Queue<Queue<Pair>> undoneActions, Queue<Queue<Pair>> actions, GameModel model) {
		this.history = history;
		this.undoneActions = undoneActions;
		this.actions = actions;
		this.model = model;
	}

	public boolean hasNext() {
		return (!undoneActions.isEmpty());
	}

	public void next() {
		Queue<Pair> latestTurn = undoneActions.peek();
		Pair<ActionResult, Action> pair = latestTurn.poll();
		doneActions.add(pair);
		pair.getSecond().doAction(model);

		if(latestTurn.size() < 1) {
			undoneActions.poll();
			history.addEndTurn(pair);
		}
		else {
			history.addAction(pair);
		}
	}

	public void back() {
		if(!doneActions.isEmpty()) {
			history.rewindAction();
			doneActions.poll();
		}
	}
}
