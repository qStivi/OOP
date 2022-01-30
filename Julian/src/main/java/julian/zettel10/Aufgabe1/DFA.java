package julian.zettel10.Aufgabe1;

public class DFA extends GenericAutomaton {

    private String current; //Id aktueller Zustand

    public DFA(Alphabet alphabet) {
        super(alphabet);
    }

    @Override
    public void reset() {
        this.current = super.getStart();
    }

    @Override
    public boolean isAccepting() { //ist aktueller Zustand akzeptierend
        for (State s : super.getStates()) {
            if (s.getId().equals(current)) {
                return s.isAcceptState();
            }
        }
        return false;
    }

    public void makeTransitions(String q1, String q2, Character symbol) throws TransitionAlreadyExists, SymbolNotInAlphabet, StateDoesNotExist {

        for (Transition t : super.getTransitions()) {
            if (t.getIdStart().equals(q1) && t.getSymbol().equals(symbol)) {
                throw new TransitionAlreadyExists(t);
            }
        }

        super.addTransition(new Transition(q1, q2, symbol));
    }

    public String delta(Character symbol) {
        for (Transition t : super.getTransitions()) {
            if (t.getIdStart().equals(current) && t.getSymbol().equals(symbol)) {
                current = t.getIdEnd();
            }
        }
        return current;
    }
}
