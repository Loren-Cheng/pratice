package com.pratice.codeWars.hash;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Isograms {

    public Isograms() {
    }

    public static boolean isIsogram(String str) {
        // ...

        if (str.length() == 0) {
            return true;
        }
        str = str.toLowerCase();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char charAtI = str.charAt(i);
            if (!set.contains(charAtI)) {
                set.add(charAtI);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            Tests.FixedTests();
        } catch (Exception e) {

        }
    }
}

class Tests {
    @Test
    public static void FixedTests() {
        assertEquals(true, Isograms.isIsogram("Dermatoglyphics"));
        assertEquals(true, Isograms.isIsogram("isogram"));
        assertEquals(false, Isograms.isIsogram("moose"));
        assertEquals(false, Isograms.isIsogram("isIsogram"));
        assertEquals(false, Isograms.isIsogram("aba"));
        assertEquals(false, Isograms.isIsogram("moOse"));
        assertEquals(true, Isograms.isIsogram("thumbscrewjapingly"));
        assertEquals(true, Isograms.isIsogram(""));
    }
}

