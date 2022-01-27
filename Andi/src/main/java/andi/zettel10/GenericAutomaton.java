package andi.zettel10;

import java.util.Arrays;

public abstract class GenericAutomaton {

    protected State[] states;
    protected Transition[] transitions;
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

    protected void addTransition(Transition transition){

    }

    public void addState(State state, boolean isStart) throws StateAlreadyExists {
        if (isStart) {
            start = state.ID;
        }
        if (states == null) {
            this.states = new State[]{state};
        } else {
                if (findState(state.ID) != null) {
                    throw new StateAlreadyExists();
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
