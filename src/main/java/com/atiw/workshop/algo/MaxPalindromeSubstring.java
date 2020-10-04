package com.aharon.workshop.algo;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Given a string, find the longest substring which is palindrome.
 */
public class MaxPalindromeSubstring {

    @Test
    public void test1() {
        assertEquals("max palindrome:", findMaxPalindromeO2("vvvdvdvvvhjlkdsfsapppas"), "vvvdvdvvv");
    }

    private static String findMaxPalindromeO2(String str) {
        System.out.println("======== findMaxPalindrome ========");
        char [] chars = str.toCharArray();
        String max = "";
        int len = chars.length;
        for (int i=len-1; i>0 ; i--) {
            for (int j=0 ; j<i ; j++) {
                if (isPalindrome(chars, j, i)) {
                    String sub = str.substring(j, i+1);
                    if (sub.length() > max.length()) {
                        max = sub;
                    }
                }
            }

        }

        return max;
    }

    private static boolean isPalindrome(char[] chars, int j, int i) {
        for (int x=0 ; x<(i-j)/2 ; x++) {
            if (chars[j+x] != chars[i-x]) {
                return false;
            } else {
                int p=0;
            }
        }
        return true;
    }


}
