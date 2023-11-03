package org.hackerrank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.hackerrank.CaesarCipher1_encrypting_strings_shifts_letter_by_number.caesarCipher_notCommonShifted;
import static org.hackerrank.ConvertMeridianTimePMAndAM12Hours_toMillitaryTime24Hours.timeConversionMoreElegant_useJavaTimeAPI;
import static org.junit.jupiter.api.Assertions.*;

class CaesarCipher1_encrypting_strings_shifts_letter_by_numberTest {

    @Test
    @DisplayName("WHEN shifted amount is greater than size of alphabet array THEN don't throws exceptions, JUST transform the shifted amount into a valid value and continue regular operation..")
    void whenShiftedAmountIsGreaterThanSizeOfAlphabetArray_and_WhenSuccessful_ThenJustTransformTheShiftedAmountIntoValidValue_and_ReturnsTheMsgEncrypted() throws ParseException {
        String msg_to_be_encrypted = "6DWV95HzxTCHP85dvv3NY2crzt1aO8j6g2zSDvFUiJj6XWDlZvNNr";
        int shift_amount = 87;

        String expected_msg_to_be_encrypted = "6MFE95QigCLQY85mee3WH2laic1jX8s6p2iBMeODrSs6GFMuIeWWa";

        String msg_encrypted = caesarCipher_notCommonShifted(msg_to_be_encrypted, shift_amount);
        Assertions.assertThat(msg_encrypted)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(expected_msg_to_be_encrypted);
    }
    @Test
    @DisplayName("WHEN msg_to_be_encrypted contains isn't alphabetic characters THEN don't throws exceptions, JUST keep the non-alphabetic characters in current position AND JUST shifted the alphabetic characters...")
    void whenMsgToBeEncryptedContainsIsntAlphabeticCharacters_and_WhenSuccessful_ThenJustKeepTheNonAlphabeticCharactersInCurrentPosition_and_JustShiftedTheAlphabeticCharacters_and_ReturnsTheMsgEncrypted() throws ParseException {
        // Ou seja, não deve ocorrer NENHUMA alteração,
        // pois chars não alfabéticos NÂO devem sofrer shifted
        String msg_to_be_encrypted_AND_is_the_msg_to_be_returns = "12345!@#$";

        assertEquals(msg_to_be_encrypted_AND_is_the_msg_to_be_returns,
                caesarCipher_notCommonShifted(msg_to_be_encrypted_AND_is_the_msg_to_be_returns, 5));
    }

}