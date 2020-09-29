package com.aharon.workshop;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

/**
 * Convert roman numbers to decimal
 */

public class RomanNumbersConverter {


    static RomanNumbersConverter romanNumbers = new RomanNumbersConverter();

    @Test
    public void test1() {
        assertEquals(romanNumbers.convertRomanNumbers("XLI"), 41);
    }
    @Test
    public void test2() {
        assertEquals(romanNumbers.convertRomanNumbers("MLCXVI"), 1066);
    }@Test
    public void test3() {
        assertEquals(romanNumbers.convertRomanNumbers("MMMCMXCIX"), 3999);
    }@Test
    public void test4() {
        assertEquals(romanNumbers.convertRomanNumbers("X"), 10);
    }

    private static void testRoman(String roman, int decimal) {
        int result = romanNumbers.convertRomanNumbers(roman);
        if (result != decimal) {
            throw new RuntimeException("Wrong result supposed:" + decimal + " get:" + result);
        }
        System.out.println("Input: " + roman + " Result:" + result);

    }


    public Map<String, Integer> map = new HashMap<String, Integer>();

    public RomanNumbersConverter() {
        map.put("I", 1);
        map.put("X", 10);
        map.put("V", 5);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);


    }

    private int convertRomanNumbers(String roman) {

        int result = 0;
        char [] charArr = roman.toCharArray();
        int prev = 0;

        for (int i=charArr.length-1 ; i>=0; i--) {

            char curr = charArr[i];
            int currInt = map.get(String.valueOf(curr)); // TODO use character
            if (currInt < prev) {
                result = result - currInt;
            } else {
                result = result + currInt;
            }
            prev = currInt;

        }
        return result;
    }

}
