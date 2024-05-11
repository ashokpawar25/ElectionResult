package com.amaap.electionresult.repository;

import com.amaap.electionresult.domain.model.entity.ResultData;

import java.util.List;

public interface ResultDataRepository {
    ResultData save(ResultData resultData);

    List<ResultData> getAllResultData();
}
