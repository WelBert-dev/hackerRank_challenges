package org.hackerrank;

import java.util.*;
import java.lang.*;

/*

In this challenge, the task is to debug the existing code to successfully execute all provided test files.

Given an array of
distinct integers, transform the array into a zig zag sequence by permuting the array elements. A sequence will be called a zig zag sequence if the first elements in the sequence are in increasing order and the last elements are in decreasing order, where

. You need to find the lexicographically smallest zig zag sequence of the given array.

Example.

Now if we permute the array as

, the result is a zig zag sequence.

Debug the given function findZigZagSequence to return the appropriate zig zag sequence for the given input array.

Note: You can modify at most three lines in the given code. You cannot add or remove lines of code.

To restore the original code, click on the icon to the right of the language selector.

Input Format

The first line contains
the number of test cases. The first line of each test case contains an integer , denoting the number of array elements. The next line of the test case contains elements of array

.

Constraints


( is always odd)

Output Format

For each test cases, print the elements of the transformed zig zag sequence in a single line.

*/
public class ZigZagSequence_debbuging_test {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = kb.nextInt();
            }
            findZigZagSequence(a, n);
        }
    }

    public static void findZigZagSequence(int [] array, int sizeOfArray){
        Arrays.sort(array);
        int mid = sizeOfArray/2;
        int temp = array[mid];
        array[mid] = array[sizeOfArray - 1];
        array[sizeOfArray - 1] = temp;

        int st = mid + 1;
        int end = sizeOfArray - 2;
        while(st <= end){
            temp = array[st];
            array[st] = array[end];
            array[end] = temp;
            st = st + 1;
            end = end - 1;
        }
        for(int i = 0; i < sizeOfArray; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(array[i]);
        }
        System.out.println();
    }
}



