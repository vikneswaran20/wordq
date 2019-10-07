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
                                .toString()),

                () -> assertThrows(NullPointerException.class, () -> {
                    new WordQ().append(null);
                })
        );
    }

    @Test
    @DisplayName("Append Array")
    void testAppendArray() {
        assertAll("should append all the given strings to the input string",
                () -> assertEquals("HelloWorld",
                        new WordQ("Hello")
                                .appendArray(new String[]{"World"})
                                .toString()),

                () -> assertEquals("HelloWorld!",
                        new WordQ("Hello")
                                .appendArray(new String[]{"World", "!"})
                                .toString()),

                () -> assertEquals("HelloWorld! WordQ",
                        new WordQ("Hello")
                                .appendArray(new String[]{"World", "!"})
                                .appendArray(new String[]{" WordQ"})
                                .toString()),

                () -> assertThrows(NullPointerException.class, () -> {
                    new WordQ().appendArray(null);
                })
        );
    }

    @Test
    @DisplayName("Join Array")
    void testJoinArray() {
        assertAll("should Join all the given string array with delimiter",
                () -> assertEquals("Hello, World",
                        new WordQ("Hello")
                                .join(new String[]{"World"}, ", ")
                                .toString()),

                () -> assertEquals("Apple, Banana, Carrot, Beans, Radish",
                        new WordQ()
                                .join(new String[]{"Apple", "Banana", "Carrot", "Beans", "Radish"}, ", ")
                                .toString()),

                () -> assertThrows(NullPointerException.class, () -> {
                    new WordQ().join(null, ", ");
                }),

                () -> assertThrows(NullPointerException.class, () -> {
                    new WordQ().join(new String[]{"Hello", "World"}, null);
                })
        );
    }

    @Test
    @DisplayName("Insert String")
    void testInsert() {
        assertAll("should insert the given string at specified position",
                () -> assertEquals("WordQ",
                        new WordQ("WdQ")
                                .insert("or", 1)
                                .toString()),

                () -> assertEquals("WordQ",
                        new WordQ()
                                .insert("WordQ", 0)
                                .toString()),

                () -> assertThrows(NullPointerException.class, () -> {
                    new WordQ().insert(null, 0);
                })
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