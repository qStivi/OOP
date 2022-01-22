package de.qStivi.zettel9.Aufgabe2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplaceTest {

    @Test
    void replace1() {
        assertEquals("a", Replace.replace("aaa", "aa", "a"));
    }

    @Test
    void replace2() {
        assertEquals("aus", Replace.replace("Maus", "M", ""));
    }

    @Test
    void replace3() {
        assertEquals("Draußen", Replace.replace("Drache", "che", "ußen"));
    }

    @Test
    void replace4() {
        assertEquals("Drache", Replace.replace("Drache", "xyz", "ußen"));
    }
}