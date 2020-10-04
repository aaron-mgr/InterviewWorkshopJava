package com.atiw.workshop.algo;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Find Pythagorean triple in SORTED array
 */
public class PythagoreanTriple {
    @Test
    public void test1() {
        assertArrayEquals("contains Pythagorean Triple:", containsPythagoreanTriple_On2(new int[] {1,2,3,4,5}), new int [] {3, 4});
    }

    @Test
    public void test2() {
        assertArrayEquals("Not contains Pythagorean Triple:", containsPythagoreanTriple_On2(new int[]{1, 2, 3, 5, 6}), new int[]{0, 0});
    }

    /**
     * O(N^2) solution
     */
    private int[] containsPythagoreanTriple_On2(int[] ints) {
        int [] result = new int [] {0, 0};
        Set<Integer> set = new HashSet<>();
        for (int x: ints) {
            set.add(x*x);
        }

        for (int i=0; i<ints.length ; i++) {
            for (int j=i+1 ; j<ints.length; j++) {
                int res = (int)Math.pow(ints[i], 2) + (int)Math.pow(ints[j], 2);
                if (set.contains(res)) {
                    result[0] = ints[i];
                    result[1] = ints[j];
                    return result;
                }
            }
        }
        return result;
    }


//    private int[] containsPythagoreanTriple_On(int[] ints) {
//        int [] result = new int [] {0, 0};
//        int i=0, j=1, curr=2;
//        while(true) {
//            int res = (int)Math.sqrt(ints[i]) + (int)Math.sqrt(ints[j]);
//            while (true) {
//                if ((int)Math.sqrt(ints[curr]) == res) {
//                    result[0] = ints[i];
//                    result[1] = ints[j];
//                    return result;
//                }
//                if (ints[curr] < res) {
//                    curr++;
//                    if (curr >= ints.length) {
//                        return result;
//                    }
//                }
//                else
//                    return result;
//            }
//
////            if (currentpos > arr.length) {
////                break;
////            }
//
//        }
//    }

}
