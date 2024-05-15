package com.amaap.electionresult.controller;

import com.amaap.electionresult.service.ElectionManagerService;
import com.amaap.electionresult.service.ResultDataService;
import com.amaap.electionresult.service.exception.InvalidFilePathException;

public class ElectionManagerController {
    private final ElectionManagerService electionManagerService;
    public ElectionManagerController(ElectionManagerService electionManagerService) {
        this.electionManagerService = electionManagerService;
    }

    public void readFile(String filePath) throws InvalidFilePathException {
        electionManagerService.readFile(filePath);
    }
}
