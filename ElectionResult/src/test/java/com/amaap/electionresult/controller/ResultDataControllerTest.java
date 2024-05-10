package com.amaap.electionresult.controller;

import com.amaap.electionresult.domain.model.entity.ResultData;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultDataControllerTest {
    ResultDataController resultDataController = new ResultDataController();

    @Test
    void shouldBeAbleToCreateResultData()
    {
        // arrange
        String constituencyName = "Pune";
        Map<String,Integer> data = new HashMap<>();
        data.put("BJP",2000);
        data.put("NCP",5050);
        ResultData expected = new ResultData(1,constituencyName,data);

        // act
        ResultData actual = resultDataController.create(constituencyName,data);

        // assert
        assertEquals(expected,actual);
    }
}
