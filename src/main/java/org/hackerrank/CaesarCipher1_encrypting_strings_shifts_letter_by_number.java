package org.hackerrank;

import javax.xml.stream.events.Characters;
import java.util.*;

/*

Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc

Example

The alphabet is rotated by , matching the mapping above. The encrypted string is

.

Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.

Function Description

Complete the caesarCipher function in the editor below.

caesarCipher has the following parameter(s):

    string s: cleartext
    int k: the alphabet rotation factor

Returns

    string: the encrypted string

Input Format

The first line contains the integer,
, the length of the unencrypted string.
The second line contains the unencrypted string, .
The third line contains

, the number of letters to rotate the alphabet by.

Constraints



is a valid ASCII string without any spaces.

Sample Input

11
middle-Outz
2

Sample Output

okffng-Qwvb

Explanation

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab

m -> o
i -> k
d -> f
d -> f
l -> n
e -> g
-    -
O -> Q
u -> w
t -> v
z -> b

*/

public class CaesarCipher1_encrypting_strings_shifts_letter_by_number {
    public static void main(String[] args) {
//        System.out.println(caesarCipher("abcdefghijklmnopqrstuvwxyza", 3));

        System.out.println(caesarCipher("middle-OutZ", 2));
    }
    // Versão funcionando com Java > 8, porém não funcionando no HackerRank Java 8
    // Por conta do método: encrypted.append(Character.toString(c + k));
    // Abaixo nova versão sem utilizar ela!
    public static String caesarCipher(String s, int k) {
        char[] charArray = s.toCharArray();
        StringBuilder encrypted = new StringBuilder(s.length());
        for (char c : charArray) {
            switch (c) {
                case 'x': case 'X':
                    encrypted.append('a');
                    break;
                case 'y': case 'Y':
                    encrypted.append('b');
                    break;
                case 'z': case 'Z':
                    encrypted.append('c');
                    break;
                default:
                    if (!Character.isLetter(c)) {
                        encrypted.append(Character.toString(c));
                    } else {
                        encrypted.append(Character.toString(c + k));
                    }

            }
        }
        return encrypted.toString();
    }
    // Versão sem utilizar o método:
    // Porém NÃO FUNCIONANDO COM UPPERCASE, por conta da falta de rotação do array
    // Quando i current letter is "Z", e k + i ultrapassa o length do array,
    // tem que resetar o index e voltar no index 0.
    public static String caesarCipher_notCommonShifted(String s, int k) {
        // middle-Outz tem que virar: okffng-Qwvb
        // Cria a tabela de acordo com o index de cada letra
        String array_str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabet_arr = array_str.toCharArray();
        Map<Character, Integer> mapa = new HashMap<>();
        for (int i = 0; i < alphabet_arr.length; i++) {
            mapa.put(alphabet_arr[i], i);
        }

        // Finalmente monta a string com a msg encriptada fazendo shifted com mapa
        char[] original_msg_arr = s.toCharArray();
        StringBuilder encrypted = new StringBuilder(s.length());
        for (int i = 0; i < original_msg_arr.length; i++) {
            if (!Character.isLetter(original_msg_arr[i])) {
                encrypted.append(original_msg_arr[i]);
            } else {
                encrypted.append(alphabet_arr[mapa.get(original_msg_arr[i])+k]);
            }
        }
        return encrypted.toString();
    }
}
