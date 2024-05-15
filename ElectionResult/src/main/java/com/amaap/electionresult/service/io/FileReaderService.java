package com.amaap.electionresult.service.io;

import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.service.exception.InvalidInputFileDataException;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.amaap.electionresult.service.io.exception.InvalidVoteCountException;
import jakarta.inject.Inject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService {
    private final FileParserService fileParserService;
    @Inject
    public FileReaderService(FileParserService fileParserService) {
        this.fileParserService = fileParserService;
    }

    public void readFile(String filePath) throws InvalidInputFileDataException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches("^([\\w\\s]+)(?:,\\s*(\\w+),\\s*(\\d+))+$")) {
                    fileParserService.parseResultData(line);
                } else {
                    throw new InvalidInputFileDataException("file data is invalid");
                }
            }
        } catch (IOException | InvalidConstituencyNameException |
                 InvalidVoteCountException | InvalidPartyCodeException e) {
            throw new RuntimeException(e);
        }
    }
}
