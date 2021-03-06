package andi.zettel8.Aufgabe1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaesarTest {

    @Test
    void decode() {
        String a = Caesar.decode("HGXBO", 'W' , 'Z' );
        Assertions.assertEquals("KJAER", a);

        String b = Caesar.decode("DKKLAJ", 'n' , 'R' );
        Assertions.assertEquals("HOOPEN", b);

        String c = Caesar.decode("TUFSMJOH", 'A' , 'Z' );
        Assertions.assertEquals("STERLING", c);

        String d = Caesar.decode("VJGFKDDWM", 'E' , 'c' );
        Assertions.assertEquals("THEDIBBUK", d);

        String e = Caesar.decode("ZQJCAKJIWOPAN", 'W' , 'A' );
        Assertions.assertEquals("DUNGEONMASTER", e);

        String f = Caesar.decode("XHZRGFLGJSOFRNS", 'G' , 'B' );
        Assertions.assertEquals("SCUMBAGBENJAMIN", f);
    }
}