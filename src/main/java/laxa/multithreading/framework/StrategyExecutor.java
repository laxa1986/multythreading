package laxa.multithreading.framework;

import laxa.multithreading.task.readwrite.strategy.Strategy;

/**
 * Author: Chekulaev Alexey
 * Date: 08.03.12
 */
public class StrategyExecutor implements Runnable {
	public static final ThreadLocal<Action> actionHolder = new ThreadLocal<Action>();
	
	private Strategy strategy;
	private Action action;
	
	public StrategyExecutor(Strategy strategy, Action action) {
		this.strategy = strategy;
		this.action = action;
	}

	@Override
	public void run() {
		StrategyExecutor.actionHolder.set(action);
		int startDelay = action.getStartDelay();
		if (startDelay > 0) {
			ThreadHelper.sleep(startDelay);
		}
		
		if (action.isRead()) {
			strategy.read();
		} else {
			strategy.write(this);
		}
	}
}