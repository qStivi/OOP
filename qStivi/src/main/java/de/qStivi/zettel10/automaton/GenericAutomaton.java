package de.qStivi.zettel10.automaton;

import de.qStivi.zettel10.exceptions.StateAlreadyExists;
import de.qStivi.zettel10.exceptions.StateDoesNotExist;
import de.qStivi.zettel10.exceptions.SymbolNotInAlphabet;

import java.util.Arrays;

public abstract class GenericAutomaton {
    protected final Alphabet alphabet;
    protected Transition[] transitions;
    protected State[] states;
    protected String start;

    public GenericAutomaton(Alphabet alphabet) {
        this.states = null;
        this.transitions = null;
        this.alphabet = alphabet;
        this.start = null;
    }

    public Transition[] getTransitions() {
        return transitions;
    }

    protected abstract void reset();

    protected abstract boolean isAccepting();

    /**
     * Adds a non-existent state to the {@link GenericAutomaton} and optionally sets the start state.
     *
     * @param state   the state to be added
     * @param isStart whether it should be the start state or not
     * @throws StateAlreadyExists when a {@link State} with the same ID already exists in {@link GenericAutomaton}
     */
    public void addState(State state, boolean isStart) throws StateAlreadyExists {
        if (states == null) {
            states = new State[0];
        }
        for (State s : states) {
            if (s.getID().equals(state.getID())) {
                throw new StateAlreadyExists();
            }
        }
        if (isStart) {
            this.start = state.getID();
        }
        var newStates = Arrays.copyOf(states, states.length + 1);
        newStates[states.length] = state;
        states = Arrays.copyOf(newStates, newStates.length);
    }

    /**
     * Returns the {@link State} corresponding to the given ID.
     *
     * @param id is the id of the {@link State} to be found
     * @return {@link State} or null if no {@link State} with the given ID was found
     */
    public State findState(String id) {
        for (State state : states) {
            if (state.getID().equals(id)) {
                return state;
            }
        }
        return null;
    }

    /**
     * Add a {@link Transition} to {@link GenericAutomaton} if all pre-conditions are met.
     *
     * @param transition the {@link Transition} to be added
     * @throws StateDoesNotExist   when at least one of the states in the {@link Transition} does not exist in {@link GenericAutomaton}
     * @throws SymbolNotInAlphabet when the symbol of {@link Transition} is not part of the {@link Alphabet}
     */
    protected void addTransition(Transition transition) throws StateDoesNotExist, SymbolNotInAlphabet {
        if (transitions == null) {
            transitions = new Transition[0];
        }
        if (!alphabet.contains(transition.getSymbol())) {
            throw new SymbolNotInAlphabet();
        }
        for (Transition t : transitions) {
            if (findState(t.getStartID()) == null || findState(t.getEndID()) == null) {
                throw new StateDoesNotExist();
            }
        }
        var newTransitions = Arrays.copyOf(transitions, transitions.length + 1);
        newTransitions[transitions.length] = transition;
        transitions = Arrays.copyOf(newTransitions, newTransitions.length);
    }
}
