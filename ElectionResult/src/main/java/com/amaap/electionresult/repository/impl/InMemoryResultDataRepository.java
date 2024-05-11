package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.repository.ResultDataRepository;
import com.amaap.electionresult.repository.db.InMemoryDatabase;

public class InMemoryResultDataRepository implements ResultDataRepository {
    private final InMemoryDatabase inMemoryDatabase;

    public InMemoryResultDataRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public ResultData save(ResultData resultData) {
        return inMemoryDatabase.insertIntoResultDataTable(resultData);
    }
}