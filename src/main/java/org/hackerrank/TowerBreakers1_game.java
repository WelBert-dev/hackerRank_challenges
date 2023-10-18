package org.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*

Two players are playing a game of Tower Breakers! Player 1

always moves first, and both players always play optimally.The rules of the game are as follows:

    - Initially there are n towers.
    - Each tower is of height m
    - The players move in alternating turns.
    - In each turn, a player can choose a tower of height X and reduce its height to Y,
    where 1 <= Y < X and Y evenly divides X.

    - If the current player is unable to make a move, they lose the game.

Given the values of N and M, determine which player will win.
If the first player wins, return 1. Otherwise, return 2.

* */
public class TowerBreakers1_game {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int result = towerBreakers(n, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
    public static int towerBreakers(int n, int m) {
        return (n % 2 == 0 || m == 1) ? 2 : 1;
    }
}
