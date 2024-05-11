package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.repository.ResultDataRepository;
import com.amaap.electionresult.repository.db.InMemoryDatabase;
import com.amaap.electionresult.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.electionresult.repository.impl.InMemoryResultDataRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultDataServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    ResultDataRepository resultDataRepository = new InMemoryResultDataRepository(inMemoryDatabase);
    ResultDataService resultDataService = new ResultDataService(resultDataRepository);

    @Test
    void shouldBeAbleToCreateResultData() {
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
}