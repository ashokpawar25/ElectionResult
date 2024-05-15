package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.service.ResultDataService;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

public class ResultDataController {
    private final ResultDataService resultDataService;

    @Inject
    public ResultDataController(ResultDataService resultDataService) {
        this.resultDataService = resultDataService;
    }

    public Response create(String constituencyName, Map<String, Integer> data) {
        try {
            resultDataService.create(constituencyName, data);
            return new Response(HttpStatus.OK, "Result Data created successfully");
        } catch (InvalidConstituencyNameException e) {
            return new Response(HttpStatus.BADREQUEST, e.getMessage());
        }
    }

    public List<ResultData> getAllResultData() {
        return resultDataService.getAllResultData();
    }
}
