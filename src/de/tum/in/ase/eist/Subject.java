package de.tum.in.ase.eist;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Subject<T> {

	private final Set<Observer<T>> observers = new HashSet<>();

	public void addObserver(Observer<T> observer) {
		Objects.requireNonNull(observer);
		observers.add(observer);
	}

	public void removeObserver(Observer<T> observer) {
		Objects.requireNonNull(observer);
		observers.remove(observer);
	}

	protected void notifyObservers(final T newState) {
		observers.forEach(x -> x.onUpdate(newState));
		//TODO Task 1.1: Iterate through the observers and notify every observer about the new state
	}
}
