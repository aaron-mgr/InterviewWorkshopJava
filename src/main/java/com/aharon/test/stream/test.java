package com.aharon.test.stream;

import java.util.HashSet;

public class test {

    arr =[1,2,3,4,5]

    def containsPythagoreanPair(arr):
            3^2 + 4^2 = 5^2
    YES


    Set results = new HashSet<>();
    for (x in arr) {
        result.add(x*x);
    }

    for (i=0; i< arr.length ; i++) {
        for (j=i+1 ; j< arr.length; j++) {
            res = arr[i]^2 + arr[j]^2;
            if (resilts.contains(res))
                return true;
        }
    }

    1^2+2^2
    1^2+3^2


    n*n




    arr=;
    currpos = 2;
    int i=0,j=1;
    for (i=0; i< arr.length ; i++) {
        for (j=i+1 ; j< arr.length; j++) {
            int currentpos = j+1;

            res = arr[i] ^ 2 + arr[j] ^ 2;
            while (true) {
                if (arr[currpos] ^ 2 == res) return true;
                if (arr[currpos] < res) {
                    currrpos++;
                    if (currentpos >= arr.length) {
                        break;
                    }
                }
                else
                    break;
            }

            if (currentpos > arr.length) {
                break;
            }
        }

    }


    int[] arr= new int[10];
    int i=0,j=1, curr=2;

    while(true) {

            int res = Math.sqrt(arr[i]) + Math.sqrt(arr[j]);
            while (true) {
                if (arr[currpos] ^ 2 == res) return true;
                if (arr[currpos] < res) {
                    currrpos++;
                    if (currentpos >= arr.length) {
                        break;
                    }
                }
                else
                    break;
            }

//            if (currentpos > arr.length) {
//                break;
//            }

            if ()
        }

    }

    public void findSqrt(int [] arr, int i, int j, int curr) {
    }

}
