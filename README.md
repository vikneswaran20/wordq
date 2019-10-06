# WordQ

**WordQ** is the String manipulation library for Java 8 with builder support.

```java
import org.wordq.WordQ;

String formattedString=new WordQ("  Word Q  ")
        .stripWhiteSpace()
        .append(" will", " format")
        .join(new String[]{"the", "java", "Strings"}, " ")
        .toString();

// formattedString => WordQ will format the java Strings
```

**WordQ** contains the set of utility functions for String manipulate and perform operations over the Strings. The library is completely tested and documented.
 
# Inspiration
This library is inspired by 
- [VOCA js](https://vocajs.com)
- [string.js](https://github.com/jprichardson/string.js)
- [Stringy](https://github.com/danielstjules/Stringy)

# License
Released under the [MIT License](https://github.com/vikneswaran20/wordq/blob/master/LICENSE)