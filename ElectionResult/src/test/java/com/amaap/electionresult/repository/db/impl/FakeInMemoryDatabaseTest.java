package com.amaap.electionresult.repository.db.impl;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FakeInMemoryDatabaseTest {
    FakeInMemoryDatabase fakeInMemoryDatabase = new FakeInMemoryDatabase();

    @Test
    void shouldBeAbleToCreateResultData() throws InvalidConstituencyNameException {
        // arrange
        int id = 1;
        String constituencyName = "Pune";
        Map<String, Integer> data = new HashMap<>();
        data.put("BJP", 2000);
        data.put("NCP", 5050);
        ResultData expected = ResultData.create(id, constituencyName, data);

        // act
        ResultData actual = fakeInMemoryDatabase.insertIntoResultDataTable(expected);

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
        List<ResultData> expected = List.of(resultData1,resultData2);

        // act
        fakeInMemoryDatabase.insertIntoResultDataTable(resultData1);
        fakeInMemoryDatabase.insertIntoResultDataTable(resultData2);
        List<ResultData> actual = fakeInMemoryDatabase.getAllResultData();

        // assert
        assertEquals(expected,actual);

    }
}