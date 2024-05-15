package com.amaap.electionresult.domain.model.entity;

import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
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

    @Test
    void shouldBeAbleToCheckEqualityOfInstance()
    {
        // arrange
        Map<String , Integer> data1 = new HashMap<>();
        data1.put("INC",8484);
        Map<String , Integer> data2 = new HashMap<>();
        data2.put("BJP",4343);
        ResultData resultData1 = new ResultData(1,"Pune",data1);
        ResultData resultData2 = new ResultData(1,"Pune",data1);
        ResultData resultData3 = new ResultData(2,"Pune",data1);
        ResultData resultData4 = new ResultData(1,"Bangalore",data1);
        ResultData resultData5 = new ResultData(1,"Pune",data2);
        ResultData resultData6 = new ResultData(2,"Bangalore",data2);
        Object object = new Object();

        // act & assert
        assertTrue(resultData1.equals(resultData1));
        assertTrue(resultData1.equals(resultData2));
        assertFalse(resultData1.equals(resultData3));
        assertFalse(resultData1.equals(resultData4));
        assertFalse(resultData1.equals(resultData5));
        assertFalse(resultData1.equals(resultData6));
        assertFalse(resultData1.equals(object));
        assertFalse(resultData1.equals(null));
    }
}