package com.amaap.electionresult.repository;

import com.amaap.electionresult.domain.model.entity.ResultData;

public interface ResultDataRepository {
    ResultData save(ResultData resultData);
}
