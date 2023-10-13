package org.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

/*

Given an array of integers, where all elements but one occur twice, find the unique element.

Example
The unique element is

.

Function Description

Complete the lonelyinteger function in the editor below.

lonelyinteger has the following parameter(s):

    int a[n]: an array of integers

Returns

    int: the element that occurs only once

Input Format

The first line contains a single integer,
, the number of integers in the array.
The second line contains space-separated integers that describe the values in

.

Constraints

It is guaranteed that
is an odd number and that there is one unique element.
, where .

*/

public class LonelyInteger {
    public static void main(String[] args) {
        System.out.println(lonelyIntegerWhereElementIsUniqueOnList(new ArrayList<>(
                List.of(1, 2, 3, 1, 4, 3, 2, 1))));
    }

    public static int lonelyIntegerWhereElementIsUniqueOnList(List<Integer> listOfIntegers) {
        // Faz o agrupamento dos valores iguais
        Map<Integer, List<Integer>> collect = listOfIntegers.stream()
                .filter(n -> n >= 0 && n <= 100)
                .collect(Collectors.groupingBy(Integer::intValue));

        // Percorre os valores do mapa até encontrar hasSize == 1
        // Ou seja, a única lista de um elemento:
        List<Integer> listOfUniqueElement = collect.values().stream()
                .filter(list -> list.size() == 1)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return listOfUniqueElement.get(0);
    }
}
