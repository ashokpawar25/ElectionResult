package com.amaap.electionresult.repository.db;

import com.amaap.electionresult.domain.model.entity.ResultData;

public interface InMemoryDatabase {
    ResultData insertIntoResultDataTable(ResultData resultData);
}
