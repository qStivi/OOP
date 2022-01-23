package Aufgabe1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PRNDLTest {

    @Test
    void isReverse1() {
        assertTrue(PRNDL.isReverse("AbBA", "ABBa"));
    }

    @Test
    void isReverse3() {
        assertTrue(PRNDL.isReverse("Reliefpfeiler", "Reliefpfeiler"));
    }

    @Test
    void isReverse7() {
        assertTrue(PRNDL.isReverse("Bei der Edna redete der andere Dieb".replace(" ", ""), "Bei der Edna redete der andere Dieb".replace(" ", "")));
    }

    @Test
    void isReverse4() {
        assertFalse(PRNDL.isReverse("Bei der Edna redete der andere Dieb", "Bei der Edna redete der andere Dieb"));
    }

    @Test
    void isReverse6() {
        assertTrue(PRNDL.isReverse("Haus", "Suah"));
    }

    @Test
    void isReverse2() {
        assertFalse(PRNDL.isReverse("Haus", "HAUS"));
    }

    @Test
    void isReverse5() {
        assertFalse(PRNDL.isReverse("Handy", "Handy"));
    }

    @Test
    void isReverse8() {
        assertFalse(PRNDL.isReverse("yee", "eeye"));
    }
}