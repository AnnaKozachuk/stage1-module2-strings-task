package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String regex = String.join("|", delimiters);
        String[] parts = source.split(regex);
        List<String> substrings = new ArrayList<>();
        for (String part : parts) {
            if (!part.isEmpty()) {
                substrings.add(part.trim());
            }
        }
        return substrings;
    }
}
