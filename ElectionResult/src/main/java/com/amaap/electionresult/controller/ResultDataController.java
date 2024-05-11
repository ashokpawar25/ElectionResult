package com.amaap.electionresult.controller;
import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.service.ResultDataService;

import java.util.Map;

public class ResultDataController {
    private final ResultDataService resultDataService;

    public ResultDataController(ResultDataService resultDataService) {
        this.resultDataService = resultDataService;
    }

    public ResultData create(String constituencyName, Map<String, Integer> data) {
        return resultDataService.create(constituencyName,data);
    }
}
