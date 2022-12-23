package com.pratice.codeWars.string;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class ShortestWord {
    public static int findShort(String s) {
        Pattern pattern = Pattern.compile("\\b\\S+\\b");
        Matcher matcher = pattern.matcher(s);
        int shortestCount = Integer.MAX_VALUE;
        String word = "";

        while (matcher.find()) {
            word = matcher.group();
            if (word.length() < shortestCount) shortestCount = word.length();
        }
        return shortestCount;
    }

    public static void main(String[] args) throws Exception {
        ShortestWordTest test = new ShortestWordTest();
        test.findShort();
    }
}

class ShortestWordTest {
    @Test
    public void findShort() throws Exception {
        assertEquals(3, ShortestWord.findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, ShortestWord.findShort("turns out random test cases are easier than writing out basic ones"));
        assertEquals(2, ShortestWord.findShort("Let's travel abroad shall we"));
    }

}
