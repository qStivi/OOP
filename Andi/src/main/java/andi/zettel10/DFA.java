package andi.zettel10;

import andi.zettel10.Exceptions.StateDoesNotExistException;
import andi.zettel10.Exceptions.SymbolNotInAlphabetException;
import andi.zettel10.Exceptions.TransitionAlreadyExistsException;

public class DFA extends GenericAutomaton {

    private String current;

    public DFA(Alphabet alphabet) {
        super(alphabet);
    }

    public String delta(Character symbol) {
        for (Transition element : transitions) {
            if (element.startID == current && element.symbol == symbol){
                current = element.endID;
                return current;
            }
        }
        return "";
    }

    public void makeTransition(String q1, String q2, Character symbol) throws TransitionAlreadyExistsException, SymbolNotInAlphabetException, StateDoesNotExistException {
        for (Transition element : transitions) {
            if (element.startID == q1 && element.endID == q2 && element.symbol == symbol) {
                throw new TransitionAlreadyExistsException();
            }
        }
        addTransition(new Transition(q1, q2, symbol));
    }

    @Override
    public void reset() {
        current = start;
    }

    @Override
    public boolean isAccepting() {
        State element = findState(current);
        if (element.acceptingState) {
            return true;
        }
        return false;
    }
}
