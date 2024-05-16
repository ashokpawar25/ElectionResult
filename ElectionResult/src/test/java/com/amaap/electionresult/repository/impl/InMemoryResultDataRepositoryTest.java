package com.amaap.electionresult.repository.impl;

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

class InMemoryResultDataRepositoryTest {
    InMemoryResultDataRepository inMemoryResultDataRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryResultDataRepository = injector.getInstance(InMemoryResultDataRepository.class);
    }

    @Test
    void shouldBeAbleToCreateResultData() {
        // arrange
        int id = 1;
        String constituencyName = "Pune";
        Map<String, Integer> data = new HashMap<>();
        data.put("BJP", 2000);
        data.put("NCP", 5050);
        ResultData expected = new ResultData(id, constituencyName, data);

        // act
        ResultData actual = inMemoryResultDataRepository.save(expected);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetResultForAllConstituencyFromDatabase() throws InvalidConstituencyNameException {
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
        inMemoryResultDataRepository.save(resultData1);
        inMemoryResultDataRepository.save(resultData2);
        List<ResultData> actual = inMemoryResultDataRepository.getAllResultData();

        // assert
        assertEquals(expected, actual);
    }
}