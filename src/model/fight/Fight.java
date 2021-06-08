package model.fight;

import java.util.Objects;

public class Fight {
	
	private final Trainer trainer1;
	private final Trainer trainer2;
	
	private Trainer currentTrainer;
	private int fightPlan;
	
	public Fight(Trainer trainer1, Trainer trainer2) {
		super();
		this.trainer1 = Objects.requireNonNull(trainer1);
		this.trainer2 = Objects.requireNonNull(trainer2);
		currentTrainer=trainer1;
		fightPlan=1;
	}
	
	public Trainer getTrainer1() {
		return trainer1;
	}


	public Trainer getTrainer2() {
		return trainer2;
	}



	public Trainer getCurrentTrainer() {
		return currentTrainer;
	}



	public Trainer getNonCurrentTrainer() {
		if(currentTrainer.equals(trainer1)) {
			return trainer2;
		}
		return trainer1;
	}
	
	/**
	 * Change sides
	 * @param 
	 * @return void
	 */
	public void nextTurn() {
		if(currentTrainer.equals(trainer1)) {
			currentTrainer=trainer2;
		}
		else {
			currentTrainer=trainer1;
		}
		switchPlan();
	}

	public int getFightPlan() {
		return fightPlan;
	}
	
	/**
	 * Switch fight plan
	 * @param 
	 * @return int Selected plan
	 */
	public int switchPlan() {
		if(fightPlan==0) {
			fightPlan=1;
			return fightPlan;
		}
		fightPlan=0;
		return fightPlan;
	}
	
	
	
	
}
