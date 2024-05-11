package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.repository.ResultDataRepository;
import com.amaap.electionresult.repository.db.InMemoryDatabase;
import com.amaap.electionresult.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.electionresult.repository.impl.InMemoryResultDataRepository;
import com.amaap.electionresult.service.ResultDataService;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultDataControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    ResultDataRepository resultDataRepository = new InMemoryResultDataRepository(inMemoryDatabase);
    ResultDataService resultDataService = new ResultDataService(resultDataRepository);
    ResultDataController resultDataController = new ResultDataController(resultDataService);

    @Test
    void shouldBeAbleToGetOkResponseWhenResultDataCreate()
    {
        // arrange
        String constituencyName = "Pune";
        Map<String,Integer> data = new HashMap<>();
        data.put("BJP",2000);
        data.put("NCP",5050);
        Response expected = new Response(HttpStatus.OK,"Result Data created successfully");

        // act
        Response actual = resultDataController.create(constituencyName,data);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestAsResponseWhenInvalidDataIsPassed()
    {
        // arrange
        String constituencyName = "Ab";
        Map<String,Integer> data = new HashMap<>();
        data.put("BJP",2000);
        data.put("NCP",5050);
        Response expected = new Response(HttpStatus.BADREQUEST,"Invalid constituency Name :"+constituencyName);

        // act
        Response actual = resultDataController.create(constituencyName,data);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetResultForAllConstituency() throws InvalidConstituencyNameException {
        // arrange
        Map<String, Integer> data1 = new HashMap<>();
        data1.put("BJP", 2000);
        data1.put("NCP", 5050);
        Map<String, Integer> data2 = new HashMap<>();
        data2.put("BJP", 4050);
        data2.put("NCP", 9030);
        ResultData resultData1 = ResultData.create(1, "Pune", data1);
        ResultData resultData2 = ResultData.create(2, "Bangalore", data2);
        List<ResultData> expected = List.of(resultData1,resultData2);

        // act
        resultDataController.create("Pune",data1);
        resultDataController.create("Bangalore",data2);
        List<ResultData> actual = resultDataController.getAllResultData();

        // assert
        assertEquals(expected,actual);
    }
}
