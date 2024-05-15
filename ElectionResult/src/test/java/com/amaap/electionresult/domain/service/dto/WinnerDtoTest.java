package com.amaap.electionresult.domain.service.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnerDtoTest {

    @Test
    void shouldBeAbleToCheckEqualityOfInstance()
    {
        // arrange
        WinnerDto dto1 = new WinnerDto("Pune","BJP",444,34.14);
        WinnerDto dto2 = new WinnerDto("Pune","BJP",444,34.14);
        WinnerDto dto3 = new WinnerDto("Bangalore","BJP",444,34.14);
        WinnerDto dto4 = new WinnerDto("Pune","INC",444,34.14);
        WinnerDto dto5 = new WinnerDto("Pune","BJP",445,34.14);
        WinnerDto dto6 = new WinnerDto("Pune","BJP",444,34.43);
        WinnerDto dto7 = new WinnerDto("Bangalore","INC",445,34.43);
        Object object = new Object();

        // act & assert
        assertTrue(dto1.equals(dto1));
        assertTrue(dto1.equals(dto2));
        assertFalse(dto1.equals(dto3));
        assertFalse(dto1.equals(dto4));
        assertFalse(dto1.equals(dto5));
        assertFalse(dto1.equals(dto6));
        assertFalse(dto1.equals(dto7));
        assertFalse(dto1.equals(object));
        assertFalse(dto1.equals(null));
    }
}