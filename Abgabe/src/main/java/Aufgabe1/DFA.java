package Aufgabe1;

import Aufgabe1.exceptions.StateDoesNotExist;
import Aufgabe1.exceptions.SymbolNotInAlphabet;
import Aufgabe1.exceptions.TransitionAlreadyExists;

public class DFA extends GenericAutomaton {
    private String current;

    public DFA(Alphabet alphabet) {
        super(alphabet);
        reset();
    }

    @Override
    public void reset() {
        this.current = start;
    }

    @Override
    protected boolean isAccepting() {
        return findState(current).isAccepting();
    }

    /**
     * Adds a new {@link Transition} to {@link DFA} if all pre-conditions are met.
     *
     * @param q1     is the starting {@link State} id
     * @param q2     is the ending {@link State} id
     * @param symbol is the {@link Transition} symbol
     * @throws SymbolNotInAlphabet     see {@link GenericAutomaton}.addTransition();
     * @throws StateDoesNotExist       see {@link GenericAutomaton}.addTransition();
     * @throws TransitionAlreadyExists when a transition with the given start {@link State} id and {@link Transition} symbol already exists in {@link  GenericAutomaton}
     */
    public void makeTransition(String q1, String q2, Character symbol) throws SymbolNotInAlphabet, StateDoesNotExist, TransitionAlreadyExists {
        if (transitions == null) {
            addTransition(new Transition(q1, q2, symbol));
            return;
        }
        for (Transition transition : transitions) {
            if (transition.getStartID().equals(q1) && transition.getSymbol().equals(symbol)) {
                throw new TransitionAlreadyExists(transition.getStartID(), transition.getSymbol());
            }
        }
        addTransition(new Transition(q1, q2, symbol));
    }

    public String delta(Character symbol) {
        for (Transition transition : transitions) {
            if (transition.getStartID().equals(current) && transition.getSymbol().equals(symbol)) {
                var id = transition.getEndID();
                current = id;
                return id;
            }
        }
        return null;
    }
}
