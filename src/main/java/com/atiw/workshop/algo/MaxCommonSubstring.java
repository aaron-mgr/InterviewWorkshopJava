package com.atiw.workshop.algo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * find longest common substring for the given string
 *
 */
public class MaxSubstring {

    @Test
    public void test1() {
        assertEquals("max common substring:", findMaxCommonSubstring("vvvdvdvvvhjlkdsfsapppas", "fddddddvhjlpppppppp"), "vhjl");
    }
    @Test
    public void test2() {
        assertEquals("max common substring:", findMaxCommonSubstring("vvvdvdvvvhjlkdsfsapppas", "vvvdvdvvfddddddvhjlpppppppp"), "vvvdvdvv");
    }
    @Test
    public void test3() {
        assertEquals("max common substring:", findMaxCommonSubstring("121212121212121", "23232323232"), "2");
    }
    /**
     * The solution is based on matrix of str1 X str2 characters
     * Step 1: Put 1 in the matrix when str[i] == str[j]
     * Step 2: Find longest diagonal in the matrix
     * The complexity of the solution is O(n^2)
     * @param str1
     * @param str2
     * @return
     */
    private static String findMaxCommonSubstring(String str1, String str2) {
        System.out.println("======== findMaxSubstring ========");
        char [] chars1 = str1.toCharArray();
        char [] chars2 = str2.toCharArray();
        int [][] matrix = new int[chars1.length][chars2.length];

        // Init matrix on n*m. Set 1 when char in given position of str1 equals to str2
        for (int i=0; i<chars1.length; i++) {
            for (int j=0; j<chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    matrix[i][j] = 1;
                }
            }
        }
        printMatrix(matrix, chars1, chars2);
        // Actually we can combine this and previous loop, but I prefer to leave it for better understanding
        // of the algorithm.
        int max=0, maxI=0, maxJ=0;
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    matrix[i][j] += matrix[i-1][j-1];
                    if (matrix[i][j]>max) {
                        max = matrix[i][j];
                        maxI = i;
                        maxJ = j; // Not in use. For better understanding only
                    }
                }
            }
        }
        printMatrix(matrix, chars1, chars2);
        String result = str1.substring(maxI-max+1, maxI+1);
        return result;
    }

    private static void printMatrix(int[][] matrix, char[] chars1, char[] chars2) {
        System.out.print("\n\n   ");
        for (char c : chars2) {
            System.out.print("  " + c);
        }
        System.out.println();
        for (int i=0; i<matrix.length; i++) {
            System.out.print("  " + chars1[i]);
            for (int j=0; j < matrix[i].length; j++) {
                System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
