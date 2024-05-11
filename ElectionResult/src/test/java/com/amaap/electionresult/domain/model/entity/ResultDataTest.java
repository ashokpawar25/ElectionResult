package com.amaap.electionresult.domain.model.entity;

import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ResultDataTest {

    @Test
    void shouldBeAbleToCreateResultData() throws InvalidConstituencyNameException {
        // arrange
        int id = 1;
        String constituencyName = "Pune";
        Map<String,Integer> data = new HashMap<>();
        data.put("BJP",4348);
        data.put("NCP",9393);
        ResultData expected = new ResultData(id,constituencyName,data);

        // act
        ResultData actual = ResultData.create(id,constituencyName,data);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidConstituencyNameIsPassed()
    {
        // arrange
        Map<String,Integer> data = new HashMap<>();
        data.put("BJP",4348);
        data.put("NCP",9393);

        // act & assert
        assertThrows(InvalidConstituencyNameException.class,()->ResultData.create(1,"",data));
    }
}