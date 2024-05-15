package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.service.WinnerEvaluator;
import com.amaap.electionresult.domain.service.dto.WinnerDto;
import com.amaap.electionresult.service.exception.InvalidFilePathException;
import com.amaap.electionresult.service.exception.InvalidInputFileDataException;
import com.amaap.electionresult.service.io.FileReaderService;

import java.util.List;

public class ElectionManagerService {
    private final FileReaderService fileReaderService;
    private final ResultDataService resultDataService;

    public ElectionManagerService(FileReaderService fileReaderService,ResultDataService resultDataService) {
        this.fileReaderService = fileReaderService;
        this.resultDataService = resultDataService;
    }

    public void readFile(String filePath) throws InvalidFilePathException, InvalidInputFileDataException {
        if (filePath == null || filePath.isEmpty()) throw new InvalidFilePathException("Invalid file path");
        fileReaderService.readFile(filePath);
    }

    public List<WinnerDto> getWinner() {
        List<ResultData> resultData = resultDataService.getAllResultData();
        return WinnerEvaluator.getWinner(resultData);
    }
}
