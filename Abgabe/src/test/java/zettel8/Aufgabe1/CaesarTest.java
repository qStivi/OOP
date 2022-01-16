package zettel8.Aufgabe1;


import Aufgabe1.Caesar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaesarTest {

    @Test
    void decode1() {
        Assertions.assertEquals("KJAER", Caesar.decode("HGXBO", 'W', 'Z'));
    }

    @Test
    void decode2() {
        Assertions.assertEquals("HOOPEN", Caesar.decode("DKKLAJ", 'n', 'R'));
    }

    @Test
    void decode3() {
        Assertions.assertEquals("STERLING", Caesar.decode("TUFSMJOH", 'A', 'Z'));
    }

    @Test
    void decode4() {
        Assertions.assertEquals("THEDIBBUK", Caesar.decode("VJGFKDDWM", 'E', 'c'));
    }

    @Test
    void decode5() {
        Assertions.assertEquals("DUNGEONMASTER", Caesar.decode("ZQJCAKJIWOPAN", 'W', 'A'));
    }

    @Test
    void decode6() {
        Assertions.assertEquals("SCUMBAGBENJAMIN", Caesar.decode("XHZRGFLGJSOFRNS", 'G', 'B'));
    }
}