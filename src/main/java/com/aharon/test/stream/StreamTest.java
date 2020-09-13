package com.aharon.test.stream;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(20, 1,55, 33, 12, 6, 9, 100);

        sumSimpleReduce(integerList);
        sumReduce(integerList);
        sumMapToint(integerList);
        sumCollectors(integerList);
        sumCollector(integerList);
        sumCollectorFilter(integerList, new HashSet<>(Arrays.asList(20, 100)));
        max(integerList);
        findMaxPalindrome("vvvdvdvvvhjlkdsfsapppas");
    }

    private static void findMaxPalindrome(String str) {
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
        System.out.printf("[%s]\n", max);
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


    private static void sumCollectorFilter(List<Integer> integerList, Set<Integer> toFilter) {
        System.out.println("======== sumCollectorFilter ========");
        int sum = integerList.stream().filter(not(toFilter::contains)).mapToInt(x->x).sum();
        System.out.format("sum=%d\n", sum);
    }

    private static void max(List<Integer> integerList) {
        System.out.println("======== max ========");
        Optional<Integer> max = integerList.stream().max(Integer::compare);
        System.out.format("max=%d\n", max.orElse(Integer.MAX_VALUE));
    }

    private static Predicate<Integer> not(Predicate<Integer> predicate) {
        return predicate.negate();
    }

    private static void sumCollector(List<Integer> integerList) {
        System.out.println("======== sumCollector ========");
        int sum = integerList.stream().mapToInt(x->x).sum();
        System.out.format("sum=%d\n", sum);
    }

    private static void sumCollectors(List<Integer> integerList) {
        System.out.println("======== sumCollectors ========");
        int sum = integerList.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.format("sum=%d\n", sum);
    }

    private static void sumMapToint(List<Integer> integerList) {
        System.out.println("======== sumMapToint ========");
        AtomicInteger sum =  new AtomicInteger(0);
        integerList.stream().map(x -> {
            sum.addAndGet(x.intValue());
            System.out.printf("x={%d} val={%d} res={%d}\n" , x, x.intValue(), sum.get());
            return x.intValue();
        })
        .count();
        System.out.format("sum=%d\n", sum.get());
    }

    private static void sumSimpleReduce(List<Integer> integerList) {
        System.out.println("======== sumSimpleReduce ========");
        int sum = integerList.stream().reduce(0, Integer::sum);

        System.out.println("sum=" + sum);
    }

    private static void sumReduce(List<Integer> integerList) {
        System.out.println("======== sumReduce ========");
        int sum = integerList.stream().reduce(0, (x, y) -> {
            int z = x + y;
            System.out.format("x={%d} y={%d} res={%d}\n" , x, y, z);
            return z;
        });
        System.out.println("sum=" + sum);
    }
}
