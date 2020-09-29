package com.aharon.workshop;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * get array of N members
 * returns array af follows for each i => a[i] = a[0]*A[1]*...*a[i-1]*a[i+1]*...
 * multiplication of all members except i
 */
public class MultiplyArray {

    @Test
    public void test1() {
        MultiplyArray multiplyArray  = new MultiplyArray();
        int [] input = new int [] {1, 2, 3, 4, 5};
        assertArrayEquals("result:", calculateMulti(input), new int [] {120,  60, 40, 30, 24});
    }

    private int[] calculateMulti(int[] ints) {
        if (ints == null || ints.length == 0) {
            return new int[0];
        }
        int [] result = new int[ints.length];
        int multi = 1;
        for (int i=0 ; i< ints.length ; i++) {
            multi = multi * ints[i];
        }
        for (int i=0 ; i< ints.length ; i++) {
            result[i] = multi/ints[i];
        }
        return result;
    }


    /**
     * 1,     2,  3,  4,  5
     *
     * 1,     1,  2,  6, 24 = a
     * 120,  60, 40, 30, 24
     *
     */
}
