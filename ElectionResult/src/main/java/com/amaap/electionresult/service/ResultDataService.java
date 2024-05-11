package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.repository.ResultDataRepository;

import java.util.List;
import java.util.Map;

public class ResultDataService {
    private final ResultDataRepository resultDataRepository;

    public ResultDataService(ResultDataRepository resultDataRepository) {
        this.resultDataRepository = resultDataRepository;
    }

    public ResultData create(String constituencyName, Map<String, Integer> data) {
        ResultData resultData = new ResultData(1, constituencyName, data);
        return resultDataRepository.save(resultData);
    }

    public List<ResultData> getAllResultData() {
        return resultDataRepository.getAllResultData();
    }
}
