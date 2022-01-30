package julian.zettel10.Aufgabe1;

public abstract class GenericAutomaton {

    private final Alphabet alphabet;
    private State[] states;
    private Transition[] transitions;
    private String start;

    public GenericAutomaton(Alphabet alphabet) {
        this.states = new State[0];
        this.transitions = new Transition[0];
        this.alphabet = alphabet;
        this.start = null;
    }

    public abstract void reset();

    public abstract boolean isAccepting();

    public void addState(State state, boolean isStart) throws StateAlreadyExists {

        for (State s : this.states) {
            if (s.getId().equals(state.getId())) {
                throw new StateAlreadyExists(s);
            }
        }

        State[] statesExpanded = new State[this.states.length + 1];
        for (int i = 0; i < this.states.length; i++) {
            statesExpanded[i] = this.states[i];
        }
        statesExpanded[statesExpanded.length - 1] = state;
        this.states = statesExpanded;

        if (isStart) {
            this.start = state.getId();
        }

    }

    public State findState(String id) {
        for (State s : states) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    protected void addTransition(Transition transition) throws StateDoesNotExist, SymbolNotInAlphabet {

        boolean containsIdStart = false;
        boolean containsIdEnd = false;

        for (State s : this.states) {
            if (s.getId().equals(transition.getIdStart())) {
                containsIdStart = true;
            }
            if (s.getId().equals(transition.getIdEnd())) {
                containsIdEnd = true;
            }
            if (containsIdStart && containsIdEnd) {
                break;
            }
        }

        if (!containsIdStart) {
            throw new StateDoesNotExist(transition.getIdStart());
        }

        if (!containsIdEnd) {
            throw new StateDoesNotExist(transition.getIdEnd());
        }

        boolean containsSymbol = false;

        for (Character c : this.alphabet.getAvailableSymbols()) {
            if (c.equals(transition.getSymbol())) {
                containsSymbol = true;
                break;
            }
        }

        if (!containsSymbol) {
            throw new SymbolNotInAlphabet(transition.getSymbol());
        }

        Transition[] transitionsExpanded = new Transition[this.transitions.length + 1];

        for (int i = 0; i < this.transitions.length; i++) {
            transitionsExpanded[i] = this.transitions[i];
        }
        transitionsExpanded[transitionsExpanded.length - 1] = transition;
        this.transitions = transitionsExpanded;
    }

    public State[] getStates() {
        return states;
    }

    public Transition[] getTransitions() {
        return transitions;
    }

    public String getStart() {
        return start;
    }


}
