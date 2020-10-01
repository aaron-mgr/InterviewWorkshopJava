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
        assertEquals(romanNumbers.convertRomanNumbers("xLi"), 41);
    }
    @Test
    public void test2() {
        assertEquals(romanNumbers.convertRomanNumbers("MLCXVI"), 1066);
    }
    @Test
    public void test3() {
        assertEquals(romanNumbers.convertRomanNumbers("MMMCMXCIX"), 3999);
    }
    @Test
    public void test4() {
        assertEquals(romanNumbers.convertRomanNumbers("X"), 10);
    }

    /**
     * Init - symbols mapping
     */
    public Map<Character, Integer> map = new HashMap<Character, Integer>();
    public RomanNumbersConverter() {
        /* support lowcase and capital characters */
        map.put('I', 1);
        map.put('X', 10);
        map.put('V', 5);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        map.put('i', 1);
        map.put('x', 10);
        map.put('v', 5);
        map.put('l', 50);
        map.put('c', 100);
        map.put('d', 500);
        map.put('m', 1000);
    }

    /**
     * Runs over numbers form less significant to most significant
     * If current roman number is less than previous - subtract it
     * otherwise add it.
     * @param roman number as string
     * @return decimal number
     */
    private long convertRomanNumbers(String roman) {
        long result = 0;
        char [] charArr = roman.toCharArray();
        int prev = 0;
        for (int i=charArr.length-1 ; i>=0; i--) {
            char curr = charArr[i];
            int currInt = map.get(curr);
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
