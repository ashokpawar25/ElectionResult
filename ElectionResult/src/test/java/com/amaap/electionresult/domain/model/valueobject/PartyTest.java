package com.amaap.electionresult.domain.model.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {

    @Test
    void shouldBeAbleToGetFullNameOfParty()
    {
        // arrange
        String expected = "Indian National Congress";

        // act
        String actual = Party.getFullName("INC");

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetInvalidIfPartyCodeDoesNotMatch()
    {
        // arrange
        String expected = "Invalid";

        // act
        String actual = Party.getFullName("SMP");

        // assert
        assertEquals(expected,actual);
    }
}