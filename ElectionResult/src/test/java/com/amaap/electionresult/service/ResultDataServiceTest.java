package com.amaap.electionresult.service;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultDataServiceTest {
    ResultDataService resultDataService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        resultDataService = injector.getInstance(ResultDataService.class);
    }

    @Test
    void shouldBeAbleToCreateResultData() throws InvalidConstituencyNameException {
        // arrange
        String constituencyName = "Pune";
        Map<String, Integer> data = new HashMap<>();
        data.put("BJP", 2000);
        data.put("NCP", 5050);
        ResultData expected = new ResultData(1, constituencyName, data);

        // act
        ResultData actual = resultDataService.create(constituencyName, data);

        // assert
        assertEquals(expected, actual);
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
        List<ResultData> expected = List.of(resultData1, resultData2);

        // act
        resultDataService.create("Pune", data1);
        resultDataService.create("Bangalore", data2);
        List<ResultData> actual = resultDataService.getAllResultData();

        // assert
        assertEquals(expected, actual);
    }
}