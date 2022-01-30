package Aufgabe1;

import Aufgabe1.exceptions.StateAlreadyExists;
import Aufgabe1.exceptions.StateDoesNotExist;
import Aufgabe1.exceptions.SymbolNotInAlphabet;
import Aufgabe1.exceptions.TransitionAlreadyExists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

// Draw.io
// https://drive.google.com/file/d/1nthF9xScnt5ChShMebu1REKovwWII2-E/view?usp=sharing
class DFATest {
    DFA dfa;

    @BeforeEach
    void setUp() throws StateAlreadyExists, SymbolNotInAlphabet, StateDoesNotExist, TransitionAlreadyExists {
        dfa = new DFA(new Alphabet(new Character[]{'a', 'b'}));
        dfa.addState(new State("q0", false), true);
        dfa.addState(new State("q1", false), false);
        dfa.addState(new State("q2", false), false);
        dfa.addState(new State("q3", false), false);
        dfa.addState(new State("q4", true), false);

        try {
            dfa.addState(new State("q0", true), false);
        } catch (StateAlreadyExists e) {
            assertInstanceOf(StateAlreadyExists.class, e);
        }

        dfa.makeTransition("q0", "q1", 'a');
        dfa.makeTransition("q0", "q0", 'b');

        dfa.makeTransition("q1", "q1", 'a');
        dfa.makeTransition("q1", "q2", 'b');

        dfa.makeTransition("q2", "q1", 'a');
        dfa.makeTransition("q2", "q3", 'b');

        dfa.makeTransition("q3", "q4", 'a');
        dfa.makeTransition("q3", "q0", 'b');

        dfa.makeTransition("q4", "q1", 'a');
        dfa.makeTransition("q4", "q0", 'b');

        dfa.reset();
    }

    @Test
    void makeTransition() throws SymbolNotInAlphabet, StateDoesNotExist, TransitionAlreadyExists {
        assertEquals("q2", dfa.getTransitions()[5].getStartID());
        assertEquals("q3", dfa.getTransitions()[5].getEndID());
        assertEquals('b', dfa.getTransitions()[5].getSymbol());

        try {
            dfa.makeTransition("q0", "q4", 'a');
        } catch (TransitionAlreadyExists e) {
            assertInstanceOf(TransitionAlreadyExists.class, e);
        }
        try {
            dfa.makeTransition("q8", "q7", 'a');
        } catch (StateDoesNotExist e) {
            assertInstanceOf(StateDoesNotExist.class, e);
        }
        try {
            dfa.makeTransition("q0", "q4", 'c');
        } catch (SymbolNotInAlphabet e) {
            assertInstanceOf(SymbolNotInAlphabet.class, e);
        }
    }

    @Test
    void delta() {
        assertEquals("q1", dfa.delta('a'));
        assertEquals("q2", dfa.delta('b'));
        assertEquals("q3", dfa.delta('b'));
        assertEquals("q4", dfa.delta('a'));

        assertEquals("q1", dfa.delta('a'));
        assertEquals("q2", dfa.delta('b'));
        assertEquals("q1", dfa.delta('a'));
        assertEquals("q1", dfa.delta('a'));
    }
}