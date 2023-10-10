package org.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*

Given an array of integers, calculate the ratios of its elements that are positive,
negative, and zero. Print the decimal value of each fraction on a new line with
places after the decimal.

Note: This challenge introduces precision problems.
The test cases are scaled to six decimal places,
though answers with absolute error of up to are acceptable.

Example
There are elements, two positive, two negative and one zero.
Their ratios are , and Results are printed as:

0.400000
0.400000
0.200000

Function Description

Complete the plusMinus function in the editor below.

plusMinus has the following parameter(s):

    int arr[n]: an array of integers

Print the ratios of positive, negative and zero values in the array.
Each value should be printed on a separate line with digits after the
decimal. The function should not return a value.

Output Format

Print the following
lines, each to

decimals:

    proportion of positive values
    proportion of negative values
    proportion of zeros

Sample Input

STDIN           Function
-----           --------
6               arr[] size n = 6
-4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]

Sample Output

0.500000
0.333333
0.166667

Explanation

There are
positive numbers, negative numbers, and zero in the array.
The proportions of occurrence are positive: , negative: and zeros: .

*/

public class PlusMinus {
    public static void main(String[] args) {
        Result.plusMinus(new ArrayList<>(List.of(-4, 3, -9, 0, 4, 1)));
        // STDIN           Function
        // -----           --------
        // 6               arr[] size n = 6
        // -4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]
        //
        // Sample Output:
        // 0.500000
        // 0.333333
        // 0.166667
    }
}
class Result {
    public static void plusMinus(List<Integer> arr) {

        int positives_qtde = 0;
        int negatives_qtde = 0;
        int neutral_qtde = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0 && arr.get(i) <= 100) {
                positives_qtde++;
            } else if (arr.get(i) < 0 && arr.get(i) >= -100){
                negatives_qtde++;
            } else if(arr.get(i) == 0){
                neutral_qtde++;
            }
        }

        float proportionOfPositiveValues = ((float) positives_qtde / arr.size());
        float proportionOfNegativeValues = ((float) negatives_qtde / arr.size());
        float proportionOfZeros = ((float) neutral_qtde / arr.size());

        System.out.printf(Locale.ENGLISH,"%.6f%n%.6f%n%.6f%n",
                          proportionOfPositiveValues,
                          proportionOfNegativeValues,
                          proportionOfZeros);
    }

}