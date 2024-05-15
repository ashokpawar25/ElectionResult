package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.model.valueobject.Party;
import com.amaap.electionresult.domain.service.WinnerEvaluator;
import com.amaap.electionresult.domain.service.dto.WinnerDto;
import com.amaap.electionresult.service.exception.InvalidFilePathException;
import com.amaap.electionresult.service.exception.InvalidInputFileDataException;
import com.amaap.electionresult.service.io.FileReaderService;
import jakarta.inject.Inject;

import java.util.List;

public class ElectionManagerService {
    private final FileReaderService fileReaderService;
    private final ResultDataService resultDataService;
    @Inject
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

    public String displayWinners(List<WinnerDto> winnerList) {
        StringBuilder winnersData = new StringBuilder();
        for(WinnerDto winner:winnerList)
        {
            winnersData.append("In ").append(winner.constituencyName).append(" constituency ").append(Party.getFullName(winner.partyCode)).append(" is won and their votes are ").append(winner.votes).append(" and they are won by ").append(winner.percentageVotes).append(" percentage of total votes.\n");
        }
        return winnersData.toString();
    }
}
