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
    static char[] alphabet_arr;
    static Map<Character, Integer> mapa;
    static {
        String array_str = "abcdefghijklmnopqrstuvwxyz";
        alphabet_arr = array_str.toCharArray();
        mapa = new HashMap<>();
        for (int i = 0; i < alphabet_arr.length; i++) {
            mapa.put(alphabet_arr[i], i);
        }
    }

    public static void main(String[] args) {
        System.out.println(caesarCipher_notCommonShifted("6DWV95HzxTCHP85dvv3NY2crzt1aO8j6g2zSDvFUiJj6XWDlZvNNr", 87));
    }
    public static String caesarCipher_notCommonShifted(String msg_to_be_encrypted, int qtde_to_be_shifted) {

        // VALIDAÇÃO CONTRA TROLL: Se a qtde do flip for maior que o array do alfabeto,
        // então reseta até ficar menor ou igual:
        while (qtde_to_be_shifted > alphabet_arr.length) {
            qtde_to_be_shifted -= alphabet_arr.length;
        }

        // Finalmente monta a string com a msg encriptada fazendo shifted com mapa
        char[] original_msg_arr = msg_to_be_encrypted.toCharArray();
        StringBuilder encrypted = new StringBuilder(msg_to_be_encrypted.length());

        for (int i = 0; i < original_msg_arr.length; i++) {
            // Se não é letra apenas faz o append
            if (!Character.isLetter(original_msg_arr[i])) {
                encrypted.append(original_msg_arr[i]);

            } else if (Character.isUpperCase(original_msg_arr[i])) {

                // Deixa Lower no próprio array para não repetir codigos abaixo,
                // e Upper nele quando retornar:
                original_msg_arr[i] = Character.toLowerCase(original_msg_arr[i]);

                int index_to_be_shifted = mapa.get(original_msg_arr[i]) + qtde_to_be_shifted;
                boolean isRollbackNecessary = index_to_be_shifted >= alphabet_arr.length;
                if (isRollbackNecessary) {
                    int index_with_rollback_shifted = index_to_be_shifted - alphabet_arr.length;
                    encrypted.append(
                            Character.toUpperCase(alphabet_arr[index_with_rollback_shifted]));
                } else {
                    int index_shifted = mapa.get(original_msg_arr[i])+qtde_to_be_shifted;
                    encrypted.append(
                            Character.toUpperCase(alphabet_arr[index_shifted]));
                }

            } else {

                // Não é Upper Case

                int index_to_be_shifted = mapa.get(original_msg_arr[i]) + qtde_to_be_shifted;
                boolean isRollbackNecessary = index_to_be_shifted >= alphabet_arr.length;
                if (isRollbackNecessary) {
                    int index_with_rollback_shifted = index_to_be_shifted - alphabet_arr.length;
                    encrypted.append(
                            alphabet_arr[index_with_rollback_shifted]);
                } else {
                    int index_shifted = mapa.get(original_msg_arr[i])+qtde_to_be_shifted;
                    encrypted.append(
                            alphabet_arr[index_shifted]);
                }
            }
        }

        return encrypted.toString();
    }
}
