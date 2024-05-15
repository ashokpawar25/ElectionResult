package com.amaap.electionresult.service;

import com.amaap.electionresult.service.exception.InvalidFilePathException;
import com.amaap.electionresult.service.exception.InvalidInputFileDataException;
import com.amaap.electionresult.service.io.FileReaderService;

public class ElectionManagerService {
    private final FileReaderService fileReaderService;

    public ElectionManagerService(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public void readFile(String filePath) throws InvalidFilePathException, InvalidInputFileDataException {
        if (filePath == null || filePath.isEmpty()) throw new InvalidFilePathException("Invalid file path");
        fileReaderService.readFile(filePath);
    }
}
