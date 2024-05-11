package com.amaap.electionresult.repository.db.impl;

import com.amaap.electionresult.domain.model.entity.ResultData;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FakeInMemoryDatabaseTest {
    FakeInMemoryDatabase fakeInMemoryDatabase = new FakeInMemoryDatabase();

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
        ResultData actual = fakeInMemoryDatabase.insertIntoResultDataTable(expected);

        // assert
        assertEquals(expected, actual);
    }
}