/*
 * MIT License
 *
 * Copyright (c) 2019 Vikneswaran
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.wordq;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * A library for string operations and string manipulations.
 *
 * <p>The collection of utility methods for string operations and string manipulations</p>.
 *
 * @author Vikneswaran
 * @since 1.0
 */
public class WordQ {
    private String input;

    /**
     * Assigns the empty String to the input.
     */
    public WordQ() {
        this.input = "";
    }

    /**
     * Assigns input String.
     *
     * @param input Initial input String.
     */
    public WordQ(String input) {
        Objects.requireNonNull(input, "The input string must not be null");
        this.input = input;
    }

    /**
     * Appends the given string(s) to the existing string.
     *
     * @param value Input String(s).
     * @return The WordQ reference.
     */
    public WordQ append(String... value) {
        Objects.requireNonNull(value, "The input string must not be null");
        return appendArray(value);
    }

    /**
     * Appends the given array of string(s) to the existing string.
     *
     * @param values Input String array.
     * @return The WordQ reference.
     */
    public WordQ appendArray(String[] values) {
        Objects.requireNonNull(values, "The input string must not be null");

        StringBuilder stringBuilder = new StringBuilder(input);
        Arrays.stream(values).forEach(value -> stringBuilder.append(value));

        input = stringBuilder.toString();
        return this;
    }

    /**
     * Joins the array of strings with given delimiter.
     *
     * @param values    Array of input Strings.
     * @param delimiter separator for the resultant string.
     * @return The WordQ reference
     */
    public WordQ join(String[] values, final String delimiter) {
        Objects.requireNonNull(values, "The input string must not be null");
        Objects.requireNonNull(delimiter, "The input delimiter must not be null");

        StringJoiner stringJoiner = new StringJoiner(delimiter);
        Arrays.stream(values).forEach(value -> stringJoiner.add(value));

        input = (input.length() > 0) ? String.join(delimiter, input, stringJoiner.toString()) : stringJoiner.toString();
        return this;
    }

    /**
     * Insert the given string at the specified index.
     *
     * @param value Input value.
     * @param index index to insert.
     * @return The WordQ reference.
     */
    public WordQ insert(String value, int index) {
        Objects.requireNonNull(value, "The input string must not be null");

        if (index > input.length() || index < 0 || "".equals(value)) {
            return this;
        }

        this.input = input.substring(0, index).concat(value).concat(input.substring(index));

        return this;
    }

    /**
     * Removes all the white spaces in the string
     *
     * @return The WordQ reference
     */
    public WordQ stripWhiteSpace() {
        input = input.replaceAll("\\s", "");
        return this;
    }

    /**
     * Returns the manipulated string,
     *
     * @return The manipulated String object.
     */
    @Override
    public String toString() {
        return this.input;
    }
}
