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
            String constituencyName = result.getConstituencyName();
            Map<String, Integer> data = result.getData();
            int totalVotes = 0;
            String winnerParty = null;
            int votes = 0;

            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                String party = entry.getKey();
                int vote = entry.getValue();
                totalVotes += vote;
                if (vote > votes) {
                    votes = vote;
                    winnerParty = party;
                }
            }
            int percentageVotes = (votes*100)/totalVotes;
            winners.add(new WinnerDto(constituencyName,winnerParty,votes,percentageVotes));
        }
        return winners;
    }
}
