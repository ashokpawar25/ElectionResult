package com.amaap.electionresult.domain.model.entity.validator;

import org.junit.jupiter.api.Test;

import static com.amaap.electionresult.domain.model.entity.validator.ResultDataValidator.isValidConstituencyName;
import static org.junit.jupiter.api.Assertions.*;

class ResultDataValidatorTest {

    @Test
    void shouldBeAbleToValidateValidConstituencyName()
    {
        assertTrue(isValidConstituencyName("Pune"));
        assertTrue(isValidConstituencyName("Bangalore"));
    }

    @Test
    void shouldBeAbleToValidateInvalidConstituencyName()
    {
        assertFalse(isValidConstituencyName(""));
        assertFalse(isValidConstituencyName(null));
        assertFalse(isValidConstituencyName("   "));
        assertFalse(isValidConstituencyName("1234"));
        assertFalse(isValidConstituencyName("Pune1"));
        assertFalse(isValidConstituencyName("Pu ne"));
        assertFalse(isValidConstituencyName("A"));
        assertFalse(isValidConstituencyName("Ab"));
        assertFalse(isValidConstituencyName("   Ab@"));
        assertFalse(isValidConstituencyName(" Abc"));
        assertFalse(isValidConstituencyName("Abc    "));
        assertFalse(isValidConstituencyName("Abc "));
    }
}