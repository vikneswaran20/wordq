package org.wordq;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordQTest {

    @Test
    @DisplayName("Append values")
    void testAppendValues() {
        assertAll("should append all the given strings to the input string",
                () -> assertEquals("HelloWorld",
                        new WordQ("Hello")
                                .append("World")
                                .toString()),

                () -> assertEquals("HelloWorld!",
                        new WordQ("Hello")
                                .append("World", "!")
                                .toString()),

                () -> assertEquals("HelloWorld! WordQ",
                        new WordQ("Hello")
                                .append("World", "!")
                                .append(" WordQ")
                                .toString())
        );
    }

    @Test
    @DisplayName("Append Array")
    void testAppendArray() {
        assertAll("should append all the given strings to the input string",
                () -> assertEquals("HelloWorld",
                        new WordQ("Hello").
                                appendArray(new String[]{"World"})
                                .toString()),

                () -> assertEquals("HelloWorld!",
                        new WordQ("Hello").
                                appendArray(new String[]{"World", "!"})
                                .toString()),

                () -> assertEquals("HelloWorld! WordQ",
                        new WordQ("Hello")
                                .appendArray(new String[]{"World", "!"})
                                .appendArray(new String[]{" WordQ"})
                                .toString())
        );
    }

    @Test
    @DisplayName("Join Array")
    void testJoinArray() {
        assertAll("should Join all the given string array with delimiter",
                () -> assertEquals("Hello, World",
                        new WordQ("Hello").
                                join(new String[]{"World"}, ", ")
                                .toString()),

                () -> assertEquals("Apple, Banana, Carrot, Beans, Radish",
                        new WordQ().
                                join(new String[]{"Apple", "Banana", "Carrot", "Beans", "Radish"}, ", ")
                                .toString())
        );
    }

    @Test
    @DisplayName("Strip White Spaces")
    void testStripWhiteSpace() {
        assertAll("should strip all the white spaces in the given String",
                () -> assertEquals("strippedword",
                        new WordQ(" stripped word ")
                                .stripWhiteSpace()
                                .toString()),

                () -> assertEquals("word",
                        new WordQ("word")
                                .stripWhiteSpace()
                                .toString())
        );
    }
}