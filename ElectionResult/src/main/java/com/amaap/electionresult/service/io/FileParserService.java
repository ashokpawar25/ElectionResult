package com.amaap.electionresult.service.io;

import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.service.ResultDataService;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.amaap.electionresult.service.io.exception.InvalidVoteCountException;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static com.amaap.electionresult.service.io.InputDataValidatorService.validateConstituencyName;
import static com.amaap.electionresult.service.io.InputDataValidatorService.validatePartyCode;

public class FileParserService {
    private final ResultDataService resultDataService;

    public FileParserService(ResultDataService resultDataService) {
        this.resultDataService = resultDataService;
    }

    public void parseResultData(String line) throws InvalidConstituencyNameException, FileNotFoundException, InvalidPartyCodeException, InvalidVoteCountException {
        String[] parts = line.split(",");
        String constituencyName = parts[0];
        boolean isValidConstituencyName = validateConstituencyName(constituencyName);
        if(!isValidConstituencyName) throw new InvalidConstituencyNameException("Invalid constituency name :"+constituencyName);
        Map<String, Integer> data = new HashMap<>();
        for (int i = 1; i < parts.length; i += 2) {
            String partyCode = parts[i].trim();
            boolean isValidPartyCode = validatePartyCode(partyCode);
            int votes = Integer.parseInt(parts[i + 1].trim());
            if (!isValidPartyCode) throw new InvalidPartyCodeException("Invalid party code :" + partyCode);
            if (votes < 0) throw new InvalidVoteCountException("Invalid vote count :" + votes);
            data.put(partyCode, votes);
        }
        resultDataService.create(constituencyName, data);
    }
}
