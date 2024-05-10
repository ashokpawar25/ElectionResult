package com.amaap.electionresult.controller;
import com.amaap.electionresult.domain.model.entity.ResultData;

import java.util.Map;

public class ResultDataController {
    public ResultData create(String constituencyName, Map<String, Integer> data) {
        return new ResultData(1,constituencyName,data);
    }
}
