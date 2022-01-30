package andi.zettel10;

import andi.zettel10.Exceptions.StateAlreadyExistsException;
import andi.zettel10.Exceptions.StateDoesNotExistException;
import andi.zettel10.Exceptions.SymbolNotInAlphabetException;

import java.util.Arrays;

public abstract class GenericAutomaton {

    protected State[] states;
    protected Transition[] transitions;

    public Transition[] getTransitions() {
        return transitions;
    }

    protected Alphabet alphabet;
    protected String start;

    public GenericAutomaton(Alphabet alphabet) {
        this.alphabet = alphabet;
        this.start = null;
        this.transitions = null;
        this.states = null;
    }

    public abstract void reset();

    public abstract boolean isAccepting();

    protected void addTransition(Transition transition) throws StateDoesNotExistException, SymbolNotInAlphabetException {
        if (findState(transition.startID) == null) {
            throw new StateDoesNotExistException();
        }
        if (findState(transition.endID) == null) {
            throw new StateDoesNotExistException();
        }
        if (findSymbolInAlphabet(transition.SYMBOL)) {
            throw new SymbolNotInAlphabetException();
        }
        Transition[] newTransitions = Arrays.copyOf(transitions, transitions.length + 1);
        newTransitions[newTransitions.length - 1] = transition;
        this.transitions = newTransitions;
    }

    private boolean findSymbolInAlphabet(char symbol) {
        for (char element : alphabet.SYMBOLS) {
            if (element == symbol) {
                return true;
            }
        }
        return false;
    }

    public void addState(State state, boolean isStart) throws StateAlreadyExistsException {
        if (isStart) {
            start = state.ID;
        }
        if (states == null) {
            this.states = new State[]{state};
        } else {
            if (findState(state.ID) != null) {
                throw new StateAlreadyExistsException();
            }
            State[] newStates = Arrays.copyOf(states, states.length + 1);
            newStates[newStates.length - 1] = state;
            this.states = newStates;
        }
    }

    public State findState(String id) {
        for (State state : states) {
            if (state.ID.equals(id)) {
                return state;
            }
        }
        return null;
    }
}
