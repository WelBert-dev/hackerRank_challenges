package org.hackerrank;

import java.util.ArrayList;
import java.util.List;

/*

Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix

is shown below:

1 2 3
4 5 6
9 8 9

The left-to-right diagonal =
. The right to left diagonal = . Their absolute difference is

.

Function description

Complete the

function in the editor below.

diagonalDifference takes the following parameter:

    int arr[n][m]: an array of integers

Return

    int: the absolute diagonal difference

Input Format

The first line contains a single integer,
, the number of rows and columns in the square matrix .
Each of the next lines describes a row, , and consists of space-separated integers

.

Constraints

Output Format

Return the absolute difference between the sums of the matrix's two diagonals as a single integer.

Sample Input

3
11 2 4
4 5 6
10 8 -12

Sample Output

15

Explanation

The primary diagonal is:

11
   5
     -12

Sum across the primary diagonal: 11 + 5 - 12 = 4

The secondary diagonal is:

     4
   5
10

Sum across the secondary diagonal: 4 + 5 + 10 = 19
Difference: |4 - 19| = 15

Note: |x| is the absolute value of x

*/

public class DiagonalDifference {
    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(1, 2, 3));
        matrix.add(List.of(4, 5, 6));
        matrix.add(List.of(9, 8, 9));

        System.out.println(diagonalDifference(matrix));

    }
    public static int diagonalDifference(List<List<Integer>> matrix) {

        int left_to_right_diagonal_sum = 0;
        int right_to_left_diagonal_sum = 0;
        for (int i = 0; i < matrix.size(); i++) {
            left_to_right_diagonal_sum += matrix.get(i).get(i);
            right_to_left_diagonal_sum += matrix.get(i).get(matrix.get(i).size()-1-i);
        }

        if (left_to_right_diagonal_sum > right_to_left_diagonal_sum) {
            return left_to_right_diagonal_sum - right_to_left_diagonal_sum;
        }

        return right_to_left_diagonal_sum - left_to_right_diagonal_sum;
    }
}
