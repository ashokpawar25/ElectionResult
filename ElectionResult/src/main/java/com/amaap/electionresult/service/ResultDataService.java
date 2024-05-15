package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.repository.ResultDataRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

public class ResultDataService {
    private final ResultDataRepository resultDataRepository;
    @Inject
    public ResultDataService(ResultDataRepository resultDataRepository) {
        this.resultDataRepository = resultDataRepository;
    }

    public ResultData create(String constituencyName, Map<String, Integer> data) throws InvalidConstituencyNameException {
        ResultData resultData = ResultData.create(1, constituencyName, data);
        return resultDataRepository.save(resultData);
    }

    public List<ResultData> getAllResultData() {
        return resultDataRepository.getAllResultData();
    }
}
