package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.service.dto.WinnerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WinnerEvaluator {
    public static List<WinnerDto> getWinner(List<ResultData> resultData) {
        List<WinnerDto> winners = new ArrayList<>();
        for (ResultData result : resultData) {
            String constituency = result.getConstituencyName();
            Map<String, Integer> allVotes = result.getData();
            int totalVotes = 0;
            String winnerParty = null;
            int partyVotes = 0;

            for (Map.Entry<String, Integer> entry : allVotes.entrySet()) {
                String party = entry.getKey();
                int vote = entry.getValue();
                totalVotes += vote;
                if (vote > partyVotes) {
                    partyVotes = vote;
                    winnerParty = party;
                }
            }
            int percentageVotes = (partyVotes*100)/totalVotes;
            winners.add(new WinnerDto(constituency,winnerParty,partyVotes,percentageVotes));
        }
        return winners;
    }
}
