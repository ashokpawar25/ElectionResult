package com.amaap.electionresult.repository.db.impl;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    private List<ResultData> resultData = new ArrayList<>();
    private int resultDataIdCounter = 0;
    @Override
    public ResultData insertIntoResultDataTable(ResultData resultData) {
        resultData.setId(++resultDataIdCounter);
        this.resultData.add(resultData);
        return resultData;
    }
}
