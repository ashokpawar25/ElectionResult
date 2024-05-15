package com.amaap.electionresult.domain.service.dto;

import java.util.Objects;

public class WinnerDto {
    public final String constituencyName;
    public final String partyCode;
    public final int votes;
    public final double percentageVotes;
    public WinnerDto(String constituencyName, String partyCode, int votes, double percentageVotes) {
        this.constituencyName = constituencyName;
        this.partyCode = partyCode;
        this.votes = votes;
        this.percentageVotes = percentageVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerDto winnerDto = (WinnerDto) o;
        return votes == winnerDto.votes && Double.compare(percentageVotes, winnerDto.percentageVotes) == 0 && Objects.equals(constituencyName, winnerDto.constituencyName) && Objects.equals(partyCode, winnerDto.partyCode);
    }
}
