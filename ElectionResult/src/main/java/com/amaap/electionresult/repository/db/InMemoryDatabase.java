package com.amaap.electionresult.repository.db;

import com.amaap.electionresult.domain.model.entity.ResultData;

import java.util.List;

public interface InMemoryDatabase {
    ResultData insertIntoResultDataTable(ResultData resultData);

    List<ResultData> getAllResultData();
}
