package com.amaap.electionresult.service.io;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class InputDataValidatorServiceTest {

    @Test
    void shouldBeAbleToValidateValidPartyCode() throws FileNotFoundException {
        // arrange
        String partyCode = "BJP";

        // act
        boolean isValidCode = InputDataValidatorService.validatePartyCode(partyCode);

        // assert
        assertTrue(isValidCode);
    }

    @Test
    void shouldBeAbleToValidateInvalidPartyCode() throws FileNotFoundException {
        // arrange
        String partyCode = "INC2";

        // act
        boolean isValidCode = InputDataValidatorService.validatePartyCode(partyCode);

        // assert
        assertFalse(isValidCode);
    }
}