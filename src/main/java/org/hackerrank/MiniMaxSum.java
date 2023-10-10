package org.hackerrank;

import java.util.ArrayList;
import java.util.List;

/*
Given five positive integers, find the minimum and maximum values
that can be calculated by summing exactly four of the five integers.
Then print the respective minimum and maximum values as a single
line of two space-separated long integers.

Example
The minimum sum is and the maximum sum is

. The function prints

16 24

Function Description

Complete the miniMaxSum function in the editor below.

miniMaxSum has the following parameter(s):

    arr: an array of

    integers

Print

Print two space-separated integers on one line: the minimum sum and the maximum sum of
of

elements.

Input Format

A single line of five space-separated integers.

Constraints

Output Format

Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)

Sample Input

1 2 3 4 5

Sample Output

10 14

Explanation

The numbers are
, , , , and

. Calculate the following sums using four of the five integers:

    Sum everything except

, the sum is
.
Sum everything except
, the sum is
.
Sum everything except
, the sum is
.
Sum everything except
, the sum is
.
Sum everything except
, the sum is .

*/

public class MiniMaxSum {
    public static void main(String[] args) {
        miniMaxSum(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
    }
    public static void miniMaxSum(List<Integer> arr) {
        long sum = 0;

        long min = arr.get(0);
        long max = arr.get(0);

        // Obs: Mais performático do que pegar com `Collectors.max` e min,
        // pois vamos percorrer 2x a lista inteira, aqui na primeira passada
        // já pegamos os dois:
        for (int i = 0; i < arr.size(); i++) {

            // 0 > arr[i] < 10⁹ (1000000000)
            if (arr.get(i) > 0 && arr.get(i) <= 1000000000) {
                if (arr.get(i) < min) {
                    min = arr.get(i);
                } else if (arr.get(i) > max){
                    max = arr.get(i);
                }
                sum += arr.get(i);
            }
        }

        long minimumSum = sum - max;
        long maximumSum = sum - min;

        System.out.printf("%s %s", minimumSum, maximumSum);
    }
}