package de.tum.in.ase.eist;

public interface Observer<T> {

	void onUpdate(T newState);
}
